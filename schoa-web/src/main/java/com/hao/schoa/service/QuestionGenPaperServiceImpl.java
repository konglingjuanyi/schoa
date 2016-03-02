package com.hao.schoa.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.torque.util.BasePeer;

import com.hao.schoa.container.QuestionParam;
import com.hao.schoa.po.QuestionBank;
import com.hao.schoa.po.QuestionBankPeer;
import com.hao.schoa.po.QuestionTixing;
import com.hao.schoa.tools.SchoaUtil;
import com.workingdogs.village.Record;

/**
 * 生成试卷
 * 
 * @author haoguowei
 * 
 */
public class QuestionGenPaperServiceImpl {

	/**
	 * 生成试卷
	 * 
	 * @param param
	 * @return 生成有序的试题ID,格式如：1,2,3...
	 */
	public static String genQuestionPaperIds(QuestionParam param) {

		// 1.得到所有题型
		List<QuestionTixing> tixingList = param.getTixingList();
		if (tixingList == null || tixingList.size() == 0) {
			return "";
		}

		LinkedHashSet<Integer> resultIdSet = new LinkedHashSet<Integer>();
		
		// 2.查询符合条件的试题ID，
		for (QuestionTixing tixing : tixingList) {
			fillTixingPaperIds(resultIdSet, tixing, param);
		}
		
		return SchoaUtil.collectionToString(resultIdSet);
	}
	
	
	
	/**
	 * 如果此题型包含必须能生成的题，则把必须能生成题的ID，填充到resultIdSet，同时生成试题数量减少相应的数量
	 * @param resultIdSet
	 * @param tixing
	 * @param param
	 */
	private static void fillTixingPaperIds(LinkedHashSet<Integer> resultIdSet, QuestionTixing tixing, QuestionParam param){
		// 题型ID
		int tixingId = tixing.getId();
		
		// 计算要生成此题型的试题数
		int amount = tixing.getAmount();
		
		// 此题型必须要生成的试题ID
		Map<Integer, Set<Integer>> mustHaveMap = param.getMustHaveMap();
		
		//必须ID
		Set<Integer> set = new HashSet<Integer>();
		
		if (mustHaveMap != null) {
			// 此题型必须要生成的试题ID
			Set<Integer> mustSet = mustHaveMap.get(tixingId);
			if (mustSet != null) {
				for (int m : mustSet) {
					//必须ID
					set.add(m);
					
					//添加到最终ID容器
					resultIdSet.add(m);
					
					amount -= 1;
					if (amount == 0) {
						break;
					}
				}
			}
		}
		
		if(amount > 0){
			//查询数据库，得到本题型下符合条件的试题
			//不能包含必须生成题的mustIds，id not in
			String mids = SchoaUtil.collectionToString(set);
			List<Integer> fullIdList = searchShitiList(mids, tixingId, param); 
			fillResultId(resultIdSet, fullIdList, amount);
		}
	}

