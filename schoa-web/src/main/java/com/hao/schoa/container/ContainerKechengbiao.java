package com.hao.schoa.container;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hao.schoa.po.ClassesKecheng;

/**
 * 课程表容器
 * @author haoguowei
 *
 */
public class ContainerKechengbiao {

	private List<Integer> weekIndexList = new ArrayList<Integer>(); //X轴，星期
	
	private List<String> timeList = new ArrayList<String>(); //Y轴，课程时间
	
	//班级排课数据，key：通过week和time同时判断对象是否相等，重写hashcode和equals；value 空值
	private Map<ClassesKecheng, ClassesKecheng> paikeMap = new HashMap<ClassesKecheng, ClassesKecheng>();
	
	public ContainerKechengbiao(){
		
	}

	public List<Integer> getWeekIndexList() {
		return weekIndexList;
	}

	public void setWeekIndexList(List<Integer> weekIndexList) {
		this.weekIndexList = weekIndexList;
	}

	public List<String> getTimeList() {
		return timeList;
	}

	public void setTimeList(List<String> timeList) {
		this.timeList = timeList;
	}

	public Map<ClassesKecheng, ClassesKecheng> getPaikeMap() {
		return paikeMap;
	}

	public void setPaikeMap(Map<ClassesKecheng, ClassesKecheng> paikeMap) {
		this.paikeMap = paikeMap;
	}

	
	
}
