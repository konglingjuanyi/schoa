package com.hao.schoa.report;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

import com.hao.schoa.container.ContainerKechengbiao;
import com.hao.schoa.po.Classes;
import com.hao.schoa.po.ClassesKecheng;
import com.hao.schoa.service.ClassesServiceImpl;
import com.hao.schoa.service.PaikeServiceImpl;
import com.hao.schoa.service.SchoaLogsServiceImpl;
import com.hao.schoa.tools.Constant;
import com.hao.schoa.tools.ExcelUtil;
import com.hao.schoa.tools.WebUtil;

/**
 * 打印班级课程表
 * @author haoguowei
 *
 */
public class ReportKechengbiao extends BaseExcelReport{

	@Override
	protected void init() {
		setModelFileName("kechengbiao.xls");
	}

	@Override
	protected String execute(HttpServletRequest request, HSSFWorkbook wb, HSSFSheet sheet) {
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		HSSFCellStyle cellStyle = ExcelUtil.getCellStyle(wb);

		// 班级信息
		Classes classes = ClassesServiceImpl.getById(classesId);

		// 课程表数据
		ContainerKechengbiao kechengbiao = PaikeServiceImpl.searcheKechengbiao(classesId);

		// 下载文件名
		String title = classes.getName() + "课程表";
		String fileName = getExportFileName(title);

		List<String> timeList = kechengbiao.getTimeList();
		List<Integer> weekList = kechengbiao.getWeekIndexList();

		int top = 2;
		int col = 0;
		Row titleRow = getRow(sheet, top);
		
		// 星期行
		for (int i = 0; i < weekList.size(); i++) {
			String weekName = WebUtil.getWeekTitle(weekList.get(i));
			genCell(titleRow, cellStyle, i + 1, weekName);
//			sheet.autoSizeColumn(i + 1);
			sheet.setColumnWidth(i+1, 4000);
			col += 1;
		}
		// 排课行
		for (int j = 0; j < timeList.size(); j++) {
			Row timeRow = getRow(sheet, ++top);
			genCell(timeRow, cellStyle, 0, timeList.get(j));

			Row teacherRow = getRow(sheet, ++top);
			genCell(teacherRow, cellStyle, 0, "老师 Teacher");

			timeRow.setHeight(Constant.HEIGTH);
			teacherRow.setHeight(Constant.HEIGTH);

			for (int i = 0; i < weekList.size(); i++) {
				ClassesKecheng obj = new ClassesKecheng(timeList.get(j), weekList.get(i));
				ClassesKecheng ck = kechengbiao.getPaikeMap().get(obj);
				genCell(timeRow, cellStyle, i + 1, ck == null ? "" : ck.getKechengName());
				genCell(teacherRow, cellStyle, i + 1, ck == null ? "" : ck.getTeacherName());
			}
		}

		// title,合并单元格(int firstRow, int lastRow, int firstCol, int lastCol)
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, col));
		sheet.getRow(0).getCell(0).setCellValue(classes.getName());

		// 班级描述 ,合并单元格(int firstRow, int lastRow, int firstCol, int lastCol)
		if (col > 0) {
			mergedRegion(1, 1, 1, col, sheet, cellStyle);
		}
		genCell(sheet.getRow(1), cellStyle, 0, classes.getName());
		genCell(sheet.getRow(1), cellStyle, 1, "");

		// 系统日志
		SchoaLogsServiceImpl.insertLogs(getSysUser(request), "打印" + title);

		return fileName;
	}

}
