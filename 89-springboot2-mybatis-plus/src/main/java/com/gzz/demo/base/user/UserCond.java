package com.gzz.demo.base.user;

import java.util.Date;
import com.gzz.common.util.BaseCondition;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @类说明 【用户】DTO对象
 * @author 高振中
 * @date 2020-04-02 20:56:51
 **/
@Setter
@Getter
@Accessors(chain = true)
@Builder	
@AllArgsConstructor
@NoArgsConstructor
public class UserCond extends BaseCondition  {
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 生日
	 */
	private Date birthday;
	/**
	 * 性别
	 */
	private Byte gender;
}