package com.hao.schoa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

import com.hao.schoa.container.TreeNodeMode;
import com.hao.schoa.po.Country;
import com.hao.schoa.po.CountryPeer;
import com.hao.schoa.po.Menu;
import com.hao.schoa.po.MenuPeer;
import com.hao.schoa.po.SysPrivilege;

public class SystemServiceImpl {

	/**
	 * 得到导航菜单树
	 * @return
	 */
	public static List<TreeNodeMode> getMenuTree() {
		List<Menu> ls = null;
		try {
			ls = getMenuByParentId(0);
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return getChilds(ls);
	}

	/**
	 * 根据父节点id找孩子
	 * @param i
	 * @return
	 * @throws TorqueException
	 */
	private static List<Menu> getMenuByParentId(int i) throws TorqueException {
		Criteria criteria = new Criteria();
		criteria.add(MenuPeer.PARENT, i);
		criteria.addAscendingOrderByColumn(MenuPeer.SORT);
		return MenuPeer.doSelect(criteria);
	}

	/**
	 * 得到所有字节点，并转换为node对象
	 * @param list
	 * @return
	 */
	public static List<TreeNodeMode> getChilds(List<Menu> list) {
		List<TreeNodeMode> ls = new ArrayList<TreeNodeMode>();
		try {
			for (Menu menu : list) {
				TreeNodeMode node = new TreeNodeMode();
				node.setId(menu.getId());
				node.setText(menu.getName());
				node.setChecked(null);
				node.setParentId(menu.getParent());
				node.setAttributes(menu);

				List<Menu> childList = getMenuByParentId(menu.getId());
				if (childList.size() > 0) {
					node.setLeaf(false);
					node.setChildren(getChilds(childList));
				} else {
					node.setLeaf(true);
					node.setHref(menu.getUrl());
				}
				ls.add(node);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	
	public static List<Country> getAllCountry(){
		Criteria c = new Criteria();
		try {
			c.addAscendingOrderByColumn(CountryPeer.ENAME);
			return CountryPeer.doSelect(c );
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 所有国家map，key-国家中文名，value-id，用在导入学生信息时匹配学生国籍
	 * @return
	 */
	public static Map<String,Integer> getAllCountryMap(){
		Map<String,Integer> map = new HashMap<String, Integer>();
		List<Country> ls = getAllCountry();
		if(ls == null || ls.isEmpty()){
			return map;
		}
		for(Country c : ls){
			map.put(c.getCname().trim(),c.getId());
		}
		return map;
	}
	
	public static Set<String> getAllPrivilegesUrl(){
		List<SysPrivilege> ls = PrivilegeServiceImpl.getPrivilegesList();
		Set<String> set = new HashSet<String>();
		for(SysPrivilege sp : ls){
			set.add(sp.getUrl());
		}
		return set;
	}
}
