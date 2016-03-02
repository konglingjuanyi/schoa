package com.hao.schoa.report;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Font;

import com.hao.schoa.po.Classes;
import com.hao.schoa.po.Student;
import com.hao.schoa.service.ClassesServiceImpl;
import com.hao.schoa.service.SchoaLogsServiceImpl;
import com.hao.schoa.service.StudentServiceImpl;
import com.hao.schoa.tools.Constant;

/**
 * 打印结业证
 * @author haoguowei
 *
 */
public class ReportJieYeZh extends BaseExcelReport{
	
	private Font fontCNUnderline = null;
	private Font fontCN = null; 
	private Font fontEN = null; 
	private Font fontENUnderline = null;

	@Override
	protected void init() {
		setModelFileName("jieyezheng.xls");
	}

	@Override
	protected String execute(HttpServletRequest request, HSSFWorkbook wb, HSSFSheet sheet) {
		int studentId = NumberUtils.toInt(request.getParameter("studentId"));
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		
		Student student = StudentServiceImpl.getById(studentId);
		Classes classes = ClassesServiceImpl.getById(classesId);
		
		//下载文件名
		String title = student.getCname() + "结业证";
		String fileName = getExportFileName(title);
		
		Drawing drawing = sheet.createDrawingPatriarch();
		
		String start = Constant.CNDATE.format(classes.getXueqi().getStartDate());
		String end = Constant.CNDATE.format(classes.getXueqi().getEndDate());
		
		initFonts(wb);
		List<Integer> idx = null;
		
//		r3l2 立贤系伊朗人，
		String tmp1 = student.getCname()+"系"+student.getCountry().getCname()+"人，";
		int _e1 = student.getCname().length();
		int _s2 = _e1 + 1;
		int _e2 = _s2 + student.getCountry().getCname().length();
		idx = new ArrayList<Integer>();
		idx.add(0);
		idx.add(_e1);
		idx.add(_s2);
		idx.add(_e2);
		sheet.getRow(3).getCell(2).setCellValue(genCNRichTextString(tmp1,idx));
		
//		r4l2 于 2013年03月01日 至
		String tmp2 = "于 " + start + " 至";
		idx = new ArrayList<Integer>();
		idx.add(2);
		idx.add(6);
		idx.add(7);
		idx.add(9);
		idx.add(10);
		idx.add(12);
		sheet.getRow(4).getCell(2).setCellValue(genCNRichTextString(tmp2,idx));
		
//		r5l2 2013 年07月01日在
		String tmp3 = end + "在";
		idx = new ArrayList<Integer>();
		idx.add(0);
		idx.add(4);
		idx.add(5);
		idx.add(7);
		idx.add(8);
		idx.add(10);
		sheet.getRow(5).getCell(2).setCellValue(genCNRichTextString(tmp3,idx));

		
//		北京邮电大学国际汉语培训中心
		sheet.getRow(6).getCell(2).setCellValue(genCNRichTextString("北京邮电大学国际汉语培训中心",null));
		
//		学习汉语，学习期满，成绩合格,
		sheet.getRow(7).getCell(2).setCellValue(genCNRichTextString("学习汉语，学习期满，成绩合格,",null));
		
//		予以结业。
		sheet.getRow(8).getCell(2).setCellValue(genCNRichTextString("予以结业。",null));
		
//		北京邮电大学
		sheet.getRow(10).getCell(3).setCellValue(genCNRichTextString("北京邮电大学",null));
		
//		日期，毕业证的落款时间为该生在该学期的最后一天
		sheet.getRow(11).getCell(3).setCellValue(genCNRichTextString(Constant.DATE.format(classes.getXueqi().getEndDate()),null));
		
//		r6l7 This is to certify that MOKHTARI  MAHNAZ
		String tmp4 = "This is to certify that "+student.getEname().toUpperCase();
		idx = new ArrayList<Integer>();
		idx.add(23);
		idx.add(24+student.getEname().length());
		sheet.getRow(6).getCell(7).setCellValue(genENRichTextString(tmp4,idx));
		
//		r7l7 (Iranian，passport No:H22402186)
		String str7 = "("+student.getCountry().getEname()+"，passport No:"+student.getPassNumb()+")";
		sheet.getRow(7).getCell(7).setCellValue(genENRichTextString(str7,null));
		
//		has completed the study of Chinese Language
		sheet.getRow(8).getCell(7).setCellValue(genENRichTextString("has completed the study of Chinese Language",null));
		
//		r9l7 Courses from  03(month)  2013 (year) to
		String tmp5 = "Courses from "+start.substring(5, 7)+"(month) "+start.substring(0, 4)+" (year) to";
		idx = new ArrayList<Integer>();
		idx.add(13);
		idx.add(15);
		idx.add(23);
		idx.add(27);
		sheet.getRow(9).getCell(7).setCellValue(genENRichTextString(tmp5,idx));

//		 r10l7 07(month) 2013 (year) and passed all the
		String tmp6 = end.substring(5, 7) + "(month) "+end.substring(0, 4)+" (year) and passed all the";
		idx = new ArrayList<Integer>();
		idx.add(0);
		idx.add(2);
		idx.add(10);
		idx.add(14);
		sheet.getRow(10).getCell(7).setCellValue(genENRichTextString(tmp6,idx));
		
//		Exams.
		sheet.getRow(11).getCell(7).setCellValue(genENRichTextString("Exams.",null));
		
//		头像
		String headPic = Constant.IMAGEPATH + student.getHeadPic(); 
		writeJPEGImg(wb, drawing, headPic, 9, 2, 11, 5);

		//系统日志
		SchoaLogsServiceImpl.insertLogs(getSysUser(request),"打印" + title);
		
		return fileName;
	}
	
