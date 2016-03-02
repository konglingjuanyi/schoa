package com.hao.schoa.report;

import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.hao.schoa.po.Student;
import com.hao.schoa.service.SchoaLogsServiceImpl;
import com.hao.schoa.service.StudentServiceImpl;
import com.hao.schoa.tools.Constant;

/**
 * 打印学习证明
 * @author haoguowei
 *
 */
public class ReportXuexiZhengMing extends BaseExcelReport{

	@Override
	protected void init() {
		setModelFileName("xuexizhengming.xls");
	}

	@Override
	protected String execute(HttpServletRequest request, HSSFWorkbook wb, HSSFSheet sheet) {
		int studentId = NumberUtils.toInt(request.getParameter("studentId"));
		Student student = StudentServiceImpl.getById(studentId);
		
		Date sDT = null;
		Date eDT = null;
		try {
			sDT = Constant.DATE.parse(request.getParameter("startDT"));
			eDT = Constant.DATE.parse(request.getParameter("endDT"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		//下载文件名
		String title = student.getCname() + "学习证明";
		String fileName = getExportFileName(title);
		
		//生日
		Date birthday = null;
		if(StringUtils.isNotBlank(student.getBirthday())){
			try {
				birthday = Constant.DATE.parse(student.getBirthday());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		//土库曼斯坦籍留学生亚哥(男）
		HSSFCell nemeCell = sheet.getRow(9).getCell(0);
		nemeCell.setCellValue(student.getCountry()==null?"":student.getCountry().getCname() 
				+ "籍留学生"
				+ student.getCname()
				+ "("
				+ (student.getSex()==0?"男":"女")
				+ ")"
				);
		
		//Student  SAPARLYYEV  YAGMYRGELDI （ m） from  TURKMENISTAN
		String _en = student.getCountry()==null?"":student.getCountry().getEname();
		HSSFCell eNemeCell = sheet.getRow(10).getCell(0);
		eNemeCell.setCellValue("Student " 
				+ student.getEname().toUpperCase()
				+ " ("
				+ (student.getSex()==0?"M":"F")
				+") from "
				+ (StringUtils.isBlank(_en)?"":_en.toUpperCase())
				);
		
		//1992年04月25日生人，护照号码为：A0222651
		HSSFCell bthCell = sheet.getRow(11).getCell(0);
		bthCell.setCellValue(
				Constant.CNDATE.format(birthday)
				+ "生人，护照号码为："
				+ student.getPassNumb()
				);

		
		//Date of birth: 25. April.1992, passport，s number: A0222651
		HSSFCell ebthCell = sheet.getRow(12).getCell(0);
		ebthCell.setCellValue(
				"Date of birth:"
				+ Constant.ENDATE.format(birthday)
				+ ", passport's number: "
				+ student.getPassNumb()
				);
		
		//时间： 2013年03月01日至2013年07月01日，
		HSSFCell dtCell = sheet.getRow(15).getCell(0);
		dtCell.setCellValue(
				"时间： "
				+ Constant.CNDATE.format(sDT)
				+ "至"
				+ Constant.CNDATE.format(eDT)
				+ "，"
				);

		//Time period: from 01.March. 2013 to 01. July.2013
		HSSFCell edtCell = sheet.getRow(16).getCell(0);
		edtCell.setCellValue(
				"Time period: from "
				+ Constant.ENDATE.format(sDT)
				+ " to "
				+ Constant.ENDATE.format(eDT)
				);
		
		//开证日期
		Date today = new Date();
		HSSFCell dt1 = sheet.getRow(22).getCell(0);
		dt1.setCellValue(Constant.CNDATE.format(today));
		
		HSSFCell dt2 = sheet.getRow(23).getCell(0);
		dt2.setCellValue(Constant.ENDATE.format(today));
		
		//系统日志
		SchoaLogsServiceImpl.insertLogs(getSysUser(request),"打印" + title);
		
		return fileName;
	}

}
