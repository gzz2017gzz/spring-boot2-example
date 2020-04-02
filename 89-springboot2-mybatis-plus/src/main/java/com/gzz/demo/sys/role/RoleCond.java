package com.gzz.demo.sys.role;

import com.gzz.common.util.BaseCondition;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @类说明 【角色】DTO对象
 * @author 高振中
 * @date 2020-04-02 20:40:14
 **/
@Setter
@Getter
@Accessors(chain = true)
@Builder	
@AllArgsConstructor
@NoArgsConstructor
public class RoleCond extends BaseCondition  {
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 客户主键
	 */
	private Integer customerId;
	/**
	 * 角色名称
	 */
	private String name;
	/**
	 * 备注
	 */
	private String remark;
}