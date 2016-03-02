package com.hao.schoa.service;

import java.util.Date;
import java.util.List;

import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

import com.hao.schoa.po.StudentPeer;
import com.hao.schoa.po.TeacherPeer;
import com.hao.schoa.po.TeacherStateLog;
import com.hao.schoa.po.TeacherStateLogPeer;
import com.hao.schoa.tools.Constant;

public class TeacherStateLogServiceImpl {

	/**
	 * 读取教师离校记录
	 * @param studentId
	 * @return
	 */
	public static List<TeacherStateLog> searchTeacherStateLog(int teacherId){
		Criteria c = new Criteria();
		c.add(TeacherStateLogPeer.TEACHER_ID, teacherId);
		c.addAscendingOrderByColumn(TeacherStateLogPeer.STATE_UPTIME);
		try {
			List<TeacherStateLog> ls = TeacherStateLogPeer.doSelect(c);
			if(ls != null && !ls.isEmpty()){
				for(TeacherStateLog obj : ls){
					obj.setStateUptimeStr(Constant.CNDATE.format(obj.getStateUptime()));
				}
			}
			return ls;
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 设置教师离校，返校
	 * @param sysUser
	 * @param teacherId
	 * @param oldState
	 * @param newState
	 * @param leaveDate
	 * @param leaveReason
	 * @return
	 */
	public static boolean updateTeacherState(String sysUser,int teacherId, int oldState, int newState, String leaveDate, String leaveReason) {
		StringBuffer sbr = new StringBuffer();
		sbr.append("update ").append(TeacherPeer.TABLE_NAME)
			.append(" set ").append(TeacherPeer.STATE).append("=").append(newState)
			.append(" , ").append(TeacherPeer.STATE_UPTIME).append("='").append(leaveDate).append("'")
			.append(" where ").append(TeacherPeer.STATE).append("=").append(oldState)
			.append(" and ").append(TeacherPeer.ID).append("=").append(teacherId);
		
		try {
			if(StudentPeer.executeStatement(sbr.toString()) > 0){
				saveTeacherStateLog(sysUser,teacherId,newState,leaveDate,leaveReason);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void saveTeacherStateLog(String sysUser, int teacherId,
			int state, String leaveDate, String leaveReason) {
		try {
			TeacherStateLog obj = new TeacherStateLog();
			obj.setTeacherId(teacherId);
			obj.setState(state);
			obj.setStateUptime(Constant.DATE.parse(leaveDate));
			obj.setStateIntro(leaveReason);
			obj.setMember(sysUser);
			obj.setUpdateTime(new Date());
			
			TeacherStateLogPeer.doInsert(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
