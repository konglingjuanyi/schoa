package com.hao.schoa.container;

import java.util.List;

import com.hao.schoa.po.ClassesKecheng;

public class ContainerPaikeModel {

	private int weekIndex;
	
	private String weekName;
	
	private String day;
	
	private List<ClassesKecheng> ls;
	
	public ContainerPaikeModel(){
		
	}
	
	@Override
	public String toString() {
		return "PaikeModel [weekIndex=" + weekIndex + ", weekName=" + weekName
				+ ", day=" + day + ", ls=" + ls + "]";
	}



	public ContainerPaikeModel(int weekIndex,String weekName,String day){
		this.weekIndex = weekIndex;
		this.weekName = weekName;
		this.day = day;
	}

	public int getWeekIndex() {
		return weekIndex;
	}

	public void setWeekIndex(int weekIndex) {
		this.weekIndex = weekIndex;
	}

	public String getWeekName() {
		return weekName;
	}

	public void setWeekName(String weekName) {
		this.weekName = weekName;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public List<ClassesKecheng> getLs() {
		return ls;
	}

	public void setLs(List<ClassesKecheng> ls) {
		this.ls = ls;
	}
	
	
}
