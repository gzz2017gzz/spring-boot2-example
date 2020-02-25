package com.gzz.demo.sys.menu;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @类说明 [菜单]DTO对象
 * @author 高振中
 * @date 2020-02-25 23:40:14
 **/
@Setter
@Getter
@Accessors(chain = true)
@Builder	
@AllArgsConstructor
@NoArgsConstructor
public class MenuCond{
    /**
     * 主键
     */
    private Integer id;
    /**
     * 上级主键
     */
    private Integer parentId;
    /**
     * 层级
     */
    private Integer level;
    /**
     * 类型
     */
    private Byte type;
    /**
     * 图标
     */
    private String icon;
    /**
     * 名称
     */
    private String name;
    /**
     * 路径
     */
    private String path;
    /**
     * 排序编号
     */
    private Integer orderNum;
    /**
     * 备注
     */
    private String remark;
}