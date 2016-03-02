package com.hao.schoa.container;

public class ContainerStudentQueqin {
	
	public ContainerStudentQueqin(int kechengId, int kaoqin, int totalQueqin,String kechengName) {
		this.kechengId = kechengId;
		this.kaoqin = kaoqin;
		this.totalQueqin = totalQueqin;
		this.kechengName = kechengName;
	}

	private int kechengId;

	private int kaoqin;
	
	private String kechengName;

	private int totalQueqin;

	

	@Override
	public String toString() {
		return "ContainerStudentQueqin [kechengId=" + kechengId + ", kaoqin="
				+ kaoqin + ", kechengName=" + kechengName + ", totalQueqin="
				+ totalQueqin + "]";
	}

	public String getKechengName() {
		return kechengName;
	}

	public void setKechengName(String kechengName) {
		this.kechengName = kechengName;
	}

	public int getKechengId() {
		return kechengId;
	}

	public void setKechengId(int kechengId) {
		this.kechengId = kechengId;
	}

	public int getKaoqin() {
		return kaoqin;
	}

	public void setKaoqin(int kaoqin) {
		this.kaoqin = kaoqin;
	}

	public int getTotalQueqin() {
		return totalQueqin;
	}

	public void setTotalQueqin(int totalQueqin) {
		this.totalQueqin = totalQueqin;
	}
}
