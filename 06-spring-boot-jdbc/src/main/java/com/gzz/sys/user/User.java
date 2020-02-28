package com.gzz.sys.user;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
/**
 * @类说明 【用户】实体类
 * @author 高振中
 * @date 2020-02-28 15:14:25
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
	private Integer customerId; // 客户主键
	private String name; // 用户名
	private String loginName; // 登录名
	private String password; // 密码
	private String email; // 邮箱
	private String phoneNo; // 手机号
	private Byte status; // 1启用0禁用
	private Date createTime; // 创建时间
	private Byte type; // 1内置2普通
	private Date updateTime; // 修改时间
	private String remark; // 备注
    // 以下为查询显示辅助属性
}