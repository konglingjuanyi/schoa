package com.hao.schoa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.torque.NoRowsException;
import org.apache.torque.TooManyRowsException;
import org.apache.torque.TorqueException;
import org.apache.torque.util.BasePeer;
import org.apache.torque.util.Criteria;

import com.hao.schoa.po.QuestionBank;
import com.hao.schoa.po.QuestionBankPeer;
import com.hao.schoa.po.QuestionTixingPeer;
import com.hao.schoa.tools.Constant;
import com.workingdogs.village.Record;

public class QuestionBankServiceImpl {

	public static QuestionBank getQuestionBankById(int id) {
		try {
			QuestionBank bank = QuestionBankPeer.retrieveByPK(id);
			if(bank != null && StringUtils.isNotBlank(bank.getWordsLevel())){
				List<String> ls = SchoaAnalyzerService.getInstance().getViewStardardLevel(bank.getWordsLevel());
				bank.setStandardLevelList(ls);
			}
			return bank;
		} catch (NoRowsException e) {
			e.printStackTrace();
		} catch (TooManyRowsException e) {
			e.printStackTrace();
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<QuestionBank> getBankList(int start,int limit){
		Criteria c = new Criteria();
		c.addAscendingOrderByColumn(QuestionBankPeer.ID);
		c.setOffset(start);
		c.setLimit(limit);
		try {
			return QuestionBankPeer.doSelect(c);
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Map<String, Object> searchQuestionBank(String keyword, int tixingId, String user, int kpointId, int start, int limit) {
		int size = 0;
		StringBuffer sbr = new StringBuffer();
		StringBuffer searchSql = new StringBuffer();
		StringBuffer countSql = new StringBuffer(" select count(*) as count");
		
		searchSql.append(" select ").append(QuestionBankPeer.TABLE_NAME).append(".* ")
			.append(",").append(QuestionTixingPeer.TITLE);
		
		sbr.append(" from ").append(QuestionBankPeer.TABLE_NAME);
		
		sbr.append(" left join ").append(QuestionTixingPeer.TABLE_NAME).append(" on ")
			.append(QuestionTixingPeer.ID).append("=").append(QuestionBankPeer.TIXING_ID);
		
		sbr.append(" where 1=1 ");
		if (StringUtils.isNotBlank(keyword)) {
			sbr.append(" and ").append(QuestionBankPeer.CONTENT).append(" like '%").append(keyword).append("%' ");
		}
		if (StringUtils.isNotBlank(user)) {
			sbr.append(" and ").append(QuestionBankPeer.MEMBER).append(" like '%").append(user).append("%' ");
		}
		if(tixingId > 0){
			sbr.append(" and ").append(QuestionBankPeer.TIXING_ID).append(" = ").append(tixingId);
		}
		if(kpointId > 0){
			sbr.append(" and ").append(" find_in_set('"+kpointId+"',"+QuestionBankPeer.KNOWLEDGE_POINT_ID+")");
		}
		
		countSql.append(sbr);
		searchSql.append(sbr);
		
		searchSql.append(" order by ").append(QuestionBankPeer.ID).append(" desc ");
		searchSql.append(" limit ").append(start).append(",").append(limit);
		
		List<QuestionBank> list = new ArrayList<QuestionBank>();
		try {
			List<Record> countList = QuestionBankPeer.executeQuery(countSql.toString());
			List<Record> searchList = QuestionBankPeer.executeQuery(searchSql.toString());
			size = countList.get(0).getValue("count").asInt();
			
			for (int i = 0; i < searchList.size(); i++) {
				Record row = searchList.get(i);
				QuestionBank bank = QuestionBankPeer.row2Object(row, 1, QuestionBankPeer.getOMClass());
				bank.setTixingStr(row.getValue(QuestionTixingPeer.TITLE).asString());
				list.add(bank);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constant.TOTAL, size);
		map.put(Constant.DATA, list);
		return map;
	}

	
	public static boolean deleteById(int id) {
		String sql = " delete from " + QuestionBankPeer.TABLE_NAME + " where id = " + id;
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
	 * 查找相似度极高的试题
	 * 题型相同，且知识点相同，且匹配词能匹配上
	 * @param id
	 * @param tixingId
	 * @param knowledgePointId
	 * @param fenci
	 * @return
	 */
	public static QuestionBank searchSameBank(int id,int tixingId,int knowledgePointId,Set<String> fenci){
		// 相似度
		double scale = 0.8;

		// 必须匹配到的词的个数
		double size = Math.floor(fenci.size() * scale);

		String str = "";
		int i = 0;
		for(String s : fenci){
			if(i != 0){
				str += " ";
			}
			if(i < size){
				str += "+" + s;	
			}else{
				str += s;
			}
			i++;
		}
		
		//题型相同，且知识点相同，且匹配词能匹配上，则判断为相似度极高的题
		StringBuffer sql = new StringBuffer();
		sql.append(" select ").append(QuestionBankPeer.TABLE_NAME).append(".*, ");
		sql.append(" MATCH(fenci)AGAINST('" + str + "'IN BOOLEAN MODE)  as score");
		sql.append(" from ").append(QuestionBankPeer.TABLE_NAME);
		sql.append(" where ").append(QuestionBankPeer.TIXING_ID).append(" = ").append(tixingId);
		sql.append(" and find_in_set('"+knowledgePointId+"', "+QuestionBankPeer.KNOWLEDGE_POINT_ID+") ");
		sql.append(" and ").append("MATCH(fenci)AGAINST('" + str + "'IN BOOLEAN MODE) ");
		if(id > 0){
			sql.append(" and ").append(QuestionBankPeer.ID).append(" != ").append(id);
		}
		sql.append(" order by score desc ");
		sql.append(" limit 1 ");
		
		System.out.println("相似试题查询：" + sql.toString());
		
		
		try {
			List<Record> searchList = QuestionBankPeer.executeQuery(sql.toString());
			if(searchList != null && searchList.size() > 0){
				Record row = searchList.get(0);
				return QuestionBankPeer.row2Object(row, 1, QuestionBankPeer.getOMClass());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 试题被使用次数加1
	 * @param ids
	 */
	public static void addUsedTimes(String ids) {
		if(StringUtils.isBlank(ids)){
			return;
		}
		String[] arr = ids.split(",");
		try {
			for(String id : arr){
				QuestionBank bank = QuestionBankPeer.retrieveByPK(Integer.parseInt(id));
				if(bank != null){
					bank.setUsedTimes(bank.getUsedTimes() + 1);
					QuestionBankPeer.doUpdate(bank);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
