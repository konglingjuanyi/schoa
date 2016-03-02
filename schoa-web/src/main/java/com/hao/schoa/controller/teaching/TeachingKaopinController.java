package com.hao.schoa.controller.teaching;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.torque.NoRowsException;
import org.apache.torque.TooManyRowsException;
import org.apache.torque.TorqueException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.hao.schoa.BaseSchoa;
import com.hao.schoa.po.Classes;
import com.hao.schoa.po.JiaoxueKaopin;
import com.hao.schoa.po.JiaoxueKaopinInfo;
import com.hao.schoa.po.JiaoxueKaopinInfoPeer;
import com.hao.schoa.po.JiaoxueKaopinPeer;
import com.hao.schoa.po.Kecheng;
import com.hao.schoa.po.KechengPeer;
import com.hao.schoa.po.Member;
import com.hao.schoa.po.Xueqi;
import com.hao.schoa.service.ClassesServiceImpl;
import com.hao.schoa.service.PaikeServiceImpl;
import com.hao.schoa.service.SchoaLogsServiceImpl;
import com.hao.schoa.service.TeachingKaopinServiceImpl;
import com.hao.schoa.service.XueqiServiceImpl;
import com.hao.schoa.tools.Constant;

/**
 * 教学考评
 * @author haoguowei
 *
 */
@Controller
public class TeachingKaopinController extends BaseSchoa{

	@RequestMapping("/initTeachingKaopin.do")
	public String initTeachingKaopin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Member member = getSysMember(request);
		if(member == null){
			return NOPRIVILEGES;
		}
		
		boolean admin = isAdminRole(member.getRoleId());
		
		int xueqiId = NumberUtils.toInt(request.getParameter("xueqiId"));
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		int kechengId = NumberUtils.toInt(request.getParameter("kechengId"));
		
		List<Xueqi> xuqis = null;
		List<Classes> classList = null;
		List<Kecheng> kechengList = null;
		
		if(admin){
			xuqis = XueqiServiceImpl.getAllXueqiList();
		}else{
			xuqis = XueqiServiceImpl.getTeacherXueqiList(member.getTeacherId());
		}
		
		if(xueqiId > 0){
			classList = ClassesServiceImpl.getClassesList(xueqiId);
		}
		
		if(classesId > 0){
			kechengList = PaikeServiceImpl.getClassesKecheng(classesId);
		}
		
		request.setAttribute("xueqiId", xueqiId);
		request.setAttribute("classesId", classesId);
		request.setAttribute("kechengId", kechengId);
		
		request.setAttribute("xueqiList", xuqis);
		request.setAttribute("classList", classList);
		request.setAttribute("kechengList", kechengList);
		
		request.setAttribute("admin", admin);
		
