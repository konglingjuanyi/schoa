package com.hao.schoa.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.torque.TorqueException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.hao.schoa.BaseSchoa;
import com.hao.schoa.po.Classes;
import com.hao.schoa.po.Kecheng;
import com.hao.schoa.po.Member;
import com.hao.schoa.po.Score;
import com.hao.schoa.po.ScorePeer;
import com.hao.schoa.po.Student;
import com.hao.schoa.po.Xueqi;
import com.hao.schoa.service.ClassesServiceImpl;
import com.hao.schoa.service.LockServiceImpl;
import com.hao.schoa.service.PaikeServiceImpl;
import com.hao.schoa.service.SchoaLogsServiceImpl;
import com.hao.schoa.service.ScoreServiceImpl;
import com.hao.schoa.service.StudentServiceImpl;
import com.hao.schoa.service.XueqiServiceImpl;
import com.hao.schoa.tools.Constant;


/**
 * 成绩
 * @author haoguowei
 *
 */
@Controller
public class ScoreController extends BaseSchoa{

	@RequestMapping("/initScore.do")
	public String initScore(HttpServletRequest request,
			HttpServletResponse response) throws IOException, TorqueException {
		
		int xueqiId = NumberUtils.toInt(request.getParameter("xueqiId"));
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		int kechengId = NumberUtils.toInt(request.getParameter("kechengId"));
		
		List<Xueqi> xuqis = null;
		List<Classes> classList = null;
		List<Kecheng> kechengList = null;
		List<Student> studentList = null;
		
		Member member = getSysMember(request);
		boolean admin = isAdminRole(member.getRoleId());
		
		if(admin){
			xuqis = XueqiServiceImpl.getAllXueqiList();
		}else{
			xuqis = XueqiServiceImpl.getTeacherXueqiList(member.getTeacherId());
		}
		
		if(xueqiId > 0){
			if(admin){
				classList = ClassesServiceImpl.getClassesList(xueqiId);
			}else{
				classList = ClassesServiceImpl.getTeacherClassesList(xueqiId,member.getTeacherId());
			}
		}
		if(classesId > 0){
			kechengList = PaikeServiceImpl.getClassesKecheng(classesId,admin?0:member.getTeacherId());
			if(kechengId > 0){
				//加载班级x下所有学生及成绩
				studentList = StudentServiceImpl.searchClassesStudent(classesId, kechengId);
			}
		}
		
		//是否可修改成绩
		boolean canmodifiy = true;
		if(!admin && LockServiceImpl.isLockScore(xueqiId, classesId, kechengId)){
			canmodifiy = false;
		}
		request.setAttribute("canmodifiy", canmodifiy);
		
		request.setAttribute("xueqiId", xueqiId);
		request.setAttribute("classesId", classesId);
		request.setAttribute("kechengId", kechengId);
		
		request.setAttribute("xueqiList", xuqis);
		request.setAttribute("classList", classList);
		request.setAttribute("kechengList", kechengList);
		
		request.setAttribute("studentList", studentList); //班级下所有学生
		return "manager/score";
	}
	
	
	@RequestMapping("/getStudentScore.do")
	public void getStudentScore(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		int studentId = NumberUtils.toInt(request.getParameter("studentId"));
		int xueqiId = NumberUtils.toInt(request.getParameter("xueqiId"));
		int kechengId = NumberUtils.toInt(request.getParameter("kechengId"));
		
		Score score = ScoreServiceImpl.getStudentScore(classesId, studentId, kechengId);
		if(score == null){
			score = new Score();
		}
		Xueqi xueqi = XueqiServiceImpl.getById(xueqiId);
		score.setTotalKeshi(ScoreServiceImpl.getTotalKeshi(xueqi.getStartDate(), xueqi.getEndDate(),classesId, kechengId));
		score.setQueqin(ScoreServiceImpl.getTotalQueqin(xueqi.getStartDate(), xueqi.getEndDate(), classesId, studentId, kechengId));
		response.getWriter().write(new Gson().toJson(score));
	}
	
	@RequestMapping("/saveScore.do")
	public void saveScore(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String,Boolean> map = new HashMap<String, Boolean>();
		map.put(Constant.SUCCESS, false);
		try {
			int classesId = NumberUtils.toInt(request.getParameter("classesId"));
			int studentId = NumberUtils.toInt(request.getParameter("studentId"));
			int kechengId = NumberUtils.toInt(request.getParameter("kechengId"));
			
			double keguan = NumberUtils.toDouble(request.getParameter("keguan"), 0d);
			double zhuguan = NumberUtils.toDouble(request.getParameter("zhuguan"), 0d);
			double juanmian = NumberUtils.toDouble(request.getParameter("juanmian"), 0d);
			double w40 = NumberUtils.toDouble(request.getParameter("w40"), 0d);
			double qizhong = NumberUtils.toDouble(request.getParameter("qizhong"), 0d);
			double w20 = NumberUtils.toDouble(request.getParameter("w20"), 0d);
			double zuoye = NumberUtils.toDouble(request.getParameter("zuoye"), 0d);
			
	//		double zuoye20 = NumberUtils.toDouble(request.getParameter("zuoye20"), 0d);
	//		double kaoqin = NumberUtils.toDouble(request.getParameter("kaoqin"), 0d);
	//		double keshi = NumberUtils.toDouble(request.getParameter("keshi"), 0d);
			double chuqin = NumberUtils.toDouble(request.getParameter("chuqin"), 0d);
			double chengjiAll = NumberUtils.toDouble(request.getParameter("chengjiAll"), 0d);
			
			String rmark = request.getParameter("rmark");
			
			Score score = ScoreServiceImpl.getStudentScore(classesId,studentId,kechengId);
			if(score == null){
				score = new Score();
			}
			score.setClassId(classesId);
			score.setKechengId(kechengId);
			score.setStudentId(studentId);
			score.setScKeguan(keguan);
			score.setScZhuguan(zhuguan);
			score.setScJuanmian(juanmian);
			score.setScQizhong(qizhong);
			score.setScZuoye(zuoye);
			score.setScChuqin(chuqin);
			score.setScAll(chengjiAll);
			score.setSc40(w40);
			score.setSc20(w20);
			score.setRemark(rmark);
		
			if(score.getId() > 0){
				ScorePeer.doUpdate(score);
			}else{
				ScorePeer.doInsert(score);
			}
			map.put(Constant.SUCCESS, true);
			SchoaLogsServiceImpl.insertLogs(getSysUser(request),"修改成绩："+score.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.getWriter().write(new Gson().toJson(map));
	}
}
