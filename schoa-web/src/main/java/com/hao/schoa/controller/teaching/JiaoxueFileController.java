package com.hao.schoa.controller.teaching;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hao.schoa.BaseSchoa;
import com.hao.schoa.DownloadFile;
import com.hao.schoa.UploadFile;
import com.hao.schoa.po.JiaoxueFile;
import com.hao.schoa.po.JiaoxueFilePeer;
import com.hao.schoa.po.Member;
import com.hao.schoa.po.Xueqi;
import com.hao.schoa.service.JiaoxueFileServiceImpl;
import com.hao.schoa.service.SchoaLogsServiceImpl;
import com.hao.schoa.service.XueqiServiceImpl;
import com.hao.schoa.tools.Constant;

/**
 * 教学文件
 * 
 * @author haoguowei
 * 
 */
@Controller
public class JiaoxueFileController extends BaseSchoa {
	
	private static final Logger logger = Logger.getLogger(JiaoxueFileController.class);

	@RequestMapping("/initJiaoxueFile.do")
	public String initJiaoxueFile(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		Member member = getSysMember(request);
		if(member == null){
			return NOPRIVILEGES;
		}
		
		boolean admin = isAdminRole(member.getRoleId());
		
		List<Xueqi> xuqis = null;
		if(admin){
			xuqis = XueqiServiceImpl.getAllXueqiList();
		}else{
			xuqis = XueqiServiceImpl.getTeacherXueqiList(member.getTeacherId());
		}
		
		request.setAttribute("xueqis", xuqis);
		return teachingJSP("jiaoxueFile");
	}

	/**
	 * 根据条件查询教学文件
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/searchJiaoxueFile.do")
	public void searchJiaoxueFile(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		Member member = getSysMember(request);
		
		int xueqi = NumberUtils.toInt(request.getParameter("xueqi"));
		int kecheng = NumberUtils.toInt(request.getParameter("kecheng"));

		int start = NumberUtils.toInt(request.getParameter("start"));
		int limit = NumberUtils.toInt(request.getParameter("limit"),Constant.LIMIT);
		
		int teacherId = -1;
		if(!isAdminPrivilege(member)){
			teacherId = member.getTeacherId();
		}

		Map<String, Object> map = JiaoxueFileServiceImpl.search(teacherId, xueqi, kecheng,
				start, limit, member);
		response.getWriter().write(new Gson().toJson(map));
	}
	

	/**
	 * 课程后对应的教学文件列表
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/searchJiaoxueFileForKecheng.do")
	public void searchJiaoxueFileForKecheng(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		Member member = getSysMember(request);
		
		int kechengId = NumberUtils.toInt(request.getParameter("kechengId"));
		
		Map<String, Object> map = JiaoxueFileServiceImpl
				.getKechengJiaoxue(kechengId,member);
		response.getWriter().write(new Gson().toJson(map));
	}

	/**
	 * 下载文件
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/downloadFile.do")
	public void downLoadFile(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int id = NumberUtils.toInt(request.getParameter("id"));
		JiaoxueFile jiaoxueFile = JiaoxueFileServiceImpl.getById(id);
		if (jiaoxueFile != null) {
			new DownloadFile().download(
					Constant.IMAGEPATH + "/" + jiaoxueFile.getSaveName(),
					jiaoxueFile.getName(),
					request, 
					response);
		} else {
			logger.error(" downloadFile  error : id=" + id);
		}
	}

	/**
	 * 清除教学文件
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/clearFile.do")
	public void clearFile(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		int id = NumberUtils.toInt(request.getParameter("id"));
		Map<String,Boolean> map = new HashMap<String, Boolean>();
		
		map.put(Constant.SUCCESS, JiaoxueFileServiceImpl.clearFile(id));
		
		SchoaLogsServiceImpl.insertLogs(getSysUser(request),"清除教学文件，id＝"+id);
		response.getWriter().write(new Gson().toJson(map));
	}
	
	
	/**
	 * 上传教学文件
	 * @param file
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/jiaoxueFileUpload.do")
	public void jiaoxueFileUpload(@RequestParam(value = "upfile", required = false) MultipartFile file, 
			HttpServletRequest request,HttpServletResponse response)  throws IOException{  
		
		int jiaoxueFileId = NumberUtils.toInt(request.getParameter("jiaoxueFileId"));
		JsonObject jsonObject = new UploadFile().writeJiaoxueFileToDisk(file);
		
		Member member = getSysMember(request);
		Map<String,Object> map = new HashMap<String, Object>();
		
		boolean success = jsonObject.get(Constant.JSON_SUCCESS).getAsBoolean();
		String msg = jsonObject.get(Constant.JSON_MSG).getAsString();
		String data = jsonObject.get(Constant.JSON_DATA).getAsString();
		if(success && data != null){
			try {
				JiaoxueFile jiaoxueFile = JiaoxueFileServiceImpl.getById(jiaoxueFileId);
				
				jiaoxueFile.setName(file.getOriginalFilename());
				jiaoxueFile.setSaveName(data);
				jiaoxueFile.setIntro(request.getParameter("intro"));
				jiaoxueFile.setFileSize((int)file.getSize());
				jiaoxueFile.setMemberId(member.getId());
				jiaoxueFile.setMemberName(member.getName());
				jiaoxueFile.setUptime(new Date());
				
				JiaoxueFilePeer.doUpdate(jiaoxueFile);
		    	    
		    	    SchoaLogsServiceImpl.insertLogs(getSysUser(request),"上传教学文件:" + data);
		    	   
		    	    map.put(Constant.SUCCESS, true);
			} catch (Exception e) {
				e.printStackTrace();
				map.put(Constant.MSG, "上传失败：" + e.getMessage());
			}
		}else{
			map.put(Constant.MSG, msg);
		}
		
		SchoaLogsServiceImpl.insertLogs(getSysUser(request),"上传教学文件:" + jsonObject.toString());
		response.getWriter().write(jsonObject.toString());
	} 
	

}
