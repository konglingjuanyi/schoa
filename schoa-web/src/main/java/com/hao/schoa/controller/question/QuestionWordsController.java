package com.hao.schoa.controller.question;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.hao.schoa.BaseSchoa;
import com.hao.schoa.po.Member;
import com.hao.schoa.po.QuestionWordsLevel;
import com.hao.schoa.po.QuestionWordsLevelPeer;
import com.hao.schoa.po.QuestionWordsStandard;
import com.hao.schoa.po.QuestionWordsStandardPeer;
import com.hao.schoa.service.QuestionWordsServiceImpl;
import com.hao.schoa.service.SchoaAnalyzerService;
import com.hao.schoa.tools.Constant;

@Controller
public class QuestionWordsController extends BaseSchoa{
	
	/**
	 * 进入词汇标准
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/initQuestionWordsStandard.do")
	public String initQuestionWordsStandard(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return questionJSP("wordsStandard");
	}
	
	/**
	 * 查看词汇标准下的各个级别的词语
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/initViewWordsStandard.do")
	public String initViewWordsStandard(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = NumberUtils.toInt(request.getParameter("id"));
		QuestionWordsStandard standard = id <= 0 ? null : QuestionWordsServiceImpl.getQuestionWordsStandardById(id);
		request.setAttribute("standard", standard);
		
		if(standard != null){
			List<QuestionWordsLevel> levelList = QuestionWordsServiceImpl.getQuestionWordsLevelList(id, 0);
			request.setAttribute("levelList", levelList);
		}
		
		return questionJSP("viewWordsStandard");
	}
	
	/**
	 * 编辑词汇标准
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/initWordsStandardEdit.do")
	public String initWordsStandardEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = NumberUtils.toInt(request.getParameter("id"));
		QuestionWordsStandard standard = id <= 0 ? null : QuestionWordsServiceImpl.getQuestionWordsStandardById(id);
		request.setAttribute("standard", standard);
		return questionJSP("wordsStandardEdit");
	}
	
	/**
	 * 保存词汇标准
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/saveWordsStandard.do")
	public String saveWordsStandard(HttpServletRequest request,HttpServletResponse response) throws IOException{
		int id = NumberUtils.toInt(request.getParameter("hideId"));
		String name = request.getParameter("name");
		String directions = request.getParameter("directions");
		
		QuestionWordsStandard standard = null;
		Date now = new Date();
		Member member = getSysMember(request);
		try {
			if(id == 0){
				standard = new QuestionWordsStandard();
				standard.setName(name);
				standard.setDirections(directions);
				standard.setCreateTime(now);
				standard.setCreateMemberId(member.getId());
				standard.setCreateMember(member.getName());
				
				QuestionWordsStandardPeer.doInsert(standard);
			}else{
				standard = QuestionWordsServiceImpl.getQuestionWordsStandardById(id);
				standard.setName(name);
				standard.setDirections(directions);
				standard.setModifyTime(now);
				standard.setModifyMemberId(member.getId());
				standard.setModifyMember(member.getName());
				
				QuestionWordsStandardPeer.doUpdate(standard);
			}
			return setSuccessAttribute(request, "词汇标准", "initQuestionWordsStandard.do");
		} catch (Exception e) {
			e.printStackTrace();
			setErrorAttribute(request, e.getMessage());
		}
		return FAIL;
	}
	
	/**
	 * 删除词汇标准
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/deleteWordsStandard.do")
	public void deleteWordsStandard(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int id = NumberUtils.toInt(request.getParameter("id"));
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(QuestionWordsServiceImpl.deleteWordsStandard(id)){
			map.put(Constant.SUCCESS, true);
		}else{
			map.put(Constant.SUCCESS, false);
		}
		response.getWriter().write(new Gson().toJson(map));
	}
	
	/**
	 * 删除词汇级别
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/deleteWordsLevel.do")
	public void deleteWordsLevel(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int id = NumberUtils.toInt(request.getParameter("id"));
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(QuestionWordsServiceImpl.deleteWordsLevelById(id)){
			map.put(Constant.SUCCESS, true);
		}else{
			map.put(Constant.SUCCESS, false);
		}
		response.getWriter().write(new Gson().toJson(map));
	}
	
	/**
	 * 查询词汇标准
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/searchQuestionWordsStandard.do")
	public void searchQuestionWordsStandard(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Map<String, Object> map = QuestionWordsServiceImpl.searchQuestionWordsStandard();
		response.getWriter().write(new Gson().toJson(map));
	}
	
	/**
	 * 进入词汇级别
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/initQuestionWordsLevel.do")
	public String initQuestionWordsLevel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int standardId = NumberUtils.toInt(request.getParameter("standardId"));
		QuestionWordsStandard standard = QuestionWordsServiceImpl.getQuestionWordsStandardById(standardId);
		request.setAttribute("standard", standard);
		return questionJSP("wordsLevel");
	}
	
	/**
	 * 查询词汇级别
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/searchQuestionWordsLevel.do")
	public void searchQuestionWordsLevel(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int standardId = NumberUtils.toInt(request.getParameter("standardId"));
		Map<String, Object> map = QuestionWordsServiceImpl.searchQuestionWordsLevel(standardId);
		response.getWriter().write(new Gson().toJson(map));
	}
	

	/**
	 * 编辑词汇级别
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/initWordsLevelEdit.do")
	public String initWordsLevelEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int standardId = NumberUtils.toInt(request.getParameter("standardId"));
		int id = NumberUtils.toInt(request.getParameter("id"));
		QuestionWordsLevel wordsLevel = QuestionWordsServiceImpl.getQuestionWordsLevelById(id);
		QuestionWordsStandard standard = QuestionWordsServiceImpl.getQuestionWordsStandardById(standardId);
		
		request.setAttribute("wordsLevel", wordsLevel);
		request.setAttribute("standard", standard);
		
		return questionJSP("wordsLevelEdit");
	}
	
	/**
	 * 保存词汇级别
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/saveWordsLevel.do")
	public String saveWordsLevel(HttpServletRequest request,HttpServletResponse response) throws IOException{
		int id = NumberUtils.toInt(request.getParameter("hideId"));
		int standardId = NumberUtils.toInt(request.getParameter("hideStandardId"));
		
		String name = request.getParameter("name");
		int levelSort = NumberUtils.toInt(request.getParameter("levelSort"));
		String directions = request.getParameter("directions");
		String content = request.getParameter("content");
		double percent = NumberUtils.toDouble(request.getParameter("percent"));
		
		QuestionWordsLevel level = null;
		Date now = new Date();
		Member member = getSysMember(request);
		try {
			if(id == 0){
				level = new QuestionWordsLevel();
				level.setName(name);
				level.setStandardId(standardId);
				level.setLevelSort(levelSort);
				level.setContent(content);
				level.setDirections(directions);
				level.setCreateTime(now);
				level.setCreateMemberId(member.getId());
				level.setCreateMember(member.getName());
				level.setPercent(percent);
				
				QuestionWordsLevelPeer.doInsert(level);
			}else{
				level = QuestionWordsServiceImpl.getQuestionWordsLevelById(id);
				level.setName(name);
				level.setLevelSort(levelSort);
				level.setContent(content);
				level.setDirections(directions);
				level.setModifyTime(now);
				level.setModifyMemberId(member.getId());
				level.setModifyMember(member.getName());
				level.setPercent(percent);
				
				QuestionWordsLevelPeer.doUpdate(level);
			}
			
			//更新词典
			SchoaAnalyzerService.getInstance().relodDic(false);
			
			return setSuccessAttribute(request, "词汇级别", "initQuestionWordsLevel.do?standardId="+standardId);
		} catch (Exception e) {
			e.printStackTrace();
			setErrorAttribute(request, e.getMessage());
		}
		return FAIL;
	}
	
	/**
	 * 联动查询，根据词汇标准ID查询词汇级别
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/getLevelByStandardId.do")
	public void getLevelByStandardId(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int standardId = NumberUtils.toInt(request.getParameter("standardId"));
		List<QuestionWordsLevel> list = QuestionWordsServiceImpl.getQuestionWordsLevelList(standardId);
		response.getWriter().write(new Gson().toJson(list));
	}
	

	/**
	 * 更新所有试题的词汇级别（耗时操作）
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/initUpdateWordsStandardLevel.do")
	public String initUpdateWordsStandardLevel(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int total = QuestionWordsServiceImpl.updateWordsStandardLevel();
		return setSuccessAttribute(request, "共更新试题"+total+"条,词汇标准", "initQuestionWordsStandard.do");
	}
	
}
