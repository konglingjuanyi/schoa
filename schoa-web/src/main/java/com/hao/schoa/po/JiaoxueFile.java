package com.hao.schoa.po;


import org.apache.torque.om.Persistent;

import com.hao.schoa.container.JiaoxueFileScore;

/**
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 */
public  class JiaoxueFile
    extends com.hao.schoa.po.BaseJiaoxueFile
    implements Persistent
{
	private JiaoxueFileScore jiaoxueFileScore;
	
	private Kecheng kecheng;
	
	private Teacher teacher;
	
	private Xueqi xueqi;
	
	private boolean quanxian; //当前操作人对记录是否有操作权限

	public Kecheng getKecheng() {
		return kecheng;
	}

	public void setKecheng(Kecheng kecheng) {
		this.kecheng = kecheng;
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

	public JiaoxueFileScore getJiaoxueFileScore() {
		return jiaoxueFileScore;
	}

	public void setJiaoxueFileScore(JiaoxueFileScore jiaoxueFileScore) {
		this.jiaoxueFileScore = jiaoxueFileScore;
	}

	public boolean getQuanxian() {
		return quanxian;
	}

	public void setQuanxian(boolean quanxian) {
		this.quanxian = quanxian;
	}

	
	
	
}
