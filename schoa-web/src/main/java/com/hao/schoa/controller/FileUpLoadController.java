package com.hao.schoa.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;
import com.hao.schoa.BaseSchoa;
import com.hao.schoa.UploadFile;
import com.hao.schoa.service.SchoaLogsServiceImpl;

@Controller
public class FileUpLoadController extends BaseSchoa{
	
	/**
	 * 上传头像
	 * @param file
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/pictureUpload.do")
	public void pictureUpload(@RequestParam(value = "photo", required = false) MultipartFile file, 
    		HttpServletRequest request,HttpServletResponse response)  throws IOException{  
		JsonObject jsonObject = new UploadFile().writeImageToDisk(file);
        SchoaLogsServiceImpl.insertLogs(getSysUser(request),"上传头像:" + jsonObject.toString());
        response.getWriter().write(jsonObject.toString());
    } 
}
