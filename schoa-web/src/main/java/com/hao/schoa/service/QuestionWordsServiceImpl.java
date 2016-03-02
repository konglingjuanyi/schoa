package com.hao.schoa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.torque.NoRowsException;
import org.apache.torque.TooManyRowsException;
import org.apache.torque.TorqueException;
import org.apache.torque.util.BasePeer;
import org.apache.torque.util.Criteria;

import com.hao.schoa.po.QuestionBank;
import com.hao.schoa.po.QuestionBankPeer;
import com.hao.schoa.po.QuestionWordsLevel;
import com.hao.schoa.po.QuestionWordsLevelPeer;
import com.hao.schoa.po.QuestionWordsStandard;
import com.hao.schoa.po.QuestionWordsStandardPeer;
import com.hao.schoa.tools.Constant;
import com.hao.schoa.tools.SchoaUtil;

public class QuestionWordsServiceImpl {
	
	public static List<QuestionWordsStandard> getQuestionWordsStandardAndLevelsList(){
		List<QuestionWordsStandard> standardList = getQuestionWordsStandardList();
		for(QuestionWordsStandard standard : standardList){
			List<QuestionWordsLevel> ls = QuestionWordsServiceImpl.getQuestionWordsLevelList(standard.getId(), 1);
			standard.setLevelList(ls);
		}
		return standardList;
	}
	
	public static List<QuestionWordsStandard> getQuestionWordsStandardList(){
		Criteria c = new Criteria();
		c.addAscendingOrderByColumn(QuestionWordsStandardPeer.ID);
		List<QuestionWordsStandard> list = null;
		try {
			list = QuestionWordsStandardPeer.doSelect(c);
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 查询词汇标准
	 * @return
	 */
	public static Map<String, Object> searchQuestionWordsStandard() {
		List<QuestionWordsStandard> list = getQuestionWordsStandardList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constant.TOTAL, list==null?0:list.size());
		map.put(Constant.DATA, list);
		return map;
	}
	
	/**
	 * 根据id得到一条纪录
	 * @param id
	 * @return
	 */
	public static QuestionWordsStandard getQuestionWordsStandardById(int id){
		try {
			return QuestionWordsStandardPeer.retrieveByPK(id);
		} catch (NoRowsException e) {
			e.printStackTrace();
		} catch (TooManyRowsException e) {
			e.printStackTrace();
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查询词汇标准下的所有级别
	 * @param standardId
	 * @return
	 */
	public static Map<String, Object> searchQuestionWordsLevel(int standardId) {
		List<QuestionWordsLevel> list = getQuestionWordsLevelList(standardId, 0);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constant.TOTAL, list==null?0:list.size());
		map.put(Constant.DATA, list);
		return map;
	}
	
	public static List<QuestionWordsLevel> getQuestionWordsLevelList(int standardId){
		return getQuestionWordsLevelList(standardId, 0);
	}
	
	/**
	 * 
	 * @param standardId
	 * @param sort 1倒排序；0正排序
	 * @return
	 */
	public static List<QuestionWordsLevel> getQuestionWordsLevelList(int standardId, int sort){
		Criteria c = new Criteria();
		c.add(QuestionWordsLevelPeer.STANDARD_ID, standardId);
		if(sort == 1){
			c.addDescendingOrderByColumn(QuestionWordsLevelPeer.LEVEL_SORT);
		}else{
			c.addAscendingOrderByColumn(QuestionWordsLevelPeer.LEVEL_SORT);
		}
		List<QuestionWordsLevel> list = null;
		try {
			list = QuestionWordsLevelPeer.doSelect(c);
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 根据id得到词汇级别
	 * @param id
	 * @return
	 */
	public static QuestionWordsLevel getQuestionWordsLevelById(int id) {
		try {
			return QuestionWordsLevelPeer.retrieveByPK(id);
		} catch (NoRowsException e) {
			e.printStackTrace();
		} catch (TooManyRowsException e) {
			e.printStackTrace();
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 计算词汇标准及级别，标准ID*10000+级别ID*1s
	 * @param content
	 * @param answer
	 * @return
	 */
	public static String calTiWordsLevel(String content, String answer) {
		String text = content + " " + answer;
		return SchoaAnalyzerService.getInstance().calStandardLevelCode(text);
	}
	
	/**
	 * 分词
	 * @param content
	 * @param answer
	 * @return
	 */
	public static String fenci(String content, String answer) {
		String text = content + " " + answer;
		Set<String> set = SchoaAnalyzerService.getInstance().fenci(text);
		return SchoaUtil.collectionStrToString(set);
	}

	public static boolean deleteWordsStandard(int id) {
		String sql = " delete from " + QuestionWordsStandardPeer.TABLE_NAME + " where id = " + id;
		try {
			int rows = BasePeer.executeStatement(sql);
			if(rows > 0){
				deleteWordsLevelByStandardId(id);
				return true;
			}
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean deleteWordsLevelByStandardId(int standardId) {
		String sql = " delete from " + QuestionWordsLevelPeer.TABLE_NAME + " where " + QuestionWordsLevelPeer.STANDARD_ID + " = " + standardId;
		try {
			int rows = BasePeer.executeStatement(sql);
			if(rows > 0){
				return true;
			}
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean deleteWordsLevelById(int id) {
		String sql = " delete from " + QuestionWordsLevelPeer.TABLE_NAME + " where id = " + id;
		try {
			int rows = BasePeer.executeStatement(sql);
			if(rows > 0){
				return true;
			}
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

	/**
	 * 
	 * 更新所有试题的词汇级别（耗时操作）
	 * @return
	 */
	public static int updateWordsStandardLevel(){
		int total = 0;
		try {
			//1.重新加载主IK词典及词汇级别词典
			SchoaAnalyzerService.getInstance().relodDic(true);
			
			int start = 0;
			int limit = 200;
			
			//2.获取所有试题
			while(true) {
				List<QuestionBank> ls = QuestionBankServiceImpl.getBankList(start, limit);
				
				if(ls == null || ls.size() == 0){
					break;
				}
				
				for(QuestionBank bank : ls){
					//3.计算试题的词汇级别码
					String level = calTiWordsLevel(bank.getContent(), bank.getAnswer());
					
					//4.更新
					bank.setWordsLevel(level);
					QuestionBankPeer.doUpdate(bank);
					
					total += 1;
				}
				start += limit;
			} 
			System.out.println("更新所有试题的词汇级别,总更新纪录数：" + total);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	

}
