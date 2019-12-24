package com.gzz.study.sys.syslog;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
//import lombok.experimental.Accessors;
/**
 * @类说明 [请求日志]实体类
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 **/
@Setter
@Getter
//@Accessors(chain = true)
@Builder	
@AllArgsConstructor
@NoArgsConstructor
public class SysLog {
    // 以下为数据库中 字段
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
    // 以下为查询显示示辅助属性
}