	/**
	 * 查询数据库，得到本题型下符合条件的试题
	 * @param mustIds
	 * @param tixingId
	 * @param param
	 * @return id的list
	 */
	private static List<Integer> searchShitiList(String mustIds, int tixingId, QuestionParam param) {
		StringBuffer sbr = new StringBuffer();
		
		sbr.append(" select id ");
		sbr.append(" from question_bank ");
		
		//题型
		sbr.append(" where tixing_id = ").append(tixingId); 
		
		//教材
		if(param.getMaterialId() > 0){
			sbr.append(" and material_id = ").append(param.getMaterialId());
		}
		
		//教材下课程
		if(StringUtils.isNotBlank(param.getMaterialKechengIds())){
			sbr.append(" and material_kecheng_id in (").append(param.getMaterialKechengIds()).append(") ");
		}
		
		//知识点
		if(StringUtils.isNotBlank(param.getKnowledgePointIds())){
//			sbr.append(" and knowledge_point_id in (").append(param.getKnowledgePointIds()).append(") ");
			String[] arr = param.getKnowledgePointIds().split(",");
			if(arr.length > 0){
				sbr.append(" and ( ");
				for(int i=0;i<arr.length;i++){
					if(i > 0){
						sbr.append(" or ");
					}
					sbr.append(" find_in_set('"+arr[i]+"', knowledge_point_id) ");
				}
				sbr.append(" ) ");
			}
		}
		
		//词汇标准及级别，标准ID*10000+级别ID*1
		if(StringUtils.isNotBlank(param.getWordsLevel())){
			sbr.append(" and MATCH(words_level)AGAINST('").append(param.getWordsLevel()).append("'IN BOOLEAN MODE) ");
		}

		//标签
		if(StringUtils.isNotBlank(param.getTags())){
			sbr.append(" and MATCH(tags)AGAINST('").append(param.getTags()).append("'IN BOOLEAN MODE) ");
		}
		
		//关键字
		if(StringUtils.isNotBlank(param.getKeyword())){
//			sbr.append(" and content like '%").append(param.getKeyword()).append("%' ");
			sbr.append(" and MATCH(fenci)AGAINST('").append(param.getKeyword()).append("'IN BOOLEAN MODE) ");
		}
		
		//试题创建时间 － 开始时间
		if(StringUtils.isNotBlank(param.getStartDay())){
			sbr.append(" and create_time >= '").append(param.getStartDay() + " 00:00:00").append("' ");
		}
		
		//试题创建时间 － 结束时间
		if(StringUtils.isNotBlank(param.getEndDay())){
			sbr.append(" and create_time <= '").append(param.getEndDay() + " 23:59:59").append("' ");
		}
		
		//mustIds
		if(StringUtils.isNotBlank(mustIds)){
			sbr.append(" and id not in (").append(mustIds).append(") ");
		}
		
		System.out.println("搜索试题SQL：" + sbr.toString());
		
		List<Integer> resultList = new ArrayList<Integer>();
		try {
			List<Record> list = BasePeer.executeQuery(sbr.toString());
			if(list != null){
				for (int i = 0; i < list.size(); i++) {
					Record row = list.get(i);
					resultList.add(row.getValue("id").asInt());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultList;
	}
	
	/**
	 * 填充ID结果集
	 * @param resultIdSet  最终ID结果集
	 * @param fullIdList 所有查询到的id集
	 * @param amount 打算填充数量
	 */
	private static void fillResultId(LinkedHashSet<Integer> resultIdSet, List<Integer> fullIdList, int amount){
		LinkedHashSet<Integer> randomIndex = genRandomIndex(amount, fullIdList.size());
		if(randomIndex != null){
			for(int i : randomIndex){
				resultIdSet.add(fullIdList.get(i));
			}
		}
	}
	
	/**
	 * 生成随机下标
	 * @param length 生成的结果数
	 * @param max 下标取值的最大范围值
	 * @return
	 */
	private static LinkedHashSet<Integer> genRandomIndex(int length, int max) {
		if (length <= 0 || max <= 0) {
			return null;
		}
		// 最终生成下标的长度
		int realLength = Math.min(length, max);
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>(realLength);
		Random ran = new Random();
		while (set.size() < realLength) {
			set.add(ran.nextInt(max));
		}
		return set;
	}
	

	/**
	 * 根据试题ID，取试题信息
	 * @param ids
	 * @return
	 */
	public static List<QuestionBank> searchQuestionByIds(String ids) {
		if(StringUtils.isBlank(ids)){
			return null;
		}
		StringBuffer sbr = new StringBuffer();
		sbr.append(" select ").append("b.* ");
		sbr.append(" from question_bank b");
		sbr.append(" where b.id in (").append(ids).append(") ");
		sbr.append(" order by field(id,").append(ids).append(") ");
		
		System.out.println("根据ID查试题：" + sbr.toString());
		
		List<QuestionBank> list = new ArrayList<QuestionBank>();
		
		try {
			List<Record> searchList = QuestionBankPeer.executeQuery(sbr.toString());
			for (int i = 0; i < searchList.size(); i++) {
				Record row = searchList.get(i);
				QuestionBank bank = QuestionBankPeer.row2Object(row, 1, QuestionBankPeer.getOMClass());
				list.add(bank);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
