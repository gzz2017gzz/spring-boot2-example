package com.gzz.sys.customer;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @类说明 【客户】实体
 * @author 高振中
 * @date 2020-03-18 14:31:03
 **/
@Setter
@Getter
//@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "【客户】实体")
public class Customer {
//	@NotNull(message = "客户主建(Id)不能为空(数值型)")
//	@NotEmpty(message = "客户名称(name)不能为空(字符型)")
//	@Length(max = 20, min = 10, message = "客户名称(name)长度在有10~20之间(字符型)")
//	@Max(value = 1000, message = "客户年龄(age)最大值是1000(数值型)")
//	@Min(value = 100, message = "客户年龄(age)最小值是100(数值型)")
//	@Pattern(regexp = "^\\d{10}$", message = "必须为10位数字(字符型[正规判断])")
	// 以下为数据库中 字段
	@ApiModelProperty("主键")
	private Integer id; // 主键
	@ApiModelProperty("客户名称")
	private String name; // 客户名称
	@ApiModelProperty("行业类型 化工0配电1变电 2")
	private Byte tradeType; // 行业类型 化工0配电1变电 2
	@ApiModelProperty("系统标题")
	private String title; // 系统标题
	@ApiModelProperty("地址")
	private String address; // 地址
	@ApiModelProperty("公司网址")
	private String url; // 公司网址
	@ApiModelProperty("联系人")
	private String contacts; // 联系人
	@ApiModelProperty("联系人职位")
	private String contactsJob; // 联系人职位
	@ApiModelProperty("联系人电话")
	private String contactsTel; // 联系人电话
	@ApiModelProperty("联系人邮件")
	private String contactsMail; // 联系人邮件
	@ApiModelProperty("联系人邮件")
	private String contactsOther; // 联系人邮件
	@ApiModelProperty("联系方式")
	private String phoneNo; // 联系方式
	@ApiModelProperty("备注")
	private String remark; // 备注
	// 以下为查询显示辅助属性
}