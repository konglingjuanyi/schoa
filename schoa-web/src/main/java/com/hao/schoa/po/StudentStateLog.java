package com.hao.schoa.po;


import org.apache.torque.om.Persistent;

/**
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 */
public  class StudentStateLog
    extends com.hao.schoa.po.BaseStudentStateLog
    implements Persistent
{
	
	private String stateUptimeStr;

	public String getStateUptimeStr() {
		return stateUptimeStr;
	}

	public void setStateUptimeStr(String stateUptimeStr) {
		this.stateUptimeStr = stateUptimeStr;
	}

	
	
}
