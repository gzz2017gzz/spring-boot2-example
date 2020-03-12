package com.gzz.study.sys.syslog;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.gzz.common.base.BaseDao;
import com.gzz.common.base.Page;

import lombok.extern.slf4j.Slf4j;

/**
 * @类说明 【请求日志】数据访问层
 * @author 高振中
 * @date 2020-03-12 12:11:06
 **/
@Slf4j
@Repository
public class SysLogDao extends BaseDao {

	/**
	 * @方法说明 新增【请求日志】记录
	 */
	public int save(SysLog vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO sys_log (id,client_ip,uri,type,method,param_data,session_id,request_time,");
		sql.append("return_time,return_data,status_code,cost_time)");
		sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
		Object[] params = { vo.getId(), vo.getClient_ip(), vo.getUri(), vo.getType(), vo.getMethod(), vo.getParam_data(), vo.getSession_id(), vo.getRequest_time(), // 太长换行
				 vo.getReturn_time(), vo.getReturn_data(), vo.getStatus_code(), vo.getCost_time() };
		// log.info(super.sql(sql.toString(), params));// 显示SQL语句
		return jdbcTemplate.update(sql.toString(), params);
	}

	/**
	 * @方法说明 删除【请求日志】记录
	 */
	public int delete(Object[] ids) {
		String sql = "DELETE FROM sys_log WHERE id IN" + toIn(ids);
		// log.info(super.sql(sql, ids));// 显示SQL语句
		return jdbcTemplate.update(sql, ids);
	}

	/**
	 * @方法说明 更新【请求日志】记录
	 */
	public int update(SysLog vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE sys_log SET client_ip=?,uri=?,type=?,method=?,param_data=?,session_id=?,request_time=?,return_time=?,");
		sql.append("return_data=?,status_code=?,cost_time=?");
		sql.append(" WHERE id=? ");
		Object[] params = {  vo.getClient_ip(), vo.getUri(), vo.getType(), vo.getMethod(), vo.getParam_data(), vo.getSession_id(), vo.getRequest_time(), vo.getReturn_time(), // 太长换行
				 vo.getReturn_data(), vo.getStatus_code(), vo.getCost_time(), vo.getId() };
		// log.info(super.sql(sql.toString(), params));// 显示SQL语句
		return jdbcTemplate.update(sql.toString(), params);
	}

	/**
	 * @方法说明 按条件查询分页【请求日志】列表
	 */
	public Page<SysLog> page(SysLogCond cond) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t.id,t.client_ip,t.uri,t.type,t.method,t.param_data,t.session_id,t.request_time,");
		sql.append("t.return_time,t.return_data,t.status_code,t.cost_time");
		sql.append(" FROM sys_log t");
		sql.append(cond.where());
		log.info(super.sql(sql.toString(), cond.array()));// 显示SQL语句
		return queryPage(sql.toString(), cond, SysLog.class);
	}

	/**
	 * @方法说明 按条件查询不分页【请求日志】列表
	 */
	public List<SysLog> list(SysLogCond cond) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t.id,t.client_ip,t.uri,t.type,t.method,t.param_data,t.session_id,t.request_time,");
		sql.append("t.return_time,t.return_data,t.status_code,t.cost_time");
		sql.append(" FROM sys_log t");
		sql.append(cond.where());
		sql.append(" ORDER BY id DESC");
		// log.info(super.sql(sql.toString(),cond.array()));//显示SQL语句
		return jdbcTemplate.query(sql.toString(), cond.array(), new BeanPropertyRowMapper<>(SysLog.class));
	}

	/**
	 * @方法说明 按主键查找单个【请求日志】记录
	 */
	public SysLog findById(Integer id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t.id,t.client_ip,t.uri,t.type,t.method,t.param_data,t.session_id,t.request_time,");
		sql.append("t.return_time,t.return_data,t.status_code,t.cost_time");
		sql.append(" FROM sys_log t WHERE t.id=?");
		// log.info(super.sql(sql.toString(),id));//显示SQL语句
		return jdbcTemplate.queryForObject(sql.toString(), new BeanPropertyRowMapper<>(SysLog.class), id);
	}

	/**
	 * @方法说明 按条件查询【请求日志】记录个数
	 */
	public int count(SysLogCond cond) {
		String sql = "SELECT COUNT(1) FROM sys_log t " + cond.where();
		// log.info(super.sql(sql,cond.array()));//显示SQL语句
		return jdbcTemplate.queryForObject(sql, cond.array(), Integer.class);
	}

	/**
	 * @方法说明 新增【请求日志】记录并返回自增涨主键值
	 */
	public long saveReturnPK(SysLog vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO sys_log (id,client_ip,uri,type,method,param_data,session_id,request_time,");
		sql.append("return_time,return_data,status_code,cost_time)");
		sql.append(" VALUES (:id,:client_ip,:uri,:type,:method,:param_data,:session_id,:request_time,");
		sql.append(":return_time,:return_data,:status_code,:cost_time)");
		// log.info(super.sql(sql.toString(), vo));// 显示SQL语句
		return saveKey(vo, sql.toString(), "id");
	}

	/**
	 * @方法说明 批量插入【请求日志】记录
	 */
	public int[] insertBatch(List<SysLog> list) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO sys_log (id,client_ip,uri,type,method,param_data,session_id,request_time,");
		sql.append("return_time,return_data,status_code,cost_time)");
		sql.append(" VALUES (:id,:client_ip,:uri,:type,:method,:param_data,:session_id,:request_time,");
		sql.append(":return_time,:return_data,:status_code,:cost_time)");
		// log.info(super.sql(sql.toString(), list));// 显示SQL语句
		return batchOperate(list, sql.toString());
	}

	/**
	 * @方法说明 逻辑删除【请求日志】记录
	 */
//	public int delete(Object... ids) {
//		String sql = "UPDATE sys_log SET dr=1 WHERE id IN " + toIn(ids);
//		return jdbcTemplate.update(sql,ids);
//	}	

}