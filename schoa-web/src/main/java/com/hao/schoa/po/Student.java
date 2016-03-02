package com.hao.schoa.po;


import org.apache.torque.om.Persistent;

/**
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 */
public  class Student
    extends com.hao.schoa.po.BaseStudent
    implements Persistent
{
	private Country country;
	
	private Score score;
	
	private int youxiu; //在班级下是否是优秀学生，1是，0否
	private int jinbu;
	
	
	
	
	public int getJinbu() {
		return jinbu;
	}

	public void setJinbu(int jinbu) {
		this.jinbu = jinbu;
	}

	public int getYouxiu() {
		return youxiu;
	}

	public void setYouxiu(int youxiu) {
		this.youxiu = youxiu;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	
}
