package com.hao.schoa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hao.schoa.BaseSchoa;
import com.hao.schoa.container.ContainerChengjidan;
import com.hao.schoa.po.ChengjidanPrintHistory;
import com.hao.schoa.report.ReportChengJiDanAndSave;
import com.hao.schoa.report.ReportChengJiDanFromHistory;
import com.hao.schoa.report.ReportChengJiDanNormal;
import com.hao.schoa.report.ReportClassesChuqin;
import com.hao.schoa.report.ReportJieYeZh;
import com.hao.schoa.report.ReportJinbujiang;
import com.hao.schoa.report.ReportKaoqin;
import com.hao.schoa.report.ReportKaoqinEmpty;
import com.hao.schoa.report.ReportKechengbiao;
import com.hao.schoa.report.ReportScore;
import com.hao.schoa.report.ReportStudentChuqin;
import com.hao.schoa.report.ReportStudents;
import com.hao.schoa.report.ReportTeacherPingjia;
import com.hao.schoa.report.ReportTeacherPingjiaResult;
import com.hao.schoa.report.ReportXuexiZhengMing;
import com.hao.schoa.report.ReportYouxiuStudent;
import com.hao.schoa.service.ChengjidanServiceImpl;

@Controller
public class ReportController extends BaseSchoa{

	/**
	 * 打印学生名单
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/initReportStudents.do")
	public void initReportStudents(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		new ReportStudents().report(request, response);
	}
	
	/**
	 * 打印学习证明
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/initReportStudyZhMPage.do")
	public String initReportStudyZhMPage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int studentId = NumberUtils.toInt(request.getParameter("studentId"));
		request.setAttribute("studentId", studentId);
		return "manager/reportStudyZhM";
	}
	
	/**
	 * 打印学习证明
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/initReportStudyZhM.do")
	public void initReportStudyZhM(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		new ReportXuexiZhengMing().report(request, response);
	}
	
	/**
	 * 打印结业证
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/initReportJieYeZh.do")
	public void initReportJieYeZh(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		new ReportJieYeZh().report(request, response);
	}
	
	/**
	 * 打印班级空考勤表
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/initReportClassEmptyKaoqin.do")
	public void initReportClassEmptyKaoqin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		new ReportKaoqinEmpty().report(request, response);
	}
	
	/**
	 * 打印班级考勤
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/initReportClassWeekKaoqin.do")
	public void initReportClassWeekKaoqin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		new ReportKaoqin().report(request, response);
	}
	
	/**
	 * 成绩登记单
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/exportScore.do")
	public void exportScore(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		new ReportScore().report(request, response);
	}
	
	/**
	 * 打印班级课程
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/initReportClassKecheng.do")
	public void initReportClassKecheng(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		new ReportKechengbiao().report(request, response);
	}
	
	/**
	 * 打印学生出勤表
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/initReportStudentChuqin.do")
	public void initReportStudentChuqin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		new ReportStudentChuqin().report(request, response);
	}
	/**
	 * 打印班级出勤表
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/initReportClassesChuqin.do")
	public void initReportClassesChuqin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		new ReportClassesChuqin().report(request, response);
	}
	
	/**
	 * 打印优秀生奖状
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/initReportYouxiuStudent.do")
	public void initReportYouxiuStudent(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		new ReportYouxiuStudent().report(request, response);
	}
	
	/**
	 * 正常打印成绩单
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/initReportChengJiDan.do")
	public void initReportChengJiDan(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		new ReportChengJiDanNormal().report(request, response);
	}
	
	/**
	 * 成绩单页面
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/initChengJiDan.do")
	public String initChengJiDan(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int studentId = NumberUtils.toInt(request.getParameter("studentId"));
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		ContainerChengjidan normal = ChengjidanServiceImpl.genSubjectMarks(studentId, classesId, null);
		List<ChengjidanPrintHistory> historys = ChengjidanServiceImpl.selectHistory(studentId, classesId);
		
		request.setAttribute("normal", normal);
		request.setAttribute("historys", historys);
		
		return "manager/chengjidan";
	}
	
	/**
	 * 保存成绩并打印
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/initSaveReportChengJiDan.do")
	public void initSaveReportChengJiDan(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		new ReportChengJiDanAndSave().report(request, response);
	}
	
	@RequestMapping("/initReportChengJiDanFromHistory.do")
	public void initReportChengJiDanFromHistory(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		new ReportChengJiDanFromHistory().report(request, response);
	}
	
	/**
	 * 打印班级下空考评表格
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/initPrintClassKaopin.do")
	public void initPrintClassKaopin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		new ReportTeacherPingjia().report(request, response);
	}
	
	/**
	 * 打印教师考评结果表
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/initPrintTeacherKaopin.do")
	public void initPrintTeacherKaopin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		new ReportTeacherPingjiaResult().report(request, response);
	}
	
	/**
	 * 打印进步奖
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/initPrintJinbu.do")
	public void initPrintJinbu(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		new ReportJinbujiang().report(request, response);
	}

}
