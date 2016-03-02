package com.hao.schoa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.torque.NoRowsException;
import org.apache.torque.TooManyRowsException;
import org.apache.torque.TorqueException;
import org.apache.torque.util.BasePeer;

import com.hao.schoa.po.QuestionPaper;
import com.hao.schoa.po.QuestionPaperPeer;
import com.hao.schoa.tools.Constant;
import com.workingdogs.village.Record;

public class QuestionPaperServiceImpl {

	public static Map<String, Object> searchQuestionPaper(String title, String user, int start, int limit) {
		int total = 0;
		StringBuffer countSql = new StringBuffer(" select count(*) as count");
		StringBuffer searchSql = new StringBuffer();
		
		searchSql.append(" select ").append(QuestionPaperPeer.TABLE_NAME).append(".* ");
		
		StringBuffer sbr = new StringBuffer();
		sbr.append(" from ").append(QuestionPaperPeer.TABLE_NAME);
		
		sbr.append(" where ").append(QuestionPaperPeer.VALID).append("=").append(Constant.valid);
		if(StringUtils.isNotBlank(title)){
			sbr.append(" and ").append(QuestionPaperPeer.TITLE).append(" like '%").append(title).append("%' ");
		}
		if(StringUtils.isNotBlank(user)){
			sbr.append(" and ").append(QuestionPaperPeer.MEMBER).append(" like '%").append(user).append("%' ");
		}
		
		countSql.append(sbr);
		searchSql.append(sbr);
		searchSql.append(" order by ").append(QuestionPaperPeer.CREATE_TIME).append(" desc ");
		searchSql.append(" limit  ").append(start).append(",").append(limit);
		
		List<QuestionPaper> list = new ArrayList<QuestionPaper>();
		try {
			List<Record> countList = QuestionPaperPeer.executeQuery(countSql.toString());
			List<Record> searchList = QuestionPaperPeer.executeQuery(searchSql.toString());
			total = countList.get(0).getValue("count").asInt();
			for (int i = 0; i < searchList.size(); i++) {
				Record row = searchList.get(i);
				QuestionPaper obj = QuestionPaperPeer.row2Object(row, 1, QuestionPaperPeer.getOMClass());
				if(obj.getCreateTime() != null){
					obj.setCreateTimeStr(Constant.CNDATEMIN.format(obj.getCreateTime()));
				}
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constant.TOTAL, total);
		map.put(Constant.DATA, list);
		return map;
	}

	public static boolean deleteById(int id,int delId,String delName) {
		String sql = " update " + QuestionPaperPeer.TABLE_NAME 
				+ " set " + QuestionPaperPeer.VALID + "=" + Constant.unvalid
				+ " , " + QuestionPaperPeer.DEL_MEMBER_ID + "=" + delId
				+ " , " + QuestionPaperPeer.DEL_MEMBER + "='" + delName + "' "
				+ " , " + QuestionPaperPeer.DEL_TIME + "='" + Constant.FULLDATE.format(new Date()) + "' "
				+ " where " + QuestionPaperPeer.ID + "=" + id;
		
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
	
	public static QuestionPaper getById(int id){
		try {
			return QuestionPaperPeer.retrieveByPK(id);
		} catch (NoRowsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TooManyRowsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TorqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
