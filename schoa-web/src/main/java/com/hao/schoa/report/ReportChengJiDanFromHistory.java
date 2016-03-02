package com.hao.schoa.report;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;

import com.hao.schoa.container.ContainerChengjidan;
import com.hao.schoa.service.ChengjidanServiceImpl;

/**
 * 从历史记录中打印
 * @author bjhaoguowei
 *
 */
public class ReportChengJiDanFromHistory extends ReportChengJiDan{

	@Override
	protected ContainerChengjidan genPrintData(HttpServletRequest request) {
		int historyId = NumberUtils.toInt(request.getParameter("historyId"));
		return ChengjidanServiceImpl.genSubjectMarks(historyId);
	}

}
