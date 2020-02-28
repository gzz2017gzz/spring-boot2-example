package com.gzz.sys.user;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
//import lombok.experimental.Accessors;
import com.gzz.common.base.BaseCondition;
/**
 * @类说明 【用户】查询条件实体
 * @author 高振中
 * @date 2020-02-28 15:14:25
 **/
@Setter
@Getter
//@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCond extends BaseCondition {

    /**
     * @方法说明: 拼加自定义条件
     **/
    @Override
    public void addCondition() {
		add(id, "AND t.id = ?");
		add(customerId, "AND t.customerId = ?");
		add(name, "AND t.name LIKE ?", 3);
		add(loginName, "AND t.loginName LIKE ?", 3);
		add(password, "AND t.password LIKE ?", 3);
		add(email, "AND t.email LIKE ?", 3);
		add(phoneNo, "AND t.phoneNo LIKE ?", 3);
		add(status, "AND t.status = ?");
		add(createTime, "AND t.createTime = ?");
		add(type, "AND t.type = ?");
		add(updateTime, "AND t.updateTime = ?");
		add(remark, "AND t.remark LIKE ?", 3);
//		add(ids, "AND t.id IN ");
    }
//	以下为查询条件
	private Integer id; // 主键
	private Integer customerId; // 客户主键
	private String name; // 用户名
	private String loginName; // 登录名
	private String password; // 密码
	private String email; // 邮箱
	private String phoneNo; // 手机号
	private Byte status; // 1启用0禁用
	private Date createTime; // 创建时间
	private Byte type; // 1内置2普通
	private Date updateTime; // 修改时间
	private String remark; // 备注
//	private List<Object> ids;// 主键列表
//	以下为自定义查询条件
}