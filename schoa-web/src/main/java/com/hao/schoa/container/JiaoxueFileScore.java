package com.hao.schoa.container;

/**
 * 上传的教学文件及得分
 * @author haoguowei
 *
 */
public class JiaoxueFileScore {
	
	public JiaoxueFileScore(int flag,String name,double score){
		this.flag = flag;
		this.name = name;
		this.score = score;
	}
	
	public JiaoxueFileScore(String name,double score){
		this.name = name;
		this.score = score;
	}
	
	private int flag;

	private String name;
	
	private double score;

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
	
}
