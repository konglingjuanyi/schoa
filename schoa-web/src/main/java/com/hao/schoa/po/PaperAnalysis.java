package com.hao.schoa.po;


import org.apache.torque.om.Persistent;

/**
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 */
public  class PaperAnalysis
    extends com.hao.schoa.po.BasePaperAnalysis
    implements Persistent
{
	private Xueqi xueqi;
	
	private Classes banji;
	
	private Kecheng kecheng;

	public Xueqi getXueqi() {
		return xueqi;
	}

	public void setXueqi(Xueqi xueqi) {
		this.xueqi = xueqi;
	}

	public Classes getBanji() {
		return banji;
	}

	public void setBanji(Classes banji) {
		this.banji = banji;
	}

	public Kecheng getKecheng() {
		return kecheng;
	}

	public void setKecheng(Kecheng kecheng) {
		this.kecheng = kecheng;
	}

	
	
}
