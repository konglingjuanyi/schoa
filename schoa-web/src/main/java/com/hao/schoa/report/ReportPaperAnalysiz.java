package com.hao.schoa.report;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.hao.schoa.po.PaperAnalysis;
import com.hao.schoa.service.PaperAnalysisServiceImpl;
import com.hao.schoa.service.SchoaLogsServiceImpl;
import com.hao.schoa.tools.ExcelUtil;

public class ReportPaperAnalysiz extends BaseExcelReport{
	
	@Override
	protected void init() {
		setModelFileName("paper.xls");
	}
	

	@Override
	protected String execute(HttpServletRequest request, HSSFWorkbook wb, HSSFSheet sheet) {
		int id = NumberUtils.toInt(request.getParameter("id"));
		PaperAnalysis pa = PaperAnalysisServiceImpl.getPaperById(id);
		
		//下载文件名
		String title = pa.getBanji().getName() + "《"+pa.getKecheng().getName()+"》" + "试卷分析表";
		String fileName = getExportFileName(title);
		
		HSSFCellStyle cellStyle = ExcelUtil.getCellStylePaperAnalysiz(wb);
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		
		sheet.getRow(1).getCell(0).setCellValue("北京邮电大学" + pa.getXueqi().getName());
		
		genCell(sheet.getRow(3), cellStyle, 2, pa.getBanji().getName());
		genCell(sheet.getRow(3), cellStyle, 4, pa.getKecheng().getJiaocai());
		
		genCell(sheet.getRow(4), cellStyle, 2, pa.getKecheng().getName());
		genCell(sheet.getRow(4), cellStyle, 4, pa.getMingtiTeacher());
		
		genCell(sheet.getRow(5), cellStyle, 2, pa.getKaoshiType());
		
		if(pa.getZl01() > 0){
			genCell(sheet.getRow(7), cellStyle, 3+pa.getZl01(), "√");
		}
		if(pa.getZl02() > 0){
			genCell(sheet.getRow(8), cellStyle, 3+pa.getZl02(), "√");
		}
		if(pa.getZl03() > 0){
			genCell(sheet.getRow(9), cellStyle, 3+pa.getZl03(), "√");
		}
		if(pa.getZl04() > 0){
			genCell(sheet.getRow(10), cellStyle, 3+pa.getZl04(), "√");
		}
		if(pa.getZl05() > 0){
			genCell(sheet.getRow(11), cellStyle, 3+pa.getZl05(), "√");
		}
		
		genCell(sheet.getRow(12), cellStyle, 3, pa.getFen90() + "人");
		genCell(sheet.getRow(12), cellStyle, 4, "占参加考试人数比例："+pa.getFen90Bili()+" %");
		genCell(sheet.getRow(13), cellStyle, 3, pa.getFen8089() + "人");
		genCell(sheet.getRow(13), cellStyle, 4, "占参加考试人数比例："+pa.getFen8089Bili()+" %");
		genCell(sheet.getRow(14), cellStyle, 3, pa.getFen7079() + "人");
		genCell(sheet.getRow(14), cellStyle, 4, "占参加考试人数比例："+pa.getFen7079Bili()+" %");
		genCell(sheet.getRow(15), cellStyle, 3, pa.getFen6069() + "人");
		genCell(sheet.getRow(15), cellStyle, 4, "占参加考试人数比例："+pa.getFen6069Bili()+" %");
		genCell(sheet.getRow(16), cellStyle, 3, pa.getFen59() + "人");
		genCell(sheet.getRow(16), cellStyle, 4, "占参加考试人数比例："+pa.getFen59Bili()+" %");
		genCell(sheet.getRow(17), cellStyle, 3, pa.getTotal() + "人");
		
		genCell(sheet.getRow(18), cellStyle, 2, pa.getFenxi1());
		genCell(sheet.getRow(19), cellStyle, 2, pa.getFenxi2());
		
		//系统日志
		SchoaLogsServiceImpl.insertLogs(getSysUser(request),"打印" + title);
	
		return fileName;
	}

}
