package com.hao.schoa.po;


import org.apache.torque.om.Persistent;

/**
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 */
public  class WaipinTeacherJixiao
    extends com.hao.schoa.po.BaseWaipinTeacherJixiao
    implements Persistent
{
	private Teacher teacher;
	
	private String xueqiName;
	
	private String banjiName;
	
	private String kechengName;

	public String getXueqiName() {
		return xueqiName;
	}

	public void setXueqiName(String xueqiName) {
		this.xueqiName = xueqiName;
	}

	public String getBanjiName() {
		return banjiName;
	}

	public void setBanjiName(String banjiName) {
		this.banjiName = banjiName;
	}

	public String getKechengName() {
		return kechengName;
	}

	public void setKechengName(String kechengName) {
		this.kechengName = kechengName;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
}
