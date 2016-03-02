package com.hao.schoa.po;


import java.util.List;

import org.apache.torque.om.Persistent;

/**
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 */
public  class Kecheng
    extends com.hao.schoa.po.BaseKecheng
    implements Persistent
{
	private Teacher teacher;
	
	private Xueqi xueqi;
	
	private int totalKeshi;
	
	private int countQueqin;
	
	private List<Integer> fileFlags;
	
	

	public int getCountQueqin() {
		return countQueqin;
	}

	public void setCountQueqin(int countQueqin) {
		this.countQueqin = countQueqin;
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

	public int getTotalKeshi() {
		return totalKeshi;
	}

	public void setTotalKeshi(int totalKeshi) {
		this.totalKeshi = totalKeshi;
	}

	public List<Integer> getFileFlags() {
		return fileFlags;
	}

	public void setFileFlags(List<Integer> fileFlags) {
		this.fileFlags = fileFlags;
	}
	
	
	
}
