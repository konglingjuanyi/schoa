package com.hao.schoa;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;
import org.apache.torque.Torque;
import org.apache.torque.TorqueException;

import com.hao.schoa.service.SystemServiceImpl;
import com.hao.schoa.tools.Constant;
import com.hao.schoa.tools.WebUtil;

public class InitServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(InitServlet.class);

	public void init() throws ServletException {
		logger.info("===============系统初始化=================");
		
		//初始化
		initTorque();
		initProperties();
		initFromDatabase();
		
		//页面调用
		this.getServletContext().setAttribute("WebUtil", new WebUtil());
		this.getServletContext().setAttribute("IMAGEURL", Constant.IMAGEURL);
		
		logger.info("========================================");
	}
	
	private void initFromDatabase() {
		Constant.allPrivilegeSet = SystemServiceImpl.getAllPrivilegesUrl();
		logger.info("allPrivilegeSet size:" + Constant.allPrivilegeSet.size());
	}

	private void initProperties() {
		InputStream stream = InitServlet.class.getResourceAsStream("/schoa.properties");
		Properties pro = new Properties();  
        try {
			pro.load(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}  
        
        Constant.IMAGEURL = pro.getProperty("schoa.image.url");
		logger.info("Constant.IMAGEURL:" + Constant.IMAGEURL);
		
		Constant.IMAGEPATH = pro.getProperty("schoa.image.path");
		logger.info("Constant.IMAGEPATH:" + Constant.IMAGEPATH);
	}

	private void initTorque() {
		PropertiesConfiguration dbConfig = new PropertiesConfiguration();
		InputStream stream = InitServlet.class.getResourceAsStream("/Torque.properties");
		try {
			dbConfig.load(stream);
			Torque.init(dbConfig);
			logger.info("Torque init success!");
		} catch (ConfigurationException e1) {
			e1.printStackTrace();
		} catch (TorqueException e) {
			e.printStackTrace();
		}
	}
}
