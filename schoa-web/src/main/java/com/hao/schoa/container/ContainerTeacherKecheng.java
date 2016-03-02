package com.hao.schoa.container;

/**
 * 教师课程
 * @author haoguowei
 *
 */
public class ContainerTeacherKecheng {

	public ContainerTeacherKecheng(){
		
	}
	
	private int xueqiId;
	
	private int banjiId;
	
	private int kechengId;
	
	private int teacherId;
	
	private String kechengName;
	
	

	public String getKechengName() {
		return kechengName;
	}

	public void setKechengName(String kechengName) {
		this.kechengName = kechengName;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getXueqiId() {
		return xueqiId;
	}

	public void setXueqiId(int xueqiId) {
		this.xueqiId = xueqiId;
	}

	public int getBanjiId() {
		return banjiId;
	}

	public void setBanjiId(int banjiId) {
		this.banjiId = banjiId;
	}

	public int getKechengId() {
		return kechengId;
	}

	public void setKechengId(int kechengId) {
		this.kechengId = kechengId;
	}
	
	
}
