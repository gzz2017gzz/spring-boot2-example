package com.gzz.sys.user;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.gzz.common.base.BaseDao;
import com.gzz.common.base.Page;
import com.gzz.common.base.SqlUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * @类说明:用户数据访问层
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 **/
@Repository
@Slf4j
public class UserDao extends BaseDao {
	private StringBuilder select = new StringBuilder();
	private StringBuilder insert = new StringBuilder();

	/**
	 * @方法说明:构造方法,用于拼加SQL及初始化工作
	 **/
	public UserDao() {
		select.append("SELECT t.id,t.name,t.birthday,t.gender");
		select.append(" FROM sys_user t WHERE 1=1");

		insert.append("INSERT INTO sys_user (name,birthday,gender)");
		insert.append(" VALUES (:name,:birthday,:gender)");
	}

	/**
	 * @方法说明:新增用户记录
	 **/
	public int save(User vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO sys_user (id,name,birthday,gender)");
		sql.append(" VALUES (?,?,?,?) ");
		Object[] params = { vo.getId(), vo.getName(), vo.getBirthday(), vo.getGender() };
		log.info(SqlUtil.showSql(sql.toString(), params));// 显示SQL语句
		return jdbcTemplate.update(sql.toString(), params);
	}

	/**
	 * @方法说明:新增用户记录并返回自增涨主键值
	 **/
	public long saveReturnPK(User vo) {
		return saveKey(vo, insert.toString(), "id");
	}

	/**
	 * @方法说明:批量插入用户记录
	 **/
	public int[] insertBatch(List<User> list) {
		return batchOperate(list, insert.toString());
	}

	/**
	 * @方法说明:物理删除用户记录(多条)
	 **/
	public int delete(Object ids[]) {
		String sql = "DELETE FROM sys_user WHERE id IN " + SqlUtil.ArrayToIn(ids);
		return jdbcTemplate.update(sql, ids);
	}

	/**
	 * @方法说明:更新用户记录
	 **/
	public int update(User vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE sys_user SET name=?,birthday=?,gender=?");
		sql.append(" WHERE id=? ");
		Object[] params = { vo.getName(), vo.getBirthday(), vo.getGender(), vo.getId() };
		return jdbcTemplate.update(sql.toString(), params);
	}

	/**
	 * @方法说明:按条件查询分页用户列表
	 **/
	public Page<User> queryPage(UserCond cond) {
		StringBuilder sb = new StringBuilder(select);
		sb.append(cond.getCondition());
		// sb.append(cond.getOrderSql());//增加排序子句;
		log.info(SqlUtil.showSql(sb.toString(), cond.getArray()));// 显示SQL语句
		return queryPage(sb.toString(), cond, User.class);
	}

	/**
	 * @方法说明:按条件查询不分页用户列表
	 **/
	public List<User> queryList(UserCond cond) {
		StringBuilder sb = new StringBuilder(select);
		sb.append(cond.getCondition());
		// sb.append(" ORDER BY operate_time DESC");
		log.info(SqlUtil.showSql(sb.toString(), cond.getArray()));// 显示SQL语句
		return jdbcTemplate.query(sb.toString(), cond.getArray(), new BeanPropertyRowMapper<>(User.class));
	}

	/**
	 * @方法说明:按ID查找单个用户实体
	 **/
	public User findById(Long id) {
		StringBuilder sb = new StringBuilder(select);
		sb.append(" AND t.id=?");
		return jdbcTemplate.queryForObject(sb.toString(), new Object[] { id }, new BeanPropertyRowMapper<>(User.class));
	}

	/**
	 * @方法说明:按条件查询用户记录个数
	 **/
	public long queryCount(UserCond cond) {
		String countSql = "SELECT COUNT(1) FROM sys_user t WHERE 1=1" + cond.getCondition();
		return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
	}

	/**
	 * @方法说明:逻辑删除用户记录(多条)
	 **/
	public int deleteLogic(Long ids[]) {
		String sql = "UPDATE sys_user SET delete_remark=1 WHERE id IN " + SqlUtil.ArrayToIn(ids);
		return jdbcTemplate.update(sql);
	}
}