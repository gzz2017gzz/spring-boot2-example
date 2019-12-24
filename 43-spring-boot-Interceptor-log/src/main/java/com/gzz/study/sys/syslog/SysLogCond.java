package com.gzz.study.sys.syslog;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
//import lombok.experimental.Accessors;
import com.gzz.common.base.BaseCondition;
/**
 * @类说明 [请求日志]查询条件实体
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
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
		add(id, "AND t.id = ?");
		add(client_ip, "AND t.client_ip LIKE ?", 3);
		add(uri, "AND t.uri LIKE ?", 3);
		add(type, "AND t.type LIKE ?", 3);
		add(method, "AND t.method LIKE ?", 3);
		add(param_data, "AND t.param_data LIKE ?", 3);
		add(session_id, "AND t.session_id LIKE ?", 3);
		add(request_time, "AND t.request_time = ?");
		add(return_time, "AND t.return_time = ?");
		add(return_data, "AND t.return_data LIKE ?", 3);
		add(status_code, "AND t.status_code = ?");
		add(cost_time, "AND t.cost_time = ?");
    	// add(ids, "AND t.id IN ");
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
	// private List<Long> ids;// 主键列表
	// 以下为自定义查询条件
}