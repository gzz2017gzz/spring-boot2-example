package com.gzz.sys.user;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.gzz.common.base.BaseDao;
import com.gzz.common.base.Page;

import lombok.extern.slf4j.Slf4j;

/**
 * @类说明 【用户】数据访问层
 * @author 高振中
 * @date 2020-03-18 13:56:40
 **/
@Slf4j
@Repository
public class UserDao extends BaseDao {

	/**
	 * @方法说明 新增【用户】记录
	 */
	public int save(User vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO sys_user (id,name,birthday,gender)");
		sql.append(" VALUES (?,?,?,?)");
		Object[] params = { vo.getId(), vo.getName(), vo.getBirthday(), vo.getGender() };
		// log.info(super.sql(sql.toString(), params));// 显示SQL语句
		return jdbcTemplate.update(sql.toString(), params);
	}

	/**
	 * @方法说明 删除【用户】记录
	 */
	public int delete(Object[] ids) {
		String sql = "DELETE FROM sys_user WHERE id IN" + toIn(ids);
		// log.info(super.sql(sql, ids));// 显示SQL语句
		return jdbcTemplate.update(sql, ids);
	}

	/**
	 * @方法说明 更新【用户】记录
	 */
	public int update(User vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE sys_user SET id=?,name=?,birthday=?,gender=?");
		sql.append(" WHERE id=? ");
		Object[] params = { vo.getName(), vo.getBirthday(), vo.getGender(), vo.getId() };
		// log.info(super.sql(sql.toString(), params));// 显示SQL语句
		return jdbcTemplate.update(sql.toString(), params);
	}

	/**
	 * @方法说明 按条件查询分页【用户】列表
	 */
	public Page<User> page(UserCond cond) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t.id,t.name,t.birthday,t.gender");
		sql.append(" FROM sys_user t");
		sql.append(cond.where());
		log.info(super.sql(sql.toString(), cond.array()));// 显示SQL语句
		return queryPage(sql.toString(), cond, User.class);
	}

	/**
	 * @方法说明 按条件查询不分页【用户】列表
	 */
	public List<User> list(UserCond cond) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t.id,t.name,t.birthday,t.gender");
		sql.append(" FROM sys_user t");
		sql.append(cond.where());
		sql.append(" ORDER BY id DESC");
		// log.info(super.sql(sql.toString(),cond.array()));//显示SQL语句
		return jdbcTemplate.query(sql.toString(), cond.array(), new BeanPropertyRowMapper<>(User.class));
	}

	/**
	 * @方法说明 按主键查找单个【用户】记录
	 */
	public User findById(Long id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t.id,t.name,t.birthday,t.gender");
		sql.append(" FROM sys_user t WHERE t.id=?");
		// log.info(super.sql(sql.toString(),id));//显示SQL语句
		return jdbcTemplate.queryForObject(sql.toString(), new BeanPropertyRowMapper<>(User.class), id);
	}

	/**
	 * @方法说明 按条件查询【用户】记录个数
	 */
	public int count(UserCond cond) {
		String sql = "SELECT COUNT(1) FROM sys_user t " + cond.where();
		// log.info(super.sql(sql,cond.array()));//显示SQL语句
		return jdbcTemplate.queryForObject(sql, cond.array(), Integer.class);
	}

	/**
	 * @方法说明 新增【用户】记录并返回自增涨主键值
	 */
	public long saveReturnPK(User vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO sys_user (id,name,birthday,gender)");
		sql.append(" VALUES (:id,:name,:birthday,:gender)");
		// log.info(super.sqlp(sql.toString(), vo));// 显示SQL语句
		return saveKey(vo, sql.toString(), "id");
	}

	/**
	 * @方法说明 批量插入【用户】记录
	 */
	public int[] insertBatch(List<User> list) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO sys_user (id,name,birthday,gender)");
		sql.append(" VALUES (:id,:name,:birthday,:gender)");
		// log.info(super.sqlp(sql.toString(), list));// 显示SQL语句
		return batchOperate(list, sql.toString());
	}

	/**
	 * @方法说明 逻辑删除【用户】记录
	 */
//	public int delete(Object... ids) {
//		String sql = "UPDATE sys_user SET dr=1 WHERE id IN " + toIn(ids);
//		return jdbcTemplate.update(sql,ids);
//	}	

}