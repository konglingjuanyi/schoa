package com.hao.schoa.controller.question;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.hao.schoa.BaseSchoa;
import com.hao.schoa.po.Member;
import com.hao.schoa.po.QuestionKnowledgePoint;
import com.hao.schoa.po.QuestionKnowledgePointPeer;
import com.hao.schoa.service.QuestionKnowledgePointServiceImpl;
import com.hao.schoa.tools.Constant;

/**
 * 知识点
 * @author haoguowei
 *
 */
@Controller
public class QuestionKnowledgePointController extends BaseSchoa{
	
	/**
	 * 进入知识点
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/initQuestionKnowledgePoint.do")
	public String initQuestionKnowledgePoint(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return questionJSP("knowledgePoint");
	}
	
	/**
	 * 编辑知识点
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/initKnowledgePointEdit.do")
	public String initKnowledgePointEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = NumberUtils.toInt(request.getParameter("id"));
		QuestionKnowledgePoint kpoint = id <= 0 ? null : QuestionKnowledgePointServiceImpl.getQuestionKnowledgePointById(id);
		request.setAttribute("kpoint", kpoint);
		return questionJSP("knowledgePointEdit");
	}
	
	/**
	 * 保存知识点
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/saveKnowledgePoint.do")
	public String saveKnowledgePoint(HttpServletRequest request,HttpServletResponse response) throws IOException{
		int id = NumberUtils.toInt(request.getParameter("hideId"));
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		
		QuestionKnowledgePoint kpoint = null;
		Date now = new Date();
		Member member = getSysMember(request);
		try {
			if(id == 0){
				kpoint = new QuestionKnowledgePoint();
				kpoint.setName(name);
				kpoint.setContent(content);
				kpoint.setCreateTime(now);
				kpoint.setCreateMemberId(member.getId());
				kpoint.setCreateMember(member.getName());
				
				QuestionKnowledgePointPeer.doInsert(kpoint);
			}else{
				kpoint = QuestionKnowledgePointServiceImpl.getQuestionKnowledgePointById(id);
				kpoint.setName(name);
				kpoint.setContent(content);
				kpoint.setModifyTime(now);
				kpoint.setModifyMemberId(member.getId());
				kpoint.setModifyMember(member.getName());
				
				QuestionKnowledgePointPeer.doUpdate(kpoint);
			}
			return setSuccessAttribute(request, "知识点", "initQuestionKnowledgePoint.do");
		} catch (Exception e) {
			e.printStackTrace();
			setErrorAttribute(request, e.getMessage());
		}
		return FAIL;
	}
	
	/**
	 * 删除知识点
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/deleteKnowledgePoint.do")
	public void deleteKnowledgePoint(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int id = NumberUtils.toInt(request.getParameter("id"));
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(QuestionKnowledgePointServiceImpl.deleteById(id)){
			map.put(Constant.SUCCESS, true);
		}else{
			map.put(Constant.SUCCESS, false);
		}
		response.getWriter().write(new Gson().toJson(map));
	}
	
	/**
	 * 查询知识点
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/searchQuestionKnowledgePoint.do")
	public void searchQuestionKnowledgePoint(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int start = NumberUtils.toInt(request.getParameter("start"));
		int limit = NumberUtils.toInt(request.getParameter("limit"), Constant.LIMIT);
		
		String name = request.getParameter("name");
		
		Map<String, Object> map = QuestionKnowledgePointServiceImpl.searchKnowledgePoint(name, start, limit);
		response.getWriter().write(new Gson().toJson(map));
	}
	
}
