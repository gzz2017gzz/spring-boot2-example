package com.gzz.sys.user;


import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @类说明 【用户】实体
 * @author 高振中
 * @date 2020-03-18 13:56:40
 **/
@Setter
@Getter
//@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "【用户】实体")
public class User {
//	@NotNull(message = "客户主建(Id)不能为空(数值型)")
//	@NotEmpty(message = "客户名称(name)不能为空(字符型)")
//	@Length(max = 20, min = 10, message = "客户名称(name)长度在有10~20之间(字符型)")
//	@Max(value = 1000, message = "客户年龄(age)最大值是1000(数值型)")
//	@Min(value = 100, message = "客户年龄(age)最小值是100(数值型)")
//	@Pattern(regexp = "^\\d{10}$", message = "必须为10位数字(字符型[正规判断])")
	// 以下为数据库中 字段
	@ApiModelProperty("主键")
	private Long id; // 主键
	@ApiModelProperty("姓名")
	private String name; // 姓名
	@ApiModelProperty("生日")
	private Date birthday; // 生日
	@ApiModelProperty("性别")
	private Byte gender; // 性别
	// 以下为查询显示辅助属性
}