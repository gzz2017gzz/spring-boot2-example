package com.gzz.demo.base.customer;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @类说明 【客户】实体类
 * @author 高振中
 * @date 2020-04-02 21:16:38
 **/
@Setter
@Getter
@Builder
@TableName(value = "sys_customer")
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends Model<Customer> {
	private static final long serialVersionUID = 1L;
//	@NotNull(message = "客户主建(Id)不能为空(数值型)")
//	@NotEmpty(message = "客户名称(name)不能为空(字符型)")
//	@Length(max = 20, min = 10, message = "客户名称(name)长度在有10~20之间(字符型)")
//	@Max(value = 1000, message = "客户年龄(age)最大值是1000(数值型)")
//	@Min(value = 100, message = "客户年龄(age)最小值是100(数值型)")
//	@Pattern(regexp = "^\\d{10}$", message = "必须为10位数字(字符型)")
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id; /* -主键 */
	private String name; /* -客户名称 */
	private Byte tradeType; /* -行业类型 化工0配电1变电 2 */
	private String title; /* -系统标题 */
	private String address; /* -地址 */
	private String url; /* -公司网址 */
	private String contacts; /* -联系人 */
	private String contactsJob; /* -联系人职位 */
	private String contactsTel; /* -联系人电话 */
	private String contactsMail; /* -联系人邮件 */
	private String contactsOther; /* -联系人邮件 */
	private String phoneNo; /* -联系方式 */
	private String remark; /* -备注 */
}