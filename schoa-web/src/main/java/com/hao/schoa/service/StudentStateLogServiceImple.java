package com.hao.schoa.service;

import java.util.Date;
import java.util.List;

import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

import com.hao.schoa.po.StudentStateLog;
import com.hao.schoa.po.StudentStateLogPeer;
import com.hao.schoa.tools.Constant;

public class StudentStateLogServiceImple {

	/**
	 * 读取学生离校记录
	 * @param studentId
	 * @return
	 */
	public static List<StudentStateLog> searchStudentStateLog(int studentId){
		Criteria c = new Criteria();
		c.add(StudentStateLogPeer.STUDENT_ID, studentId);
		c.addAscendingOrderByColumn(StudentStateLogPeer.STATE_UPTIME);
		try {
			List<StudentStateLog> ls = StudentStateLogPeer.doSelect(c);
			if(ls != null && !ls.isEmpty()){
				for(StudentStateLog ssl : ls){
					ssl.setStateUptimeStr(Constant.CNDATE.format(ssl.getStateUptime()));
				}
			}
			return ls;
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void saveStudentStateLog(String sysUser, int studentId,
			int state, String leaveDate, String leaveReason) {
		try {
			StudentStateLog ssl = new StudentStateLog();
			ssl.setStudentId(studentId);
			ssl.setState(state);
			ssl.setStateUptime(Constant.DATE.parse(leaveDate));
			ssl.setStateIntro(leaveReason);
			ssl.setMember(sysUser);
			ssl.setUpdateTime(new Date());
			
			StudentStateLogPeer.doInsert(ssl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