	/**
	 * 初始化文字样式
	 * @param wb
	 */
	private void initFonts(HSSFWorkbook wb) {
		short fontSizeEn = 250;
		short fontSizeCn = 250;
		
		String fontNameEn = "Times New Roman";
		String fontNameCn = "宋体";
		
		//中文下划线
		fontCNUnderline = wb.createFont();
		fontCNUnderline.setUnderline(Font.U_SINGLE);
		fontCNUnderline.setFontName(fontNameCn);
		fontCNUnderline.setFontHeight(fontSizeCn);
		
		//中文
		fontCN = wb.createFont();
		fontCN.setFontName(fontNameCn);
		fontCN.setFontHeight(fontSizeCn);
		
		//英文
		fontEN = wb.createFont();
		fontEN.setFontName(fontNameEn);
		fontEN.setFontHeight(fontSizeEn);
		
		//英文下划线
		fontENUnderline = wb.createFont();
		fontENUnderline.setUnderline(Font.U_SINGLE);
		fontENUnderline.setFontName(fontNameEn);
		fontENUnderline.setFontHeight(fontSizeEn);
	}
	
	/**
	 * 英文单元格文字格式化
	 * @param str
	 * @param index
	 * @return
	 */
	private HSSFRichTextString genENRichTextString(String str, List<Integer> index){
		return genRichTextString(1,str,index);
	}
	
	/**
	 * 中文单元格文字格式化
	 * @param str
	 * @param index
	 * @return
	 */
	private HSSFRichTextString genCNRichTextString(String str, List<Integer> index){
		return genRichTextString(0,str,index);
	}

	/**
	 * 单元格文字格式化
	 * @param flag 0中文，1英文
	 * @param str 
	 * @param index 只能是偶数
	 * @return
	 */
	private HSSFRichTextString genRichTextString(int flag,String str, List<Integer> index){
		HSSFRichTextString richString = new HSSFRichTextString(str);
		Font font = flag == 0 ? fontCN : fontEN;
		Font fontUnderLine = flag == 0 ? fontCNUnderline : fontENUnderline;
		richString.applyFont(font);
		if(index != null && !index.isEmpty()){
			for (int i = 0; i < index.size()/2; i++) {
				richString.applyFont(index.get(i * 2), index.get(i * 2 + 1), fontUnderLine);
			}
		}
		
		return richString;
	}
	

	
}
