package com.hao.schoa.service;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.cfg.DefaultConfig;
import org.wltea.analyzer.dic.Dictionary;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.hao.schoa.po.QuestionWordsLevel;
import com.hao.schoa.po.QuestionWordsStandard;

/**
 * 分词
 * @author haoguowei
 *
 */
public class SchoaAnalyzerService {
	
	private static SchoaAnalyzerService singleton;
	
	private List<QuestionWordsStandard> standardList;
	
	private Analyzer analyzer = new IKAnalyzer(true);
	
	private Dictionary dic = Dictionary.initial(DefaultConfig.getInstance());
	
	private SchoaAnalyzerService(){
		loadLevelDict();
	}
	
	/**
	 * 加载词汇级别字典
	 */
	private void loadLevelDict() {
		standardList = QuestionWordsServiceImpl.getQuestionWordsStandardList();
		if(standardList != null){
			
			//存储所有级别（不区分 词汇 标准），对应的词语
			LinkedHashMap<Integer, String[]> levelWordsMap = new LinkedHashMap<Integer, String[]>();
			
			for(QuestionWordsStandard standard : standardList){
				//必须是到排序，从高级别，到低级别依次匹配
				List<QuestionWordsLevel> ls = QuestionWordsServiceImpl.getQuestionWordsLevelList(standard.getId(), 1);
				if(ls != null){
					standard.setLevelList(ls);
					for(QuestionWordsLevel level : ls){
						if(StringUtils.isNotBlank(level.getContent())){
							String[] terms = level.getContent().split(System.getProperty("line.separator"));
							
							//分词加到主词典
							dic.addWords(terms);
							
							//存储级别对应的词语
							levelWordsMap.put(level.getId(), terms);
						}
					}
				}
			}
			//加载schoa 级别对应的词典
			dic.loadSchoaWordLevelDict(levelWordsMap);
		}
	}
	
	/**
	 * 重新加载词典
	 * @param loadIkDict 是否重新加载ik主词典
	 */
	public void relodDic(boolean loadIkDict){
		if(loadIkDict){
			System.out.println("重新加载所有词典,start");
			dic.reloadMainDict();
		}
		loadLevelDict();
		System.out.println("重新加载所有词典,end");
	}
	
	/**
	 * 输出标准级别
	 * @return
	 */
	public List<String> getViewStardardLevel(String str){
		List<String> ls = new ArrayList<String>();
		if(StringUtils.isBlank(str)){
			return ls;
		}
		String[] arr = str.split(",");
		for(String s : arr){
			int i = Integer.parseInt(s);
			int stardardId = i/10000;
			int levelId = i%10000;
			QuestionWordsStandard ws = QuestionWordsServiceImpl.getQuestionWordsStandardById(stardardId);
			QuestionWordsLevel wl = QuestionWordsServiceImpl.getQuestionWordsLevelById(levelId);
			if(ws != null && wl != null){
				ls.add(ws.getName() + " - " + wl.getName());
			}
		}
		return ls;
	}
	
	/**
	 * 计算标准级别码
	 * @param text
	 * @return
	 */
	public String calStandardLevelCode(String text){
		if(standardList == null || standardList.size() == 0 || StringUtils.isBlank(text)){
			return "";
		}
		
		//级别码字符串
		StringBuffer sbr = new StringBuffer();
		
		//将原试题语句，分词
		Set<String> words = fenci(text);
		
		//分别计算每个标准下的级别ID
		for (QuestionWordsStandard standard : standardList) {
			//计算级别
			int levelId = calMatchWordLevel2(standard.getLevelList(), words);
			
			//标准ID＋匹配上的级别ID，组装成级别码
			if(levelId > 0){
				sbr.append(calWordLevelCode(standard.getId(), levelId)).append(",");
				continue;
			}
		}
		
		return sbr.toString();
	}
	
	/**
	 * 生成级别码
	 * @param standardId
	 * @param levelId
	 * @return
	 */
	public String calWordLevelCode(int standardId, int levelId){
		if(standardId == 0){
			return "";
		}
		return String.valueOf(standardId * 10000 + levelId);
	}
	
	/**
	 * 计算匹配的级别ID
	 * @param levelList
	 * @param words
	 * @return
	 */
	private int calMatchWordLevel(List<QuestionWordsLevel> levelList, Set<String> words){
		//标准下的所有级别
		if (levelList == null || levelList.size() == 0) {
			return 0;
		}
		
		//从高级到低级，找到词语中最高的级别
		for (QuestionWordsLevel level : levelList) {
			if(dic.isMatchWordLevelDict(words, level.getId())){
				return level.getId();
			}
		}
		return 0;
	}
	
	/**
	 * 计算匹配的级别ID
	 * @param levelList
	 * @param words
	 * @return
	 */
	private int calMatchWordLevel2(List<QuestionWordsLevel> levelList, Set<String> words){
		//标准下的所有级别
		if (levelList == null || levelList.size() == 0 || words == null || words.size() == 0) {
			return 0;
		}
		
		//key--级别ID，value--个数
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		
		//分别计算每个词所属级别，并计算级别对应的单词个数
		for(String word : words){
			//计算单词匹配的级别
			int levelId = dic.getMatchWordLevel(word);
			if(levelId > 0){
				if(map.containsKey(levelId)){
					map.put(levelId, map.get(levelId) + 1);
				}else{
					map.put(levelId, 1);
				}
			}
		}
		
		for(QuestionWordsLevel level : levelList){
			if(level.getPercent() <= 0 || level.getPercent() > 100){
				continue;
			}
			int levelId = level.getId();
			Integer val = map.get(levelId);
			if(val != null && val > 0){
				double p = val * 100.0 / words.size();
				if(p >= level.getPercent()){
					return levelId;
				}
			}
		}
		return 0;
	}
	
	/**
	 *  将原试题语句，分词
	 * @param text
	 * @return
	 */
	public Set<String> fenci(String text) {
//		System.out.println("［分词］原始语句：" + text);
		Set<String> set = new LinkedHashSet<String>();
		TokenStream ts = null;
		try {
			ts = analyzer.tokenStream("",new StringReader(text));
			CharTermAttribute term = (CharTermAttribute) ts.addAttribute(CharTermAttribute.class);
			 //重置TokenStream（重置StringReader）
			ts.reset(); 
			while (ts.incrementToken()) {
				set.add(term.toString());
			}
			ts.end();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ts.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("［分词］结果：" + set);
		return set;
	}
	
	public List<QuestionWordsStandard> getStandardList() {
		return standardList;
	}

	public static SchoaAnalyzerService getInstance(){
		if(singleton == null){
			synchronized(SchoaAnalyzerService.class){
				if(singleton == null){
					singleton = new SchoaAnalyzerService();
					return singleton;
				}
			}
		}
		return singleton;
	}
}
