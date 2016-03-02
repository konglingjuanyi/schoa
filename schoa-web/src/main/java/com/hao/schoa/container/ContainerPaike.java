package com.hao.schoa.container;

import java.util.Arrays;
import java.util.Date;

public class ContainerPaike {
	
	private Date startDate;
	
	private Date endDate;
	
	private String startStr;
	
	private String endStr;
	
	private int[] wks = new int[7];
	private int[] paiKeId = new int[7];

	public String getStartStr() {
		return startStr;
	}

	public void setStartStr(String startStr) {
		this.startStr = startStr;
	}

	public String getEndStr() {
		return endStr;
	}

	public void setEndStr(String endStr) {
		this.endStr = endStr;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int[] getWks() {
		return wks;
	}

	public void setWks(int[] wks) {
		this.wks = wks;
	}

	public int[] getPaiKeId() {
		return paiKeId;
	}

	public void setPaiKeId(int[] paiKeId) {
		this.paiKeId = paiKeId;
	}

	@Override
	public String toString() {
		return "ContainerPaike [startDate=" + startDate + ", endDate="
				+ endDate + ", startStr=" + startStr + ", endStr=" + endStr
				+ ", wks=" + Arrays.toString(wks) + ", paiKeId="
				+ Arrays.toString(paiKeId) + "]";
	}

	
	
	
	
}
