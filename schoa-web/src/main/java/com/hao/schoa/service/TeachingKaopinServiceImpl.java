package com.hao.schoa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.torque.NoRowsException;
import org.apache.torque.TooManyRowsException;
import org.apache.torque.TorqueException;
import org.apache.torque.util.BasePeer;
import org.apache.torque.util.Criteria;

import com.hao.schoa.po.Classes;
import com.hao.schoa.po.ClassesPeer;
import com.hao.schoa.po.JiaoxueKaopin;
import com.hao.schoa.po.JiaoxueKaopinInfo;
import com.hao.schoa.po.JiaoxueKaopinInfoPeer;
import com.hao.schoa.po.JiaoxueKaopinPeer;
import com.hao.schoa.po.Kecheng;
import com.hao.schoa.po.KechengPeer;
import com.hao.schoa.po.Teacher;
import com.hao.schoa.po.TeacherPeer;
import com.hao.schoa.po.Xueqi;
import com.hao.schoa.po.XueqiPeer;
import com.hao.schoa.tools.Constant;
import com.workingdogs.village.Record;

/**
 * 教学考评
 * @author haoguowei
 *
 */
public class TeachingKaopinServiceImpl {
	
	public static Map<String, Object> search(int teacherId,int xueqiId, int classesId, int kechengId, int start, int limit) {
		int total = 0;
		StringBuffer countSql = new StringBuffer(" select count(*) as count");
		StringBuffer searchSql = new StringBuffer();
		
		searchSql.append(" select ").append(JiaoxueKaopinPeer.TABLE_NAME).append(".* ")
					.append(",").append(XueqiPeer.NAME)
					.append(",").append(ClassesPeer.NAME)
					.append(",").append(KechengPeer.NAME)
					.append(",").append(TeacherPeer.NAME);
		
		StringBuffer sbr = new StringBuffer();
		sbr.append(" from ").append(JiaoxueKaopinPeer.TABLE_NAME);
		sbr.append(" left join ").append(XueqiPeer.TABLE_NAME).append(" on ").append(XueqiPeer.ID).append("=").append(JiaoxueKaopinPeer.XUEQI_ID);
		sbr.append(" left join ").append(ClassesPeer.TABLE_NAME).append(" on ").append(ClassesPeer.ID).append("=").append(JiaoxueKaopinPeer.BANJI_ID);
		sbr.append(" left join ").append(KechengPeer.TABLE_NAME).append(" on ").append(KechengPeer.ID).append("=").append(JiaoxueKaopinPeer.KECHENG_ID);
		sbr.append(" left join ").append(TeacherPeer.TABLE_NAME).append(" on ").append(TeacherPeer.ID).append("=").append(JiaoxueKaopinPeer.TEACHER_ID);
		
		sbr.append(" where 1=1 ");
		if(xueqiId > 0){
			sbr.append(" and ").append(JiaoxueKaopinPeer.XUEQI_ID).append(" = ").append(xueqiId);
		}
		if(classesId > 0){
			sbr.append(" and ").append(JiaoxueKaopinPeer.BANJI_ID).append(" = ").append(classesId);
		}
		if(kechengId > 0){
			sbr.append(" and ").append(JiaoxueKaopinPeer.KECHENG_ID).append(" = ").append(kechengId);
		}
		if(teacherId != 0){
			sbr.append(" and ").append(JiaoxueKaopinPeer.TEACHER_ID).append(" = ").append(teacherId);
		}
		
		
		countSql.append(sbr);
		searchSql.append(sbr);
		searchSql.append(" order by ").append(JiaoxueKaopinPeer.KECHENG_ID).append(" desc ");
		searchSql.append(" limit  ").append(start).append(",").append(limit);
		
		List<JiaoxueKaopin> list = new ArrayList<JiaoxueKaopin>();
		try {
			List<Record> countList = JiaoxueKaopinPeer.executeQuery(countSql.toString());
			List<Record> searchList = JiaoxueKaopinPeer.executeQuery(searchSql.toString());
			total = countList.get(0).getValue("count").asInt();
			for (int i = 0; i < searchList.size(); i++) {
				Record row = searchList.get(i);
				JiaoxueKaopin obj = JiaoxueKaopinPeer.row2Object(row, 1, JiaoxueKaopinPeer.getOMClass());
				
				Teacher teacher = new Teacher();
				teacher.setId(obj.getTeacherId());
				teacher.setName(row.getValue(TeacherPeer.NAME).asString());
				obj.setTeacher(teacher);
				
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

	public static Boolean deleteKaopin(int kaopinId) {
		String sql = "delete from " + JiaoxueKaopinPeer.TABLE_NAME
					+ " where " + JiaoxueKaopinPeer.ID + "=" + kaopinId;
		
		try {
			JiaoxueKaopinPeer.executeStatement(sql);
			deleteKaopinItems(kaopinId);
			return true;
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public static JiaoxueKaopin getKaopinById(int id) {
		if(id <= 0){
			return null;
		}
		try {
			return JiaoxueKaopinPeer.retrieveByPK(id);
		} catch (NoRowsException e) {
			e.printStackTrace();
		} catch (TooManyRowsException e) {
			e.printStackTrace();
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static JiaoxueKaopin getKaopinFullById(int id) {
		if(id <= 0){
			return null;
		}
		try {
			JiaoxueKaopin kaopin = JiaoxueKaopinPeer.retrieveByPK(id);
			
			Teacher teacher = TeacherServiceImpl.getById(kaopin.getTeacherId());
			kaopin.setTeacher(teacher);
			
			Classes banji = ClassesServiceImpl.retrieveByPK(kaopin.getBanjiId());
			kaopin.setBanji(banji);
			
			Xueqi xueqi = XueqiServiceImpl.getById2(kaopin.getXueqiId());
			kaopin.setXueqi(xueqi);
			
			Kecheng kecheng = KechengServiceImpl.retrieveByPK(kaopin.getKechengId());
			kaopin.setKecheng(kecheng);
			
			return kaopin;
		} catch (NoRowsException e) {
			e.printStackTrace();
		} catch (TooManyRowsException e) {
			e.printStackTrace();
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static JiaoxueKaopinInfo getKaopinInfoById(int id) {
		try {
			return JiaoxueKaopinInfoPeer.retrieveByPK(id);
		} catch (NoRowsException e) {
			e.printStackTrace();
		} catch (TooManyRowsException e) {
			e.printStackTrace();
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Boolean deleteKaopinItem(int id) {
		
		JiaoxueKaopinInfo obj = null;
		try {
			obj = JiaoxueKaopinInfoPeer.retrieveByPK(id);
		} catch (NoRowsException e1) {
			e1.printStackTrace();
		} catch (TooManyRowsException e1) {
			e1.printStackTrace();
		} catch (TorqueException e1) {
			e1.printStackTrace();
		}
		if(obj == null){
			return false;
		}
		int kaopinId = obj.getKaopinId();
		
		String sql = "delete from " + JiaoxueKaopinInfoPeer.TABLE_NAME
				+ " where " + JiaoxueKaopinInfoPeer.ID + "=" + id;
	
		try {
			JiaoxueKaopinInfoPeer.executeStatement(sql);
			//计算得分
			int score = TeachingKaopinServiceImpl.calKaopinScore(kaopinId);
			TeachingKaopinServiceImpl.updateKaopinScore(kaopinId, score);
			
			return true;
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	public static Boolean deleteKaopinItems(int kaopinId) {
		String sql = "delete from " + JiaoxueKaopinInfoPeer.TABLE_NAME
				+ " where " + JiaoxueKaopinInfoPeer.KAOPIN_ID + " = " + kaopinId;
		
		try {
			JiaoxueKaopinInfoPeer.executeStatement(sql);
			return true;
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static List<JiaoxueKaopinInfo> getKappinfenList(int kaopinId){
		Criteria c = new Criteria();
		c.add(JiaoxueKaopinInfoPeer.KAOPIN_ID, kaopinId);
		c.addDescendingOrderByColumn(JiaoxueKaopinInfoPeer.UPDATE_TIME);
		
		List<JiaoxueKaopinInfo> list = null;
		try {
			list = JiaoxueKaopinInfoPeer.doSelect(c);
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static Map<String, Object> searchKaopinPingfenList(int kaopinId) {
		List<JiaoxueKaopinInfo> list = getKappinfenList(kaopinId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constant.TOTAL, list==null?0:list.size());
		map.put(Constant.DATA, list);
		return map;
	}

	public static int calKaopinScore(int kaopinId) {
		int score = 0;
		
		List<JiaoxueKaopinInfo> list = getKappinfenList(kaopinId);
		if(list == null || list.isEmpty()){
			return score;
		}
		
		//试题数
		int shitiSize = Constant.questionMap.size();
		//考评人数
		int mans = list.size();
		//优秀分
		int youxiu = shitiSize * mans * 4;
		//总得分
		int sum = 0;
		
		for(JiaoxueKaopinInfo info : list){
			sum += info.getSumScore();
		}
		sum = Math.min(youxiu, sum);
		
		return sum * 30 / youxiu;
	}

	public static void updateKaopinScore(int kaopinId, int score) {
		String sql = " update " + JiaoxueKaopinPeer.TABLE_NAME
					+ " set " + JiaoxueKaopinPeer.SCORE + "=" + score
					+ " where " + JiaoxueKaopinPeer.ID + "=" + kaopinId;	
		
		try {
			JiaoxueKaopinPeer.executeStatement(sql);
		} catch (TorqueException e) {
			e.printStackTrace();
		}
	}

	public static List<JiaoxueKaopin> getKaopin(int xueqiId, int classesId, int kechengId) {
		Criteria c = new Criteria();
		c.add(JiaoxueKaopinPeer.XUEQI_ID, xueqiId);
		c.add(JiaoxueKaopinPeer.BANJI_ID, classesId);
		c.add(JiaoxueKaopinPeer.KECHENG_ID, kechengId);
		try {
			return JiaoxueKaopinPeer.doSelect(c);
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static Map<String, Integer> getAVGScore(String ids) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String sql = "SELECT  ROUND(AVG(anshi)), ROUND(AVG(youyiyi)), ROUND(AVG(neirong)), ROUND(AVG(shouhuo)), "
				+ "ROUND(AVG(shuohua_qingchu)), ROUND(AVG(heibanzi_qingchu)), ROUND(AVG(heibanzi_zhongyao)), "
				+ "ROUND(AVG(shuliang_heshi)), ROUND(AVG(hanzi_jihui)), ROUND(AVG(huodong_youxiao)),  ROUND(AVG(zuoye_heshi)), "
				+ "ROUND(AVG(zuoye_bangzhu)), ROUND(AVG(naixin)),  ROUND(AVG(jinbu)), ROUND(AVG(yange)),  ROUND(AVG(yuanyi)), ROUND(AVG(liaotian)) "
				+ "FROM jiaoxue_kaopin_info "
				+ " WHERE kaopin_id IN (" + ids + ")";
		try {
			List<Record> ls = BasePeer.executeQuery(sql);
			if(ls == null || ls.isEmpty()){
				return map;
			}
			Record rec = ls.get(0);
			map.put("anshi", rec.getValue("ROUND(AVG(anshi))").asInt());
			map.put("youyiyi", rec.getValue("ROUND(AVG(youyiyi))").asInt());
			map.put("neirong", rec.getValue("ROUND(AVG(neirong))").asInt());
			map.put("shouhuo", rec.getValue("ROUND(AVG(shouhuo))").asInt());
			map.put("shuohuaQingchu", rec.getValue("ROUND(AVG(shuohua_qingchu))").asInt());
			map.put("heibanziQingchu", rec.getValue("ROUND(AVG(heibanzi_qingchu))").asInt());
			map.put("heibanziZhongyao", rec.getValue("ROUND(AVG(heibanzi_zhongyao))").asInt());
			map.put("shuliangHeshi", rec.getValue("ROUND(AVG(shuliang_heshi))").asInt());
			map.put("hanziJihui", rec.getValue("ROUND(AVG(hanzi_jihui))").asInt());
			map.put("huodongYouxiao", rec.getValue("ROUND(AVG(huodong_youxiao))").asInt());
			map.put("zuoyeHeshi", rec.getValue("ROUND(AVG(zuoye_heshi))").asInt());
			map.put("zuoyeBangzhu", rec.getValue("ROUND(AVG(zuoye_bangzhu))").asInt());
			map.put("naixin", rec.getValue("ROUND(AVG(naixin))").asInt());
			map.put("jinbu", rec.getValue("ROUND(AVG(jinbu))").asInt());
			map.put("yange", rec.getValue("ROUND(AVG(yange))").asInt());
			map.put("yuanyi", rec.getValue("ROUND(AVG(yuanyi))").asInt());
			map.put("liaotian", rec.getValue("ROUND(AVG(liaotian))").asInt());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}
	
	public static Map<Integer,Integer> getKaopinMans(String column,int xueqiId,int banjiId,int kechengId,int teacherId){
		
		column = Constant.keyMapping.get(column)==null?column:Constant.keyMapping.get(column);
		
		StringBuffer sbr = new StringBuffer();
		sbr.append(" select ").append(JiaoxueKaopinInfoPeer.TABLE_NAME).append(".").append(column)
			.append(",count(").append(JiaoxueKaopinInfoPeer.TABLE_NAME).append(".").append(column).append(") ")
			.append(" from ").append(JiaoxueKaopinInfoPeer.TABLE_NAME)
			.append(" left join ").append(JiaoxueKaopinPeer.TABLE_NAME).append(" on ")
			.append(JiaoxueKaopinPeer.ID).append("=").append(JiaoxueKaopinInfoPeer.KAOPIN_ID)
			.append(" where ").append(JiaoxueKaopinPeer.XUEQI_ID).append("=").append(xueqiId)
			.append(" and ").append(JiaoxueKaopinPeer.BANJI_ID).append("=").append(banjiId)
			.append(" and ").append(JiaoxueKaopinPeer.KECHENG_ID).append("=").append(kechengId)
			.append(" and ").append(JiaoxueKaopinPeer.TEACHER_ID).append("=").append(teacherId)
			.append(" group by ").append(JiaoxueKaopinInfoPeer.TABLE_NAME).append(".").append(column);
		
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		try {
			List<Record> ls = BasePeer.executeQuery(sbr.toString());
			if(ls == null){
				return map;
			}
			for(Record rec : ls){
				map.put(rec.getValue(1).asInt(), rec.getValue(2).asInt());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	public static Map<Integer,Integer> getKaopinMans(String column, int kaopinId){
		
		column = Constant.keyMapping.get(column)==null?column:Constant.keyMapping.get(column);
		
		StringBuffer sbr = new StringBuffer();
		sbr.append(" select ").append(JiaoxueKaopinInfoPeer.TABLE_NAME).append(".").append(column)
		.append(",count(").append(JiaoxueKaopinInfoPeer.TABLE_NAME).append(".").append(column).append(") ")
		.append(" from ").append(JiaoxueKaopinInfoPeer.TABLE_NAME)
		.append(" where ").append(JiaoxueKaopinInfoPeer.KAOPIN_ID).append("=").append(kaopinId)
		.append(" group by ").append(JiaoxueKaopinInfoPeer.TABLE_NAME).append(".").append(column);
		
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		try {
			List<Record> ls = BasePeer.executeQuery(sbr.toString());
			if(ls == null){
				return map;
			}
			for(Record rec : ls){
				map.put(rec.getValue(1).asInt(), rec.getValue(2).asInt());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	public static double getSumScore(int xueqiId,int banjiId,int kechengId,int teacherId){
		StringBuffer sbr = new StringBuffer();
		sbr.append(" select ").append("AVG(score) ")
			.append(" from ").append(JiaoxueKaopinPeer.TABLE_NAME)
			.append(" where ").append(JiaoxueKaopinPeer.XUEQI_ID).append("=").append(xueqiId)
			.append(" and ").append(JiaoxueKaopinPeer.BANJI_ID).append("=").append(banjiId)
			.append(" and ").append(JiaoxueKaopinPeer.KECHENG_ID).append("=").append(kechengId)
			.append(" and ").append(JiaoxueKaopinPeer.TEACHER_ID).append("=").append(teacherId);
		
		try {
			List<Record> ls = BasePeer.executeQuery(sbr.toString());
			if(ls == null || ls.isEmpty()){
				return 0;
			}
			Record rec = ls.get(0);
			return rec.getValue(1).asDouble();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}

	public static List<JiaoxueKaopinInfo> getKaopinPingjia(int xueqiId,
			int classesId, int kechengId, int teacherId) {
		Criteria c = new Criteria();
		c.add(JiaoxueKaopinPeer.XUEQI_ID, xueqiId);
		c.add(JiaoxueKaopinPeer.BANJI_ID, classesId);
		c.add(JiaoxueKaopinPeer.KECHENG_ID, kechengId);
		c.add(JiaoxueKaopinPeer.TEACHER_ID, teacherId);
		try {
			List<JiaoxueKaopin> ls = JiaoxueKaopinPeer.doSelect(c);
			if(ls != null && ls.size() > 0){
				int kpId = ls.get(0).getId();
				return getKaopinPingjia(kpId);
			}
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	private static List<JiaoxueKaopinInfo> getKaopinPingjia(int kpId) {
		Criteria c = new Criteria();
		c.add(JiaoxueKaopinInfoPeer.KAOPIN_ID, kpId);
		try {
			return JiaoxueKaopinInfoPeer.doSelect(c);
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
