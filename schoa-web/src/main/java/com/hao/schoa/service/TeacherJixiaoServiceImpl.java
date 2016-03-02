package com.hao.schoa.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.torque.NoRowsException;
import org.apache.torque.TooManyRowsException;
import org.apache.torque.TorqueException;
import org.apache.torque.util.BasePeer;
import org.apache.torque.util.Criteria;

import com.hao.schoa.container.Jixiao;
import com.hao.schoa.container.JixiaoKey;
import com.hao.schoa.po.JiaoxueFilePeer;
import com.hao.schoa.po.JiaoxueKaopinPeer;
import com.hao.schoa.po.JixiaoWaipin;
import com.hao.schoa.po.JixiaoWaipinPeer;
import com.hao.schoa.po.JixiaoZaibian;
import com.hao.schoa.po.JixiaoZaibianPeer;
import com.hao.schoa.po.TingkePeer;
import com.hao.schoa.po.Xueqi;
import com.hao.schoa.tools.Constant;
import com.workingdogs.village.DataSetException;
import com.workingdogs.village.Record;

public class TeacherJixiaoServiceImpl {

	public static Map<JixiaoKey,JixiaoWaipin> getWaipinJixiao(int xueqiId,int teacherId) {
		List<Jixiao> ls = getJixiao(xueqiId,teacherId,false);
		if(ls == null){
			return null;
		}
		
		Map<JixiaoKey,JixiaoWaipin> map = new LinkedHashMap<JixiaoKey,JixiaoWaipin>();
		for(Jixiao jixiao : ls){
			JixiaoKey key = new JixiaoKey();
			key.setTeacherId(jixiao.getTeacherId());
			key.setXueqiId(jixiao.getXueqiId());
			
			JixiaoWaipin item = null;
			if(map.containsKey(key)){
				item = map.get(key);
			}else{
				item = getJixiaoWaipin(jixiao.getXueqiId(),jixiao.getTeacherId());
				item.setXueqiId(jixiao.getXueqiId());
				item.setXueqiName(jixiao.getXueqiName());
				item.setTeacherId(jixiao.getTeacherId());
				item.setTeacherName(jixiao.getTeacherName());
			}
			
			List<Jixiao> JixiaoList = item.getJixiao();
			if(JixiaoList==null){
				JixiaoList = new ArrayList<Jixiao>();
			}
			JixiaoList.add(jixiao);
			item.setJixiao(JixiaoList);
			
			map.put(key, item);
		}
		
		return map;
	}
	public static Map<JixiaoKey,JixiaoZaibian> getZaiBianJixiao(int xueqiId,int teacherId) {
		List<Jixiao> ls = getJixiao(xueqiId,teacherId,true);
		if(ls == null){
			return null;
		}
		
		Map<JixiaoKey,JixiaoZaibian> map = new LinkedHashMap<JixiaoKey,JixiaoZaibian>();
		for(Jixiao jixiao : ls){
			JixiaoKey key = new JixiaoKey();
			key.setTeacherId(jixiao.getTeacherId());
			key.setXueqiId(jixiao.getXueqiId());
			
			JixiaoZaibian item = null;
			if(map.containsKey(key)){
				item = map.get(key);
			}else{
				item = getJixiaoZaibian(jixiao.getXueqiId(),jixiao.getTeacherId());
				item.setXueqiId(jixiao.getXueqiId());
				item.setXueqiName(jixiao.getXueqiName());
				item.setTeacherId(jixiao.getTeacherId());
				item.setTeacherName(jixiao.getTeacherName());
			}
			
			List<Jixiao> JixiaoList = item.getJixiao();
			if(JixiaoList==null){
				JixiaoList = new ArrayList<Jixiao>();
			}
			JixiaoList.add(jixiao);
			item.setJixiao(JixiaoList);
			
			map.put(key, item);
		}
		
		return map;
	}
	
