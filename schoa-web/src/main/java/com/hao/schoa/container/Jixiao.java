package com.hao.schoa.container;


public class Jixiao {
	
	private int teacherId;
	
	private String teacherName;
	
	private int xueqiId;
	
	private String xueqiName;

	private int banjiId;
	
	private String banjiName;
	
	private int kechengId;

	private String kechengName;
	

	private double scKaopin = 0;

	/** The value for the scChuqin field */
	private double scChuqin = 0;

	/** The value for the scJiaoxuefile field */
	private double scJiaoxuefile = 0;

	/** The value for the scTingke field */
	private double scTingke = 0;

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public int getXueqiId() {
		return xueqiId;
	}

	public void setXueqiId(int xueqiId) {
		this.xueqiId = xueqiId;
	}

	public String getXueqiName() {
		return xueqiName;
	}

	public void setXueqiName(String xueqiName) {
		this.xueqiName = xueqiName;
	}

	public int getBanjiId() {
		return banjiId;
	}

	public void setBanjiId(int banjiId) {
		this.banjiId = banjiId;
	}

	public String getBanjiName() {
		return banjiName;
	}

	public void setBanjiName(String banjiName) {
		this.banjiName = banjiName;
	}

	public int getKechengId() {
		return kechengId;
	}

	public void setKechengId(int kechengId) {
		this.kechengId = kechengId;
	}

	public String getKechengName() {
		return kechengName;
	}

	public void setKechengName(String kechengName) {
		this.kechengName = kechengName;
	}

	public double getScKaopin() {
		return scKaopin;
	}

	public void setScKaopin(double scKaopin) {
		this.scKaopin = scKaopin;
	}

	public double getScChuqin() {
		return scChuqin;
	}

	public void setScChuqin(double scChuqin) {
		this.scChuqin = scChuqin;
	}

	public double getScJiaoxuefile() {
		return scJiaoxuefile;
	}

	public void setScJiaoxuefile(double scJiaoxuefile) {
		this.scJiaoxuefile = scJiaoxuefile;
	}

	public double getScTingke() {
		return scTingke;
	}

	public void setScTingke(double scTingke) {
		this.scTingke = scTingke;
	}

	@Override
	public String toString() {
		return "Jixiao [teacherId=" + teacherId + ", teacherName="
				+ teacherName + ", xueqiId=" + xueqiId + ", xueqiName="
				+ xueqiName + ", banjiId=" + banjiId + ", banjiName="
				+ banjiName + ", kechengId=" + kechengId + ", kechengName="
				+ kechengName + ", scKaopin=" + scKaopin + ", scChuqin="
				+ scChuqin + ", scJiaoxuefile=" + scJiaoxuefile + ", scTingke="
				+ scTingke + "]";
	}

	
	
}
