package com.hao.schoa.report;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

import com.hao.schoa.container.ContainerPaikeModel;
import com.hao.schoa.po.Classes;
import com.hao.schoa.po.ClassesKecheng;
import com.hao.schoa.po.Student;
import com.hao.schoa.service.ClassesServiceImpl;
import com.hao.schoa.service.KaoqinServiceImpl;
import com.hao.schoa.service.SchoaLogsServiceImpl;
import com.hao.schoa.service.StudentServiceImpl;
import com.hao.schoa.tools.Constant;
import com.hao.schoa.tools.ExcelUtil;

/**
 * 打印班级考勤
 * 
 * @author haoguowei
 * 
 */
public class ReportKaoqin extends BaseExcelReport {

	@Override
	protected void init() {

	}

	@Override
	protected String execute(HttpServletRequest request, HSSFWorkbook wb, HSSFSheet sheet) {
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		Classes classes = ClassesServiceImpl.getById(classesId);

		// 获取班级排课Map key-星期(0-6) value-排好的课程列表
		Map<Integer, List<ClassesKecheng>> map = KaoqinServiceImpl.getClassesKechengMap(classesId);

		// 加载班级下所有学生
		List<Student> students = StudentServiceImpl.searchClassesStudent(classesId);

		String weeks = request.getParameter("weeks");
		String tp[] = weeks.split("~");
		String start = tp[0], end = tp[1];
		
		//第1周
		String zhou = request.getParameter("zhou");

		Map<Integer, ContainerPaikeModel> model = KaoqinServiceImpl.getPaikeModelMap(start, end);
		for (int wk : model.keySet()) {
			model.get(wk).setLs(map.get(wk));
		}

		// 加载学生考勤
		Map<String, String> kaoqinMap = KaoqinServiceImpl.getKaoqin(classesId, start, end);

		// 下载文件名
		String title = classes.getName() + "班级考勤表";
		String fileName = getExportFileName(title);

		HSSFCellStyle cellStyle = ExcelUtil.getCellStyleKaoqin(wb);
		HSSFCellStyle kechengStyle = ExcelUtil.getCellStyleKaoqinKecheng(wb);
		HSSFCellStyle headStyle = ExcelUtil.getHeadStyle(wb);

		Row row2 = sheet.createRow(2);
		Row row3 = sheet.createRow(3);
		
		mergedRegion(2, 3, 0, 0, sheet, cellStyle);
		mergedRegion(2, 3, 1, 1, sheet, cellStyle);
		
		genCell(row2, cellStyle, 0, "序号");
		genCell(row2, cellStyle, 1, "姓名／时间");
		// 设置列宽度
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		
		sheet.setDefaultRowHeight((short)380);

		int maxHigth = 0;
		int maxWidth = 1;
		int firstCol = 2;
		for (int key : model.keySet()) {
			ContainerPaikeModel paikeModel = model.get(key);
			List<ClassesKecheng> ls = paikeModel.getLs();
			if (ls != null && ls.size() > 0) {
				int cols = ls.size();
				// 合并单元格参数 (int firstRow, int lastRow, int firstCol, int lastCol)
				mergedRegion(2, 2, firstCol, firstCol + cols - 1, sheet, cellStyle);
				genCell(row2, cellStyle, firstCol, Constant.WEEKMAP.get(key));
				sheet.autoSizeColumn(firstCol-1);
				row2.setHeight((short)400);
				
				int idx = 0;
				for (ClassesKecheng ck : ls) {
					String str = ck.getStart() + "-" + ck.getEnd() + "\n";
					str += ck.getKechengName() + "  " + ck.getTeacherName();
					genCell(row3, kechengStyle, firstCol + idx, str);
					sheet.autoSizeColumn(firstCol + idx);
					row3.setHeight((short)600);
					maxWidth += 1;
					idx++;
				}
				firstCol += cols;
			}
		}

		
		for (int i = 0; i < students.size(); i++) {
			Student stu = students.get(i);
			maxHigth = 4 + i;
			Row row = sheet.createRow(4 + i);
			// 序号
			genCell(row, cellStyle, 0, i + 1);

			// 姓名
			String name = stu.getCname() + (stu.getState() == 2 ? "(离校)" : "");
			genCell(row, cellStyle, 1, name);

			int cIndex = 2;
			for (int key : model.keySet()) {
				ContainerPaikeModel paikeModel = model.get(key);
				List<ClassesKecheng> ls = paikeModel.getLs();
				if (ls != null && ls.size() > 0) {
					for (ClassesKecheng ck : ls) {
						String k = "k_" + stu.getId() + "_" + ck.getId();
						genCell(row, cellStyle, cIndex, kaoqinMap.get(k));
						cIndex++;
					}
				}
			}
		}
		
		//说明
		maxHigth += 1;
		mergedRegion(maxHigth, maxHigth, 0, maxWidth, sheet, null);
		Row row = getRow(sheet, maxHigth);
		Cell shmC0 = genCell(row, 0);
		shmC0.setCellValue("出勤:√   迟到:Δ   病假:O   事假:⊙   缺勤:X   早退:∝   回国:回国   未报到:未报到");
		
		maxHigth += 1;
		mergedRegion(maxHigth, maxHigth, 0, maxWidth, sheet, null);
		Row row1 = getRow(sheet, maxHigth);
		Cell shmC1 = genCell(row1, 0);
		shmC1.setCellValue("学习成绩（总分100）=期中考试成绩（20%）+期末考试成绩（40%） +平时成绩（20%）+出勤（20%）");
		
		maxHigth += 1;
		mergedRegion(maxHigth, maxHigth, 0, maxWidth, sheet, null);
		Row _row3 = getRow(sheet, maxHigth);
		Cell shmC2 = genCell(_row3,0);
		shmC2.setCellValue("说明：为准确统计学生考勤，请各位教师按本考勤表符号填写本班学生出勤情况，每周交办公室。");
		
		maxHigth += 1;
		mergedRegion(maxHigth, maxHigth, maxWidth-1, maxWidth, sheet, null);
		Row _row4 = getRow(sheet, maxHigth);
		Cell shmC4 = genCell(_row4,maxWidth-1);
		shmC4.setCellValue("北京邮电大学");
		sheet.autoSizeColumn(maxWidth);
		
		maxHigth += 1;
		mergedRegion(maxHigth, maxHigth, maxWidth-1, maxWidth, sheet, null);
		Row _row5 = getRow(sheet, maxHigth);
		Cell shmC5 = genCell(_row5,maxWidth-1);
		shmC5.setCellValue("国际汉语培训中心");
		
		

		// 标题
		// 2013年 06月 B2班 (第18周)
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, firstCol - 1));
		Row titleRow = sheet.createRow(0);
		titleRow.setHeight(Constant.HEIGTH);
		
		mergedRegion(1, 1, 0, maxWidth, sheet, null);
		Row _row0 = getRow(sheet, 1);
		genCell(_row0,0).setCellValue("请老师认真记录，我们的一举一动会映射到学生的成长轨迹中！谢谢");

		StringBuffer str = new StringBuffer();
		str.append(weeks).append("    ")
			.append(classes.getName())
			.append(" (").append(zhou).append(")");
		genCell(titleRow, headStyle, 0, str.toString());

		// 系统日志
		SchoaLogsServiceImpl.insertLogs(getSysUser(request), "打印" + title);

		return fileName;
	}

}
