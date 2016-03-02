package com.hao.schoa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.torque.NoRowsException;
import org.apache.torque.TooManyRowsException;
import org.apache.torque.TorqueException;

import com.hao.schoa.po.Classes;
import com.hao.schoa.po.ClassesPeer;
import com.hao.schoa.po.Kecheng;
import com.hao.schoa.po.KechengPeer;
import com.hao.schoa.po.Tingke;
import com.hao.schoa.po.TingkePeer;
import com.hao.schoa.po.Xueqi;
import com.hao.schoa.po.XueqiPeer;
import com.hao.schoa.tools.Constant;
import com.workingdogs.village.Record;

/**
 * 教师听课情况
 * @author haoguowei
 *
 */
public class TingkeServiceImpl {

	public static Map<String, Object> search(int selfTeacherId, int xueqiId, int classesId, int kechengId, int teacherId, int start, int limit) {
		int total = 0;
		StringBuffer countSql = new StringBuffer(" select count(*) as count");
		StringBuffer searchSql = new StringBuffer();
		
		searchSql.append(" select ").append(TingkePeer.TABLE_NAME).append(".* ")
					.append(",").append(XueqiPeer.NAME)
					.append(",").append(ClassesPeer.NAME)
					.append(",").append(KechengPeer.NAME);
		
		StringBuffer sbr = new StringBuffer();
		sbr.append(" from ").append(TingkePeer.TABLE_NAME);
		sbr.append(" left join ").append(XueqiPeer.TABLE_NAME).append(" on ").append(XueqiPeer.ID).append("=").append(TingkePeer.XUEQI_ID);
		sbr.append(" left join ").append(ClassesPeer.TABLE_NAME).append(" on ").append(ClassesPeer.ID).append("=").append(TingkePeer.BANJI_ID);
		sbr.append(" left join ").append(KechengPeer.TABLE_NAME).append(" on ").append(KechengPeer.ID).append("=").append(TingkePeer.KECHENG_ID);
		
		sbr.append(" where 1=1 ");
		if(xueqiId > 0){
			sbr.append(" and ").append(TingkePeer.XUEQI_ID).append(" = ").append(xueqiId);
		}
		if(classesId > 0){
			sbr.append(" and ").append(TingkePeer.BANJI_ID).append(" = ").append(classesId);
		}
		if(kechengId > 0){
			sbr.append(" and ").append(TingkePeer.KECHENG_ID).append(" = ").append(kechengId);
		}
		if(teacherId > 0){
			sbr.append(" and ").append(TingkePeer.DUXIE_TEACHER_ID).append(" = ").append(teacherId);
		}
		if(selfTeacherId != 0){
			sbr.append(" and ").append(KechengPeer.TEACHER_ID).append(" = ").append(selfTeacherId);
		}
		
		
		countSql.append(sbr);
		searchSql.append(sbr);
		searchSql.append(" order by ").append(TingkePeer.KECHENG_ID).append(" desc ");
		searchSql.append(" limit  ").append(start).append(",").append(limit);
		
		List<Tingke> list = new ArrayList<Tingke>();
		try {
			List<Record> countList = TingkePeer.executeQuery(countSql.toString());
			List<Record> searchList = TingkePeer.executeQuery(searchSql.toString());
			total = countList.get(0).getValue("count").asInt();
			for (int i = 0; i < searchList.size(); i++) {
				Record row = searchList.get(i);
				Tingke obj = TingkePeer.row2Object(row, 1, TingkePeer.getOMClass());
				
				Xueqi xq = new Xueqi();
				xq.setName(row.getValue(XueqiPeer.NAME).asString());
				obj.setXueqi(xq);
				
				Classes banji = new Classes();
				banji.setName(row.getValue(ClassesPeer.NAME).asString());
				obj.setBanji(banji);
				
				Kecheng kecheng = new Kecheng();
				kecheng.setName(row.getValue(KechengPeer.NAME).asString());
				obj.setKecheng(kecheng);
			
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

	public static Tingke getTingkeById(int id) {
		try {
			return TingkePeer.retrieveByPK(id);
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

	public static Boolean deleteTingke(int id) {
		String sql = "delete from " + TingkePeer.TABLE_NAME
				+ " where " + TingkePeer.ID + "=" + id;
		try {
			TingkePeer.executeStatement(sql);
			return true;
		} catch (TorqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
