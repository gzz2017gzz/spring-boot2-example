package com.gzz.study.sys.syslog;


import java.util.List;

import com.gzz.common.base.BaseCondition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @类说明 【请求日志】查询条件实体
 * @author 高振中
 * @date 2020-03-12 12:11:06
 **/
@Setter
@Getter
//@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysLogCond extends BaseCondition {

	/**
	 * @方法说明: 拼加自定义条件
	 **/
	@Override
	public void addCondition() {
		add("AND t.id = ?", id);
		add("AND t.client_ip LIKE ?", client_ip, 3);
		add("AND t.uri LIKE ?", uri, 3);
		add("AND t.type LIKE ?", type, 3);
		add("AND t.method LIKE ?", method, 3);
		add("AND t.param_data LIKE ?", param_data, 3);
		add("AND t.session_id LIKE ?", session_id, 3);
		add("AND t.request_time = ?", request_time);
		add("AND t.return_time = ?", return_time);
		add("AND t.return_data LIKE ?", return_data, 3);
		add("AND t.status_code = ?", status_code);
		add("AND t.cost_time = ?", cost_time);
		add("AND t.id IN", ids);
	}

	// 以下为查询条件
	private Integer id; // 主键
	private String client_ip; // 客户端IP
	private String uri; // 请求地址
	private String type; // 请求方式,普通,ajax
	private String method; // method post get等
	private String param_data; // 参数json
	private String session_id; // sessionID
	private Long request_time; // request_time
	private Long return_time; // return_time
	private String return_data; // 返回json
	private Integer status_code; // httpStatusCode
	private Integer cost_time; // 耗时-毫秒）
	private List<Object> ids;// 主键列表
	// 以下为自定义查询条件
}