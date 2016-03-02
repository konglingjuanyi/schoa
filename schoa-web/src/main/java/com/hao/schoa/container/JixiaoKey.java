package com.hao.schoa.container;


public class JixiaoKey {

	private int xueqiId;
	private int teacherId;
	
	public JixiaoKey(int xueqiId,int teacherId){
		this.xueqiId = xueqiId;
		this.teacherId = teacherId;
	}
	public JixiaoKey(){
		
	}
	
	@Override
	public boolean equals(Object obj) {
		JixiaoKey tmp = (JixiaoKey)obj;
		return tmp.teacherId == this.teacherId;
	}

	@Override
	public int hashCode() {
		return this.xueqiId;
	}

	public int getXueqiId() {
		return xueqiId;
	}

	public void setXueqiId(int xueqiId) {
		this.xueqiId = xueqiId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	@Override
	public String toString() {
		return "JixiaoKey [xueqiId=" + xueqiId + ", teacherId=" + teacherId
				+ "]";
	}
	
	
}
