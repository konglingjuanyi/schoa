package com.hao.schoa.po;


import org.apache.torque.om.Persistent;

/**
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 */
public  class Score
    extends com.hao.schoa.po.BaseScore
    implements Persistent
{
	private Student student;
	
	private Kecheng kecheng;
	
	private int queqin; //某节课缺勤数
	
	private int totalKeshi; //某节课总课时
	
	

	public int getQueqin() {
		return queqin;
	}

	public void setQueqin(int queqin) {
		this.queqin = queqin;
	}

	public int getTotalKeshi() {
		return totalKeshi;
	}

	public void setTotalKeshi(int totalKeshi) {
		this.totalKeshi = totalKeshi;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Kecheng getKecheng() {
		return kecheng;
	}

	public void setKecheng(Kecheng kecheng) {
		this.kecheng = kecheng;
	}
	
	
	
}
