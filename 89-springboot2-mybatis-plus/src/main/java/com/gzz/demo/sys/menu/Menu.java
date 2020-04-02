package com.gzz.demo.sys.menu;

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
 * @类说明 【菜单】实体类
 * @author 高振中
 * @date 2020-04-02 20:40:14
 **/
@Setter
@Getter
@Builder
@TableName(value = "sys_menu")
@AllArgsConstructor
@NoArgsConstructor
public class Menu extends Model<Menu> {
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
	private Integer id;
	/**
	 * 上级主键
	 */
	@TableField(value = "parentId", exist = true)
	private Integer parentId;
	/**
	 * 层级
	 */
	@TableField(value = "level", exist = true)
	private Integer level;
	/**
	 * 类型
	 */
	@TableField(value = "type", exist = true)
	private Byte type;
	/**
	 * 图标
	 */
	@TableField(value = "icon", exist = true)
	private String icon;
	/**
	 * 名称
	 */
	@TableField(value = "name", exist = true)
	private String name;
	/**
	 * 路径
	 */
	@TableField(value = "path", exist = true)
	private String path;
	/**
	 * 排序编号
	 */
	@TableField(value = "orderNum", exist = true)
	private Integer orderNum;
	/**
	 * 备注
	 */
	@TableField(value = "remark", exist = true)
	private String remark;
}