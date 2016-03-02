package com.hao.schoa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.torque.TorqueException;
import org.apache.torque.util.BasePeer;
import org.apache.torque.util.Criteria;

import com.hao.schoa.po.SysPrivilege;
import com.hao.schoa.po.SysPrivilegePeer;
import com.hao.schoa.po.SysRolePrivilege;
import com.hao.schoa.po.SysRolePrivilegePeer;
import com.hao.schoa.tools.Constant;
import com.workingdogs.village.Record;

public class PrivilegeServiceImpl {

	public static List<SysPrivilege> getPrivilegesList(){
		Criteria criteria = new Criteria();
		try {
			return SysPrivilegePeer.doSelect(criteria);
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return new ArrayList<SysPrivilege>();
	}
	
	public static Map<String, Object> search() {
		List<SysPrivilege> list = getPrivilegesList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constant.TOTAL, list.size());
		map.put(Constant.DATA, list);
		return map;
	}

	/**
	 * 角色下的权限
	 * @param role
	 * @return
	 */
	public static List<SysPrivilege> searchRolePrivilegeList(int role){
		StringBuffer sbr = new StringBuffer();
		sbr.append(" select ").append(SysPrivilegePeer.TABLE_NAME).append(".* ");
		sbr.append(" from ").append(SysRolePrivilegePeer.TABLE_NAME);
		sbr.append(" left join ").append(SysPrivilegePeer.TABLE_NAME)
				.append(" on ").append(SysPrivilegePeer.ID).append("=").append(SysRolePrivilegePeer.PRIVILEGE_ID);
		sbr.append(" where ").append(SysRolePrivilegePeer.ROLE_ID).append(" = ").append(role);
		
		List<SysPrivilege> list = new ArrayList<SysPrivilege>();
		try {
			List<Record> searchList = BasePeer.executeQuery(sbr.toString());
			for (int i = 0; i < searchList.size(); i++) {
				Record row = searchList.get(i);
				SysPrivilege obj = SysPrivilegePeer.row2Object(row, 1, SysPrivilegePeer.getOMClass());
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 角色下的权限
	 * @param role
	 * @return
	 */
	public static Map<String, Object> searchRolePrivilegesMap(int role) {
		List<SysPrivilege> list = searchRolePrivilegeList(role);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constant.TOTAL, list.size());
		map.put(Constant.DATA, list);
		return map;
	}

	/**
	 * 设置角色的权限
	 * @param role
	 * @param priIds
	 * @return
	 */
	public static Boolean saveRolePrivileges(int role, String priIds) {
		if(role > 0){
			try {
				//1.删除该角色所有权限
				deleteRolePrivileges(role);
				//2.添加新权限
				if(StringUtils.isNotBlank(priIds)){
					String[] str = priIds.split(",");
					for(String tmp : str){
						int p = NumberUtils.toInt(tmp);
						if(p > 0){
							SysRolePrivilege rp = new SysRolePrivilege();
							rp.setRoleId(role);
							rp.setPrivilegeId(p);
							SysRolePrivilegePeer.doInsert(rp);
						}
					}
				}
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	/**
	 * 删除该角色所有权限
	 * @param role
	 * @return
	 */
	public static boolean deleteRolePrivileges(int role){
		StringBuffer sb = new StringBuffer();
		sb.append("delete from ").append(SysRolePrivilegePeer.TABLE_NAME)
			.append(" where ").append(SysRolePrivilegePeer.ROLE_ID).append("=").append(role);
		try {
			BasePeer.executeStatement(sb.toString());
			return true;
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 角色没有的权限
	 * @param role
	 * @return
	 */
	public static List<SysPrivilege> searchPrivilegesWithoutRoles(int role) {
		List<SysPrivilege> all = getPrivilegesList();
		List<SysPrivilege> list = searchRolePrivilegeList(role);
		if(list==null||list.size()==0){
			return all;
		}
		
		List<Integer> ids = new ArrayList<Integer>();
		for(SysPrivilege sp : list){
			ids.add(sp.getId());
		}
		
		List<SysPrivilege> resList = new ArrayList<SysPrivilege>();
		for(SysPrivilege sp : all){
			if(!ids.contains(sp.getId())){
				resList.add(sp);
			}
		}
		return resList;
	}
	/**
	 * 角色没有的权限
	 * @param role
	 * @return
	 */
	public static Map<String, Object> searchPrivilegesWithoutRolesMap(int role) {
		List<SysPrivilege> list = searchPrivilegesWithoutRoles(role);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constant.TOTAL, list.size());
		map.put(Constant.DATA, list);
		return map;
	}

	/**
	 * 得到角色的权限url
	 * @param roleId
	 * @return
	 */
	public static List<String> getPrivileges(int role) {
		StringBuffer sbr = new StringBuffer();
		sbr.append(" select ").append(SysPrivilegePeer.URL);
		sbr.append(" from ").append(SysRolePrivilegePeer.TABLE_NAME);
		sbr.append(" left join ").append(SysPrivilegePeer.TABLE_NAME)
				.append(" on ").append(SysPrivilegePeer.ID).append("=").append(SysRolePrivilegePeer.PRIVILEGE_ID);
		sbr.append(" where ").append(SysRolePrivilegePeer.ROLE_ID).append(" = ").append(role);
		
		List<String> list = new ArrayList<String>();
		try {
			List<Record> searchList = BasePeer.executeQuery(sbr.toString());
			for (int i = 0; i < searchList.size(); i++) {
				Record row = searchList.get(i);
				String url = row.getValue(SysPrivilegePeer.URL).asString();
				list.add(url);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
