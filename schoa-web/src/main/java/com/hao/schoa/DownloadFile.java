package com.hao.schoa;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.hao.schoa.service.SchoaLogsServiceImpl;

public class DownloadFile extends BaseSchoa{
	
	private static final Logger logger = Logger.getLogger(DownloadFile.class);
	
	private final int SIZE = 1024 * 1024;
	
	public DownloadFile(){
		
	}
	
	/**
	 * 下载文件
	 * @param filePath 文件路径，包括文件路径＋文件名
	 * @param downloadName 文件下载显示名称 
	 * @param request
	 * @param response
	 * @return
	 */
	public void download(String filePath, String downloadName, HttpServletRequest request,HttpServletResponse response){
		File file = new File(filePath);
		if(file.exists()){
			OutputStream os = null;
			InputStream in = null;
			try {
				String fName = getExportFileName(downloadName);
				response.setContentType("multipart/form-data");
				response.setHeader("Content-Disposition", "attachment;fileName=" + fName);
				
				os = response.getOutputStream();
				in = new FileInputStream(file);  
				
				byte[] b = new byte[SIZE];  
	            int length;  
	            while ((length = in.read(b)) > 0) {  
	                os.write(b, 0, length);  
	            }  
	            SchoaLogsServiceImpl.insertLogs(getSysUser(request),"下载文件,fileName:" + downloadName + ";filePath:" + filePath);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					if(in != null) in.close();
					if(os != null) os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}else{
			logger.error("文件不存在！fileName:" + downloadName + ";filePath:" + filePath);
		}
	}
}
