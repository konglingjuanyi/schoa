package com.hao.schoa.po;


import java.util.List;

import org.apache.torque.om.Persistent;

import com.hao.schoa.container.Jixiao;

/**
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 */
public  class JixiaoWaipin
    extends com.hao.schoa.po.BaseJixiaoWaipin
    implements Persistent
{
	
	private String xueqiName;
	
	private List<Jixiao> jixiao;
	
	private double total;

	public double getTotal() {
		double t = this.getScKaihui() + this.getScHuodong() + this.getScYinxiang() + this.getScGongxian();
		List<Jixiao> ls = this.getJixiao();
		if(ls != null){
			double tmp = 0d;
			for(Jixiao jx : ls){
				tmp += jx.getScKaopin();
				tmp += jx.getScChuqin();
				tmp += jx.getScJiaoxuefile();
				tmp += jx.getScTingke();
			}
			t += tmp/ls.size();
		}
		return t;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getXueqiName() {
		return xueqiName;
	}

	public void setXueqiName(String xueqiName) {
		this.xueqiName = xueqiName;
	}

	public List<Jixiao> getJixiao() {
		return jixiao;
	}

	public void setJixiao(List<Jixiao> jixiao) {
		this.jixiao = jixiao;
	}

	
}
