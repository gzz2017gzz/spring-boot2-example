package com.gzz.sys.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @类说明:用户实体类
 * @author http://www.gaozz.club
 * @date:2018-07-13 10:17:27
 **/
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {

	// 数据库中的字段
	private Long id;// 主键
	private String name;// 姓名

	// 此处可添加查询显示辅助字段

}