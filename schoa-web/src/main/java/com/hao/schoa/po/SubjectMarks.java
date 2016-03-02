package com.hao.schoa.po;

public class SubjectMarks {

	private String subject;
	
	private double qizhong;
	
	private double qimo;
	
	private double total;
	
	private int kechengId;//课程id

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public double getQizhong() {
		return qizhong;
	}

	public void setQizhong(double qizhong) {
		this.qizhong = qizhong;
	}

	public double getQimo() {
		return qimo;
	}

	public void setQimo(double qimo) {
		this.qimo = qimo;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getKechengId() {
		return kechengId;
	}

	public void setKechengId(int kechengId) {
		this.kechengId = kechengId;
	}
	
	
	
}
