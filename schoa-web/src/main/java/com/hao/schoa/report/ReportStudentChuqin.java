package com.hao.schoa.report;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellRangeAddress;

import com.hao.schoa.container.ContainerQueqinInfo;
import com.hao.schoa.po.Classes;
import com.hao.schoa.po.Kecheng;
import com.hao.schoa.po.Student;
import com.hao.schoa.po.Xueqi;
import com.hao.schoa.service.ClassesServiceImpl;
import com.hao.schoa.service.KaoqinServiceImpl;
import com.hao.schoa.service.PaikeServiceImpl;
import com.hao.schoa.service.ScoreServiceImpl;
import com.hao.schoa.service.StudentServiceImpl;
import com.hao.schoa.service.XueqiServiceImpl;
import com.hao.schoa.tools.Constant;
import com.hao.schoa.tools.ExcelUtil;

/**
 * 单个学生出勤表
 * @author haoguowei
 *
 */
public class ReportStudentChuqin extends BaseExcelReport{
	
	HSSFCellStyle style;
	
	@Override
	protected void init() {
		setModelFileName("studentchuqin.xls");
	}

	@Override
	protected String execute(HttpServletRequest request, HSSFWorkbook wb, HSSFSheet sheet) {
		int studentId = NumberUtils.toInt(request.getParameter("studentId"));
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		
		String startStr = request.getParameter("startDT");
		String endStr = request.getParameter("endDT");
		
		Student student = StudentServiceImpl.getById(studentId);
		Classes classes = ClassesServiceImpl.retrieveByPK(classesId);
		
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = Constant.DATE.parse(startStr);
			endDate = Constant.DATE.parse(endStr);
			
			Xueqi xueqi = XueqiServiceImpl.getById(classes.getXueqiId());
			startDate = startDate.before(xueqi.getStartDate())?xueqi.getStartDate():startDate;
			endDate = endDate.after(xueqi.getEndDate())?xueqi.getEndDate():endDate;
			
			startStr = Constant.DATE.format(startDate);
			endStr = Constant.DATE.format(endDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int totalKeshi = ScoreServiceImpl.getTotalKeshi(startDate,endDate,classesId, 0); //总课时
		int totalQueqin = ScoreServiceImpl.getTotalQueqin(startStr, endStr, classesId, studentId, 0); //总缺勤
		
		//下载文件名
		String title = student.getCname() + "在"+ classes.getName() + "出勤表";
		String fileName = getExportFileName(title);
		
		style = ExcelUtil.getCellStyleTitle(wb);
		
		String showDate = Constant.CNDATE.format(startDate)+"－－"+Constant.CNDATE.format(endDate);
		sheet.getRow(7).getCell(0).setCellValue(showDate);
		
		int top = 9;
		
//		ALOKAILI,HAMZH SAUD M（哈姆兹），护照号：H836305
		StringBuffer sb = new StringBuffer();
		sb.append(student.getEname())
			.append("(")
			.append(student.getCname())
			.append(")")
			.append("，护照号：")
			.append(student.getPassNumb());
		setRowValueTitle(sheet, top, sb.toString());
		
//		所在班级(Class)：A班
		top += 1;
		setRowValue(sheet, top, "所在班级(Class)：" + classes.getName());
		
//		总课时Total hours：80课时(hours) 
		top += 1;
		setRowValue(sheet, top, "总课时Total hours：" + totalKeshi + "课时(hours)");
		
//		总出勤Total attendance：60课时(hours) 
		top += 1;
		setRowValue(sheet, top, "总出勤Total attendance：" + (totalKeshi - totalQueqin) + "课时(hours)");
		
//		总缺勤Absence：20课时(hours)
		top += 1;
		setRowValue(sheet, top, "总缺勤Absence：" + totalQueqin + "课时(hours)");
		
//		课程出勤情况Courses attendance：
		top += 2;
		setRowValueTitle(sheet, top, "课程出勤情况Courses attendance：");
		
		//班级下安排的课程
		List<Kecheng> kechengList = PaikeServiceImpl.getClassesKecheng(classesId);
		if(kechengList != null && !kechengList.isEmpty()){
			//学生在班级的出勤情况
			Map<Integer,ContainerQueqinInfo> queqinMap = 
					KaoqinServiceImpl.getStudentKaoqinInfo(classesId, student.getId(),startStr,endStr);
			for(Kecheng kc : kechengList){
				StringBuffer sbr = new StringBuffer();
				sbr.append(kc.getName()).append("：");
				
				ContainerQueqinInfo info = queqinMap.get(kc.getId());
				String tmp = "全勤";
				if(info != null && StringUtils.isNotBlank(info.getQueqinInfo())){
					tmp = info.getQueqinInfo();
				}
				sbr.append(tmp);
				top += 1;
				setRowValue(sheet, top, sbr.toString());
			}
		}
		return fileName;
	}
	
	private void setRowValue(HSSFSheet sheet, int rowIndex, String value){
		// 合并单元格参数 (int firstRow, int lastRow, int firstCol, int lastCol)
		sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 0, 8));
		sheet.createRow(rowIndex).createCell(0).setCellValue(value);
		sheet.getRow(rowIndex).setHeight(Constant.HEIGTH);
	}
	private void setRowValueTitle(HSSFSheet sheet, int rowIndex, String value){
		// 合并单元格参数 (int firstRow, int lastRow, int firstCol, int lastCol)
		sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 0, 8));
		Cell c = sheet.createRow(rowIndex).createCell(0);
		c.setCellValue(value);
		c.setCellStyle(style);
		sheet.getRow(rowIndex).setHeight(Constant.HEIGTH);
	}
	
}
