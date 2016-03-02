package com.hao.schoa.report;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

import com.hao.schoa.po.Classes;
import com.hao.schoa.po.Kecheng;
import com.hao.schoa.po.Score;
import com.hao.schoa.po.Student;
import com.hao.schoa.service.ClassesServiceImpl;
import com.hao.schoa.service.KechengServiceImpl;
import com.hao.schoa.service.SchoaLogsServiceImpl;
import com.hao.schoa.service.StudentServiceImpl;
import com.hao.schoa.tools.Constant;
import com.hao.schoa.tools.ExcelUtil;
import com.hao.schoa.tools.NumberFormat;

public class ReportScore extends BaseExcelReport{
	
	@Override
	protected void init() {
		setModelFileName("score.xls");
	}

	@Override
	protected String execute(HttpServletRequest request, HSSFWorkbook wb, HSSFSheet sheet) {
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		int kechengId = NumberUtils.toInt(request.getParameter("kechengId"));
		
		sheet.setDefaultRowHeight((short)380);
		
		//课程
		Kecheng kecheng = KechengServiceImpl.retrieveByPK(kechengId);
		
		//班级
		Classes classes = ClassesServiceImpl.getById(classesId);
		
		//加载班级下所有学生及成绩
		List<Student> studentList = StudentServiceImpl.searchClassesStudent(classesId, kechengId);
		
		//下载文件名
		String title = classes.getName() + "《"+kecheng.getName()+"》" + "成绩登记表";
		String fileName = getExportFileName(title);
		
		HSSFCellStyle style = ExcelUtil.getCellStyle(wb);
		HSSFCellStyle styleNoBorder = ExcelUtil.getCellStyleNoBorder(wb);
		HSSFCellStyle styleNoBorder2 = ExcelUtil.getCellStyleNoBorder2(wb);
		HSSFCellStyle styleXiahuaxian = ExcelUtil.getCellStyleXiahuaxian(wb);
		
		//优秀为90分以上，良好为80-90分，中等为70-80分，及格为60分以上。
		int youxiu = 0;
		int lianghao = 0;
		int zhongdeng = 0;
		int jige = 0;
		int bujige = 0;
		double sum = 0d;
		
		/** 头部模块 **/
		//北京邮电大学2012——2013学年第二学期（春季）
		StringBuffer sbr = new StringBuffer("北京邮电大学");
//		int y = SchoaUtil.getDateYear(classes.getXueqi().getStartDate());
//		sbr.append(y).append("——").append(y+1).append("学年");
		if(classes.getXueqi() != null){
			sbr.append(classes.getXueqi().getName());
		}
		sheet.getRow(1).getCell(0).setCellValue(sbr.toString());
		
		
		//《语法》考试成绩登记表
		StringBuffer str = new StringBuffer();
		str.append("《").append(kecheng.getName()).append("》考试成绩登记表");
		sheet.getRow(2).getCell(0).setCellValue(str.toString());
		
		//班级
		sheet.getRow(4).getCell(2).setCellValue(classes.getName());
//		sheet.getRow(4).getCell(2).setCellStyle(styleXiahuaxian);
		
		/** 数据块 **/
		int top = 6;
		for (int i = 0; i < studentList.size(); i++) {
			Student stu = studentList.get(i);
			Score score = stu.getScore();
			if(score == null){
				score = new Score();
			}
			top += 1;
			Row row = sheet.createRow(top);
			Double value = score.getScAll();
			sum += value;
			if(value >= 90){
				youxiu += 1;
			}else if(value >= 80){
				lianghao += 1;
			}else if(value >= 70){
				zhongdeng += 1;
			}else if(value >= 60){
				jige += 1;
			}else{
				bujige += 1;
			}
			String name = stu.getCname() + (stu.getState() == 2 ? "(离校)" : "");
			genCell(row, style, 0, i+1);
			genCell(row, style, 1, name);
			genCell(row, style, 2, value);
			genCell(row, style, 3, score.getScKeguan());
			genCell(row, style, 4, score.getScZhuguan());
			genCell(row, style, 5, score.getScJuanmian());
			genCell(row, style, 6, score.getSc40());
			genCell(row, style, 7, score.getScQizhong());
			genCell(row, style, 8, score.getSc20());
			genCell(row, style, 9, score.getScChuqin());
			genCell(row, style, 10, score.getScZuoye());
			genCell(row, style, 11, score.getRemark());
		}
		
		top += 1;
		Row row = sheet.createRow(top);
		// 合并单元格参数 (int firstRow, int lastRow, int firstCol, int lastCol)
		mergedRegion(top, top, 0, 1, sheet, style);
		mergedRegion(top, top, 2, 3, sheet, style);
		mergedRegion(top, top, 4, 5, sheet, style);
		mergedRegion(top, top, 6, 7, sheet, style);
		mergedRegion(top, top, 8, 9, sheet, style);
		mergedRegion(top, top, 10, 11, sheet, style);

		top += 1;
		Row rowV = sheet.createRow(top);
		// 合并单元格参数 (int firstRow, int lastRow, int firstCol, int lastCol)
		mergedRegion(top, top, 0, 1, sheet, style);
		mergedRegion(top, top, 2, 3, sheet, style);
		mergedRegion(top, top, 4, 5, sheet, style);
		mergedRegion(top, top, 6, 7, sheet, style);
		mergedRegion(top, top, 8, 9, sheet, style);
		mergedRegion(top, top, 10, 11, sheet, style);
		
		genCell(row, style, 0, "优秀");
		genCell(row, style, 2, "良好");
		genCell(row, style, 4, "中等");
		genCell(row, style, 6, "及格");
		genCell(row, style, 8, "不及格");
		genCell(row, style, 10, "平均分");

		genCell(rowV, style, 0, youxiu);
		genCell(rowV, style, 2, lianghao);
		genCell(rowV, style, 4, zhongdeng);
		genCell(rowV, style, 6, jige);
		genCell(rowV, style, 8, bujige);
		
		double average = studentList.size() == 0 ? 0d : sum/studentList.size();
		genCell(rowV, style, 10, NumberFormat.formatDouble(average));
		
		/** 底部 **/
		top += 2;
		Row rowQZ = sheet.createRow(top);
		//合并单元格参数 (int firstRow, int lastRow, int firstCol, int lastCol)
		sheet.addMergedRegion(new CellRangeAddress(top,top,1,2));
		sheet.addMergedRegion(new CellRangeAddress(top,top,5,8));
		sheet.addMergedRegion(new CellRangeAddress(top,top,10,11));
		
		genCell(rowQZ, styleNoBorder, 1, "任课教师签字：");
		genCell(rowQZ, styleNoBorder, 5, "教研中心签字：（盖章）");
//		genCell(rowQZ, styleNoBorder, 10, Constant.CNDATE.format(new Date()));
		genCell(rowQZ, styleNoBorder, 10, Constant.CNDATE.format(classes.getXueqi().getEndDate()));
		
		top += 2;
		Row rowSM = sheet.createRow(top);
		sheet.addMergedRegion(new CellRangeAddress(top,top,0,11));
		genCell(rowSM, styleNoBorder2, 0, "说明：1 总成绩为期末成绩、期中成绩、平时成绩折合后的最终成绩，页面设置为A4。");
		top += 1;
		Row rowSM2 = sheet.createRow(top);
		sheet.addMergedRegion(new CellRangeAddress(top,top,0,11));
		genCell(rowSM2, styleNoBorder2, 0, "      2 优秀为90分之上，良好为80-90分，中等为70-80分，及格为60分之上。");
		
		
		//系统日志
		SchoaLogsServiceImpl.insertLogs(getSysUser(request),"打印" + title);
	
		return fileName;
	}

}
