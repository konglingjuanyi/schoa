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
import com.hao.schoa.po.QuestionMaterials;
import com.hao.schoa.po.QuestionMaterialsKecheng;
import com.hao.schoa.po.QuestionMaterialsKechengPeer;
import com.hao.schoa.po.QuestionMaterialsPeer;
import com.hao.schoa.service.QuestionMaterialsServiceImpl;
import com.hao.schoa.tools.Constant;

/**
 * 教材课程
 * @author haoguowei
 *
 */
@Controller
public class QuestionMaterialsController extends BaseSchoa{

	/**
	 * 进入教材
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/initQuestionMaterials.do")
	public String initQuestionMaterials(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return questionJSP("materials");
	}
	
	/**
	 * 编辑教材
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/initMaterialsEdit.do")
	public String initMaterialsEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = NumberUtils.toInt(request.getParameter("id"));
		QuestionMaterials materials = id <= 0 ? null : QuestionMaterialsServiceImpl.getQuestionMaterialsById(id);
		request.setAttribute("materials", materials);
		return questionJSP("materialsEdit");
	}
	
	/**
	 * 保存教材
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/saveMaterials.do")
	public String saveMaterials(HttpServletRequest request,HttpServletResponse response) throws IOException{
		int id = NumberUtils.toInt(request.getParameter("hideId"));
		String name = request.getParameter("name");
		String directions = request.getParameter("directions");
		
		QuestionMaterials materials = null;
		Date now = new Date();
		Member member = getSysMember(request);
		try {
			if(id == 0){
				materials = new QuestionMaterials();
				materials.setName(name);
				materials.setDirections(directions);
				materials.setCreateTime(now);
				materials.setCreateMemberId(member.getId());
				materials.setCreateMember(member.getName());
				
				QuestionMaterialsPeer.doInsert(materials);
			}else{
				materials = QuestionMaterialsServiceImpl.getQuestionMaterialsById(id);
				materials.setName(name);
				materials.setDirections(directions);
				materials.setModifyTime(now);
				materials.setModifyMemberId(member.getId());
				materials.setModifyMember(member.getName());
				
				QuestionMaterialsPeer.doUpdate(materials);
			}
			return setSuccessAttribute(request, "教材管理", "initQuestionMaterials.do");
		} catch (Exception e) {
			e.printStackTrace();
			setErrorAttribute(request, e.getMessage());
		}
		return FAIL;
	}
	
	/**
	 * 删除教材
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/deleteMaterials.do")
	public void deleteMaterials(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int id = NumberUtils.toInt(request.getParameter("id"));
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(QuestionMaterialsServiceImpl.deleteMaterialById(id)){
			map.put(Constant.SUCCESS, true);
		}else{
			map.put(Constant.SUCCESS, false);
		}
		response.getWriter().write(new Gson().toJson(map));
	}
	
	/**
	 * 删除课程
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/deleteMaterialKecheng.do")
	public void deleteMaterialKecheng(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int id = NumberUtils.toInt(request.getParameter("id"));
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(QuestionMaterialsServiceImpl.deleteMaterialKechengById(id)){
			map.put(Constant.SUCCESS, true);
		}else{
			map.put(Constant.SUCCESS, false);
		}
		response.getWriter().write(new Gson().toJson(map));
	}
	
	/**
	 * 查询教材
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/searchQuestionMaterials.do")
	public void searchQuestionMaterials(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Map<String, Object> map = QuestionMaterialsServiceImpl.searchQuestionMaterials();
		response.getWriter().write(new Gson().toJson(map));
	}
	

	/**
	 * 进入教材课程
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/initQuestionMaterialsKecheng.do")
	public String initQuestionWordsLevel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int materialsId = NumberUtils.toInt(request.getParameter("materialsId"));
		QuestionMaterials materials = QuestionMaterialsServiceImpl.getQuestionMaterialsById(materialsId);
		request.setAttribute("materials", materials);
		return questionJSP("materialsKecheng");
	}
	
	/**
	 * 查询教材课程
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/searchQuestionMaterialsKecheng.do")
	public void searchQuestionMaterialsKecheng(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int materialsId = NumberUtils.toInt(request.getParameter("materialsId"));
		Map<String, Object> map = QuestionMaterialsServiceImpl.searchQuestionMaterialsKecheng(materialsId);
		response.getWriter().write(new Gson().toJson(map));
	}
	

	/**
	 * 编辑教材课程
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/initMaterialsKechengEdit.do")
	public String initMaterialsKechengEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int materialsId = NumberUtils.toInt(request.getParameter("materialsId"));
		int id = NumberUtils.toInt(request.getParameter("id"));
		
		QuestionMaterials materials = QuestionMaterialsServiceImpl.getQuestionMaterialsById(materialsId);
		QuestionMaterialsKecheng kecheng = QuestionMaterialsServiceImpl.getQuestionMaterialsKechengById(id);
		
		request.setAttribute("materials", materials);
		request.setAttribute("kecheng", kecheng);
		
		return questionJSP("materialsKechengEdit");
	}
	
	/**
	 * 保存教材课程
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/saveMaterialsKecheng.do")
	public String saveMaterialsKecheng(HttpServletRequest request,HttpServletResponse response) throws IOException{
		int id = NumberUtils.toInt(request.getParameter("hideId"));
		int materialsId = NumberUtils.toInt(request.getParameter("hideMaterialsId"));
		
		String name = request.getParameter("name");
		String directions = request.getParameter("directions");
		
		QuestionMaterialsKecheng kecheng = null;
		Date now = new Date();
		Member member = getSysMember(request);
		try {
			if(id == 0){
				kecheng = new QuestionMaterialsKecheng();
				kecheng.setName(name);
				kecheng.setDirections(directions);
				kecheng.setMaterialsId(materialsId);
				kecheng.setCreateTime(now);
				kecheng.setCreateMemberId(member.getId());
				kecheng.setCreateMember(member.getName());
				
				QuestionMaterialsKechengPeer.doInsert(kecheng);
			}else{
				kecheng = QuestionMaterialsServiceImpl.getQuestionMaterialsKechengById(id);
				kecheng.setName(name);
				kecheng.setDirections(directions);
				kecheng.setModifyTime(now);
				kecheng.setModifyMemberId(member.getId());
				kecheng.setModifyMember(member.getName());
				
				QuestionMaterialsKechengPeer.doUpdate(kecheng);
			}
			return setSuccessAttribute(request, "教材课文", "initQuestionMaterialsKecheng.do?materialsId="+materialsId);
		} catch (Exception e) {
			e.printStackTrace();
			setErrorAttribute(request, e.getMessage());
		}
		return FAIL;
	}
	
	/**
	 * 联动查询，根据教材Id查询教材课程
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/getMKechengByMaterialId.do")
	public void getMKechengByMaterialId(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int materialId = NumberUtils.toInt(request.getParameter("materialId"));
		List<QuestionMaterialsKecheng> list = QuestionMaterialsServiceImpl.getMaterialKechengList(materialId);
		response.getWriter().write(new Gson().toJson(list));
	}

}
