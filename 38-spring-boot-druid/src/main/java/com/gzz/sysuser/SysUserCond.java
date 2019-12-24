package com.gzz.sysuser;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
//import lombok.experimental.Accessors;
import com.gzz.common.base.BaseCondition;
/**
 * @类说明 [用户]查询条件实体
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 **/
@Setter
@Getter
//@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysUserCond extends BaseCondition {

    /**
     * @方法说明: 拼加自定义条件
     **/
    @Override
    public void addCondition() {
		add(id, "AND t.id = ?");
		add(name, "AND t.name LIKE ?", 3);
		add(birthday, "AND t.birthday = ?");
		add(gender, "AND t.gender = ?");
    	// add(ids, "AND t.id IN ");
    }
    // 以下为查询条件
	private Long id; // 主键
	private String name; // 姓名
	private Date birthday; // 生日
	private Byte gender; // 性别
	// private List<Long> ids;// 主键列表
	// 以下为自定义查询条件
}