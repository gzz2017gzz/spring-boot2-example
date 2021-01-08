package com.gzz;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gzz.sys.table.TableDao;

/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
@SpringBootApplication
public class Application {
	private int row = 0;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private TableDao dao;

	@PostConstruct
	public void run() throws IOException {

		HSSFWorkbook workbook = new HSSFWorkbook(); // 创建工作簿对象

		HSSFSheet sheet = workbook.createSheet("数据库表"); // 创建工作表

		CellStyle border = this.border(workbook);
		CellStyle color = this.color(workbook);

		dao.queryTables().forEach(table -> {

			Row rowm = sheet.createRow(row++);
			rowm.createCell(0).setCellValue("表名");
			rowm.createCell(1).setCellValue(table.getTable_name());
			rowm.createCell(2).setCellValue("描述");
			rowm.createCell(3).setCellValue(table.getTable_comment());
			rowm.createCell(4).setCellValue("");
			rowm.createCell(5).setCellValue("");
			rowm.forEach(cell -> cell.setCellStyle(color));
			sheet.addMergedRegion(new CellRangeAddress(row - 1, row - 1, 3, 5));

			rowm = sheet.createRow(row++);
			rowm.createCell(0).setCellValue("字段名");
			rowm.createCell(1).setCellValue("字段描述");
			rowm.createCell(2).setCellValue("数据类型");
			rowm.createCell(3).setCellValue("可为空");
			rowm.createCell(4).setCellValue("是主键");
			rowm.createCell(5).setCellValue("规则");
			rowm.forEach(cell -> cell.setCellStyle(color));
			dao.queryFields(table.getTable_name()).forEach(field -> {
				Row rowf = sheet.createRow(row++);
				rowf.createCell(0).setCellValue(field.getColumn_name());
				rowf.createCell(1).setCellValue(field.getColumn_comment());
				rowf.createCell(2).setCellValue(field.getColumn_type());
				rowf.createCell(3).setCellValue(field.getIs_nullable());
				rowf.createCell(4).setCellValue(field.getPri());
				rowf.createCell(5).setCellValue("无");
				rowf.forEach(cell -> cell.setCellStyle(border));
			});
			row++;
		});
		row=0;
		HSSFSheet sheet1 = workbook.createSheet("据库表目录"); // 创建工作表
		Row rowm1 = sheet1.createRow(row++);
		rowm1.createCell(0).setCellValue("表名");
		rowm1.createCell(1).setCellValue("描述");
		dao.queryTables().forEach(table -> {
			Row rowm = sheet1.createRow(row++);
			rowm.createCell(0).setCellValue(table.getTable_name());
			rowm.createCell(1).setCellValue(table.getTable_comment());
		});
	 
		sheet1.autoSizeColumn(1); 
 
		workbook.write(new File("d:/数据库结构.xls"));
		workbook.close();
	}

	private CellStyle color(HSSFWorkbook workbook) {
		CellStyle color = workbook.createCellStyle();
		color.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		color.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		color.setBorderBottom(BorderStyle.THIN); // 下边框
		color.setBorderLeft(BorderStyle.THIN);// 左边框
		color.setBorderTop(BorderStyle.THIN);// 上边框
		color.setBorderRight(BorderStyle.THIN);// 右边框
		return color;
	}

	private CellStyle border(HSSFWorkbook workbook) {
		CellStyle border = workbook.createCellStyle();
		border.setBorderBottom(BorderStyle.THIN); // 下边框
		border.setBorderLeft(BorderStyle.THIN);// 左边框
		border.setBorderTop(BorderStyle.THIN);// 上边框
		border.setBorderRight(BorderStyle.THIN);// 右边框
		return border;
	}
}
