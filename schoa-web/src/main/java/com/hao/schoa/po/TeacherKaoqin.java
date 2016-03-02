package com.hao.schoa.po;


import org.apache.torque.om.Persistent;

/**
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 */
public  class TeacherKaoqin
    extends com.hao.schoa.po.BaseTeacherKaoqin
    implements Persistent
{
	private ClassesKecheng classesKecheng;
	
	private String kaoqinInfo;
	private String dayAndTime;
	private String banjiName;
	
	

	
	public String getBanjiName() {
		return banjiName;
	}

	public void setBanjiName(String banjiName) {
		this.banjiName = banjiName;
	}

	public String getDayAndTime() {
		return dayAndTime;
	}

	public void setDayAndTime(String dayAndTime) {
		this.dayAndTime = dayAndTime;
	}

	public String getKaoqinInfo() {
		return kaoqinInfo;
	}

	public void setKaoqinInfo(String kaoqinInfo) {
		this.kaoqinInfo = kaoqinInfo;
	}

	public ClassesKecheng getClassesKecheng() {
		return classesKecheng;
	}

	public void setClassesKecheng(ClassesKecheng classesKecheng) {
		this.classesKecheng = classesKecheng;
	}
	

	
	
	
}
