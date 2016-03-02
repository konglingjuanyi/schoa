package com.hao.schoa.po;


import java.util.List;

import org.apache.torque.om.Persistent;

import com.hao.schoa.container.Jixiao;

/**
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 */
public  class JixiaoZaibian
    extends com.hao.schoa.po.BaseJixiaoZaibian
    implements Persistent
{
	private String xueqiName;
	
	private List<Jixiao> jixiao;
	
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
