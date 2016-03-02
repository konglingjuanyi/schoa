package com.hao.schoa.controller.question;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.hao.schoa.BaseSchoa;
import com.hao.schoa.po.Member;
import com.hao.schoa.po.QuestionBank;
import com.hao.schoa.po.QuestionPaper;
import com.hao.schoa.po.QuestionPaperPeer;
import com.hao.schoa.po.QuestionTixing;
import com.hao.schoa.service.QuestionBankServiceImpl;
import com.hao.schoa.service.QuestionGenPaperServiceImpl;
import com.hao.schoa.service.QuestionPaperServiceImpl;
import com.hao.schoa.service.QuestionTixingServiceImpl;
import com.hao.schoa.tools.Constant;

/**
 * 试卷
 * 
 * @author haoguowei
 * 
 */
@Controller
public class QuestionPaperController extends BaseSchoa {

	/**
	 * 进入试卷
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/initQuestionPaper.do")
	public String initQuestionPaper(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return questionJSP("paper");
	}
	
	/**
	 * 查询试卷
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/searchQuestionPaper.do")
	public void searchQuestionPaper(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int start = NumberUtils.toInt(request.getParameter("start"));
		int limit = NumberUtils.toInt(request.getParameter("limit"), Constant.LIMIT);
		
		String title = request.getParameter("title");
		String user = request.getParameter("user");
		
		Map<String, Object> map = QuestionPaperServiceImpl.searchQuestionPaper(title, user, start, limit);
		response.getWriter().write(new Gson().toJson(map));
	}
	
	/**
	 * 删除试卷
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/deleteQuestionPaper.do")
	public void deleteQuestionPaper(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int id = NumberUtils.toInt(request.getParameter("id"));
		Member member = getSysMember(request);
		int delId = member.getId();
		String delName = member.getName();
		
		Map<String, Object> map = new HashMap<String, Object>();
		if(QuestionPaperServiceImpl.deleteById(id,delId,delName)){
			map.put(Constant.SUCCESS, true);
		}else{
			map.put(Constant.SUCCESS, false);
		}
		response.getWriter().write(new Gson().toJson(map));
	}
	
	/**
	 * 保存试卷
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/saveQuestionPaper.do")
	public String saveQuestionPaper(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		String user = request.getParameter("user");
		String ids = request.getParameter("ids");
		
		Date now = new Date();
		Member member = getSysMember(request);
		try {
			QuestionPaper paper = new QuestionPaper();
			paper.setTitle(title);
			paper.setQuestions(ids);
			paper.setMember(user);
			paper.setValid(Constant.valid);
			paper.setCreateTime(now);
			paper.setCreateMemberId(member.getId());
			paper.setCreateMember(member.getName());
			
			QuestionPaperPeer.doInsert(paper);
			//试题被使用次数加1
			QuestionBankServiceImpl.addUsedTimes(ids);
			return setSuccessAttribute(request, "试卷管理", "initQuestionPaper.do");
		} catch (Exception e) {
			e.printStackTrace();
			setErrorAttribute(request, e.getMessage());
		}
		return FAIL;
	}
	
	/**
	 * 查看答案
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/initViewShowAnswer.do")
	public String initQuestionAnswer(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = NumberUtils.toInt(request.getParameter("id"));
		String ids = request.getParameter("ids");
		List<QuestionBank> bankList = null;
		QuestionPaper paper = null;
		if(id > 0){
			paper = QuestionPaperServiceImpl.getById(id);
			if(paper != null){
				ids = paper.getQuestions();
			}
		}
		if(StringUtils.isNotBlank(ids)){
			bankList = QuestionGenPaperServiceImpl.searchQuestionByIds(ids);
		}
		
		Map<Integer,QuestionTixing> tixingMap = QuestionTixingServiceImpl.getTixingMap();
		request.setAttribute("paper", paper);
		request.setAttribute("tixingMap", tixingMap);
		request.setAttribute("bankList", bankList);
		return questionJSP("viewShowAnswer");
	}
	
	/**
	 * 查看试卷
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/initViewShowPaper.do")
	public String initQuestionpaperView(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = NumberUtils.toInt(request.getParameter("id"));
		String ids = "";
		List<QuestionBank> bankList = null;
		QuestionPaper paper = null;
		if(id > 0){
			paper = QuestionPaperServiceImpl.getById(id);
			if(paper != null){
				ids = paper.getQuestions();
			}
		}
		if(StringUtils.isNotBlank(ids)){
			bankList = QuestionGenPaperServiceImpl.searchQuestionByIds(ids);
		}
		
		Map<Integer,QuestionTixing> tixingMap = QuestionTixingServiceImpl.getTixingMap();
		request.setAttribute("paper", paper);
		request.setAttribute("tixingMap", tixingMap);
		request.setAttribute("bankList", bankList);
		return questionJSP("viewShowPaper");
	}
}
