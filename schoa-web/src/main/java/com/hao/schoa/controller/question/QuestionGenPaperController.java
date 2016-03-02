package com.hao.schoa.controller.question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hao.schoa.BaseSchoa;
import com.hao.schoa.container.QuestionParam;
import com.hao.schoa.po.QuestionBank;
import com.hao.schoa.po.QuestionKnowledgePoint;
import com.hao.schoa.po.QuestionMaterials;
import com.hao.schoa.po.QuestionTixing;
import com.hao.schoa.po.QuestionWordsStandard;
import com.hao.schoa.service.QuestionGenPaperServiceImpl;
import com.hao.schoa.service.QuestionKnowledgePointServiceImpl;
import com.hao.schoa.service.QuestionMaterialsServiceImpl;
import com.hao.schoa.service.QuestionTixingServiceImpl;
import com.hao.schoa.service.QuestionWordsServiceImpl;
import com.hao.schoa.service.SchoaAnalyzerService;
import com.hao.schoa.tools.SchoaUtil;

/**
 * 创建试卷
 * @author haoguowei
 *
 */
@Controller
public class QuestionGenPaperController extends BaseSchoa{
	
	private static final int mater = 1;
	private static final int words = 0;

	/**
	 * 进入根据教材生成试卷页
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/initGenerateMaterialPaper.do")
	public String initGenerateMaterialPaper(HttpServletRequest request, HttpServletResponse response) throws IOException {
		initParams(request, mater);
		return questionJSP("generatePaperParam");
	}
	
	/**
	 * 进入根据词汇生成试卷页
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/initGenerateWordsPaper.do")
	public String initGenerateWordsPaper(HttpServletRequest request, HttpServletResponse response) throws IOException {
		initParams(request, words);
		return questionJSP("generatePaperParam");
	}
	
	private void initParams(HttpServletRequest request, int from){
		//题型
		List<QuestionTixing> tixingList = QuestionTixingServiceImpl.getTixingList();
		request.setAttribute("tixingList", tixingList);

		//知识点
		List<QuestionKnowledgePoint> kpointList = QuestionKnowledgePointServiceImpl.getQuestionKnowledgePointList();
		request.setAttribute("kpointList", kpointList);
		
		//词汇标准	
		if(from == words){
			List<QuestionWordsStandard> standardList = QuestionWordsServiceImpl.getQuestionWordsStandardList();
			request.setAttribute("standardList", standardList);
		}

		//教材	
		if(from == mater){
			List<QuestionMaterials> materList = QuestionMaterialsServiceImpl.getQuestionMaterialList();
			request.setAttribute("materList", materList);
		}		
		
	}
	
	/**
	 * 生成试卷
	 * @return
	 */
	@RequestMapping("/generatePaper.do")
	public String generatePaper(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//解析参数，组装QuestionParam
		QuestionParam param = makeQuestionParam(request);
		
		//计算随机ID
		String ids = QuestionGenPaperServiceImpl.genQuestionPaperIds(param);
		System.out.println("生成试卷,符合条件的随机ID：" + ids);
		
		//根据ID获取试题内容
		List<QuestionBank> bankList = QuestionGenPaperServiceImpl.searchQuestionByIds(ids);
		
		//所有题型
		Map<Integer,QuestionTixing> tixingMap = QuestionTixingServiceImpl.getTixingMap();
		
		request.setAttribute("ids", ids);
		request.setAttribute("bankList", bankList);
		request.setAttribute("tixingMap", tixingMap);
		
		return questionJSP("viewPaper");
	}
	
	/**
	 * 解析参数，组装QuestionParam
	 * @param request
	 * @return
	 */
	private QuestionParam makeQuestionParam(HttpServletRequest request){
		QuestionParam param = new QuestionParam();
		
		//关键字
		param.setKeyword(request.getParameter("keyword"));
		
		//标签
		param.setTags(SchoaUtil.splitTags(request.getParameter("tags")));
		
		//试题创建时间 － 开始时间
		param.setStartDay(request.getParameter("startDay"));
		
		//试题创建时间 － 结束时间
		param.setEndDay(request.getParameter("endDay"));
		
		//知识点ID
		param.setKnowledgePointIds(request.getParameter("kpoints"));
		
		//题型ID,及生成数量
		List<QuestionTixing> tixingList = new ArrayList<QuestionTixing>();
		String[] tixingArr = request.getParameter("tixings").split(",");
		for(String tixingId : tixingArr){
			QuestionTixing qtx = new QuestionTixing();
			qtx.setId(Integer.parseInt(tixingId));
			qtx.setAmount(NumberUtils.toInt(request.getParameter("tixing_" + tixingId)));
			tixingList.add(qtx);
		}
		param.setTixingList(tixingList);
		
		//教材ID,只能选一个题材
		param.setMaterialId(NumberUtils.toInt(request.getParameter("materId")));
		
		//教材课程ID,可以是多课程
		param.setMaterialKechengIds(request.getParameter("kewens"));
		
		//词汇级别
		int standardId = NumberUtils.toInt(request.getParameter("standardId"));
		int levelId = NumberUtils.toInt(request.getParameter("levelId"));
		if(standardId > 0 && levelId > 0){
			String wordsLevel = SchoaAnalyzerService.getInstance().calWordLevelCode(standardId, levelId);
			param.setWordsLevel(wordsLevel);
		}
		
		//一定能生成的题
		String[] mustIdArray = getMustIdArray(request.getParameter("mustIds"));
		param.setMustHaveMap(getMustMap(mustIdArray));
		request.setAttribute("mustIdArray", mustIdArray);
		
		return param;
	}
	
	private String[] getMustIdArray(String mustIds){
		if(StringUtils.isBlank(mustIds)){
			return null;
		}
		return mustIds.split(",");
	}
	
	/**
	 * 解析一定能生成的试题ID
	 * @param mustIds
	 * @return
	 */
	private Map<Integer,Set<Integer>> getMustMap(String[] arr){
		if(arr == null){
			return null;
		}
		Map<Integer,Set<Integer>> map = new HashMap<Integer,Set<Integer>>();
		for(String str : arr){
			String[] tmp = str.split("-");
			int k = Integer.parseInt(tmp[0]);
			int v = Integer.parseInt(tmp[1]);
			if(map.get(k) == null){
				map.put(k, new LinkedHashSet<Integer>());
			}
			map.get(k).add(v);
		}
		return map;
		
	}
	
}
