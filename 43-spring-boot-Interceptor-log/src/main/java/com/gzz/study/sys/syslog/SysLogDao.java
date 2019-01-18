package com.gzz.study.sys.syslog;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import com.gzz.common.base.BaseDao;
import com.gzz.common.base.Page;
import com.gzz.common.base.SqlUtil;
/**
 * @类说明 [请求日志]数据访问层
 * @author 高振中
 * @date 2019-01-12 23:40:32
 **/
@Repository
public class SysLogDao extends BaseDao{

    private StringBuilder insert = new StringBuilder();
    private StringBuilder select = new StringBuilder();

    /**
     * @方法说明 构造方法-拼加SQL 
     */
    public SysLogDao () {
    	select.append("SELECT t.id,t.client_ip,t.uri,t.type,t.method,t.param_data,t.session_id,t.request_time,t.return_time,t.return_data,"); 
		select.append("t.status_code,t.cost_time");
    	select.append(" FROM sys_log t WHERE 1=1");
		
        insert.append("INSERT INTO sys_log (client_ip,uri,type,method,param_data,session_id,request_time,return_time,return_data,"); 
		insert.append("status_code,cost_time) ");
        insert.append(" VALUES (:client_ip,:uri,:type,:method,:param_data,:session_id,:request_time,:return_time,:return_data,"); 
		insert.append(":status_code,:cost_time)");
    }

    /**
     * @方法说明  新增请求日志记录
     */
    public int save(SysLog vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO sys_log (id,client_ip,uri,type,method,param_data,session_id,request_time,return_time,return_data,"); 
		sql.append("status_code,cost_time)");
        sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
        Object[] params ={ vo.getId(),vo.getClient_ip(),vo.getUri(),vo.getType(),vo.getMethod(),vo.getParam_data(),vo.getSession_id(),vo.getRequest_time(),vo.getReturn_time(),vo.getReturn_data(),vo.getStatus_code(),vo.getCost_time() };
        //logger.info(SqlUtil.showSql(sql.toString(), params));//显示SQL语句
        return jdbcTemplate.update(sql.toString(), params);
    }
    
    /**
     * @方法说明 新增请求日志记录并返回自增涨主键值
     */
    public long saveReturnPK(SysLog vo) {
         return saveKey(vo, insert.toString(), "id");
    }
    
    /**
     * @方法说明 批量插入请求日志记录
     */
    public int[] insertBatch(List<SysLog> list) {
       return batchOperate(list, insert.toString());
    }
    
    /**
     * @方法说明 物理删除请求日志记录(多条)
     */
    public int delete(Integer ids[]) {
        String sql = "DELETE FROM sys_log WHERE id" + SqlUtil.ArrayToIn(ids);
        return jdbcTemplate.update(sql);
    }
    
    /**
     * @方法说明 更新请求日志记录
     */
    public int update(SysLog vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE sys_log SET client_ip=?,uri=?,type=?,method=?,param_data=?,session_id=?,request_time=?,return_time=?,return_data=?,"); 
		sql.append("status_code=?,cost_time=? ");
        sql.append(" WHERE id=? ");
        Object[] params = {vo.getClient_ip(),vo.getUri(),vo.getType(),vo.getMethod(),vo.getParam_data(),vo.getSession_id(),vo.getRequest_time(),vo.getReturn_time(),vo.getReturn_data(),vo.getStatus_code(),vo.getCost_time(),vo.getId()};
        return jdbcTemplate.update(sql.toString(), params);
      }

    /**
     * @方法说明 按条件查询分页请求日志列表
     */
    public Page<SysLog> queryPage(SysLogCond cond) {
        StringBuilder sb = new StringBuilder(select);
        sb.append(cond.getCondition());
        //sb.append(cond.getOrderSql());//增加排序子句;
        //logger.info(SqlUtil.showSql(sb.toString(),cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, SysLog.class);
    }
    
    /**
     * @方法说明 按条件查询不分页请求日志列表
     */
    public List<SysLog> queryList(SysLogCond cond) {
    	StringBuilder sb = new StringBuilder(select);
    	sb.append(cond.getCondition());
    	//sb.append(" ORDER BY operate_time DESC");
    	return jdbcTemplate.query(sb.toString(), cond.getArray(), new BeanPropertyRowMapper<>(SysLog.class));
    }
    
    /**
     * @方法说明 按ID查找单个请求日志实体
     */
    public SysLog findById(Integer id) {
    	StringBuilder sb = new StringBuilder(select);
    	sb.append(" AND t.id=?");
    	return jdbcTemplate.queryForObject(sb.toString(), new Object[]{id}, new BeanPropertyRowMapper<>(SysLog.class));
    }
    
    /**
     * @方法说明 按条件查询请求日志记录个数
     */
    public long queryCount(SysLogCond cond) {
    	String countSql = "SELECT COUNT(1) FROM sys_log t WHERE 1=1" + cond.getCondition();
    	return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
    }
    
    /**
     * @方法说明 按条件查询请求日志记录个数
     */
    public int deleteLogic(Integer ids[]) {
    	String sql = "UPDATE sys_log SET delete_remark=1 WHERE id" + SqlUtil.ArrayToIn(ids);
    	return jdbcTemplate.update(sql);
    }
 
}