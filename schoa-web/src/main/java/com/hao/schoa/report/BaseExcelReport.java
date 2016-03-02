package com.hao.schoa.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;

import com.hao.schoa.BaseSchoa;
import com.hao.schoa.tools.SchoaUtil;

/**
 * excel报表
 * @author haoguowei
 *
 */
public abstract class BaseExcelReport extends BaseSchoa{
	
	private String modelFileName;
	
	/**
	 * 初始化
	 */
	protected abstract void init();
	
	
	/**
	 * 画报表，返回文件名
	 * @param request
	 * @param wb
	 * @param sheet
	 * @return
	 */
	protected abstract String execute(HttpServletRequest request, HSSFWorkbook wb, HSSFSheet sheet);
	
	/**
	 * 生成报表，并下载
	 * @param request
	 * @param response
	 */
	public void report(HttpServletRequest request, HttpServletResponse response) {
		init();
		
		String modelFile = getModelFilePath(request) + modelFileName;
		ServletOutputStream os = null;
		try {
			HSSFWorkbook wb;
			HSSFSheet sheet;
			if(StringUtils.isBlank(modelFileName)){
				wb = new HSSFWorkbook();
				sheet = wb.createSheet();
			}else{
				wb = new HSSFWorkbook(new FileInputStream(modelFile));
				sheet = wb.getSheetAt(0);
			}
			
			String fileName = execute(request, wb, sheet);
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xls");
			os = response.getOutputStream();
			wb.write(os); 
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(os != null) os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected static Cell genCell(Row row, int index) {
		Cell cell = row.createCell(index);
		return cell;
	}
	protected static Cell genCell(Row row, HSSFCellStyle style, int index) {
		Cell cell = row.createCell(index);
		cell.setCellStyle(style);
		return cell;
	}
	
	protected static Cell genCell(Row row, HSSFCellStyle style, int index, String val) {
		Cell cell = genCell(row, style, index);
		cell.setCellValue(val);
		return cell;
	}
	
	protected static Cell genCell(Row row, HSSFCellStyle style, int index, double val) {
		Cell cell = genCell(row, style, index);
		cell.setCellValue(val);
		return cell;
	}
	
	protected static Cell genCell(Row row, HSSFCellStyle style, int index, int val) {
		Cell cell = genCell(row, style, index);
		cell.setCellValue(val);
		return cell;
	}
	
	protected static Row getRow(Sheet sheet, int index){
		Row row = sheet.getRow(index);
		if (row == null) {
			row = sheet.createRow(index);
		}
		return row;
	}
	
	/**
	 * excel添加照片
	 * @param wb
	 * @param drawing
	 * @param img
	 * @param col1
	 * @param row1
	 * @param col2
	 * @param row2
	 */
	public static void writeJPEGImg(Workbook wb, Drawing drawing, String img, int col1, int row1, int col2, int row2) {
		try {
			if(!new File(img).exists()){
				img = SchoaUtil.getDefalutImage(); 
			}
			int pic_type = img.endsWith(".png")?Workbook.PICTURE_TYPE_PNG:Workbook.PICTURE_TYPE_JPEG;
			InputStream is = new FileInputStream(img);
			int pictureIdx = wb.addPicture(IOUtils.toByteArray(is), pic_type);
			is.close();

			ClientAnchor anchor = wb.getCreationHelper().createClientAnchor();
			anchor.setCol1(col1);
			anchor.setRow1(row1);
			anchor.setCol2(col2);
			anchor.setRow2(row2);
			drawing.createPicture(anchor, pictureIdx);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 合并单元格
	 * @param firstRow
	 * @param lastRow
	 * @param firstCol
	 * @param lastCol
	 * @param sheet
	 * @param cellStyle
	 */
	public void mergedRegion(int firstRow, int lastRow, int firstCol, int lastCol, HSSFSheet sheet, HSSFCellStyle cellStyle) {
		CellRangeAddress range = new CellRangeAddress(firstRow, lastRow, firstCol, lastCol);
		sheet.addMergedRegion(range);
		setRegionStyle(sheet, range, cellStyle);
	}
	
	
	/**
	 * 设置合并单元格样式，避免合并后样式不全
	 * @param sheet
	 * @param range
	 * @param cellStyle
	 */
	public void setRegionStyle(HSSFSheet sheet, CellRangeAddress range, HSSFCellStyle cellStyle) {
		for (int i = range.getFirstRow(); i <= range.getLastRow(); i++) {
			Row row = getRow(sheet, i);
			for (int j = range.getFirstColumn(); j <= range.getLastColumn(); j++) {
				if(cellStyle == null){
					row.createCell(j);
				}else{
					genCell(row, cellStyle, j);
				}
			}
			
			
		}
	}
	
	public String getModelFileName() {
		return modelFileName;
	}

	public void setModelFileName(String modelFileName) {
		this.modelFileName = modelFileName;
	}

}
