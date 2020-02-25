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
 * @类说明 [菜单]实体类
 * @author 高振中
 * @date 2020-02-25 23:40:14
 **/
@Setter
@Getter
@Builder
@TableName(value = "sys_menu")
@AllArgsConstructor
@NoArgsConstructor
public class Menu extends Model<Menu> {
	private static final long serialVersionUID = 1L;
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