package com.gzz.demo.base.customer;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @类说明 【客户】实体类
 * @author 高振中
 * @date 2020-02-26 01:03:39
 **/
@Setter
@Getter
@Builder
@TableName(value = "sys_customer")
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends Model<Customer> {
	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@TableField(value = "name", exist = true)
	private String name; /* 客户名称 */

	@TableField(value = "tradeType", exist = true)
	private Byte tradeType; /* 行业类型 化工0配电1变电 2 */

	@TableField(value = "title", exist = true)
	private String title; /* 系统标题 */

	@TableField(value = "address", exist = true)
	private String address; /* 地址 */

	@TableField(value = "url", exist = true)
	private String url; /* 公司网址 */

	@TableField(value = "contacts", exist = true)
	private String contacts; /* 联系人 */

	@TableField(value = "contactsJob", exist = true)
	private String contactsJob; /* 联系人职位 */

	@TableField(value = "contactsTel", exist = true)
	private String contactsTel; /* 联系人电话 */

	@TableField(value = "contactsMail", exist = true)
	private String contactsMail; /* 联系人邮件 */

	@TableField(value = "contactsOther", exist = true)
	private String contactsOther; /* 联系人邮件 */

	@TableField(value = "phoneNo", exist = true)
	private String phoneNo; /* 联系方式 */

	@TableField(value = "remark", exist = true)
	private String remark; /* 备注 */
}