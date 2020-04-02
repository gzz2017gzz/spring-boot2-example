package com.gzz.demo.sys.dict;

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
 * @类说明 【枚举字典】实体类
 * @author 高振中
 * @date 2020-04-02 20:40:14
 **/
@Setter
@Getter
@Builder
@TableName(value = "sys_dict")
@AllArgsConstructor
@NoArgsConstructor
public class Dict extends Model<Dict> {
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
	 * 类型名称
	 */
	@TableField(value = "typeName", exist = true)
	private String typeName;
	/**
	 * 类型编码
	 */
	@TableField(value = "typeCode", exist = true)
	private Integer typeCode;
	/**
	 * 数据键
	 */
	@TableField(value = "dataKey", exist = true)
	private Integer dataKey;
	/**
	 * 数据值
	 */
	@TableField(value = "dataValue", exist = true)
	private String dataValue;
	/**
	 * 状态1 启动 0 禁用
	 */
	@TableField(value = "status", exist = true)
	private Byte status;
	/**
	 * 备注
	 */
	@TableField(value = "remark", exist = true)
	private String remark;
}