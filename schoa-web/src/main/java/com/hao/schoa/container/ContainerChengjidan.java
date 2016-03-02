package com.hao.schoa.container;

import java.util.Date;
import java.util.List;

import com.hao.schoa.po.SubjectMarks;

/**
 * 成绩单容器
 * 
 * @author haoguowei
 * 
 */
public class ContainerChengjidan {

	private int studentId;

	private int classesId;

	private String classesName;

	private String passportNumber;

	private String studentName;

	private String studentEName;

	private String sex;
	
	private String sexEName;

	private String nation;
	
	private String nationEName;

	private String dateCn;

	private String dateEn;

	private Date xueqiStartDate;
	
	private Date xueqiEndDate;

	private List<SubjectMarks> subjectMarks;

	public int getStudentId() {
		return studentId;
	}

	public Date getXueqiStartDate() {
		return xueqiStartDate;
	}

	public void setXueqiStartDate(Date xueqiStartDate) {
		this.xueqiStartDate = xueqiStartDate;
	}

	public Date getXueqiEndDate() {
		return xueqiEndDate;
	}

	public void setXueqiEndDate(Date xueqiEndDate) {
		this.xueqiEndDate = xueqiEndDate;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getClassesId() {
		return classesId;
	}

	public void setClassesId(int classesId) {
		this.classesId = classesId;
	}

	public String getClassesName() {
		return classesName;
	}

	public void setClassesName(String classesName) {
		this.classesName = classesName;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEName() {
		return studentEName;
	}

	public void setStudentEName(String studentEName) {
		this.studentEName = studentEName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getDateCn() {
		return dateCn;
	}

	public void setDateCn(String dateCn) {
		this.dateCn = dateCn;
	}

	public String getDateEn() {
		return dateEn;
	}

	public void setDateEn(String dateEn) {
		this.dateEn = dateEn;
	}

	public List<SubjectMarks> getSubjectMarks() {
		return subjectMarks;
	}

	public void setSubjectMarks(List<SubjectMarks> subjectMarks) {
		this.subjectMarks = subjectMarks;
	}

	public String getSexEName() {
		return sexEName;
	}

	public void setSexEName(String sexEName) {
		this.sexEName = sexEName;
	}

	public String getNationEName() {
		return nationEName;
	}

	public void setNationEName(String nationEName) {
		this.nationEName = nationEName;
	}

}