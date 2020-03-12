package com.gzz.study.sys.syslog;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
/**
 * @类说明 【请求日志】实体类
 * @author 高振中
 * @date 2020-03-12 12:11:06
 **/
@Setter
@Getter
//@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysLog {
//	@NotNull(message = "客户主建(Id)不能为空(数值型)")
//	@NotEmpty(message = "客户名称(name)不能为空(字符型)")
//	@Length(max = 20, min = 10, message = "客户名称(name)长度在有10~20之间(字符型)")
//	@Max(value = 1000, message = "客户年龄(age)最大值是1000(数值型)")
//	@Min(value = 100, message = "客户年龄(age)最小值是100(数值型)")
//	@Pattern(regexp = "^\\d{10}$", message = "必须为10位数字(字符型[正规判断])")
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
	// 以下为查询显示辅助属性
}