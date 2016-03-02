package com.hao.schoa;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;
import com.hao.schoa.tools.Constant;
import com.hao.schoa.tools.SchoaUtil;

public class UploadFile extends BaseSchoa{
	
	private static final Logger logger = Logger.getLogger(UploadFile.class);
	
	private static long MAXSIZE = 10 * Constant._1M;
	private static long JIAOXUEFILE_MAXSIZE = 500 * Constant._1M;
	
	/**
	 * 校验文件大小
	 * @param file
	 * @return
	 */
	public boolean verifyFileSize(MultipartFile file){
		return verifyFileSize(file, MAXSIZE);
	}
	
	/**
	 * 校验文件大小
	 * @param file
	 * @return
	 */
	public boolean verifyFileSize(MultipartFile file, long fileSize){
		if(file == null){
			return false;
		}
		return file.getSize() <= fileSize;
	}
	
	/**
	 * 校验图片
	 * @param file
	 * @return
	 */
	public boolean verifyImage(MultipartFile file){
		if(file == null){
			return false;
		}
		Pattern reg = Pattern.compile("([^\\s]+(\\.(?i)(jpg|png|jpeg))$)");
		Matcher matcher=reg.matcher(file.getOriginalFilename());
		return matcher.find();
	}
	
	/**
	 * 图片处理
	 * @param file
	 * @return
	 */
	public JsonObject writeImageToDisk(MultipartFile file){
		boolean res = false;
		String msg = "";
		String data = "";
		
		if(!verifyImage(file)){
			msg = "图片格式错误！请上传“jpg”或“png”格式的图片！";
	    }else if(!verifyFileSize(file)){
	    		msg = "图片太大！";
	    }else{
	    		data = writeToDisk(file);
	    		if(StringUtils.isBlank(data)){
	    			msg = "图片上传失败！";
	    		}else{
	    			res = true;
	    		}
	    }
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty(Constant.JSON_SUCCESS, res);
		jsonObject.addProperty(Constant.JSON_MSG, msg);
		jsonObject.addProperty(Constant.JSON_DATA, data);
		return jsonObject;
	}
	
	public JsonObject writeFileToDisk(MultipartFile file){
		return writeFileToDisk(file, MAXSIZE);
	}
	
	public JsonObject writeJiaoxueFileToDisk(MultipartFile file){
		return writeFileToDisk(file, JIAOXUEFILE_MAXSIZE);
	}
	
	public JsonObject writeFileToDisk(MultipartFile file, long fileSize){
		boolean res = false;
		String msg = "";
		String data = "";
		
		if(!verifyFileSize(file, fileSize)){
			msg = "文件太大！请上传小于"+fileSize+"的文件！";
		}else{
			data = writeToDisk(file);
			if(StringUtils.isBlank(data)){
				msg = "文件上传失败！";
			}else{
				res = true;
			}
		}
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty(Constant.JSON_SUCCESS, res);
		jsonObject.addProperty(Constant.JSON_MSG, msg);
		jsonObject.addProperty(Constant.JSON_DATA, data);
		return jsonObject;
	}
	
	
	/**
	 * 文件处理
	 * @param file
	 * @param request
	 * @param response
	 * @return 文件路径＋名称
	 */
	public String writeToDisk(MultipartFile file){
		String filePath =  SchoaUtil.getRandomPath(2, 64);
		String fileName = file.getOriginalFilename();
		fileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
		
		logger.info("====================================");
        logger.info("文件类型：" + file.getContentType());  
        logger.info("文件大小：" + file.getSize());  
        logger.info("文件服务：" + Constant.IMAGEPATH);
        logger.info("文件路径：" + filePath);
        logger.info("文件名称：" + fileName);
        logger.info("====================================");
        
        try {
			file.transferTo(SchoaUtil.genDestFile(Constant.IMAGEPATH + filePath, fileName));
			return filePath + fileName;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("文件保存失败！file：" + fileName);
		}
        return null;
	}
	
	/**
	 * 将文件保存到固定路径下
	 * @param file
	 * @param savePath
	 * @param fileName
	 * @return
	 */
	public String writeToDisk(MultipartFile file, String savePath, String fileName){
		
		logger.info("====================================");
        logger.info("文件类型：" + file.getContentType());  
        logger.info("文件大小：" + file.getSize());  
        logger.info("文件路径：" + savePath);
        logger.info("文件名称：" + fileName);
        logger.info("====================================");
        
        try {
			file.transferTo(new File(savePath, fileName));
			return savePath + fileName;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("文件保存失败！file：" + fileName);
		}
        return null;
	}
	
}
