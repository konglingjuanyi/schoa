package com.hao.schoa.container;

/**
 * 缺勤信息
 * @author haoguowei
 *
 */
public class ContainerQueqinInfo {

	private String queqinInfo; //缺勤信息
	
	private int totalQueqin; //缺勤课时

	public String getQueqinInfo() {
		return queqinInfo;
	}

	public void setQueqinInfo(String queqinInfo) {
		this.queqinInfo = queqinInfo;
	}

	public int getTotalQueqin() {
		return totalQueqin;
	}

	public void setTotalQueqin(int totalQueqin) {
		this.totalQueqin = totalQueqin;
	}

	@Override
	public String toString() {
		return "ContainerQueqinInfo [queqinInfo=" + queqinInfo
				+ ", totalQueqin=" + totalQueqin + "]";
	}
	
	
	
}
