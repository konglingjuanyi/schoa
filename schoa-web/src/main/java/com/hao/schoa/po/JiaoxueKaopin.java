package com.hao.schoa.po;


import org.apache.torque.om.Persistent;

/**
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 */
public  class JiaoxueKaopin
    extends com.hao.schoa.po.BaseJiaoxueKaopin
    implements Persistent
{
	private Teacher teacher;
	
	private Classes banji;
	
	private Xueqi xueqi;
	
	private Kecheng kecheng;

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Classes getBanji() {
		return banji;
	}

	public void setBanji(Classes banji) {
		this.banji = banji;
	}

	public Xueqi getXueqi() {
		return xueqi;
	}

	public void setXueqi(Xueqi xueqi) {
		this.xueqi = xueqi;
	}

	public Kecheng getKecheng() {
		return kecheng;
	}

	public void setKecheng(Kecheng kecheng) {
		this.kecheng = kecheng;
	}
	
	
}
