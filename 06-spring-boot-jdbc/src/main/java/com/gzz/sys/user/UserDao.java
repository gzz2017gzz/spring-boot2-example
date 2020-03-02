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
 * @date 2020-03-02 23:40:53
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
    	select.append("SELECT t.id,t.name,t.birthday,t.gender");
    	select.append(" FROM sys_user t ");
    	//insert.append("INSERT INTO sys_user (id,name,birthday,gender) ");
    	//insert.append(" VALUES (:id,:name,:birthday,:gender)");
    }

    /**
     * @方法说明  新增【用户】记录
     */
    public int save(User vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO sys_user (id,name,birthday,gender)");
        sql.append(" VALUES (?,?,?,?)");
        Object[] params ={ vo.getId(),vo.getName(),vo.getBirthday(),vo.getGender() };
        //log.info(super.sql(sql.toString(), params));//显示SQL语句
        return jdbcTemplate.update(sql.toString(), params);
    }
    
    /**
     * @方法说明 物理删除【用户】记录(多条)
     */
    public int delete(Object ids[]) {
        String sql = "DELETE FROM sys_user WHERE id IN" + SQLUnit.toIn(ids);
        //log.info(super.sql(sql, ids));//显示SQL语句
        return jdbcTemplate.update(sql,ids);
    }
    
    /**
     * @方法说明 更新【用户】记录
     */
    public int update(User vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE sys_user SET name=?,birthday=?,gender=?");
        sql.append(" WHERE id=? ");
        Object[] params = {vo.getName(),vo.getBirthday(),vo.getGender(),vo.getId()};
        //log.info(super.sql(sql.toString(), params));//显示SQL语句
        return jdbcTemplate.update(sql.toString(), params);
      }

    /**
     * @方法说明 按条件查询分页【用户】列表
     */
    public Page<User> page(UserCond cond) {
        StringBuilder sql = new StringBuilder(select);
        sql.append(cond.where());
        log.info(super.sql(sql.toString(),cond.array()));//显示SQL语句
        return queryPage(sql.toString(), cond, User.class);
    }
    
    /**
     * @方法说明 按条件查询不分页【用户】列表
     */
    public List<User> list(UserCond cond) {
    	StringBuilder sql = new StringBuilder(select);
    	sql.append(cond.where());
    	sql.append(" ORDER BY id DESC");
    	//log.info(super.sql(sql.toString(),cond.array()));//显示SQL语句
    	return jdbcTemplate.query(sql.toString(), cond.array(), new BeanPropertyRowMapper<>(User.class));
    }
    
    /**
     * @方法说明 按ID查找单个【用户】实体
     */
	public User findById(Long id) {
		StringBuilder sql = new StringBuilder(select);
		sql.append(" WHERE t.id=?");
		//log.info(super.sql(sql.toString(),id));//显示SQL语句
		return jdbcTemplate.queryForObject(sql.toString(), new BeanPropertyRowMapper<>(User.class), id);
	}
    
    /**
     * @方法说明 按条件查询【用户】记录个数
     */
	public int count(UserCond cond) {
		String sql = "SELECT COUNT(1) FROM sys_user t " + cond.where();
		//log.info(super.sql(sql,cond.array()));//显示SQL语句
		return jdbcTemplate.queryForObject(sql, cond.array(), Integer.class);
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