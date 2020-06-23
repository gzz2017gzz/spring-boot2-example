package com.gzz.sys.form;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @类说明 【字段定义】实体
 * @author 高振中
 * @date 2020-06-17 18:03:53
 **/
@Setter
@Getter
//@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Form {
	private String field_id; // 字段主键
	private String field_name; // 字段主键
	private String type; // 控件类型
	private String value; // 默认值
	private String title; // 标题
	private String props; // 属性JSON
	private String validate; // 验证JSON
	private String col; // 布局列数
	private String dataSource; // 数据来源JSON
	private String options; // 数据项
	private Integer order_num; // 顺序

	public JSONObject getJson() {
		JSONObject json = new JSONObject();
		json.put("field", field_name);
		if (!StringUtils.isEmpty(col))
			json.put("col", JSONObject.parseObject(col));
		if (!StringUtils.isEmpty(value))
			json.put("value", value);
		if (!StringUtils.isEmpty(title))
			json.put("title", title);
		json.put("type", type);
		if (type.equals("hidden")) {
		} else if (type.equals("input")) {
			if (!StringUtils.isEmpty(validate))
				json.put("validate", JSON.parseArray(validate));
			if (!StringUtils.isEmpty(props))
				json.put("props", JSONObject.parseObject(props));
		} else if (type.equals("InputNumber")) {
		} else if (type.equals("DatePicker")) {
			json.put("value", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		} else if (type.equals("select")) {
			json.put("options", JSON.parseArray(options));
		} else if (type.equals("switch")) {
			json.put("props", JSONObject.parseObject(props));
		} else {
			json.put(type, "不支持的控件类型!");
		}
		return json;
	}
}