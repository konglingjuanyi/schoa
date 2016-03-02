package com.hao.schoa.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hao.schoa.BaseSchoa;
import com.hao.schoa.po.Student;
import com.hao.schoa.po.StudentPeer;
import com.hao.schoa.service.StudentServiceImpl;
import com.hao.schoa.service.SystemServiceImpl;
import com.hao.schoa.tools.Constant;
import com.hao.schoa.tools.SchoaUtil;

@Controller
public class ReadStudentExcelController extends BaseSchoa {

	@RequestMapping("/readStudentExcel.do")
	public String readStudentExcel(MultipartHttpServletRequest request)
			throws IOException {
		String studentFileStr = "studentFile";
		String path = getRealPath(request) + "/tmp/";
		SchoaUtil.genDestFile(path, null);

		try {
			MultipartFile studentFile = request.getFile(studentFileStr);
			File sFile = getFile(studentFile, path);
			
			boolean res = readStudents(sFile, request);
			
			sFile.delete();
			return res ? setSuccessAttribute(request, "学生管理", "initStudent.do") : FAIL;
		} catch (Exception e) {
			setErrorAttribute(request, "文件读取失败！<br/>" + e.getMessage());
			e.printStackTrace();
		}
		return FAIL;
	}
	
	@RequestMapping("/readStudentCodeExcel.do")
	public String readStudentCodeExcel(MultipartHttpServletRequest request)
			throws IOException {
		String numbFile = "numbFile";
		String path = getRealPath(request) + "/tmp/";
		SchoaUtil.genDestFile(path, null);
		try {
			MultipartFile studentFile = request.getFile(numbFile);
			File file = getFile(studentFile, path);
			//key护照 value学号
			Map<String,Integer> map = readNumbs(file);
			for(String key : map.keySet()){
				List<Student> ls = StudentServiceImpl.getStudentByPassNumb(key);
				if(ls != null && !ls.isEmpty()){
					Student stu = ls.get(0);
					stu.setCode(map.get(key));
					StudentPeer.doUpdate(stu);
				}
			}
			file.delete();
			return setSuccessAttribute(request, "学生管理", "initStudent.do") ;
		} catch (Exception e) {
			setErrorAttribute(request, "文件读取失败！<br/>" + e.getMessage());
			e.printStackTrace();
		}
		return FAIL;
	}
	
	private boolean verification(Sheet sheet){
		Row row = sheet.getRow(1);
		if(row != null && row.getCell(1) != null){
			if(row.getCell(1).toString().equals("中文姓名")){
				return true;
			}
		}
		return false;
	}

	private File getFile(MultipartFile file, String path) throws IOException {
		int i = file.getOriginalFilename().lastIndexOf(".");
		String name = path + System.currentTimeMillis() + file.getOriginalFilename().substring(i);
		File dest = new File(name);
		file.transferTo(dest);
		return dest;
	}

	/**
	 * 读学生信息
	 * @param file
	 * @throws Exception
	 */
	public boolean readStudents(File file, HttpServletRequest request) throws Exception {
		InputStream in = null;
		in = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(in);
		Sheet sheet = wb.getSheetAt(0);
		
		if(!verification(sheet)){
			setErrorAttribute(request, "文件验证失败！");
			return false;
		}
		
		//所有国家
		Map<String,Integer> nationsMap = SystemServiceImpl.getAllCountryMap();
		
		for (Row row : sheet) {
			if(row.getCell(7) == null 
					|| StringUtils.isBlank(row.getCell(7).toString()) 
					|| row.getCell(0) == null 
					|| StringUtils.isBlank(row.getCell(0).toString())){
				continue;
			}
			
			Student student = new Student();
			
			student.setCname(getCellValue(row,1).toString());
			student.setEname(getCellValue(row,2).toString());
			
			//国家
			String excelNation = getCellValue(row,3).toString();
			if(nationsMap.containsKey(excelNation)){
				student.setNation(nationsMap.get(excelNation));
			}
			
			String sex = getCellValue(row,5).toString();
			if(StringUtils.isBlank(sex)||sex.trim().equals("男")){
				student.setSex(0);
			}else{
				student.setSex(1);
			}
			
			student.setBirthday(getCellValue(row,6).toString());
			
			Cell codecell = row.getCell(7);
			String code = "";
			if(codecell!=null){
				if(HSSFCell.CELL_TYPE_NUMERIC == codecell.getCellType()){
					DecimalFormat df = new DecimalFormat("0");  
					code = df.format(codecell.getNumericCellValue());
				}else{
					code = codecell.toString();
				}
			}
			student.setPassNumb(code);
			
			//学生证号
			student.setCode(0);
			
//			if(StringUtils.isNotBlank(code) && map!=null && map.containsKey(code)){
//				student.setCode(map.get(code));
//			}else{
//				student.setCode(0);
//			}
			
			student.setBirthday(getCellValue(row,6).toString());
			student.setAddress(getCellValue(row,8).toString());
			
			Object closedDate = getCellValue(row,9);
			if(closedDate instanceof Date){
				student.setClosedDate((Date) closedDate);
			}else{
				student.setClosedDate(null);
			}
			String costFrom = getCellValue(row,10).toString();
			
			if(StringUtils.isBlank(costFrom)||"自费".equals(costFrom)){
				student.setCostFrom(1);
			}else if("公费".equals(costFrom)){
				student.setCostFrom(2);
			}else if("奖学金".equals(costFrom)){
				student.setCostFrom(3);
			}
			
			if(StringUtils.isNotBlank(student.getPassNumb())){
				List<Student> ls = StudentServiceImpl.getStudentByPassNumb(student.getPassNumb());
				if(ls != null && ls.size() > 0){
					
				}else{
					StudentPeer.doInsert(student);
				}
			}else{
				StudentPeer.doInsert(student);
			}
		}
		if (in != null)in.close();
		return true;
	}
	
	private static Object getCellValue(Row row,int index){
		Cell cell = row.getCell(index);
		if(cell == null){
			return "";
		}
		if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
			    Date d = cell.getDateCellValue();  
			    if(d != null){
			    		return Constant.DATE.format(d);
			    }else{
			    		return "";
			    }
			}else{
				if(index == 9){
					return DateUtil.getJavaDate(cell.getNumericCellValue());
				}
			}
			return cell.getNumericCellValue();
		}
		if(cell.getCellType() == HSSFCell.CELL_TYPE_STRING){
			return cell.getStringCellValue();
		}
		return "";
	}

	/**
	 * 读取学生号
	 * @param file
	 * @return map key护照 value学号
	 * @throws Exception
	 */
	public static Map<String,Integer> readNumbs(File file) throws Exception {
		Map<String,Integer> map = new HashMap<String,Integer>();
		InputStream in = null;
		in = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(in);
		Sheet sheet = wb.getSheetAt(0);
		for (Row row : sheet) {
			if(row.getCell(0) != null && row.getCell(2) != null){
				if(HSSFCell.CELL_TYPE_NUMERIC == row.getCell(0).getCellType()){
					int xuehao = (int) row.getCell(0).getNumericCellValue();
					String code = row.getCell(2).toString();
					if(StringUtils.isNotBlank(code)){
						map.put(code,xuehao);
					}
				}
			}
		}
		if (in != null) in.close();
		return map;
	}

}
