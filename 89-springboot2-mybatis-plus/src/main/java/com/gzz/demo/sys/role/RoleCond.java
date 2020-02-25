package com.gzz.demo.sys.role;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @类说明 [角色]DTO对象
 * @author 高振中
 * @date 2020-02-25 23:40:14
 **/
@Setter
@Getter
@Accessors(chain = true)
@Builder	
@AllArgsConstructor
@NoArgsConstructor
public class RoleCond{
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