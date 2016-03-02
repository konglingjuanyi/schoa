package com.hao.schoa.report;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import com.hao.schoa.container.ContainerChengjidan;
import com.hao.schoa.po.SubjectMarks;
import com.hao.schoa.service.SchoaLogsServiceImpl;
import com.hao.schoa.service.ScoreServiceImpl;
import com.hao.schoa.tools.Constant;
import com.hao.schoa.tools.ExcelUtil;
import com.hao.schoa.tools.NumberFormat;

public abstract class ReportChengJiDan extends BaseExcelReport{
	
	/**
	 * 成绩单数据
	 * @param request
	 * @return
	 */
	protected abstract ContainerChengjidan genPrintData(HttpServletRequest request);
	
	@Override
	protected void init() {
		setModelFileName("chengjidan.xls");
	}
	
	@Override
	protected String execute(HttpServletRequest request, HSSFWorkbook wb, HSSFSheet sheet) {
		ContainerChengjidan data = genPrintData(request);
		writeExcel(wb, sheet, data);
		
		//下载文件名
		String title = data.getStudentName() + "在" + data.getClassesName() + "成绩单";
		
		//系统日志
		SchoaLogsServiceImpl.insertLogs(getSysUser(request),"打印" + title);
		return getExportFileName(title);
	}
	
	private void writeExcel(HSSFWorkbook wb, HSSFSheet sheet, ContainerChengjidan data) {
		sheet.getRow(12).getCell(1).setCellValue(data.getClassesName());
		sheet.getRow(12).getCell(5).setCellValue(data.getPassportNumber());
		sheet.getRow(13).getCell(1).setCellValue(data.getClassesName());
		sheet.getRow(13).getCell(5).setCellValue(data.getPassportNumber());
		
		sheet.getRow(14).getCell(1).setCellValue(data.getStudentName());
		sheet.getRow(14).getCell(4).setCellValue(data.getSex());
		sheet.getRow(14).getCell(6).setCellValue(data.getNation());
		
		sheet.getRow(15).getCell(1).setCellValue(data.getStudentEName());
		sheet.getRow(15).getCell(4).setCellValue(data.getSexEName());
		sheet.getRow(15).getCell(6).setCellValue(data.getNationEName());
		
		sheet.getRow(16).getCell(3).setCellValue(data.getDateCn());
		sheet.getRow(17).getCell(3).setCellValue(data.getDateEn());
		
		//计算本学期出勤率
		int _totalKeshi = ScoreServiceImpl.getTotalKeshi(
				data.getXueqiStartDate(),data.getXueqiEndDate(),data.getClassesId(), 0); //总课时
		int _totalQueqin = ScoreServiceImpl.getTotalQueqin(
				data.getXueqiStartDate(),data.getXueqiEndDate(), data.getClassesId(), data.getStudentId(), 0); //总缺勤
		String sum = "";
		if(_totalKeshi > 0){
			sum = NumberFormat.formatBaiFenBi((_totalKeshi-_totalQueqin)*1.0/_totalKeshi);
		}
		sheet.getRow(18).getCell(3).setCellValue(sum);
		
		//课程成绩
		List<SubjectMarks> ls = data.getSubjectMarks();
		int rowIdx = 22;
		HSSFCellStyle style = ExcelUtil.getCellStyle(wb);
		if (ls != null) {
			for (SubjectMarks subjectMarks : ls) {
				mergedRegion(rowIdx, rowIdx, 0, 1, sheet, style);
				mergedRegion(rowIdx, rowIdx, 2, 3, sheet, style);
				mergedRegion(rowIdx, rowIdx, 4, 5, sheet, style);
				mergedRegion(rowIdx, rowIdx, 6, 7, sheet, style);
				
				Row row = getRow(sheet, rowIdx);
				row.setHeight(Constant.HEIGTH);
				

				/////////////////////课程出勤率///////////////////
				//课程出勤率 = （课程总课时-课程缺勤）／ 课程总课时
				int totalKeshi = ScoreServiceImpl.getTotalKeshi(data.getXueqiStartDate(), data.getXueqiEndDate(), data.getClassesId(), subjectMarks.getKechengId());
				int totalQueqin = ScoreServiceImpl.getTotalQueqin(data.getXueqiStartDate(), data.getXueqiEndDate(), data.getClassesId(), data.getStudentId(), subjectMarks.getKechengId());
				String attendance = NumberFormat.formatBaiFenBi((totalKeshi - totalQueqin) * 1.0 / totalKeshi);
				System.out.println("======" + subjectMarks.getSubject() + " =====" + attendance);
				///////////////////////////////////////////////
				
				genCell(row, style, 0, subjectMarks.getSubject());
				genCell(row, style, 2, Double.valueOf(subjectMarks.getQizhong()));
				genCell(row, style, 4, Double.valueOf(subjectMarks.getQimo()));
				genCell(row, style, 6, Double.valueOf(subjectMarks.getTotal()));
				genCell(row, style, 8, attendance);
				rowIdx++;
			}
		}
		
		Date today = new Date();
		sheet.getRow(34).getCell(0).setCellValue("http://hanyu.bupt.edu.cn");
		sheet.getRow(35).getCell(0).setCellValue(Constant.CNDATE.format(today));
		sheet.getRow(36).getCell(0).setCellValue(Constant.ENDATE.format(today));
	}
}
