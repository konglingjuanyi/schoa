package com.hao.schoa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

import com.hao.schoa.po.Role;
import com.hao.schoa.po.RolePeer;
import com.hao.schoa.tools.Constant;

public class RoleServiceImpl {

	public static List<Role> getRoleList(){
		Criteria criteria = new Criteria();
		try {
			return RolePeer.doSelect(criteria);
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return new ArrayList<Role>();
	}

	public static Map<String, Object> search() {
		List<Role> list = getRoleList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constant.TOTAL, list.size());
		map.put(Constant.DATA, list);
		return map;
	}
}
