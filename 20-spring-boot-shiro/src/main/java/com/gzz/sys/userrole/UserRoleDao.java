package com.gzz.sys.userrole;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.gzz.base.BaseDao;
import com.gzz.base.Page;
import com.gzz.base.SqlUtil;

/**
 * @类说明 [用户角色关系]数据访问层
 * @author 高振中
 * @date 2018-12-24 21:36:34
 **/
@Repository
public class UserRoleDao extends BaseDao {

	private StringBuilder insert = new StringBuilder();
	private StringBuilder select = new StringBuilder();

	/**
	 * @方法说明 构造方法-拼加SQL
	 */
	public UserRoleDao() {
		select.append("SELECT t.user_id,t.role_id");
		select.append(" FROM user_role t WHERE 1=1");

		insert.append("INSERT INTO user_role (role_id) ");
		insert.append(" VALUES (:role_id)");
	}

	/**
	 * @方法说明 新增用户角色关系记录
	 */
	public int save(UserRole vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("REPLACE INTO user_role (user_id,role_id)");
		sql.append(" VALUES (?,?)");
		Object[] params = { vo.getUser_id(), vo.getRole_id() };
		// logger.info(SqlUtil.showSql(sql.toString(), params));//显示SQL语句
		return jdbcTemplate.update(sql.toString(), params);
	}

	/**
	 * @方法说明 新增用户角色关系记录并返回自增涨主键值
	 */
	public long saveReturnPK(UserRole vo) {
		return saveKey(vo, insert.toString(), "user_id");
	}

	/**
	 * @方法说明 批量插入用户角色关系记录
	 */
	public int[] insertBatch(List<UserRole> list) {
		return batchOperate(list, insert.toString());
	}

	/**
	 * @方法说明 物理删除用户角色关系记录(多条)
	 */
	public int delete(Long ids[]) {
		String sql = "DELETE FROM user_role WHERE user_id" + SqlUtil.ArrayToIn(ids);
		return jdbcTemplate.update(sql);
	}

	/**
	 * @方法说明 更新用户角色关系记录
	 */
	public int update(UserRole vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE user_role SET role_id=? ");
		sql.append(" WHERE user_id=? ");
		Object[] params = { vo.getRole_id(), vo.getUser_id() };
		return jdbcTemplate.update(sql.toString(), params);
	}

	/**
	 * @方法说明 按条件查询分页用户角色关系列表
	 */
	public Page<UserRole> queryPage(UserRoleCond cond) {
		StringBuilder sb = new StringBuilder(select);
		sb.append(cond.getCondition());
		// sb.append(cond.getOrderSql());//增加排序子句;
		// logger.info(SqlUtil.showSql(sb.toString(),cond.getArray()));//显示SQL语句
		return queryPage(sb.toString(), cond, UserRole.class);
	}

	/**
	 * @方法说明 按条件查询不分页用户角色关系列表
	 */
	public List<UserRole> queryList(UserRoleCond cond) {
		StringBuilder sb = new StringBuilder(select);
		sb.append(cond.getCondition());
		// sb.append(" ORDER BY operate_time DESC");
		return jdbcTemplate.query(sb.toString(), cond.getArray(), new BeanPropertyRowMapper<>(UserRole.class));
	}

	/**
	 * @方法说明 按ID查找单个用户角色关系实体
	 */
	public UserRole findById(Long id) {
		StringBuilder sb = new StringBuilder(select);
		sb.append(" AND t.user_id=?");
		return jdbcTemplate.queryForObject(sb.toString(), new Object[] { id },
				new BeanPropertyRowMapper<>(UserRole.class));
	}

	/**
	 * @方法说明 按条件查询用户角色关系记录个数
	 */
	public long queryCount(UserRoleCond cond) {
		String countSql = "SELECT COUNT(1) FROM user_role t WHERE 1=1" + cond.getCondition();
		return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
	}

	/**
	 * @方法说明 按条件查询用户角色关系记录个数
	 */
	public int deleteLogic(Long ids[]) {
		String sql = "UPDATE user_role SET delete_remark=1 WHERE user_id" + SqlUtil.ArrayToIn(ids);
		return jdbcTemplate.update(sql);
	}

	public Set<String> queryRoles(Long user_id) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT r.role FROM user_role t JOIN role r ON t.role_id=r.id");
		sb.append("  WHERE t.user_id=?");
		logger.info(SqlUtil.showSql(sb.toString(), new Object[] { user_id }));// 显示SQL语句
		return new HashSet<>(jdbcTemplate.queryForList(sb.toString(), String.class, user_id));
	}
}