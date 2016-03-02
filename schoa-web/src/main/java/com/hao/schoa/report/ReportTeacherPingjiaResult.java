package com.hao.schoa.report;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Drawing;

import com.hao.schoa.po.Classes;
import com.hao.schoa.po.JiaoxueKaopin;
import com.hao.schoa.po.JiaoxueKaopinInfo;
import com.hao.schoa.po.Kecheng;
import com.hao.schoa.service.ClassesServiceImpl;
import com.hao.schoa.service.KechengServiceImpl;
import com.hao.schoa.service.SchoaLogsServiceImpl;
import com.hao.schoa.service.TeachingKaopinServiceImpl;
import com.hao.schoa.tools.Constant;
import com.hao.schoa.tools.ExcelUtil;

/**
 * 打印教师考评结果表
 * @author haoguowei
 *
 */
public class ReportTeacherPingjiaResult extends BaseExcelReport{

	@Override
	protected void init() {
		setModelFileName("teacherPingjiaResult.xls");
	}

	@Override
	protected String execute(HttpServletRequest request, HSSFWorkbook wb, HSSFSheet sheet) {

		int kaopinId = NumberUtils.toInt(request.getParameter("kaopinId"));
		JiaoxueKaopin kaopin = TeachingKaopinServiceImpl.getKaopinById(kaopinId);
		
		int classesId = kaopin.getBanjiId();
		int kechengId = kaopin.getKechengId();
		
		//班级
		Classes banji = ClassesServiceImpl.retrieveByPK(classesId);
		//课程,包括教师，学期信息
		Kecheng kecheng = KechengServiceImpl.getById(kechengId);
		
		// 下载文件名
		String title = kecheng.getTeacher().getName() + "教师评价结果表";
		String fileName = getExportFileName(title);
		
		//行，列
		int row = 7;
		int col =  2;
		Drawing drawing = sheet.createDrawingPatriarch();
		
		HSSFCellStyle leftTitleStyle = ExcelUtil.leftTitleStyle(wb);
		HSSFCellStyle leftStyle = ExcelUtil.leftStyle(wb);
		
		sheet.getRow(0).getCell(0).setCellValue("北京邮电大学教师评分标准（"+banji.getName()+"）");
		sheet.getRow(1).getCell(0).setCellValue("The assessment of teachers in BUPT（"+banji.getName()+"）");
		
		//学期
		sheet.getRow(2).getCell(2).setCellValue(kecheng.getXueqi().getName());
		//班级
		sheet.getRow(3).getCell(2).setCellValue(banji.getName());
		//课程
		sheet.getRow(4).getCell(2).setCellValue(kecheng.getName());
		//教师
		sheet.getRow(5).getCell(2).setCellValue(kecheng.getTeacher().getName());
		//总得分
//		double score = TeachingKaopinServiceImpl.getSumScore(xueqiId, classesId, kechengId, kecheng.getTeacherId());
		sheet.getRow(6).getCell(2).setCellValue(String.valueOf(kaopin.getScore())+"分,(满分30分)");
		
		//照片
		writeJPEGImg(wb, drawing, Constant.IMAGEPATH + kecheng.getTeacher().getHeadPic() , 0, 2, 1, 7);
		
		//题目
		for(String key : Constant.questionMap.keySet()){
			row+=1;
			HSSFRow rowTmp = sheet.createRow(row);
			mergedRegion(row, row, 0, col, sheet, leftTitleStyle);
			rowTmp.setHeight((short) 400);
			genCell(rowTmp, leftTitleStyle, 0, Constant.questionMap.get(key));
			
			row+=1;
			HSSFRow rowTmp2 = sheet.createRow(row);
			rowTmp2.setHeight((short) 400);
			mergedRegion(row, row, 0, col, sheet, leftStyle);
			
			Map<Integer,Integer> map = TeachingKaopinServiceImpl.getKaopinMans(key, kaopinId);
			String show = "";
			show += "不好"+(map.get(1)==null?0:map.get(1))+"人，";
			show += "一般"+(map.get(2)==null?0:map.get(2))+"人，";
			show += "好"+(map.get(3)==null?0:map.get(3))+"人，";
			show += "很好"+(map.get(4)==null?0:map.get(4))+"人，";
			show += "非常好"+(map.get(5)==null?0:map.get(5))+"人";
			
			genCell(rowTmp2, leftStyle, 0, show);
		}
		
		row+=2;
		HSSFRow r_0 = sheet.createRow(row);
		r_0.setHeight((short) 400);
		mergedRegion(row, row, 0, col, sheet, leftStyle);
		genCell(r_0, leftTitleStyle, 0, "评价汇总：");
		
		List<JiaoxueKaopinInfo> ls = TeachingKaopinServiceImpl.getKappinfenList(kaopinId);
		if(ls != null && ls.size() > 0){
			for(JiaoxueKaopinInfo info : ls){
				if(StringUtils.isBlank(info.getPingjia())){
					continue;
				}
				row+=1;
				HSSFRow r_1 = sheet.createRow(row);
				r_1.setHeight((short) 800);
				mergedRegion(row, row, 0, col, sheet, leftStyle);
				genCell(r_1, leftStyle, 0, info.getPingjia());
			}
		}
		
		// 系统日志
		SchoaLogsServiceImpl.insertLogs(getSysUser(request), "打印" + title);
		return fileName;
	}
	
}
