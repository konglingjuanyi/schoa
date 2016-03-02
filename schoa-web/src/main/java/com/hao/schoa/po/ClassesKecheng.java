package com.hao.schoa.po;


import org.apache.torque.om.Persistent;

/**
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 */
public  class ClassesKecheng
    extends com.hao.schoa.po.BaseClassesKecheng
    implements Persistent
{
	public ClassesKecheng(){
		
	}
	
	public ClassesKecheng(String time,int week){
		setWeek(week);
		setTime(time);
	}
	
	//通过week和time同时判断对象是否相等
	@Override
	public int hashCode() {
		return getWeek();
	}
	//通过week和time同时判断对象是否相等
	@Override
	public boolean equals(Object obj) {
		ClassesKecheng ck = (ClassesKecheng)obj;
		return ck.getTime().equals(this.getTime());
	}
	
	private String time; //课程表显示，形如：10:00-12:00
	
	private String kechengName;
	
	private int teacherId;
	
	private String teacherName;
	
	private String start;
	
	private String end;
	

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getKechengName() {
		return kechengName;
	}

	public void setKechengName(String kechengName) {
		this.kechengName = kechengName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	
	
	
}
