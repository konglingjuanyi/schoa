package com.hao.schoa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.torque.NoRowsException;
import org.apache.torque.TooManyRowsException;
import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

import com.hao.schoa.po.QuestionTixing;
import com.hao.schoa.po.QuestionTixingPeer;
import com.hao.schoa.tools.Constant;

public class QuestionTixingServiceImpl {

	public static QuestionTixing getQuestionTixingById(int id) {
		try {
			return QuestionTixingPeer.retrieveByPK(id);
		} catch (NoRowsException e) {
			e.printStackTrace();
		} catch (TooManyRowsException e) {
			e.printStackTrace();
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<QuestionTixing> getTixingList(){
		Criteria c = new Criteria();
		c.addAscendingOrderByColumn(QuestionTixingPeer.SORT);
		List<QuestionTixing> list = null;
		try {
			list = QuestionTixingPeer.doSelect(c);
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static Map<Integer,QuestionTixing> getTixingMap(){
		List<QuestionTixing> list = getTixingList();
		Map<Integer,QuestionTixing> map = new HashMap<Integer, QuestionTixing>();
		if(CollectionUtils.isNotEmpty(list)){
			for (QuestionTixing questionTixing : list) {
				map.put(questionTixing.getId(), questionTixing);
			}
		}
		return map;
	}

	public static Map<String, Object> searchQuestionTixing() {
		List<QuestionTixing> list = getTixingList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constant.TOTAL, list==null?0:list.size());
		map.put(Constant.DATA, list);
		return map;
	}
	
	public static List<QuestionTixing> getTixingListByIds(String[] ids){
		if(ids == null || ids.length == 0){
			return null;
		}
		
		Criteria c = new Criteria();
		c.addAscendingOrderByColumn(QuestionTixingPeer.SORT);
		c.addIn(QuestionTixingPeer.ID, ids);
		List<QuestionTixing> list = null;
		try {
			list = QuestionTixingPeer.doSelect(c);
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return list;
	}

}
