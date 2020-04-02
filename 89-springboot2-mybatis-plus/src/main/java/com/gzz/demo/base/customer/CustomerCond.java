package com.gzz.demo.base.customer;

import com.gzz.common.util.BaseCondition;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @类说明 【客户】DTO对象
 * @author 高振中
 * @date 2020-04-02 20:56:51
 **/
@Setter
@Getter
@Accessors(chain = true)
@Builder	
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCond extends BaseCondition  {
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 客户名称
	 */
	private String name;
	/**
	 * 行业类型 化工0配电1变电 2
	 */
	private Byte tradeType;
	/**
	 * 系统标题
	 */
	private String title;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 公司网址
	 */
	private String url;
	/**
	 * 联系人
	 */
	private String contacts;
	/**
	 * 联系人职位
	 */
	private String contactsJob;
	/**
	 * 联系人电话
	 */
	private String contactsTel;
	/**
	 * 联系人邮件
	 */
	private String contactsMail;
	/**
	 * 联系人邮件
	 */
	private String contactsOther;
	/**
	 * 联系方式
	 */
	private String phoneNo;
	/**
	 * 备注
	 */
	private String remark;
}