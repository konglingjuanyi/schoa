package com.hao.schoa.po;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.torque.om.Persistent;

/**
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 */
public  class QuestionBank
    extends com.hao.schoa.po.BaseQuestionBank
    implements Persistent
{
	private String tixingStr;
	private List<String> standardLevelList;
	
	private int k1;
	private int k2;

	public String getTixingStr() {
		return tixingStr;
	}

	public void setTixingStr(String tixingStr) {
		this.tixingStr = tixingStr;
	}

	public List<String> getStandardLevelList() {
		return standardLevelList;
	}

	public void setStandardLevelList(List<String> standardLevelList) {
		this.standardLevelList = standardLevelList;
	}

	public int getK1() {
		String k = getKnowledgePointId();
		if(StringUtils.isNotBlank(k)){
			String arr[] = k.split(",");
			if(arr != null && arr.length > 0){
				return Integer.parseInt(arr[0]);
			}
		}
		return 0;
	}

	public void setK1(int k1) {
		this.k1 = k1;
	}

	public int getK2() {
		String k = getKnowledgePointId();
		if(StringUtils.isNotBlank(k)){
			String arr[] = k.split(",");
			if(arr != null && arr.length == 2){
				return Integer.parseInt(arr[1]);
			}
		}
		return 0;
	}

	public void setK2(int k2) {
		this.k2 = k2;
	}


	
	
	
}
