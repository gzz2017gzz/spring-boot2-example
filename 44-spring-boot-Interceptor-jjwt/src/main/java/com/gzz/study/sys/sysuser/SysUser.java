package com.gzz.study.sys.sysuser;

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
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
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