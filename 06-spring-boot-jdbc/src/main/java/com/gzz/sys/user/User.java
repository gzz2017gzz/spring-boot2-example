package com.gzz.sys.user;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @类说明:用户实体类
 * @author http://www.gaozz.club
 * @date:2018-07-13 10:17:27
 **/
@Setter
@Getter
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {

	// 数据库中的字段
	private Long id;// 主键
	private String name;// 姓名
	// @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date birthday;// 生日
	private Byte gender;// 性别

	// 此处可添加查询显示辅助字段

}