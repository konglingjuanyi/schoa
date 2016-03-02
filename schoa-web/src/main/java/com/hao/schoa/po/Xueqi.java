package com.hao.schoa.po;


import org.apache.torque.om.Persistent;

/**
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 */
public  class Xueqi
    extends com.hao.schoa.po.BaseXueqi
    implements Persistent
{
	private String startDateStr;
	
	private String endDateStr;
	
	public String getStartDateStr() {
		return startDateStr;
	}
	
	public void setStartDateStr(String startDateStr) {
		this.startDateStr = startDateStr;
	}
	
	public String getEndDateStr() {
		return endDateStr;
	}
	
	public void setEndDateStr(String endDateStr) {
		this.endDateStr = endDateStr;
	}
	
	
}
