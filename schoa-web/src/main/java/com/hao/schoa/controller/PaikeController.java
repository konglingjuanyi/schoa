package com.hao.schoa.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.torque.TorqueException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.hao.schoa.BaseSchoa;
import com.hao.schoa.container.ContainerPaike;
import com.hao.schoa.po.Classes;
import com.hao.schoa.po.ClassesKecheng;
import com.hao.schoa.po.ClassesKechengPeer;
import com.hao.schoa.po.Kecheng;
import com.hao.schoa.po.Member;
import com.hao.schoa.po.Xueqi;
import com.hao.schoa.service.ClassesServiceImpl;
import com.hao.schoa.service.KaoqinServiceImpl;
import com.hao.schoa.service.KechengServiceImpl;
import com.hao.schoa.service.PaikeServiceImpl;
import com.hao.schoa.service.SchoaLogsServiceImpl;
import com.hao.schoa.service.XueqiServiceImpl;
import com.hao.schoa.tools.Constant;
import com.hao.schoa.tools.SchoaUtil;

@Controller
public class PaikeController extends BaseSchoa{

	/**
	 * 班级排课
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/initPaike.do")
	public String initPaike(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));

		// 是否有考勤
		boolean isHaveKaoqin = KaoqinServiceImpl.isHaveKaoqin(classesId);

		// 班级
		Classes classes = ClassesServiceImpl.getById(classesId);
		
		// 学期下的课程，下拉选择框
		List<Kecheng> kechengs = KechengServiceImpl.getKechengList(
				classes.getXueqiId(), 0, "");

		// 时间下拉框
		List<String> timeList = SchoaUtil.getTimeList();

		// 已经排课的记录
		Map<Date, ContainerPaike> paikeMap = PaikeServiceImpl.getPaiKeMap(classes
				.getId());
		if (paikeMap.size() == 0) {
			paikeMap.put(null, new ContainerPaike());
		}

		request.setAttribute("timeList", timeList);
		request.setAttribute("classes", classes);
		request.setAttribute("kechengList", kechengs);
		request.setAttribute("paikeMap", paikeMap);
		request.setAttribute("isHaveKaoqin", isHaveKaoqin);
		return "manager/paike";
	}
	@RequestMapping("/initUpdatePaike.do")
	public String initUpdatePaike(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Member member = getSysMember(request);
		if(member == null){
			return NOPRIVILEGES;
		}
		boolean admin = isAdminRole(member.getRoleId());
		if(!admin){
			return NOPRIVILEGES;
		}

		int xueqiId = NumberUtils.toInt(request.getParameter("xueqiId"));
		int banjiId = NumberUtils.toInt(request.getParameter("banjiId"));
		
		List<Xueqi> xuqiList = XueqiServiceImpl.getAllXueqiList();
		List<Classes> banjiList = null;
		if(xueqiId > 0){
			banjiList = ClassesServiceImpl.getClassesList(xueqiId);
		}
		
		// 是否有考勤
		boolean isHaveKaoqin = KaoqinServiceImpl.isHaveKaoqin(banjiId);

		// 班级
		Classes classes = ClassesServiceImpl.getById(banjiId);
		
		// 学期下的课程，下拉选择框
		List<Kecheng> kechengList = KechengServiceImpl.getKechengList(xueqiId, 0, "");

		// 已经排课的记录
		Map<Date, ContainerPaike> paikeMap = PaikeServiceImpl.getPaiKeMap(banjiId);

		request.setAttribute("xuqiList", xuqiList);
		request.setAttribute("banjiList", banjiList);
		request.setAttribute("xueqiId", xueqiId);
		request.setAttribute("banjiId", banjiId);
		
		request.setAttribute("classes", classes);
		request.setAttribute("kechengList", kechengList);
		request.setAttribute("paikeMap", paikeMap);
		request.setAttribute("isHaveKaoqin", isHaveKaoqin);
		
		return "manager/updatePaike";
	}
	@RequestMapping("/saveUpdatePaike.do")
	public String saveUpdatePaike(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Member member = getSysMember(request);
		if(member == null){
			return NOPRIVILEGES;
		}
		boolean admin = isAdminRole(member.getRoleId());
		if(!admin){
			return NOPRIVILEGES;
		}
		
		int xueqiId = NumberUtils.toInt(request.getParameter("xueqiId"));
		int banjiId = NumberUtils.toInt(request.getParameter("banjiId"));
		
		int paikeId = NumberUtils.toInt(request.getParameter("paikeId"));
		int oldKechengId = NumberUtils.toInt(request.getParameter("oldKechengId"));
		int newKechengId = NumberUtils.toInt(request.getParameter("newKechengId"));
		
		
		if (paikeId <= 0 || oldKechengId <= 0 || newKechengId <= 0) {
			return FAIL;
		}
		
		boolean b = PaikeServiceImpl.updatePaikeKecheng(paikeId, oldKechengId, newKechengId);
		
		if(b){
			response.sendRedirect("initUpdatePaike.do?xueqiId="+xueqiId+"&banjiId="+banjiId);
			return null;
		}
		
		return FAIL;
	}

	/**
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/savePaike.do")
	public void savePaike(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		
		boolean isHaveKaoqin = KaoqinServiceImpl.isHaveKaoqin(classesId);
		if(isHaveKaoqin){
			map.put(Constant.MSG, "该班级已经存在考勤记录，不可以修改！");
			map.put(Constant.SUCCESS, "false");
			response.getWriter().write(new Gson().toJson(map));
			return;
		}
		
		List<ClassesKecheng> ls = new ArrayList<ClassesKecheng>();
		String params = request.getParameter("params");
		String[] items = params.split(",");
		int flag = 0;
		for (String str : items) {
			String[] item = str.split("\\|");
			Date st = null;
			Date ed = null;
			try {
				st = SchoaUtil.pinPaikeTime(item[1]);
				ed = SchoaUtil.pinPaikeTime(item[2]);
			} catch (Exception e) {
				e.printStackTrace();
				flag = 1;
				map.put(Constant.MSG, "操作失败！开始时间或结束时间格式错误！");
				map.put(Constant.SUCCESS, "false");
				break;
			}
			for (int i = 0; i < 7; i++) {
				ClassesKecheng obj = new ClassesKecheng();
				obj.setClassesId(classesId);
				obj.setKechengStart(st);
				obj.setKechengEnd(ed);
				obj.setWeek(i);
				obj.setKechengId(NumberUtils.toInt(item[3 + i]));
				
				//验证教师排课时间是否冲突
				String verify = PaikeServiceImpl.verifyPaikeTime(obj.getClassesId(), obj.getWeek(), obj.getKechengId(), item[1], item[2]);
				if(StringUtils.isNotBlank(verify)){
					flag = 1;
					map.put(Constant.MSG, verify);
					map.put(Constant.SUCCESS, "false");
					break;
				}else{
					ls.add(obj);
				}
			}
		}
		if (flag == 1) {
			response.getWriter().write(new Gson().toJson(map));
			return;
		}

		boolean is = PaikeServiceImpl.deletePaike(classesId);
		if (is) {
			for (ClassesKecheng ck : ls) {
				try {
					if (ck.getKechengId() > 0) {
						ClassesKechengPeer.doInsert(ck);
					}
				} catch (TorqueException e) {
					e.printStackTrace();
				}
			}
			map.put(Constant.SUCCESS, "true");
			SchoaLogsServiceImpl.insertLogs(getSysUser(request),"排课classesId："+classesId);
		} else {
			map.put(Constant.MSG, "操作失败！");
			map.put(Constant.SUCCESS, "false");
		}

		response.getWriter().write(new Gson().toJson(map));
	}

}
