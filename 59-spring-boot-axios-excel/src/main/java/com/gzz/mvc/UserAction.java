package com.gzz.mvc;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

@RestController
@RequestMapping("/api")
public class UserAction {

	@RequestMapping("/role")
	public void role(HttpServletResponse response) throws Exception {
		response.reset();
		response.setContentType("application/vnd.ms-excel");
		// 浏览器处响应用以下方式可以解决中文乱码问题如果是axios处理响应header部分仍乱码
		response.setHeader("Content-Disposition", "attachment; filename=" + new String("中文文件名.xls".getBytes(), "ISO-8859-1"));
		write(response);
	}

	@RequestMapping("/user")
	public void user(HttpServletResponse response) throws Exception {
		response.reset();
		response.setContentType("application/vnd.ms-excel");
		// 划重点 把中文转码成iso8859-1支持的百分号编码方式到页面再还原
		response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("中文文件名.xls", "utf-8"));
		write(response);
	}

	private void write(HttpServletResponse response) throws Exception {
		WritableWorkbook wbook = Workbook.createWorkbook(response.getOutputStream());
		WritableSheet sheet = wbook.createSheet("定单记录.xls", 0);
		sheet.addCell(new Label(0, 0, "定单记录"));
		wbook.write();
		if (wbook != null) {
			wbook.close();
		}
	}
}
