package com.hao.schoa.report;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Drawing;

import com.hao.schoa.po.Classes;
import com.hao.schoa.po.Kecheng;
import com.hao.schoa.service.ClassesServiceImpl;
import com.hao.schoa.service.PaikeServiceImpl;
import com.hao.schoa.service.SchoaLogsServiceImpl;
import com.hao.schoa.service.TeacherServiceImpl;
import com.hao.schoa.tools.Constant;
import com.hao.schoa.tools.ExcelUtil;

/**
 * 打印班级下空考评表格
 * @author haoguowei
 *
 */
public class ReportTeacherPingjia extends BaseExcelReport{

	@Override
	protected void init() {
		
	}

	@Override
	protected String execute(HttpServletRequest request, HSSFWorkbook wb, HSSFSheet sheet) {
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));

		//班级
		Classes banji = ClassesServiceImpl.retrieveByPK(classesId);
		
		//班级下得课程及教师信息
		List<Kecheng> kechengList = PaikeServiceImpl.getClassesKecheng(classesId);
		for(Kecheng kecheng : kechengList){
			kecheng.setTeacher(TeacherServiceImpl.getById(kecheng.getTeacherId()));
		}
		
		// 下载文件名
		String title = banji.getName() + "教师评价表";
		String fileName = getExportFileName(title);
		
		//行，列
		int row = 0;
		int col =  kechengList.size() - 1;
		Drawing drawing = sheet.createDrawingPatriarch();
		
		short _h_title = 600;
		short _h = 500;
		short _h_img = 2700;
		short _w = 5100;
		
		HSSFCellStyle titleStyle = ExcelUtil.kaopinTitle(wb);
		HSSFCellStyle kaopinStyle = ExcelUtil.kaopin(wb);
		
		HSSFCellStyle leftTitleStyle = ExcelUtil.leftTitleStyle(wb);
		HSSFCellStyle leftStyle = ExcelUtil.leftStyle(wb);
		
		HSSFCellStyle kaopinWenti = ExcelUtil.kaopinWentiStyle(wb);
		
		HSSFRow row0 = sheet.createRow(row);
		mergedRegion(row, row, 0, col, sheet, titleStyle);
		genCell(row0, titleStyle, 0, "北京邮电大学教师评分标准（"+banji.getName()+"）");
		row0.setHeight(_h_title);
		
		row+=1;
		HSSFRow row1 = sheet.createRow(row);
		mergedRegion(row, row, 0, col, sheet, kaopinStyle);
		genCell(row1, kaopinStyle, 0, "The assessment of teachers in BUPT（"+banji.getName()+"）");
		row1.setHeight(_h);
		
		row+=1;
		HSSFRow row2 = sheet.createRow(row);
		mergedRegion(row, row, 0, col, sheet, leftTitleStyle);
		genCell(row2, leftTitleStyle, 0, "请在按照下面的说明打");
		row2.setHeight(_h);
		
		row+=1;
		HSSFRow row3 = sheet.createRow(row);
		mergedRegion(row, row, 0, col, sheet, leftStyle);
		genCell(row3, leftStyle, 0, "Please follow the instructions below painting black ");
		row3.setHeight(_h);
		
		row+=1;
		HSSFRow row4 = sheet.createRow(row);
		mergedRegion(row, row, 0, col, sheet, leftStyle);
		genCell(row4, leftStyle, 0, "不好√    一般√√    好√√√    很好√√√√    非常好√√√√√");
		row4.setHeight(_h);
		
		//照片
		row+=1;
		HSSFRow row5 = sheet.createRow(row);
		row5.setHeight(_h_img);
		for(int i=0;i<kechengList.size();i++){
			Kecheng kch = kechengList.get(i);
			writeJPEGImg(wb, drawing, Constant.IMAGEPATH + kch.getTeacher().getHeadPic() , i, row, i+1, row+1);
		}
		
		//题目
		for(String key : Constant.questionMap.keySet()){
			row+=1;
			HSSFRow rowTmp = sheet.createRow(row);
			mergedRegion(row, row, 0, col, sheet, leftTitleStyle);
			genCell(rowTmp, leftTitleStyle, 0, Constant.questionMap.get(key));
			rowTmp.setHeight((short) 400);
			
			row+=1;
			HSSFRow rowTmp2 = sheet.createRow(row);
			rowTmp2.setHeight((short) 400);
			
			row+=1;
			HSSFRow rowTmp3 = sheet.createRow(row);
			rowTmp3.setHeight((short) 400);
			
			for(int i=0;i<kechengList.size();i++){
				Kecheng kch = kechengList.get(i);
				genCell(rowTmp2, kaopinWenti, i, kch.getName());
				genCell(rowTmp3, kaopinWenti, i, "□□□□□");
				sheet.setColumnWidth(i, _w);
			}
		}
		
		row+=1;
		HSSFRow row6 = sheet.createRow(row);
		mergedRegion(row, row, 0, col, sheet, leftTitleStyle);
		genCell(row6, leftTitleStyle, 0, "18.你对每门任课老师总的评价。 Please write down your personal opinions toward every teacher below.");
		row6.setHeight(_h);
		
		for(int i=0;i<kechengList.size();i++){
			//头像
			row+=1;
			Kecheng kch = kechengList.get(i);
			HSSFRow rowTmp = sheet.createRow(row);
			rowTmp.setHeight(_h_img);
			writeJPEGImg(wb,drawing,Constant.IMAGEPATH + kch.getTeacher().getHeadPic() , 0, row, 1, row+1);
			
			//内容
			row+=1;
			HSSFRow rowTmp2 = sheet.createRow(row);
			rowTmp2.setHeight(_h);
			mergedRegion(row, row, 0, col, sheet, leftStyle);
			genCell(rowTmp2, leftStyle, 0, (i+1) + "." + kch.getName() + "______________________________");
		}
		
		// 系统日志
		SchoaLogsServiceImpl.insertLogs(getSysUser(request), "打印" + title);
		return fileName;
	}

}
