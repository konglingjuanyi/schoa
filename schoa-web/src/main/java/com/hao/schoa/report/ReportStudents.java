package com.hao.schoa.report;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Row;

import com.hao.schoa.po.Student;
import com.hao.schoa.service.SchoaLogsServiceImpl;
import com.hao.schoa.service.StudentServiceImpl;
import com.hao.schoa.tools.Constant;
import com.hao.schoa.tools.ExcelUtil;
import com.hao.schoa.tools.PinyinUtil;

public class ReportStudents extends BaseExcelReport{
	
	private static final int imgW = 2; // 头像图片宽占用单元格
	private static final int imgH = 9; // 头像图片高占用单元格
	private static final int img2W = 2; // 国旗图片宽占用单元格
	private static final int img2H = 5; // 国旗图片高占用单元格
	private static String imgPrePath = "";
	private static HSSFCellStyle style;
	
	@Override
	protected void init() {
		
	}

	@Override
	protected String execute(HttpServletRequest request, HSSFWorkbook wb, HSSFSheet sheet) {
		
		Short _h = 320;
		int _w = 9;
		
		sheet.setDefaultColumnWidth(_w);
		sheet.setDefaultRowHeight(_h);
		
		String ids = request.getParameter("ids");
		List<Student> list = null;
		if (StringUtils.isBlank(ids)) {
			list = new ArrayList<Student>();
		} else {
			list = StudentServiceImpl.searchStudentList(ids, "", "");
		}
		
		//下载文件名
		String title = "学生名单";
		String fileName = getExportFileName(title);
		
		imgPrePath = getRealPath(request) + "/";
		Drawing drawing = sheet.createDrawingPatriarch();
		style = ExcelUtil.getCellStyle(wb);
		
		int preX = 1; // 偏离x轴单元格个数
		int preY = 0; // 偏离y轴单元格个数

		int partWidth = imgW + img2W; // 一个学生总宽度
		int partHeight = imgH + 3; // 一个学生总高度

		int size = list.size();
		for (int i = 0; i < size; i++) {
			Student stu = list.get(i);
			if (i % 2 == 0) {
				writePart(stu, wb, sheet, drawing, preX, preY);
			} else {
				writePart(stu, wb, sheet, drawing, preX + partWidth, preY);
				preY += partHeight;
			}
		}
		
		//系统日志
		SchoaLogsServiceImpl.insertLogs(getSysUser(request),"打印" + title);
		
		return fileName;
	}

	/**
	 * 
	 * @param wb
	 * @param stu
	 * @param sheet
	 * @param preX
	 *            起始坐标
	 * @param preY
	 *            起始坐标
	 */
	public boolean writePart(Student stu, HSSFWorkbook wb, HSSFSheet sheet, Drawing drawing,
			int preX, int preY) {
		String headPic = Constant.IMAGEPATH + stu.getHeadPic();
		String countryPic = imgPrePath + stu.getCountry().getPath();

		int ch = (imgH - img2H) / 2;

		// 头像
		writeJPEGImg(wb, drawing, headPic, preX, preY, preX + imgW, preY + imgH);
		mergedRegion(preY, preY + imgH - 1, preX, preX + imgW - 1, sheet, style);
		Row headRow = getRow(sheet, preY);
		genCell(headRow, style, preX, "");

		// 国旗
		writeJPEGImg(wb, drawing, countryPic, preX + imgW, preY, preX + imgW + img2W, preY + img2H);
		mergedRegion(preY, preY + img2H - 1, preX + imgW, preX + imgW + img2W - 1, sheet, style);
		Row gqRow = getRow(sheet, preY);
		genCell(gqRow, style, preX + imgW, "");

		// 国家1
		// 合并单元格参数 (int firstRow, int lastRow, int firstCol, int lastCol)
		mergedRegion(preY + img2H, preY + img2H + (ch - 1), preX + imgW, preX + imgW + (img2W - 1), sheet, style);
		Row cNameRow = getRow(sheet, preY + img2H);
		genCell(cNameRow, ExcelUtil.getCellStyleStudents(wb), preX + imgW, PinyinUtil.getPinYin(stu.getCountry().getCname()));

		// 国家2
		// sheet.addMergedRegion(new CellRangeAddress(7, 8, 2, 3));
		mergedRegion(preY + img2H + ch, preY + img2H + 2 * ch - 1, preX + imgW, preX + imgW + (img2W - 1), sheet, style);
		Row eNameRow = getRow(sheet, preY + img2H + ch);
		genCell(eNameRow, style, preX + imgW, stu.getCountry().getEname());

		// 名称
		mergedRegion(preY + imgH, preY + imgH + 1, preX, preX + imgW + img2W - 1, sheet, style);
		Row nNameRow = getRow(sheet, preY + imgH);
		genCell(nNameRow, ExcelUtil.getCellStyleStudents(wb), preX, stu.getEname() + "  " + PinyinUtil.getPinYin(stu.getCname()));

		// 空行
		mergedRegion(preY + imgH + 2, preY + imgH + 2, preX, preX + imgW + img2W - 1, sheet, style);
		Row kNameRow = getRow(sheet, preY + imgH + 2);
		genCell(kNameRow, style, preX, "");
		return true;
	}
	
}
