package com.hao.schoa.po;


import java.util.List;

import org.apache.torque.om.Persistent;

/**
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 */
public  class QuestionTixing
    extends com.hao.schoa.po.BaseQuestionTixing
    implements Persistent
{
	//试题
	private List<QuestionBank> bankList;

	public List<QuestionBank> getBankList() {
		return bankList;
	}

	public void setBankList(List<QuestionBank> bankList) {
		this.bankList = bankList;
	}
	
	
}
