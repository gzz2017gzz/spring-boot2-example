package com.gzz;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
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

		HSSFCellStyle setBorder = workbook.createCellStyle();

		setBorder.setBorderBottom(BorderStyle.THIN); // 下边框
		setBorder.setBorderLeft(BorderStyle.THIN);// 左边框
		setBorder.setBorderTop(BorderStyle.THIN);// 上边框
		setBorder.setBorderRight(BorderStyle.THIN);// 右边框

		HSSFCellStyle aaa = workbook.createCellStyle();
		aaa.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
		aaa.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		dao.queryTables().forEach(table -> {

			HSSFRow rowm = sheet.createRow(row++);

			rowm.createCell(0).setCellValue("表名");
			rowm.createCell(1).setCellValue(table.getTable_name());
			rowm.createCell(2).setCellValue("");
			rowm.createCell(3).setCellValue("描述");
			rowm.createCell(4).setCellValue(table.getTable_comment());
			rowm.createCell(5).setCellValue("");

			rowm = sheet.createRow(row++);
			rowm.createCell(0).setCellValue("字段名");
			rowm.createCell(1).setCellValue("字段描述");
			rowm.createCell(2).setCellValue("数据类型");
			rowm.createCell(3).setCellValue("可为空");
			rowm.createCell(4).setCellValue("是主键");
			rowm.createCell(5).setCellValue("规则");
			dao.queryFields(table.getTable_name()).forEach(field -> {

				HSSFRow rowf = sheet.createRow(row++);
				rowf.createCell(0).setCellValue(field.getColumn_name());
				rowf.createCell(1).setCellValue(field.getColumn_comment());
				rowf.createCell(2).setCellValue(field.getColumn_type());
				rowf.createCell(3).setCellValue(field.getIs_nullable());
				rowf.createCell(4).setCellValue(field.getPri());
				rowf.createCell(5).setCellValue("无");
			});
			rowm = sheet.createRow(row++);
			rowm.setRowStyle(aaa);
 
		});
		for (int i = 0; i < row; i++) {
			HSSFRow row2 = sheet.getRow(i);
			if (row2 != null)
				for (int j = 0; j < 6; j++) {
					HSSFCell cell = row2.getCell(j);
					if (cell != null) {
						cell.setCellStyle(setBorder);
					}
				}
		}

		workbook.write(new File("d:/数据库结构.xls"));
		workbook.close();
	}
}
