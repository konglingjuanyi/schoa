package com.hao.schoa.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.torque.TorqueException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hao.schoa.BaseSchoa;
import com.hao.schoa.po.Member;
import com.hao.schoa.po.PaperAnalysis;
import com.hao.schoa.po.PaperAnalysisPeer;
import com.hao.schoa.report.ReportPaperAnalysiz;
import com.hao.schoa.service.LockServiceImpl;
import com.hao.schoa.service.PaperAnalysisServiceImpl;

@Controller
public class PaperAnalysisController extends BaseSchoa{

	/**
	 * 试卷分析
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 * @throws TorqueException 
	 */
	@RequestMapping("/initPaperAnalysis.do")
	public String initPaperAnalysis(HttpServletRequest request,
			HttpServletResponse response) throws IOException, TorqueException {
		
		int xueqiId = NumberUtils.toInt(request.getParameter("xueqiId"));
		int banjiId = NumberUtils.toInt(request.getParameter("banjiId"));
		int kechengId = NumberUtils.toInt(request.getParameter("kechengId"));
		
		
		Member member = getSysMember(request);
		boolean admin = isAdminRole(member.getRoleId());
		
		PaperAnalysis paperAnalysis = PaperAnalysisServiceImpl.getPaperAnalysis(xueqiId,banjiId,kechengId,member.getName());
		
		//是否可修改成绩
		boolean canmodifiy = true;
		if(!admin && LockServiceImpl.isLockScore(xueqiId, banjiId, kechengId)){
			canmodifiy = false;
		}
		
		request.setAttribute("canmodifiy", canmodifiy);
		request.setAttribute("paperAnalysis", paperAnalysis);
		request.setAttribute("canmodifiy", canmodifiy);
		return "manager/paperAnalysis";
	}
	
	@RequestMapping("/savePaper.do")
	public String savePaper(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		int id = NumberUtils.toInt(request.getParameter("id"));
		int print = NumberUtils.toInt(request.getParameter("print"));
		
		String mingtiTeacher = request.getParameter("mingtiTeacher");
		String kaoshiType = request.getParameter("kaoshiType");
		
		int zl01 = NumberUtils.toInt(request.getParameter("zl01"));
		int zl02 = NumberUtils.toInt(request.getParameter("zl02"));
		int zl03 = NumberUtils.toInt(request.getParameter("zl03"));
		int zl04 = NumberUtils.toInt(request.getParameter("zl04"));
		int zl05 = NumberUtils.toInt(request.getParameter("zl05"));
		
		String fenxi1 = request.getParameter("fenxi1");
		String fenxi2 = request.getParameter("fenxi2");
		
		try {
			PaperAnalysis pa = PaperAnalysisPeer.retrieveByPK(id);
			pa.setMingtiTeacher(mingtiTeacher);
			pa.setKaoshiType(kaoshiType);
			pa.setZl01(zl01);
			pa.setZl02(zl02);
			pa.setZl03(zl03);
			pa.setZl04(zl04);
			pa.setZl05(zl05);
			
			pa.setFenxi1(fenxi1);
			pa.setFenxi2(fenxi2);
			
			PaperAnalysisServiceImpl.fullPaperAnalysisScoreInfo(pa);
			
			pa.setMember(getSysUser(request));
			pa.setUpdateTime(new Date());
			
			PaperAnalysisPeer.doUpdate(pa);
			
			if(print == 1){
				//打印
				new ReportPaperAnalysiz().report(request, response);
				return null;
			}
			
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return FAIL;
	}
}
