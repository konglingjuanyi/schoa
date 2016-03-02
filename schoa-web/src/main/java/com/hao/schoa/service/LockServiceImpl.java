package com.hao.schoa.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

import com.hao.schoa.po.KaoqinLock;
import com.hao.schoa.po.KaoqinLockPeer;
import com.hao.schoa.po.ScoreLock;
import com.hao.schoa.po.ScoreLockPeer;
import com.hao.schoa.tools.Constant;

public class LockServiceImpl {

	public static void lockScore(int xueqiId,int banjiId,int kechengId,String member){
		ScoreLock lock = new ScoreLock();
		lock.setXueqiId(xueqiId);
		lock.setBanjiId(banjiId);
		lock.setKechengId(kechengId);
		lock.setMember(member);
		lock.setUpdateTime(new Date());
		
		try {
			ScoreLockPeer.doInsert(lock);
		} catch (TorqueException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 是否锁定成绩
	 * @param xueqiId
	 * @param banjiId
	 * @param kechengId
	 * @return
	 * @throws TorqueException
	 */
	public static boolean isLockScore(int xueqiId,int banjiId,int kechengId) throws TorqueException{
		Criteria c = new Criteria();
		c.add(ScoreLockPeer.XUEQI_ID, xueqiId);
		c.add(ScoreLockPeer.BANJI_ID, banjiId);
		c.add(ScoreLockPeer.KECHENG_ID, kechengId);
		List<ScoreLock> ls = ScoreLockPeer.doSelect(c);
		if(ls == null || ls.isEmpty()){
			return false;
		}else{
			return true;
		}
	}
	
	public static void lockKaoqin(int xueqiId,int banjiId,Date startDate,Date endDate,String memeber){
		KaoqinLock lock = new KaoqinLock();
		lock.setXueqiId(xueqiId);
		lock.setBanjiId(banjiId);
		lock.setStartDate(startDate);
		lock.setEndDate(endDate);
		lock.setMember(memeber);
		
		try {
			KaoqinLockPeer.doInsert(lock);
		} catch (TorqueException e) {
			e.printStackTrace();
		}
	}
	public static void lockKaoqin(int xueqiId,int banjiId,String startDate,String endDate,String memeber){
		try {
			lockKaoqin(xueqiId,banjiId,Constant.DATE.parse(startDate),Constant.DATE.parse(endDate),memeber);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isLockKaoqin(int xueqiId,int banjiId, Date start, Date end) throws TorqueException{
		Criteria c = new Criteria();
		c.add(KaoqinLockPeer.XUEQI_ID, xueqiId);
		c.add(KaoqinLockPeer.BANJI_ID, banjiId);
		c.add(KaoqinLockPeer.START_DATE, start, Criteria.GREATER_EQUAL);
		c.add(KaoqinLockPeer.END_DATE,  end, Criteria.LESS_EQUAL);
		List<KaoqinLock> ls = KaoqinLockPeer.doSelect(c);
		if(ls == null || ls.isEmpty()){
			return false;
		}else{
			return true;
		}
	}
	public static boolean isLockKaoqin(int xueqiId,int banjiId, String start, String end) throws Exception{
		return isLockKaoqin(xueqiId,banjiId,Constant.DATE.parse(start),Constant.DATE.parse(end));
	}
}
