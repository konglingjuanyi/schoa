package com.hao.schoa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.torque.NoRowsException;
import org.apache.torque.TooManyRowsException;
import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

import com.hao.schoa.po.Classes;
import com.hao.schoa.po.KechengPeer;
import com.hao.schoa.po.Xueqi;
import com.hao.schoa.po.XueqiPeer;
import com.hao.schoa.tools.Constant;
import com.hao.schoa.tools.SchoaUtil;
import com.workingdogs.village.Record;

public class XueqiServiceImpl {

	public static Map<String, Object> searchXueqi(String name) {
		Criteria criteria = new Criteria();
		int total = 0;
		List<Xueqi> list = null;
		if (StringUtils.isNotBlank(name)) {
			criteria.add(XueqiPeer.NAME, (Object) ("%" + name + "%"), criteria.LIKE);
		}
		criteria.addDescendingOrderByColumn(XueqiPeer.ID);
		try {
			list = XueqiPeer.doSelect(criteria);
			total = list.size();
			if(list != null && !list.isEmpty()){
				for(Xueqi xq : list){
					if(xq.getStartDate() != null){
						xq.setStartDateStr(Constant.CNDATE.format(xq.getStartDate()));
					}
					if(xq.getEndDate() != null){
						xq.setEndDateStr(Constant.CNDATE.format(xq.getEndDate()));
					}
				}
			}
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constant.TOTAL, total);
		map.put(Constant.DATA, list);
		return map;
	}
	
	public static Xueqi getXueqiById(int id){
		try {
			return XueqiPeer.retrieveByPK(id);
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

	public static Xueqi getById(int id) {
		if (id > 0) {
			try {
				Xueqi xueqi = XueqiPeer.retrieveByPK(id);
				if(xueqi.getStartDate() != null){
					xueqi.setStartDateStr(Constant.DATE.format(xueqi.getStartDate()));
				}
				if(xueqi.getEndDate() != null){
					xueqi.setEndDateStr(Constant.DATE.format(xueqi.getEndDate()));
				}
				return xueqi;
			} catch (NoRowsException e) {
				e.printStackTrace();
			} catch (TooManyRowsException e) {
				e.printStackTrace();
			} catch (TorqueException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public static Xueqi getById2(int id) {
		if (id > 0) {
			try {
				Xueqi xueqi = XueqiPeer.retrieveByPK(id);
				return xueqi;
			} catch (NoRowsException e) {
				e.printStackTrace();
			} catch (TooManyRowsException e) {
				e.printStackTrace();
			} catch (TorqueException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static List<Xueqi> getAllXueqiList() {
		Map<String,Object> map = searchXueqi("");
		List<Xueqi> list = null;
		if(map != null){
			list = (List<Xueqi>) map.get(Constant.DATA);
		}
		return list;
	}

	/**
	 * 学期下所有周
	 * @param xueqiId
	 */
	public static List<String> getWeeksByXueqi(int xueqiId) {
		List<String> ls = new ArrayList<String>();
		Xueqi xueqi = XueqiServiceImpl.getById(xueqiId);
		
		Date start = xueqi.getStartDate();
		Date end = xueqi.getEndDate();
		if (start == null || end == null ||start.getTime() > end.getTime()) {
			return ls;
		}
		String ed = SchoaUtil.getLastDayInWeekStr(end);
		Date tmp = SchoaUtil.getFirstDayInWeek(start);
		while(true){
			String _ed = Constant.DATE.format(SchoaUtil.addDay(tmp, 6));
			String str = Constant.DATE.format(tmp)+"~"+_ed;
			ls.add(str);
			if(_ed.equals(ed)){
				break;
			}
			tmp = SchoaUtil.addDay(tmp, 7);
		}
		return ls;
	}

	/**
	 * 根据教师id得到教师所在的所有学期
	 * @param teacherId
	 * @return
	 */
	public static List<Xueqi> getTeacherXueqiList(int teacherId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select ").append(XueqiPeer.TABLE_NAME).append(".* ")
			.append(" from ").append(KechengPeer.TABLE_NAME)
			.append(" left join ").append(XueqiPeer.TABLE_NAME).append(" on ").append(XueqiPeer.ID).append("=").append(KechengPeer.XUEQI_ID)
			.append(" where ").append(KechengPeer.TEACHER_ID).append(" = ").append(teacherId)
			.append(" group by ").append(KechengPeer.XUEQI_ID)
			.append(" order by ").append(KechengPeer.XUEQI_ID).append(" desc ");
		
		List<Xueqi> ls = new ArrayList<Xueqi>();
		
		try {
			List<Record> searchList = XueqiPeer.executeQuery(sb.toString());
			for (int i = 0; i < searchList.size(); i++) {
				Record row = searchList.get(i);
				Xueqi xueqi = XueqiPeer.row2Object(row, 1, XueqiPeer.getOMClass());
				ls.add(xueqi);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ls;
	}

	/**
	 * 学期下是否存在考勤记录
	 * @param xueqiId
	 * @return
	 */
	public static boolean isHaveKaoqin(int xueqiId) {
		List<Classes> classesList = ClassesServiceImpl.getListByXueqi(xueqiId);
		if(classesList == null || classesList.isEmpty()){
			return false;
		}
		
		StringBuffer ids = new StringBuffer();
		for (int i = 0; i < classesList.size(); i++) {
			Classes c = classesList.get(i);
			if (i != 0) {
				ids.append(",");
			}
			ids.append(c.getId());
		}
		
		if(StringUtils.isNotBlank(ids.toString())){
			try {
				return KaoqinServiceImpl.isHaveKaoqin(ids.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