	public static JixiaoWaipin getJixiaoWaipin(int xueqiId,int teacherId){
		Criteria c = new Criteria();
		if(xueqiId > 0){
			c.add(JixiaoWaipinPeer.XUEQI_ID, xueqiId);
		}
		if(teacherId > 0){
			c.add(JixiaoWaipinPeer.TEACHER_ID, teacherId);
		}
		c.addDescendingOrderByColumn(JixiaoWaipinPeer.ID);
		c.setLimit(1);
		try {
			List<JixiaoWaipin> ls = JixiaoWaipinPeer.doSelect(c);
			if(ls!=null&&ls.size() > 0){
				return ls.get(0);
			}
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return new JixiaoWaipin();
	}
	public static JixiaoZaibian getJixiaoZaibian(int xueqiId,int teacherId){
		Criteria c = new Criteria();
		if(xueqiId > 0){
			c.add(JixiaoZaibianPeer.XUEQI_ID, xueqiId);
		}
		if(teacherId > 0){
			c.add(JixiaoZaibianPeer.TEACHER_ID, teacherId);
		}
		c.addDescendingOrderByColumn(JixiaoZaibianPeer.ID);
		c.setLimit(1);
		try {
			List<JixiaoZaibian> ls = JixiaoZaibianPeer.doSelect(c);
			if(ls!=null&&ls.size() > 0){
				return ls.get(0);
			}
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return new JixiaoZaibian();
	}
	
	public static JixiaoZaibian getJixiaoById(int id){
		try {
			return JixiaoZaibianPeer.retrieveByPK(id);
		} catch (NoRowsException e) {
			e.printStackTrace();
		} catch (TooManyRowsException e) {
			e.printStackTrace();
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<Jixiao> getJixiao(int xueqiId,int teacherId, boolean zhengbian){
		String sql = "select t.id,t.name,k.xueqi_id,x.name,ck.classes_id,c.name,ck.kecheng_id,k.name"
					+" from classes_kecheng ck"
					+" left join kecheng k on k.id = ck.kecheng_id"
					+" left join teacher t on t.id = k.teacher_id"
					+" left join xueqi x on x.id = k.xueqi_id"
					+" left join classes c on c.id = ck.classes_id"
					+" where t.type = " + (zhengbian?0:1);
		if(xueqiId > 0){
			sql += " and k.xueqi_id="+xueqiId ; //学期
		}
		if(teacherId > 0){
			sql += " and t.id="+teacherId;  //教师
		}
		sql+= " group by t.id,k.xueqi_id,ck.classes_id,ck.kecheng_id"
			+" order by t.id,k.xueqi_id,ck.classes_id,ck.kecheng_id";
		
		
		List<Jixiao> ls = new ArrayList<Jixiao>();
		try {
			List<Record> searchList = JiaoxueKaopinPeer.executeQuery(sql.toString());
			for (int i = 0; i < searchList.size(); i++) {
				Record row = searchList.get(i);
				int _tID = row.getValue(1).asInt();
				int _xID = row.getValue(3).asInt();
				int _cID = row.getValue(5).asInt();
				int _kID = row.getValue(7).asInt();
				
				Jixiao jixiao = new Jixiao();
				
				jixiao.setTeacherId(_tID);
				jixiao.setTeacherName(row.getValue(2).asString());
				jixiao.setXueqiId(_xID);
				jixiao.setXueqiName(row.getValue(4).asString());
				jixiao.setBanjiId(_cID);
				jixiao.setBanjiName(row.getValue(6).asString());
				jixiao.setKechengId(_kID);
				jixiao.setKechengName(row.getValue(8).asString());
				
				Xueqi xq = XueqiServiceImpl.getById2(_xID);
				
				jixiao.setScKaopin(calKaopinScore(_xID, _cID, _kID, _tID));
				jixiao.setScChuqin(calChuqinScore(_xID, _cID, _kID, _tID, xq));
				jixiao.setScJiaoxuefile(calFileScore(_xID, _cID, _kID, _tID));
				jixiao.setScTingke(calTingkeScore(_xID, _cID, _kID, _tID));
				ls.add(jixiao);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ls;
	}
	
	public static double getScore(String sql){
		List<Record> ls = null;
		double score = 0;
		try {
			ls = BasePeer.executeQuery(sql);
			if(ls != null && !ls.isEmpty()){
				score = ls.get(0).getValue(1).asDouble();
			}
		} catch (TorqueException e) {
			e.printStackTrace();
		}catch (DataSetException e) {
			e.printStackTrace();
		}
		return score;
	}

	
	/**
	 * 计算外聘教师听课成绩
	 * @param jixiao
	 * @return
	 */
	public static double calTingkeScore(int xueqiId,int banjiId,int kechengId,int teacherId) {
		String sql = "SELECT AVG("+TingkePeer.SCORE+") "
				+ " FROM  " + TingkePeer.TABLE_NAME
				+ " WHERE "+TingkePeer.XUEQI_ID+" = " + xueqiId
				+ " AND "+TingkePeer.BANJI_ID+"=" + banjiId
				+ " AND "+TingkePeer.KECHENG_ID+"= " + kechengId
				+ " AND "+TingkePeer.TEACHER_ID+"=" + teacherId;
		
		return getScore(sql);
	}
	
	
	/**
	 * 计算外聘教师教学文件成绩
	 * @param jixiao
	 * @return
	 */
	public static double calFileScore(int xueqiId,int banjiId,int kechengId,int teacherId) {
		String sql = "SELECT sum("+JiaoxueFilePeer.FILE_SCORE+") "
				+ " FROM " + JiaoxueFilePeer.TABLE_NAME
				+ " WHERE " + JiaoxueFilePeer.KECHENG_ID + "=" + kechengId
				+ " AND " + JiaoxueFilePeer.XUEQI_ID + "=" + xueqiId
				+ " AND " + JiaoxueFilePeer.TEACHER_ID + "=" + teacherId
				+ " AND " + JiaoxueFilePeer.SAVE_NAME + " IS NOT NULL  " 
				+ " AND " + JiaoxueFilePeer.SAVE_NAME + " != ''  " ;

		return getScore(sql);
	}



	/**
	 * 计算外聘教师出勤成绩
	 * @param jixiao
	 * @param xueqi
	 * @return
	 */
	public static double calChuqinScore(int xueqiId,int banjiId,int kechengId,int teacherId,Xueqi xueqi) {
		Map<Integer,Integer> map = TeacherChuqinServiceImpl.getChuqinTimes(teacherId,banjiId,kechengId, xueqi.getStartDate(), xueqi.getEndDate());
		if(map == null || map.size() == 0){
			return Constant.sc_teacher_chuqin;
		}
		//迟到一次扣2.5分，缺课一次扣5分。请假或调课一次扣2分，20分满分，扣完不再扣。
		double score = Constant.sc_teacher_chuqin 
				- (map.containsKey(-1)?map.get(-1):0) * 2.5 //迟到
				- (map.containsKey(1)?map.get(1):0) * 5 //缺课
				- (map.containsKey(-3)?map.get(-3):0) * 2; //请假或调课
		
		return Math.max(score, 0);
	
	}
//	public static double calChuqinScore(int xueqiId,int banjiId,int kechengId,int teacherId,Xueqi xueqi) {
//		int queqin = TeacherChuqinqinServiceImpl.getQueqinKeshi(teacherId,banjiId,kechengId, xueqi.getStartDate(), xueqi.getEndDate());
//		int sum = ScoreServiceImpl.getTotalKeshi(xueqi.getStartDate(), xueqi.getEndDate(), banjiId, kechengId);
//		double chuqin = (sum - queqin) * 1.0;
//		if(sum != 0){
//			return Math.round(Constant.sc_teacher_chuqin * chuqin / sum);
//		}
//		return 0;
//	}

	/**
	 * 计算外聘教师考评成绩
	 * @param jixiao
	 * @return
	 */
	public static double calKaopinScore(int xueqiId,int banjiId,int kechengId,int teacherId) {
		String sql = "SELECT AVG("+JiaoxueKaopinPeer.SCORE+") "
				+ " FROM  " + JiaoxueKaopinPeer.TABLE_NAME
				+ " WHERE "+JiaoxueKaopinPeer.XUEQI_ID+" = " + xueqiId
				+ " AND "+JiaoxueKaopinPeer.BANJI_ID+"=" + banjiId
				+ " AND "+JiaoxueKaopinPeer.KECHENG_ID+"= " + kechengId
				+ " AND "+JiaoxueKaopinPeer.TEACHER_ID+"=" + teacherId;
		
		return getScore(sql);
	}

}
