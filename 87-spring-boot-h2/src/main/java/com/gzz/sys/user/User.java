package com.gzz.sys.user;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
//import lombok.experimental.Accessors;
/**
 * @类说明 [user]实体类
 * @author 高振中
 * @date 2019-12-20 18:28:06
 **/
@Setter
@Getter
//@Accessors(chain = true)
@Builder	
@AllArgsConstructor
@NoArgsConstructor
public class User {
    // 以下为数据库中 字段
	private Integer id; // 主键
	private String name; // 姓名
	private String sex; // 性别
	private Integer age; // 年龄
	private String phone; // 电话
	private Date create_time; // 创建时间
    // 以下为查询显示辅助属性
}