package com.hao.schoa.report;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.hao.schoa.BaseSchoa;

/**
 * word报表
 * 
 * @author haoguowei
 * 
 */
public abstract class BaseWordReport extends BaseSchoa {

	private static final Logger logger = Logger.getLogger(BaseWordReport.class);

	private String modelFileName;

	/**
	 * 初始化
	 */
	protected abstract void init();

	/**
	 * 画报表，返回文件名
	 * 
	 * @param request
	 * @param doc
	 * @return
	 */
	protected abstract String execute(HttpServletRequest request, XWPFDocument doc);

	/**
	 * 生成报表，并下载
	 * 
	 * @param request
	 * @param response
	 */
	public void report(HttpServletRequest request, HttpServletResponse response) {
		init();

		String modelFile = getModelFilePath(request) + modelFileName;
		ServletOutputStream os = null;
		try {
			if (StringUtils.isBlank(modelFileName)) {
				logger.error("未找到word模版。");
			}
			XWPFDocument doc = new XWPFDocument(new FileInputStream(modelFile));

			String fileName = execute(request, doc);

			response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
			response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".docx");
			os = response.getOutputStream();
			doc.write(os);
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (os != null)
					os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String getModelFileName() {
		return modelFileName;
	}

	public void setModelFileName(String modelFileName) {
		this.modelFileName = modelFileName;
	}

}
