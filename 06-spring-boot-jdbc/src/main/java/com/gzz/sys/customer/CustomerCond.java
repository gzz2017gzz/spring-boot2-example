package com.gzz.sys.customer;

import java.util.List;

//import lombok.experimental.Accessors;
import com.gzz.common.base.BaseCondition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @类说明 【客户】查询条件实体
 * @author 高振中
 * @date 2020-02-28 14:34:06
 **/
@Setter
@Getter
//@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCond extends BaseCondition {

	/**
	 * @方法说明: 拼加自定义条件
	 **/
	@Override
	public void addCondition() {
		add(id, "AND t.id = ?");
		add(name, "AND t.name LIKE ?", 3);
		add(tradeType, "AND t.tradeType = ?");
		add(title, "AND t.title LIKE ?", 3);
		add(address, "AND t.address LIKE ?", 3);
		add(url, "AND t.url LIKE ?", 3);
		add(contacts, "AND t.contacts LIKE ?", 3);
		add(contactsJob, "AND t.contactsJob LIKE ?", 3);
		add(contactsTel, "AND t.contactsTel LIKE ?", 3);
		add(contactsMail, "AND t.contactsMail LIKE ?", 3);
		add(contactsOther, "AND t.contactsOther LIKE ?", 3);
		add(phoneNo, "AND t.phoneNo LIKE ?", 3);
		add(remark, "AND t.remark LIKE ?", 3);
		add(ids, "AND t.id IN ");
	}

//	以下为查询条件
	private Integer id; // 主键
	private String name; // 客户名称
	private Byte tradeType; // 行业类型 化工0配电1变电 2
	private String title; // 系统标题
	private String address; // 地址
	private String url; // 公司网址
	private String contacts; // 联系人
	private String contactsJob; // 联系人职位
	private String contactsTel; // 联系人电话
	private String contactsMail; // 联系人邮件
	private String contactsOther; // 联系人邮件
	private String phoneNo; // 联系方式
	private String remark; // 备注
	private List<Object> ids;// 主键列表
//	以下为自定义查询条件
}