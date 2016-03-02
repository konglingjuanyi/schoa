package com.hao.schoa.report;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;

import com.hao.schoa.container.ContainerChengjidan;
import com.hao.schoa.service.ChengjidanServiceImpl;

/**
 * 正常打印成绩单
 * @author haoguowei
 *
 */
public class ReportChengJiDanNormal extends ReportChengJiDan{

	@Override
	protected ContainerChengjidan genPrintData(HttpServletRequest request) {
		int studentId = NumberUtils.toInt(request.getParameter("studentId"));
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		return ChengjidanServiceImpl.genSubjectMarks(studentId, classesId, null);
	}

}
