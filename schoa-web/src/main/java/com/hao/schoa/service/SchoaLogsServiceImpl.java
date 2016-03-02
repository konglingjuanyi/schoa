package com.hao.schoa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.torque.TorqueException;

import com.hao.schoa.po.SchoaLogs;
import com.hao.schoa.po.SchoaLogsPeer;
import com.hao.schoa.tools.Constant;
import com.workingdogs.village.Record;

public class SchoaLogsServiceImpl {

	/**
	 * 添加日志
	 * @param operator
	 * @param description
	 */
	public static void insertLogs(String operator,String description){
		SchoaLogs log = new SchoaLogs();
		log.setOperator(operator);
		log.setOperatorTime(new Date());
		log.setDescription(description);
		try {
			SchoaLogsPeer.doInsert(log);
		} catch (TorqueException e) {
			e.printStackTrace();
		}
	}

	public static Map<String, Object> searchLogs(String name, int start, int limit) {
		int total = 0;
		StringBuffer countSql = new StringBuffer(" select count(*) as count");
		StringBuffer searchSql = new StringBuffer();
		
		searchSql.append(" select ").append(SchoaLogsPeer.TABLE_NAME).append(".* ");
		
		StringBuffer sbr = new StringBuffer();
		sbr.append(" from ").append(SchoaLogsPeer.TABLE_NAME);
		
		sbr.append(" where 1=1 ");
		if(StringUtils.isNotBlank(name)){
			sbr.append(" and ").append(SchoaLogsPeer.OPERATOR).append(" like '%").append(name).append("%' ");
		}
		
		countSql.append(sbr);
		searchSql.append(sbr)
				.append(" order by ").append(SchoaLogsPeer.OPERATOR_TIME).append(" desc")
				.append(" limit  ").append(start).append(",").append(limit);
		
		List<SchoaLogs> list = new ArrayList<SchoaLogs>();
		try {
			List<Record> countList = SchoaLogsPeer.executeQuery(countSql.toString());
			List<Record> searchList = SchoaLogsPeer.executeQuery(searchSql.toString());
			total = countList.get(0).getValue("count").asInt();
			for (int i = 0; i < searchList.size(); i++) {
				Record row = searchList.get(i);
				SchoaLogs obj = SchoaLogsPeer.row2Object(row, 1, SchoaLogsPeer.getOMClass());
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
}
