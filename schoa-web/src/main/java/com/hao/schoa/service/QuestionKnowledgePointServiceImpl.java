package com.hao.schoa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.torque.NoRowsException;
import org.apache.torque.TooManyRowsException;
import org.apache.torque.TorqueException;
import org.apache.torque.util.BasePeer;
import org.apache.torque.util.Criteria;

import com.hao.schoa.po.QuestionKnowledgePoint;
import com.hao.schoa.po.QuestionKnowledgePointPeer;
import com.hao.schoa.tools.Constant;
import com.workingdogs.village.Record;

public class QuestionKnowledgePointServiceImpl {
	
	/**
	 * 查询知识点
	 * @return
	 */
	public static Map<String, Object> searchKnowledgePoint(String name, int start, int limit) {

		int size = 0;
		StringBuffer sbr = new StringBuffer();
		StringBuffer searchSql = new StringBuffer();
		StringBuffer countSql = new StringBuffer(" select count(*) as count");
		
		searchSql.append(" select ").append(QuestionKnowledgePointPeer.TABLE_NAME).append(".* ");
		
		sbr.append(" from ").append(QuestionKnowledgePointPeer.TABLE_NAME);
		
		sbr.append(" where 1=1 ");
		if (StringUtils.isNotBlank(name)) {
			sbr.append(" and ").append(QuestionKnowledgePointPeer.NAME).append(" like '%").append(name).append("%' ");
		}
		
		countSql.append(sbr);
		searchSql.append(sbr);
		
		searchSql.append(" order by ").append(QuestionKnowledgePointPeer.ID).append(" desc ");
		searchSql.append(" limit ").append(start).append(",").append(limit);
		
		List<QuestionKnowledgePoint> list = new ArrayList<QuestionKnowledgePoint>();
		try {
			List<Record> countList = QuestionKnowledgePointPeer.executeQuery(countSql.toString());
			List<Record> searchList = QuestionKnowledgePointPeer.executeQuery(searchSql.toString());
			size = countList.get(0).getValue("count").asInt();
			
			for (int i = 0; i < searchList.size(); i++) {
				Record row = searchList.get(i);
				QuestionKnowledgePoint kpoint = QuestionKnowledgePointPeer.row2Object(row, 1, QuestionKnowledgePointPeer.getOMClass());
				list.add(kpoint);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constant.TOTAL, size);
		map.put(Constant.DATA, list);
		return map;
	}

	public static QuestionKnowledgePoint getQuestionKnowledgePointById(int id) {
		try {
			return QuestionKnowledgePointPeer.retrieveByPK(id);
		} catch (NoRowsException e) {
			e.printStackTrace();
		} catch (TooManyRowsException e) {
			e.printStackTrace();
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<QuestionKnowledgePoint> getQuestionKnowledgePointList(){
		Criteria c = new Criteria();
		c.addDescendingOrderByColumn(QuestionKnowledgePointPeer.ID);
		List<QuestionKnowledgePoint> list = null;
		try {
			list = QuestionKnowledgePointPeer.doSelect(c);
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static boolean deleteById(int id) {
		String sql = " delete from " + QuestionKnowledgePointPeer.TABLE_NAME + " where id = " + id;
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

}
