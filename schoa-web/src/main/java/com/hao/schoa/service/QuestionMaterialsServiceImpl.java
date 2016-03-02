package com.hao.schoa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.torque.NoRowsException;
import org.apache.torque.TooManyRowsException;
import org.apache.torque.TorqueException;
import org.apache.torque.util.BasePeer;
import org.apache.torque.util.Criteria;

import com.hao.schoa.po.QuestionMaterials;
import com.hao.schoa.po.QuestionMaterialsKecheng;
import com.hao.schoa.po.QuestionMaterialsKechengPeer;
import com.hao.schoa.po.QuestionMaterialsPeer;
import com.hao.schoa.tools.Constant;

public class QuestionMaterialsServiceImpl {

	public static QuestionMaterials getQuestionMaterialsById(int id) {
		try {
			return QuestionMaterialsPeer.retrieveByPK(id);
		} catch (NoRowsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TooManyRowsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TorqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<QuestionMaterials> getQuestionMaterialList(){
		Criteria c = new Criteria();
		c.addAscendingOrderByColumn(QuestionMaterialsPeer.ID);
		List<QuestionMaterials> list = null;
		try {
			list = QuestionMaterialsPeer.doSelect(c);
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static Map<String, Object> searchQuestionMaterials() {
		List<QuestionMaterials> list = getQuestionMaterialList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constant.TOTAL, list==null?0:list.size());
		map.put(Constant.DATA, list);
		return map;
	}
	
	public static List<QuestionMaterialsKecheng> getMaterialKechengList(int materialId){
		Criteria c = new Criteria();
		c.add(QuestionMaterialsKechengPeer.MATERIALS_ID, materialId);
		c.addAscendingOrderByColumn(QuestionMaterialsKechengPeer.ID);
		List<QuestionMaterialsKecheng> list = null;
		try {
			list = QuestionMaterialsKechengPeer.doSelect(c);
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static Map<String, Object> searchQuestionMaterialsKecheng(int materialId) {
		List<QuestionMaterialsKecheng> list = getMaterialKechengList(materialId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constant.TOTAL, list==null?0:list.size());
		map.put(Constant.DATA, list);
		return map;
	}

	public static QuestionMaterialsKecheng getQuestionMaterialsKechengById(int id) {
		try {
			return QuestionMaterialsKechengPeer.retrieveByPK(id);
		} catch (NoRowsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TooManyRowsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TorqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static boolean deleteMaterialById(int id) {
		String sql = " delete from " + QuestionMaterialsPeer.TABLE_NAME + " where id = " + id;
		try {
			int rows = BasePeer.executeStatement(sql);
			if(rows > 0){
				deleteMaterialKechengByMaterialId(id);
				return true;
			}
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean deleteMaterialKechengByMaterialId(int materialId) {
		String sql = " delete from " + QuestionMaterialsKechengPeer.TABLE_NAME + " where " + QuestionMaterialsKechengPeer.MATERIALS_ID + " = " + materialId;
		try {
			int rows = BasePeer.executeStatement(sql);
			if(rows > 0){
				return true;
			}
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean deleteMaterialKechengById(int id) {
		String sql = " delete from " + QuestionMaterialsKechengPeer.TABLE_NAME + " where id = " + id;
		try {
			int rows = BasePeer.executeStatement(sql);
			if(rows > 0){
				return true;
			}
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return false;
	}

}
