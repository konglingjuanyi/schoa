package com.hao.schoa.controller.question;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.hao.schoa.BaseSchoa;
import com.hao.schoa.po.Member;
import com.hao.schoa.po.QuestionBank;
import com.hao.schoa.po.QuestionBankPeer;
import com.hao.schoa.po.QuestionKnowledgePoint;
import com.hao.schoa.po.QuestionMaterials;
import com.hao.schoa.po.QuestionTixing;
import com.hao.schoa.service.QuestionBankServiceImpl;
import com.hao.schoa.service.QuestionKnowledgePointServiceImpl;
import com.hao.schoa.service.QuestionMaterialsServiceImpl;
import com.hao.schoa.service.QuestionTixingServiceImpl;
import com.hao.schoa.service.QuestionWordsServiceImpl;
import com.hao.schoa.service.SchoaAnalyzerService;
import com.hao.schoa.tools.Constant;
import com.hao.schoa.tools.SchoaUtil;

/**
 * 题库
 * @author haoguowei
 *
 */
@Controller
public class QuestionBankController extends BaseSchoa{
	/**
	 * 进入题库
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/initQuestionBank.do")
	public String initQuestionBank(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//题型
		List<QuestionTixing> tixingList = QuestionTixingServiceImpl.getTixingList();
		request.setAttribute("tixingList", tixingList);
		
		//知识点
		List<QuestionKnowledgePoint> kpointList = QuestionKnowledgePointServiceImpl.getQuestionKnowledgePointList();
		request.setAttribute("kpointList", kpointList);
		
		return questionJSP("bank");
	}
	
	/**
	 * 编辑试题
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/initBankEdit.do")
	public String initBankEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = NumberUtils.toInt(request.getParameter("id"));
		QuestionBank bank = id <= 0 ? null : QuestionBankServiceImpl.getQuestionBankById(id);
		request.setAttribute("bank", bank);

		//题型
		List<QuestionTixing> tixingList = QuestionTixingServiceImpl.getTixingList();
		request.setAttribute("tixingList", tixingList);
		
		//知识点
		List<QuestionKnowledgePoint> kpointList = QuestionKnowledgePointServiceImpl.getQuestionKnowledgePointList();
		request.setAttribute("kpointList", kpointList);
		
		//教材
		List<QuestionMaterials> materialList = QuestionMaterialsServiceImpl.getQuestionMaterialList();
		request.setAttribute("materialList", materialList);
		
		return questionJSP("bankEdit");
	}
	
	@RequestMapping("/getWordLevel.do")
	public void getWordLevel(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String content = request.getParameter("content");
		String answer = request.getParameter("answer");
		
		//词汇标准及级别，标准ID*10000+级别ID*1s
		String wordsLevel = QuestionWordsServiceImpl.calTiWordsLevel(content, answer);
		List<String> ls = SchoaAnalyzerService.getInstance().getViewStardardLevel(wordsLevel);
				
		response.getWriter().write(new Gson().toJson(ls));
	}
	
	/**
	 * 保存试题
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/saveBank.do")
	public String saveBank(HttpServletRequest request,HttpServletResponse response) throws IOException{
		int id = NumberUtils.toInt(request.getParameter("hideId"));
		String content = request.getParameter("content");
		String answer = request.getParameter("answer");
		String hideImg = request.getParameter("hideImg");
		String hideImgA = request.getParameter("hideImgA");
		String hideImgB = request.getParameter("hideImgB");
		String hideImgC = request.getParameter("hideImgC");
		String hideImgD = request.getParameter("hideImgD");
		String hideImgE = request.getParameter("hideImgE");
		String hideImgF = request.getParameter("hideImgF");
		String tags = request.getParameter("tags");
		String remark = request.getParameter("remark");
		String m = request.getParameter("member");
		int tixingId = NumberUtils.toInt(request.getParameter("tixingId"));
		int k1 = NumberUtils.toInt(request.getParameter("knowledgePointId1"));
		int k2 = NumberUtils.toInt(request.getParameter("knowledgePointId2"));
		int materialId = NumberUtils.toInt(request.getParameter("materialId"));
		int materialKechengId = NumberUtils.toInt(request.getParameter("materialKechengId"));
		
		//词汇标准及级别，标准ID*10000+级别ID*1s
		String wordsLevel = QuestionWordsServiceImpl.calTiWordsLevel(content, answer);
		String fenci = QuestionWordsServiceImpl.fenci(content, answer);
		tags = SchoaUtil.splitTags(tags);

		QuestionBank bank = null;
		Date now = new Date();
		Member member = getSysMember(request);
		try {
			if(id == 0){
				bank = new QuestionBank();
				bank.setContent(content);
				bank.setAnswer(answer);
				bank.setImg(hideImg);
				bank.setTags(tags);
				bank.setRemark(remark);
				bank.setTixingId(tixingId);
				bank.setKnowledgePointId(k1+","+k2);
				bank.setMaterialId(materialId);
				bank.setMaterialKechengId(materialKechengId);
				bank.setWordsLevel(wordsLevel);
				bank.setMember(m);
				bank.setFenci(fenci);
				
				bank.setImgA(hideImgA);
				bank.setImgB(hideImgB);
				bank.setImgC(hideImgC);
				bank.setImgD(hideImgD);
				bank.setImgE(hideImgE);
				bank.setImgF(hideImgF);
				
				bank.setCreateTime(now);
				bank.setCreateMemberId(member.getId());
				bank.setCreateMember(member.getName());
				
				QuestionBankPeer.doInsert(bank);
			}else{
				bank = QuestionBankServiceImpl.getQuestionBankById(id);
				bank.setContent(content);
				bank.setAnswer(answer);
				bank.setImg(hideImg);
				bank.setTags(tags);
				bank.setRemark(remark);
				bank.setTixingId(tixingId);
				bank.setKnowledgePointId(k1+","+k2);
				bank.setMaterialId(materialId);
				bank.setMaterialKechengId(materialKechengId);
				bank.setWordsLevel(wordsLevel);
				bank.setMember(m);
				bank.setFenci(fenci);
				
				bank.setImgA(hideImgA);
				bank.setImgB(hideImgB);
				bank.setImgC(hideImgC);
				bank.setImgD(hideImgD);
				bank.setImgE(hideImgE);
				bank.setImgF(hideImgF);
				
				bank.setModifyTime(now);
				bank.setModifyMemberId(member.getId());
				bank.setModifyMember(member.getName());
				
				QuestionBankPeer.doUpdate(bank);
			}
			return setSuccessAttribute(request, "试题库", "initQuestionBank.do");
		} catch (Exception e) {
			e.printStackTrace();
			setErrorAttribute(request, e.getMessage());
		}
		return FAIL;
	}
	
	/**
	 * 删除试题
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/deleteBank.do")
	public void deleteKnowledgePoint(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int id = NumberUtils.toInt(request.getParameter("id"));
		Map<String, Object> map = new HashMap<String, Object>();
		if(QuestionBankServiceImpl.deleteById(id)){
			map.put(Constant.SUCCESS, true);
		}else{
			map.put(Constant.SUCCESS, false);
		}
		response.getWriter().write(new Gson().toJson(map));
	}
	
	/**
	 * 查询试题
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/searchQuestionBank.do")
	public void searchQuestionBank(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int start = NumberUtils.toInt(request.getParameter("start"));
		int limit = NumberUtils.toInt(request.getParameter("limit"), Constant.LIMIT);
		
		String keyword = request.getParameter("keyword");
		int tixingId = NumberUtils.toInt(request.getParameter("tixingId"));
		String user = request.getParameter("user");
		int kpointId = NumberUtils.toInt(request.getParameter("kpointId"));
		
		Map<String, Object> map = QuestionBankServiceImpl.searchQuestionBank(keyword, tixingId, user, kpointId, start, limit);
		response.getWriter().write(new Gson().toJson(map));
	}
	
	/**
	 * 匹配相似的试题
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/searchSameBank.do")
	public void searchSameBank(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String content = request.getParameter("content");
		int id = NumberUtils.toInt(request.getParameter("id"));
		int tixingId = NumberUtils.toInt(request.getParameter("tixingId"));
		int knowledgePointId = NumberUtils.toInt(request.getParameter("knowledgePointId"));
		Set<String> fenci = SchoaAnalyzerService.getInstance().fenci(content);
		
		QuestionBank bank = QuestionBankServiceImpl.searchSameBank(id, tixingId, knowledgePointId, fenci);
		response.getWriter().write(bank==null?"":bank.getContent());
	}
}
