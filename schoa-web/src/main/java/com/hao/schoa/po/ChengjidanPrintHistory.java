package com.hao.schoa.po;


import java.util.List;

import org.apache.torque.om.Persistent;

/**
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 */
public  class ChengjidanPrintHistory
    extends com.hao.schoa.po.BaseChengjidanPrintHistory
    implements Persistent
{
	private List<SubjectMarks> chengjidan;

	public List<SubjectMarks> getChengjidan() {
		return chengjidan;
	}

	public void setChengjidan(List<SubjectMarks> chengjidan) {
		this.chengjidan = chengjidan;
	}
	
	
}
