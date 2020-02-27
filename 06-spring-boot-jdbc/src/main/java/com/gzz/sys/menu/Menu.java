package com.gzz.sys.menu;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * @类说明 [菜单]实体类
 * @author 高振中
 * @date 2020-02-26 22:07:45
 **/
@Setter
@Getter
@Builder	
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    // 以下为数据库中 字段
	private Integer id; // 主键
	private Integer parentId; // 上级主键
	private Integer level; // 层级
	private Byte type; // 类型
	private String icon; // 图标
	private String name; // 名称
	private String path; // 路径
	private Integer orderNum; // 排序编号
	private String remark; // 备注
    // 以下为查询显示辅助属性
}