		return teachingJSP("kaopin");
	}
	
	@RequestMapping("/initEditKaopin.do")
	public String initEditKaopin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Member member = getSysMember(request);
		if(member == null){
			return NOPRIVILEGES;
		}
		
		boolean admin = isAdminRole(member.getRoleId());
		if(!admin){
			return NOPRIVILEGES;
		}
		
		int id = NumberUtils.toInt(request.getParameter("id"));
		
		JiaoxueKaopin kaopin = TeachingKaopinServiceImpl.getKaopinById(id);
		List<Xueqi> xuqis = XueqiServiceImpl.getAllXueqiList();
		
		request.setAttribute("kaopin", kaopin);
		request.setAttribute("xueqiList", xuqis);
		
		return teachingJSP("editKaopin");
	}
	
	/**
	 * 教师考评详情
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/initKaopinItem.do")
	public String initKaopinItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Member member = getSysMember(request);
		if(member == null){
			return NOPRIVILEGES;
		}
		
		boolean admin = isAdminRole(member.getRoleId());
		
		//考评基本信息
		int kaopinId = NumberUtils.toInt(request.getParameter("kaopinId"));
		JiaoxueKaopin kaopin = TeachingKaopinServiceImpl.getKaopinFullById(kaopinId);
		if(!admin && kaopin.getTeacherId() != member.getTeacherId()){
			kaopin = null;
		}
		request.setAttribute("kaopin", kaopin);
		
		//评分信息
		int itemId = NumberUtils.toInt(request.getParameter("itemId"));
		JiaoxueKaopinInfo kaopinInfo = TeachingKaopinServiceImpl.getKaopinInfoById(itemId);
		request.setAttribute("kaopinInfo", kaopinInfo);
		
		//问题
		request.setAttribute("questionMap", Constant.questionMap);
		request.setAttribute("admin", admin);
		
		return teachingJSP("kaopinItem");
	}
	/**
	 * 教师考评列表
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 * @throws TorqueException 
	 * @throws TooManyRowsException 
	 * @throws NoRowsException 
	 */
	@RequestMapping("/initTeacherKaopinList.do")
	public String initTeacherKaopinList(HttpServletRequest request, HttpServletResponse response) throws IOException, NoRowsException, TooManyRowsException, TorqueException {
		Member member = getSysMember(request);
		if(member == null){
			return NOPRIVILEGES;
		}
		boolean admin = isAdminRole(member.getRoleId());
		
		int kaopinId = NumberUtils.toInt(request.getParameter("kaopinId"));
		
		//考评基本信息
		JiaoxueKaopin kaopin = TeachingKaopinServiceImpl.getKaopinFullById(kaopinId);
		if(!admin && kaopin.getTeacherId() != member.getTeacherId()){
			kaopin = null;
		}
		
		request.setAttribute("kaopin", kaopin);
		request.setAttribute("admin", admin);
		
		return teachingJSP("kaopinList");
	}
	
	@RequestMapping("/searchTeachingKaopin.do")
	public void searchTeachingKaopin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int xueqiId = NumberUtils.toInt(request.getParameter("xueqiId"));
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		int kechengId = NumberUtils.toInt(request.getParameter("kechengId"));

		int start = NumberUtils.toInt(request.getParameter("start"));
		int limit = NumberUtils.toInt(request.getParameter("limit"), Constant.LIMIT);
		
		int teacherId = 0;
		Member member = getSysMember(request);
		if(member == null){
			teacherId = -1;
		}else{
			teacherId = isAdminRole(member.getRoleId()) ? 0 : member.getTeacherId();
		}

		Map<String, Object> map = TeachingKaopinServiceImpl.search(teacherId, xueqiId, classesId, kechengId,
				start, limit);
		response.getWriter().write(new Gson().toJson(map));
	}
	
	@RequestMapping("/searchKaopinPingfenList.do")
	public void searchKaopinPingfenList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int kaopinId = NumberUtils.toInt(request.getParameter("kaopinId"));
		
		Map<String, Object> map = TeachingKaopinServiceImpl.searchKaopinPingfenList(kaopinId);
		response.getWriter().write(new Gson().toJson(map));
	}
	
	/**
	 * 删除考评
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/deleteKaopin.do")
	public void deleteKaopin(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		int id = NumberUtils.toInt(request.getParameter("id"));
		Map<String,Boolean> map = new HashMap<String, Boolean>();
		
		map.put(Constant.SUCCESS, TeachingKaopinServiceImpl.deleteKaopin(id));
		
		SchoaLogsServiceImpl.insertLogs(getSysUser(request),"删除考评，id＝"+id);
		response.getWriter().write(new Gson().toJson(map));
	}
	
	/**
	 * 删除一条评分成绩
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/deleteKaopinItem.do")
	public void deleteKaopinItem(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		int id = NumberUtils.toInt(request.getParameter("id"));
		Map<String,Boolean> map = new HashMap<String, Boolean>();
		
		map.put(Constant.SUCCESS, TeachingKaopinServiceImpl.deleteKaopinItem(id));
		
		SchoaLogsServiceImpl.insertLogs(getSysUser(request),"删除一条评分成绩，id＝"+id);
		response.getWriter().write(new Gson().toJson(map));
	}
	
	@RequestMapping("/saveJiaoxueKaopin.do")
	public String saveJiaoxueKaopin(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
			int id = NumberUtils.toInt(request.getParameter("hideId"));
			int xueqiId = NumberUtils.toInt(request.getParameter("xueqiId"));
			int classesId = NumberUtils.toInt(request.getParameter("classesId"));
			int kechengId = NumberUtils.toInt(request.getParameter("kechengId"));
			String name = request.getParameter("name");
	
			Member member = getSysMember(request);
			
			if(member == null){
				return NOPRIVILEGES;
			}
	
			JiaoxueKaopin jiaoxueKaopin = null;
			try {
				if (id == 0) {
					Kecheng kch = KechengPeer.retrieveByPK(kechengId);
					int teacherId = kch == null?0:kch.getTeacherId();
					
					jiaoxueKaopin = new JiaoxueKaopin();
					jiaoxueKaopin.setXueqiId(xueqiId);
					jiaoxueKaopin.setBanjiId(classesId);
					jiaoxueKaopin.setKechengId(kechengId);
					jiaoxueKaopin.setTeacherId(teacherId);
					
					jiaoxueKaopin.setName(name);
					
					jiaoxueKaopin.setScore(0);
					jiaoxueKaopin.setKaopinInfoId(0);
					jiaoxueKaopin.setCreateTime(new Date());
					jiaoxueKaopin.setMemberId(member.getId());
					jiaoxueKaopin.setMemberName(member.getName());
					jiaoxueKaopin.setUpdateTime(new Date());
					
					JiaoxueKaopinPeer.doInsert(jiaoxueKaopin);
					
					SchoaLogsServiceImpl.insertLogs(getSysUser(request), 
							"新创建教学考评"+jiaoxueKaopin.toString());
				} else {
					jiaoxueKaopin = TeachingKaopinServiceImpl.getKaopinById(id);
					
//					jiaoxueKaopin.setXueqiId(xueqiId);
//					jiaoxueKaopin.setBanjiId(classesId);
//					jiaoxueKaopin.setKechengId(kechengId);
//					jiaoxueKaopin.setTeacherId(teacherId);
					
					jiaoxueKaopin.setName(name);
					
					jiaoxueKaopin.setMemberId(member.getId());
					jiaoxueKaopin.setMemberName(member.getName());
					jiaoxueKaopin.setUpdateTime(new Date());
					
					JiaoxueKaopinPeer.doUpdate(jiaoxueKaopin);
					
					SchoaLogsServiceImpl.insertLogs(getSysUser(request), "修改教学考评"+jiaoxueKaopin.toString());
				}
				return setSuccessAttribute(request, "教学考评", "initTeachingKaopin.do");
			} catch (Exception e) {
				e.printStackTrace();
				setErrorAttribute(request, e.getMessage());
			}
		return FAIL;
	}
	
	@RequestMapping("/saveTeacherPingfen.do")
	public String saveTeacherPingfen(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Member member = getSysMember(request);
		
		int kaopinId = NumberUtils.toInt(request.getParameter("hide_kaopin_id"));
		int kaopinInfoId = NumberUtils.toInt(request.getParameter("hide_kaopinInfo_id"));
		
		if(member == null){
			return NOPRIVILEGES;
		}
		if(kaopinId <= 0){
			setErrorAttribute(request, "考评id＝"+kaopinId);
			return FAIL;
		}
		
		int sum = 0;
		int anshi = NumberUtils.toInt(request.getParameter("anshi"));
		int youyiyi = NumberUtils.toInt(request.getParameter("youyiyi"));
		int neirong = NumberUtils.toInt(request.getParameter("neirong"));
		int shouhuo = NumberUtils.toInt(request.getParameter("shouhuo"));
		int shuohuaQingchu = NumberUtils.toInt(request.getParameter("shuohuaQingchu"));
		int heibanziQingchu = NumberUtils.toInt(request.getParameter("heibanziQingchu"));
		int heibanziZhongyao = NumberUtils.toInt(request.getParameter("heibanziZhongyao"));
		int shuliangHeshi = NumberUtils.toInt(request.getParameter("shuliangHeshi"));
		int hanziJihui = NumberUtils.toInt(request.getParameter("hanziJihui"));
		int huodongYouxiao = NumberUtils.toInt(request.getParameter("huodongYouxiao"));
		int zuoyeHeshi = NumberUtils.toInt(request.getParameter("zuoyeHeshi"));
		int zuoyeBangzhu = NumberUtils.toInt(request.getParameter("zuoyeBangzhu"));
		int naixin = NumberUtils.toInt(request.getParameter("naixin"));
		int jinbu = NumberUtils.toInt(request.getParameter("jinbu"));
		int yange = NumberUtils.toInt(request.getParameter("yange"));
		int yuanyi = NumberUtils.toInt(request.getParameter("yuanyi"));
		int liaotian = NumberUtils.toInt(request.getParameter("liaotian"));
		
		sum += anshi;
		sum += youyiyi;
		sum += neirong;
		sum += shouhuo;
		sum += shuohuaQingchu;
		sum += heibanziQingchu;
		sum += heibanziZhongyao;
		sum += shuliangHeshi;
		sum += hanziJihui;
		sum += huodongYouxiao;
		sum += zuoyeHeshi;
		sum += zuoyeBangzhu;
		sum += naixin;
		sum += jinbu;
		sum += yange;
		sum += yuanyi;
		sum += liaotian;
		
		String pingjia = request.getParameter("pingjia");
		JiaoxueKaopinInfo kaopinInfo = null;
		try {
			if (kaopinInfoId == 0) {
				kaopinInfo = new JiaoxueKaopinInfo();
				kaopinInfo.setCreateTime(new Date());
			} else {
				kaopinInfo = TeachingKaopinServiceImpl.getKaopinInfoById(kaopinInfoId);
			}
			
			kaopinInfo.setKaopinId(kaopinId);
			kaopinInfo.setAnshi(anshi);
			kaopinInfo.setYouyiyi(youyiyi);
			kaopinInfo.setNeirong(neirong);
			kaopinInfo.setShouhuo(shouhuo);
			kaopinInfo.setShuohuaQingchu(shuohuaQingchu);
			kaopinInfo.setHeibanziQingchu(heibanziQingchu);
			kaopinInfo.setHeibanziZhongyao(heibanziZhongyao);
			kaopinInfo.setShuliangHeshi(shuliangHeshi);
			kaopinInfo.setHanziJihui(hanziJihui);
			kaopinInfo.setHuodongYouxiao(huodongYouxiao);
			kaopinInfo.setZuoyeHeshi(zuoyeHeshi);
			kaopinInfo.setZuoyeBangzhu(zuoyeBangzhu);
			kaopinInfo.setNaixin(naixin);
			kaopinInfo.setJinbu(jinbu);
			kaopinInfo.setYange(yange);
			kaopinInfo.setYuanyi(yuanyi);
			kaopinInfo.setLiaotian(liaotian);
			kaopinInfo.setPingjia(pingjia);
			kaopinInfo.setManId(member.getId());
			kaopinInfo.setManName(member.getName());
			kaopinInfo.setUpdateTime(new Date());
			kaopinInfo.setSumScore(sum);
			
			if (kaopinInfoId == 0) {
				JiaoxueKaopinInfoPeer.doInsert(kaopinInfo);
			} else {
				JiaoxueKaopinInfoPeer.doUpdate(kaopinInfo);
			}
			
			//计算得分
			int score = TeachingKaopinServiceImpl.calKaopinScore(kaopinId);
			TeachingKaopinServiceImpl.updateKaopinScore(kaopinId, score);
			return setSuccessAttribute(request, request.getParameter("hide_title"), "initTeacherKaopinList.do?kaopinId="+kaopinId);
		} catch (Exception e) {
			e.printStackTrace();
			setErrorAttribute(request, e.getMessage());
		}
		return FAIL;
	}
	
}
