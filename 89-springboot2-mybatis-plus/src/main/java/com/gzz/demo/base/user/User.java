package com.gzz.demo.base.user;

import java.util.Date;
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
 * @类说明 【用户】实体类
 * @author 高振中
 * @date 2020-03-17 17:22:53
 **/
@Setter
@Getter
@Builder
@TableName(value = "sys_user")
@AllArgsConstructor
@NoArgsConstructor
public class User extends Model<User> {
	private static final long serialVersionUID = 1L;
//	@NotNull(message = "客户主建(Id)不能为空(数值型)")
//	@NotEmpty(message = "客户名称(name)不能为空(字符型)")
//	@Length(max = 20, min = 10, message = "客户名称(name)长度在有10~20之间(字符型)")
//	@Max(value = 1000, message = "客户年龄(age)最大值是1000(数值型)")
//	@Min(value = 100, message = "客户年龄(age)最小值是100(数值型)")
//	@Pattern(regexp = "^\\d{10}$", message = "必须为10位数字(字符型)")
	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	 * 姓名
	 */
	@TableField(value = "name", exist = true)
	private String name;
	/**
	 * 生日
	 */
	@TableField(value = "birthday", exist = true)
	private Date birthday;
	/**
	 * 性别
	 */
	@TableField(value = "gender", exist = true)
	private Byte gender;
}