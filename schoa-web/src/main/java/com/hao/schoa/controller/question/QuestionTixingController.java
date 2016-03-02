package com.hao.schoa.controller.question;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.hao.schoa.BaseSchoa;
import com.hao.schoa.po.Member;
import com.hao.schoa.po.QuestionTixing;
import com.hao.schoa.po.QuestionTixingPeer;
import com.hao.schoa.service.QuestionTixingServiceImpl;

/**
 * 题型管理
 * @author haoguowei
 *
 */
@Controller
public class QuestionTixingController extends BaseSchoa{

	/**
	 * 进入题型
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/initQuestionTixing.do")
	public String initQuestionTixing(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return questionJSP("tixing");
	}
	
	/**
	 * 编辑题型
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/initTixingEdit.do")
	public String initTixingEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = NumberUtils.toInt(request.getParameter("id"));
		QuestionTixing tixing = id <= 0 ? null : QuestionTixingServiceImpl.getQuestionTixingById(id);
		request.setAttribute("tixing", tixing);
		return questionJSP("tixingEdit");
	}
	
	/**
	 * 保存题型
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/saveTixing.do")
	public String saveTixing(HttpServletRequest request,HttpServletResponse response) throws IOException{
		int id = NumberUtils.toInt(request.getParameter("hideId"));
		String title = request.getParameter("title");
		String subtitle = request.getParameter("subtitle");
		String standardInfo = request.getParameter("standardInfo");
		int amount = NumberUtils.toInt(request.getParameter("amount"));
		int sort = NumberUtils.toInt(request.getParameter("sort"));
		
		QuestionTixing tixing = null;
		Date now = new Date();
		Member member = getSysMember(request);
		try {
			if(id == 0){
				tixing = new QuestionTixing();
				tixing.setCreateTime(now);
				tixing.setCreateMemberId(member.getId());
				tixing.setCreateMember(member.getName());
				
				tixing.setTitle(title);
				tixing.setSubtitle(subtitle);
				tixing.setStandardInfo(standardInfo);
				tixing.setAmount(amount);
				tixing.setSort(sort);
				
				QuestionTixingPeer.doInsert(tixing);
			}else{
				tixing = QuestionTixingServiceImpl.getQuestionTixingById(id);
				tixing.setModifyTime(now);
				tixing.setModifyMemberId(member.getId());
				tixing.setModifyMember(member.getName());
				
				tixing.setTitle(title);
				tixing.setSubtitle(subtitle);
				tixing.setStandardInfo(standardInfo);
				tixing.setAmount(amount);
				tixing.setSort(sort);
				
				QuestionTixingPeer.doUpdate(tixing);
			}
			return setSuccessAttribute(request, "题型管理", "initQuestionTixing.do");
		} catch (Exception e) {
			e.printStackTrace();
			setErrorAttribute(request, e.getMessage());
		}
		return FAIL;
	}
	
	/**
	 * 查询题型
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/searchQuestionTixing.do")
	public void searchQuestionTixing(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Map<String, Object> map = QuestionTixingServiceImpl.searchQuestionTixing();
		response.getWriter().write(new Gson().toJson(map));
	}
	

}
