package com.gzz.demo.sys.dict;

import com.gzz.common.util.BaseCondition;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @类说明 【枚举字典】DTO对象
 * @author 高振中
 * @date 2020-04-02 20:40:14
 **/
@Setter
@Getter
@Accessors(chain = true)
@Builder	
@AllArgsConstructor
@NoArgsConstructor
public class DictCond extends BaseCondition  {
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 类型名称
	 */
	private String typeName;
	/**
	 * 类型编码
	 */
	private Integer typeCode;
	/**
	 * 数据键
	 */
	private Integer dataKey;
	/**
	 * 数据值
	 */
	private String dataValue;
	/**
	 * 状态1 启动 0 禁用
	 */
	private Byte status;
	/**
	 * 备注
	 */
	private String remark;
}