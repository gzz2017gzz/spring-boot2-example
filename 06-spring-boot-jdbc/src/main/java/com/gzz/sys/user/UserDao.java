package com.gzz.sys.user;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import com.gzz.common.base.BaseDao;
import com.gzz.common.base.Page;
import com.gzz.common.base.SQLUnit;
import lombok.extern.slf4j.Slf4j;
/**
 * @类说明 【用户】数据访问层
 * @author 高振中
 * @date 2020-02-28 15:14:25
 **/
@Slf4j
@Repository
public class UserDao extends BaseDao{

//	private StringBuilder insert = new StringBuilder();
    private StringBuilder select = new StringBuilder();

    /**
     * @方法说明 构造方法-拼加SQL
     */
    public UserDao() {
    	select.append("SELECT t.id,t.customerId,t.name,t.loginName,t.password,t.email,t.phoneNo,t.status,t.createTime,t.type,"); 
		select.append("t.updateTime,t.remark");
    	select.append(" FROM sys_user t ");
    	//insert.append("INSERT INTO sys_user (id,customerId,name,loginName,password,email,phoneNo,status,createTime,type,"); 
		//insert.append("updateTime,remark) ");
    	//insert.append(" VALUES (:id,:customerId,:name,:loginName,:password,:email,:phoneNo,:status,:createTime,:type,"); 
		//insert.append(":updateTime,:remark)");
    }

    /**
     * @方法说明  新增【用户】记录
     */
    public int save(User vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO sys_user (id,customerId,name,loginName,password,email,phoneNo,status,createTime,type,"); 
		sql.append("updateTime,remark)");
        sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
        Object[] params ={ vo.getId(),vo.getCustomerId(),vo.getName(),vo.getLoginName(),vo.getPassword(),vo.getEmail(),vo.getPhoneNo(),vo.getStatus(),vo.getCreateTime(),vo.getType(),//太长换行 
		vo.getUpdateTime(),vo.getRemark() };
        //log.info(super.sql(sql.toString(), params));//显示SQL语句
        return jdbcTemplate.update(sql.toString(), params);
    }
    
    /**
     * @方法说明 物理删除【用户】记录(多条)
     */
    public int delete(Object ids[]) {
        String sql = "DELETE FROM sys_user WHERE id IN" + SQLUnit.toIn(ids);
        return jdbcTemplate.update(sql,ids);
    }
    
    /**
     * @方法说明 更新【用户】记录
     */
    public int update(User vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE sys_user SET customerId=?,name=?,loginName=?,password=?,email=?,phoneNo=?,status=?,createTime=?,type=?,updateTime=?,"); 
		sql.append("remark=?");
        sql.append(" WHERE id=? ");
        Object[] params = {vo.getCustomerId(),vo.getName(),vo.getLoginName(),vo.getPassword(),vo.getEmail(),vo.getPhoneNo(),vo.getStatus(),vo.getCreateTime(),vo.getType(),vo.getUpdateTime(),//太长换行 
		vo.getRemark(),vo.getId()};
        return jdbcTemplate.update(sql.toString(), params);
      }

    /**
     * @方法说明 按条件查询分页【用户】列表
     */
    public Page<User> queryPage(UserCond cond) {
        StringBuilder sb = new StringBuilder(select);
        sb.append(cond.where());
        log.info(super.sql(sb.toString(),cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, User.class);
    }
    
    /**
     * @方法说明 按条件查询不分页【用户】列表
     */
    public List<User> queryList(UserCond cond) {
    	StringBuilder sb = new StringBuilder(select);
    	sb.append(cond.where());
    	//sb.append(" ORDER BY id DESC");
    	return jdbcTemplate.query(sb.toString(), cond.getArray(), new BeanPropertyRowMapper<>(User.class));
    }
    
    /**
     * @方法说明 按ID查找单个【用户】实体
     */
	public User findById(Integer id) {
		StringBuilder sb = new StringBuilder(select);
		sb.append(" WHERE t.id=?");
		return jdbcTemplate.queryForObject(sb.toString(), new BeanPropertyRowMapper<>(User.class),id);
	}
    
    /**
     * @方法说明 按条件查询【用户】记录个数
     */
	public long queryCount(UserCond cond) {
		String countSql = "SELECT COUNT(1) FROM sys_user t " + cond.where();
		return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
	}
    
    /**
     * @方法说明 逻辑删除【用户】记录 
     */
//	public int delete(Object ids[]) {
//		String sql = "UPDATE sys_user SET dr=1 WHERE id IN " + SQLUnit.toIn(ids);
//		return jdbcTemplate.update(sql,ids);
//	}
    
    /**
     * @方法说明 新增【用户】记录并返回自增涨主键值
     */
//	public long saveReturnPK(User vo) {
//		return saveKey(vo, insert.toString(), "id");
//	}
    
    /**
     * @方法说明 批量插入【用户】记录
     */
//	public int[] insertBatch(List<User> list) {
//		return batchOperate(list, insert.toString());
//	}    
 
}