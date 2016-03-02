package com.hao.schoa.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import com.hao.schoa.container.ContainerQueqinInfo;
import com.hao.schoa.po.Classes;
import com.hao.schoa.po.Kecheng;
import com.hao.schoa.po.Student;
import com.hao.schoa.po.Xueqi;
import com.hao.schoa.po.XueqiPeer;
import com.hao.schoa.service.ClassesServiceImpl;
import com.hao.schoa.service.KaoqinServiceImpl;
import com.hao.schoa.service.PaikeServiceImpl;
import com.hao.schoa.service.SchoaLogsServiceImpl;
import com.hao.schoa.service.ScoreServiceImpl;
import com.hao.schoa.service.StudentServiceImpl;
import com.hao.schoa.tools.Constant;
import com.hao.schoa.tools.ExcelUtil;
import com.hao.schoa.tools.NumberFormat;

/**
 * 班级出勤表
 * @author haoguowei
 *
 */
public class ReportClassesChuqin extends BaseExcelReport{

	@Override
	protected void init() {
		setModelFileName("banjichuqin.xls");
	}

	@Override
	protected String execute(HttpServletRequest request, HSSFWorkbook wb, HSSFSheet sheet) {
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		String startDT = request.getParameter("startDT");
		String endDT = request.getParameter("endDT");
		
		//班级
		Classes classes = ClassesServiceImpl.retrieveByPK(classesId);
		
		Date startDate = null;
		Date endDate = null;
		
		try {
			startDate = Constant.DATE.parse(startDT);
			endDate = Constant.DATE.parse(endDT);
			Xueqi xueqi = XueqiPeer.retrieveByPK(classes.getXueqiId());
			startDate = startDate.before(xueqi.getStartDate())?xueqi.getStartDate():startDate;
			endDate = endDate.after(xueqi.getEndDate())?xueqi.getEndDate():endDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HSSFCellStyle style = ExcelUtil.getCellStyle(wb);
		
		
		
		//下载文件名
		String title = classes.getName() + "学生考勤表";
		String fileName = getExportFileName(title);
		
		//加载班级下所有学生
		List<Student> studentList = StudentServiceImpl.searchClassesStudent(classesId);
		
		//班级下安排的课程
		List<Kecheng> kechengList = PaikeServiceImpl.getClassesKecheng(classesId);
		if(kechengList != null){
			for(Kecheng kc : kechengList){
				kc.setTotalKeshi(ScoreServiceImpl.getTotalKeshi(startDate,endDate,classesId, kc.getId()));//班级下课程总课时
			}
		}else{
			kechengList = new ArrayList<Kecheng>();
		}
		int kechengSize = kechengList.size();
		
		//A班 学生考勤表
		sheet.getRow(1).getCell(0).setCellValue(classes.getName() + " 学生考勤表");
		sheet.getRow(2).getCell(0).setCellValue("（"+Constant.CNDATE.format(startDate)+"－－"+Constant.CNDATE.format(endDate)+"）");
		
		int top = 6;
		if(studentList != null){
			for(Student student : studentList){
				//学生在班级的出勤情况
				Map<Integer,ContainerQueqinInfo> queqinMap = 
						KaoqinServiceImpl.getStudentKaoqinInfo(classesId, student.getId(),Constant.DATE.format(startDate),Constant.DATE.format(endDate));
				int startLine = top;
				
				int sumKeshi = 0;
				int sumQueqin = 0;
				short h = 500;
				for(Kecheng kc : kechengList){
					Row kcRow = getRow(sheet, top);
					
					kcRow.setHeight(h);
					
					//课程
					genCell(kcRow, style, 1, kc.getName());
					
					//总课时
					genCell(kcRow, style, 2, kc.getTotalKeshi());
					sumKeshi += kc.getTotalKeshi();
					
					//出勤情况
					mergedRegion(top, top, 3, 4, sheet, style);
					ContainerQueqinInfo info = queqinMap.get(kc.getId());
					String tmp = "全勤";
					int queqin = 0;
					if(info != null && StringUtils.isNotBlank(info.getQueqinInfo())){
						tmp = info.getQueqinInfo();
						queqin = info.getTotalQueqin();
						sumQueqin +=  info.getTotalQueqin();
					}
					genCell(kcRow, style, 3, tmp);
					
					//课程出勤率;（总课时-缺勤）／总课时
					String chuqinlvStr = "";
					if(kc.getTotalKeshi() > 0){
						chuqinlvStr = NumberFormat.formatBaiFenBi(
								(kc.getTotalKeshi() - queqin) * 1.0 / kc.getTotalKeshi());
					}
					mergedRegion(top, top, 5, 6, sheet, style);
					genCell(kcRow, style, 5, chuqinlvStr);
					
					top += 1;
				}
				
				mergedRegion(startLine, startLine+kechengSize-1, 0, 0, sheet, style);
				mergedRegion(startLine, startLine+kechengSize-1, 7, 8, sheet, style);
				
				//姓名
				Row topRow = getRow(sheet, startLine);
				genCell(topRow, style, 0, student.getCname() + "\r\n" + student.getEname());
				
				//总出勤率;总出勤率=总出勤课时/总课时*100%
				String sum = "";
				if(sumKeshi > 0){
					sum = NumberFormat.formatBaiFenBi((sumKeshi-sumQueqin)*1.0/sumKeshi);
				}
				genCell(topRow, style, 7, sum);
			}
		}
		
		//说明，备注行
		top += 0;
		HSSFCellStyle styleNoBorder = ExcelUtil.getCellStyleNoBorder(wb);
		styleNoBorder.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		mergedRegion(top, top, 0, 8, sheet, styleNoBorder);
		genCell(getRow(sheet,top), styleNoBorder, 0, "备注：全勤Present in class every day   缺勤Absence from class   迟到Be late   病假Be sick");
		
		top += 1;
		mergedRegion(top, top, 0, 8, sheet, styleNoBorder);
		genCell(getRow(sheet,top), styleNoBorder, 0, "	早退Leave early   放假Holiday Notice   回国Back country   未报到 Haven’t register");
		
		
		//系统日志
		SchoaLogsServiceImpl.insertLogs(getSysUser(request),"打印" + title);
				
		return fileName;
	}
	
	
//	SELECT ck.`kecheng_id`,k.kaoqin,count(k.id)
//	FROM kaoqin k
//	LEFT JOIN classes_kecheng ck ON ck.id=k.classes_kecheng_id
//	WHERE ck.classes_id = 2
//	AND k.`kaoqin` > 0
//	GROUP BY ck.kecheng_id,k.kaoqin

}
