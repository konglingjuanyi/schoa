package com.hao.schoa.report;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.hao.schoa.po.Student;
import com.hao.schoa.service.StudentServiceImpl;
import com.hao.schoa.tools.Constant;

public class ReportYouxiuStudent extends BaseWordReport {

	private String englishName = "englishName";
	private String chinesName = "chinesName";
	private String cnDate = "cnDate";
	private String enDate = "enDate";

	@Override
	protected void init() {
		setModelFileName("youxiu.docx");
	}

	@Override
	protected String execute(HttpServletRequest request, XWPFDocument doc) {
		int studentId = NumberUtils.toInt(request.getParameter("studentId"));
		Student student = StudentServiceImpl.getById(studentId);
		Date today = new Date();

		Map<String, String> dataMap = new HashMap<String, String>();
		dataMap.put(englishName, student.getEname());
		dataMap.put(chinesName, student.getCname());
		dataMap.put(cnDate, Constant.CNDATE.format(today));
		dataMap.put(enDate, Constant.ENDATE.format(today));

		// 下载文件名
		String title = student.getCname() + "优秀奖状";
		String fileName = getExportFileName(title);

		List<XWPFParagraph> paragraphs = doc.getParagraphs();
		for (XWPFParagraph xwp : paragraphs) {
			List<XWPFRun> runs = xwp.getRuns();
			for (XWPFRun tmp : runs) {
				if (tmp == null || tmp.getText(0) == null) {
					continue;
				}
				String val = dataMap.get(tmp.getText(0).trim());
				if (StringUtils.isNotBlank(val)) {
					tmp.setText(val, 0);
				}
			}
		}
		return fileName;
	}

}
