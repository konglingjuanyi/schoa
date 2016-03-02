package com.hao.schoa.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.torque.TorqueException;

import com.google.gson.Gson;
import com.hao.schoa.container.ContainerChengjidan;
import com.hao.schoa.po.ChengjidanPrintHistory;
import com.hao.schoa.po.ChengjidanPrintHistoryPeer;
import com.hao.schoa.po.SubjectMarks;
import com.hao.schoa.service.ChengjidanServiceImpl;

/**
 * 保存成绩并打印
 * @author haoguowei
 *
 */
public class ReportChengJiDanAndSave extends ReportChengJiDan{
	
	@Override
	protected ContainerChengjidan genPrintData(HttpServletRequest request) {
		int studentId = NumberUtils.toInt(request.getParameter("studentId"));
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		String str = request.getParameter("str");
		String[] tr = str.split(";");
		List<SubjectMarks> ls = new ArrayList<SubjectMarks>();
		for (int i = 0; i < tr.length; i++) {
			SubjectMarks sm = new SubjectMarks();
			String[] tmp = tr[i].split(",");
			sm.setSubject(tmp[0]);
			sm.setQizhong(Double.parseDouble(tmp[1]));
			sm.setQimo(Double.parseDouble(tmp[2]));
			sm.setTotal(Double.parseDouble(tmp[3]));
			sm.setKechengId(Integer.parseInt(tmp[4]));
			ls.add(sm);
		}
		
		ChengjidanPrintHistory his = new ChengjidanPrintHistory();
		his.setStudentId(studentId);
		his.setClassesId(classesId);
		his.setOperator(getSysUser(request));
		his.setCreateTime(new Date());
		his.setSnapshot(new Gson().toJson(ls));
		try {
			ChengjidanPrintHistoryPeer.doInsert(his);
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return ChengjidanServiceImpl.genSubjectMarks(studentId, classesId, ls);
	}
}
