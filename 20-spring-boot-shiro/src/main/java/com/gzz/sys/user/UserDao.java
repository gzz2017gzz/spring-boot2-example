package com.gzz.sys.user;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.gzz.base.BaseDao;
import com.gzz.base.Page;
import com.gzz.base.SqlUtil;

/**
 * @类说明 [用户]数据访问层
 * @author 高振中
 * @date 2018-12-24 21:36:34
 **/
@Repository
public class UserDao extends BaseDao {

	private StringBuilder insert = new StringBuilder();
	private StringBuilder select = new StringBuilder();

	/**
	 * @方法说明 构造方法-拼加SQL
	 */
	public UserDao() {
		select.append("SELECT t.id,t.name,t.password,t.salt,t.locked");
		select.append(" FROM user t WHERE 1=1");

		insert.append("INSERT INTO user (name,password,salt,locked) ");
		insert.append(" VALUES (:name,:password,:salt,:locked)");
	}

	/**
	 * @方法说明 新增用户记录
	 */
	public int save(User vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("REPLACE INTO user (id,name,password,salt,locked)");
		sql.append(" VALUES (?,?,?,?,?)");
		Object[] params = { vo.getId(), vo.getName(), vo.getPassword(), vo.getSalt(), vo.getLocked() };
		// logger.info(SqlUtil.showSql(sql.toString(), params));//显示SQL语句
		return jdbcTemplate.update(sql.toString(), params);
	}

	/**
	 * @方法说明 新增用户记录并返回自增涨主键值
	 */
	public long saveReturnPK(User vo) {
		return saveKey(vo, insert.toString(), "id");
	}

	/**
	 * @方法说明 批量插入用户记录
	 */
	public int[] insertBatch(List<User> list) {
		return batchOperate(list, insert.toString());
	}

	/**
	 * @方法说明 物理删除用户记录(多条)
	 */
	public int delete(Long ids[]) {
		String sql = "DELETE FROM user WHERE id" + SqlUtil.ArrayToIn(ids);
		return jdbcTemplate.update(sql);
	}

	/**
	 * @方法说明 更新用户记录
	 */
	public int update(User vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE user SET name=?,password=?,salt=?,locked=? ");
		sql.append(" WHERE id=? ");
		Object[] params = { vo.getName(), vo.getPassword(), vo.getSalt(), vo.getLocked(), vo.getId() };
		return jdbcTemplate.update(sql.toString(), params);
	}

	/**
	 * @方法说明 按条件查询分页用户列表
	 */
	public Page<User> queryPage(UserCond cond) {
		StringBuilder sb = new StringBuilder(select);
		sb.append(cond.getCondition());
		// sb.append(cond.getOrderSql());//增加排序子句;
		// logger.info(SqlUtil.showSql(sb.toString(),cond.getArray()));//显示SQL语句
		return queryPage(sb.toString(), cond, User.class);
	}

	/**
	 * @方法说明 按条件查询不分页用户列表
	 */
	public List<User> queryList(UserCond cond) {
		StringBuilder sb = new StringBuilder(select);
		sb.append(cond.getCondition());
		logger.info(SqlUtil.showSql(sb.toString(), cond.getArray()));// 显示SQL语句
		return jdbcTemplate.query(sb.toString(), cond.getArray(), new BeanPropertyRowMapper<>(User.class));
	}

	/**
	 * @方法说明 按ID查找单个用户实体
	 */
	public User findById(Long id) {
		StringBuilder sb = new StringBuilder(select);
		sb.append(" AND t.id=?");
		return jdbcTemplate.queryForObject(sb.toString(), new Object[] { id }, new BeanPropertyRowMapper<>(User.class));
	}

	/**
	 * @方法说明 按条件查询用户记录个数
	 */
	public long queryCount(UserCond cond) {
		String countSql = "SELECT COUNT(1) FROM user t WHERE 1=1" + cond.getCondition();
		return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
	}

	/**
	 * @方法说明 按条件查询用户记录个数
	 */
	public int deleteLogic(Long ids[]) {
		String sql = "UPDATE user SET delete_remark=1 WHERE id" + SqlUtil.ArrayToIn(ids);
		return jdbcTemplate.update(sql);
	}

}