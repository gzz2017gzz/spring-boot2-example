package com.gzz.sys.menu;
import java.util.List;

import com.gzz.common.base.BaseCondition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * @类说明 [菜单]查询条件实体
 * @author 高振中
 * @date 2020-02-26 22:07:45
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuCond extends BaseCondition {

    /**
     * @方法说明: 拼加自定义条件
     **/
    @Override
    public void addCondition() {
		add(id, "AND t.id = ?");
		add(parentId, "AND t.parentId = ?");
		add(level, "AND t.level = ?");
		add(type, "AND t.type = ?");
		add(icon, "AND t.icon LIKE ?", 3);
		add(name, "AND t.name LIKE ?", 3);
		add(path, "AND t.path LIKE ?", 3);
		add(orderNum, "AND t.orderNum = ?");
		add(remark, "AND t.remark LIKE ?", 3);
 		add(ids, "AND t.id IN ");
    }
//	以下为查询条件
	private Integer id; // 主键
	private Integer parentId; // 上级主键
	private Integer level; // 层级
	private Byte type; // 类型
	private String icon; // 图标
	private String name; // 名称
	private String path; // 路径
	private Integer orderNum; // 排序编号
	private String remark; // 备注
	private List<Object> ids;// 主键列表
//	以下为自定义查询条件
}