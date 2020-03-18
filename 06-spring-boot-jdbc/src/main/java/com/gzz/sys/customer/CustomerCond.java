package com.gzz.sys.customer;

import java.util.List;

import com.gzz.common.base.BaseCondition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @类说明 【客户】查询条件
 * @author 高振中
 * @date 2020-03-18 14:31:03
 **/
@Setter
@Getter
//@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "【客户】查询条件")
public class CustomerCond extends BaseCondition {

	/**
	 * @方法说明: 拼加自定义条件
	 **/
	@Override
	public void addCondition() {
		add("AND t.id = ?", id);
		add("AND t.name LIKE ?", name, 3);
		add("AND t.tradeType = ?", tradeType);
		add("AND t.title LIKE ?", title, 3);
		add("AND t.address LIKE ?", address, 3);
		add("AND t.url LIKE ?", url, 3);
		add("AND t.contacts LIKE ?", contacts, 3);
		add("AND t.contactsJob LIKE ?", contactsJob, 3);
		add("AND t.contactsTel LIKE ?", contactsTel, 3);
		add("AND t.contactsMail LIKE ?", contactsMail, 3);
		add("AND t.contactsOther LIKE ?", contactsOther, 3);
		add("AND t.phoneNo LIKE ?", phoneNo, 3);
		add("AND t.remark LIKE ?", remark, 3);
		add("AND t.id IN", ids);
	}

	// 以下为查询条件
	@ApiModelProperty("主键")
	private Integer id; // 主键
	@ApiModelProperty("客户名称")
	private String name; // 客户名称
	@ApiModelProperty("行业类型 化工0配电1变电 2")
	private Byte tradeType; // 行业类型 化工0配电1变电 2
	@ApiModelProperty("系统标题")
	private String title; // 系统标题
	@ApiModelProperty("地址")
	private String address; // 地址
	@ApiModelProperty("公司网址")
	private String url; // 公司网址
	@ApiModelProperty("联系人")
	private String contacts; // 联系人
	@ApiModelProperty("联系人职位")
	private String contactsJob; // 联系人职位
	@ApiModelProperty("联系人电话")
	private String contactsTel; // 联系人电话
	@ApiModelProperty("联系人邮件")
	private String contactsMail; // 联系人邮件
	@ApiModelProperty("联系人邮件")
	private String contactsOther; // 联系人邮件
	@ApiModelProperty("联系方式")
	private String phoneNo; // 联系方式
	@ApiModelProperty("备注")
	private String remark; // 备注
	@ApiModelProperty("主键数组")
	private List<Object> ids;// 主键列表
	// 以下为自定义查询条件
}