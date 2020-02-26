package com.gzz.demo.base.customer;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @类说明 【客户】DTO对象
 * @author 高振中
 * @date 2020-02-26 01:03:39
 **/
@Setter
@Getter
@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCond {
	private Integer id; /* 主键 */
	private String name; /* 客户名称 */
	private Byte tradeType; /* 行业类型 化工0配电1变电 2 */
	private String title; /* 系统标题 */
	private String address; /* 地址 */
	private String url; /* 公司网址 */
	private String contacts; /* 联系人 */
	private String contactsJob; /* 联系人职位 */
	private String contactsTel; /* 联系人电话 */
	private String contactsMail; /* 联系人邮件 */
	private String contactsOther; /* 联系人邮件 */
	private String phoneNo; /* 联系方式 */
	private String remark; /* 备注 */
}