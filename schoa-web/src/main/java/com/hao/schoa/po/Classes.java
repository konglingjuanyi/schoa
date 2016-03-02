package com.hao.schoa.po;


import org.apache.torque.om.Persistent;

/**
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 */
public  class Classes
    extends com.hao.schoa.po.BaseClasses
    implements Persistent
{
	private Teacher teacher;
	
	private Xueqi xueqi;
	
	private int youxiu; //学生在班级是否是优秀生
	

	public int getYouxiu() {
		return youxiu;
	}

	public void setYouxiu(int youxiu) {
		this.youxiu = youxiu;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Xueqi getXueqi() {
		return xueqi;
	}

	public void setXueqi(Xueqi xueqi) {
		this.xueqi = xueqi;
	}
	
	
}
