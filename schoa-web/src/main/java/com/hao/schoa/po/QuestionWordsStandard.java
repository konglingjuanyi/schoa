package com.hao.schoa.po;


import java.util.List;

import org.apache.torque.om.Persistent;

/**
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 */
public  class QuestionWordsStandard
    extends com.hao.schoa.po.BaseQuestionWordsStandard
    implements Persistent
{
	private List<QuestionWordsLevel> levelList;

	public List<QuestionWordsLevel> getLevelList() {
		return levelList;
	}

	public void setLevelList(List<QuestionWordsLevel> levelList) {
		this.levelList = levelList;
	}
	
	
}
