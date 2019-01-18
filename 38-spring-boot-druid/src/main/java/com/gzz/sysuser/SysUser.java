package com.gzz.sysuser;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

//import lombok.experimental.Accessors;
/**
 * @类说明 [用户]实体类
 * @author 高振中
 * @date 2019-01-13 00:00:31
 **/
@Setter
@Getter
//@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysUser {
	// 以下为数据库中 字段
	private Long id; // 主键
	private String name; // 姓名
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date birthday; // 生日
	private Byte gender; // 性别
	// 以下为查询显示辅助属性
}