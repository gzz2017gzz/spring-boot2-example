package com.gzz.sys.rolefunction;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.gzz.base.BaseDao;
import com.gzz.base.Page;
import com.gzz.base.SqlUtil;

/**
 * @类说明 [角色功能关系]数据访问层
 * @author 高振中
 * @date 2018-12-24 21:36:34
 **/
@Repository
public class RoleFunctionDao extends BaseDao {

	private StringBuilder insert = new StringBuilder();
	private StringBuilder select = new StringBuilder();

	/**
	 * @方法说明 构造方法-拼加SQL
	 */
	public RoleFunctionDao() {
		select.append("SELECT t.role_id,t.function_id");
		select.append(" FROM role_function t WHERE 1=1");

		insert.append("INSERT INTO role_function (function_id) ");
		insert.append(" VALUES (:function_id)");
	}

	/**
	 * @方法说明 新增角色功能关系记录
	 */
	public int save(RoleFunction vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("REPLACE INTO role_function (role_id,function_id)");
		sql.append(" VALUES (?,?)");
		Object[] params = { vo.getRole_id(), vo.getFunction_id() };
		// logger.info(SqlUtil.showSql(sql.toString(), params));//显示SQL语句
		return jdbcTemplate.update(sql.toString(), params);
	}

	/**
	 * @方法说明 新增角色功能关系记录并返回自增涨主键值
	 */
	public long saveReturnPK(RoleFunction vo) {
		return saveKey(vo, insert.toString(), "role_id");
	}

	/**
	 * @方法说明 批量插入角色功能关系记录
	 */
	public int[] insertBatch(List<RoleFunction> list) {
		return batchOperate(list, insert.toString());
	}

	/**
	 * @方法说明 物理删除角色功能关系记录(多条)
	 */
	public int delete(Long ids[]) {
		String sql = "DELETE FROM role_function WHERE role_id" + SqlUtil.ArrayToIn(ids);
		return jdbcTemplate.update(sql);
	}

	/**
	 * @方法说明 更新角色功能关系记录
	 */
	public int update(RoleFunction vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE role_function SET function_id=? ");
		sql.append(" WHERE role_id=? ");
		Object[] params = { vo.getFunction_id(), vo.getRole_id() };
		return jdbcTemplate.update(sql.toString(), params);
	}

	/**
	 * @方法说明 按条件查询分页角色功能关系列表
	 */
	public Page<RoleFunction> queryPage(RoleFunctionCond cond) {
		StringBuilder sb = new StringBuilder(select);
		sb.append(cond.getCondition());
		// sb.append(cond.getOrderSql());//增加排序子句;
		// logger.info(SqlUtil.showSql(sb.toString(),cond.getArray()));//显示SQL语句
		return queryPage(sb.toString(), cond, RoleFunction.class);
	}

	/**
	 * @方法说明 按条件查询不分页角色功能关系列表
	 */
	public List<RoleFunction> queryList(RoleFunctionCond cond) {
		StringBuilder sb = new StringBuilder(select);
		sb.append(cond.getCondition());
		// sb.append(" ORDER BY operate_time DESC");
		return jdbcTemplate.query(sb.toString(), cond.getArray(), new BeanPropertyRowMapper<>(RoleFunction.class));
	}

	/**
	 * @方法说明 按ID查找单个角色功能关系实体
	 */
	public RoleFunction findById(Long id) {
		StringBuilder sb = new StringBuilder(select);
		sb.append(" AND t.role_id=?");
		return jdbcTemplate.queryForObject(sb.toString(), new Object[] { id },
				new BeanPropertyRowMapper<>(RoleFunction.class));
	}

	/**
	 * @方法说明 按条件查询角色功能关系记录个数
	 */
	public long queryCount(RoleFunctionCond cond) {
		String countSql = "SELECT COUNT(1) FROM role_function t WHERE 1=1" + cond.getCondition();
		return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
	}

	/**
	 * @方法说明 按条件查询角色功能关系记录个数
	 */
	public int deleteLogic(Long ids[]) {
		String sql = "UPDATE role_function SET delete_remark=1 WHERE role_id" + SqlUtil.ArrayToIn(ids);
		return jdbcTemplate.update(sql);
	}

	public Set<String> queryPermissions(Long user_id) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT p.url FROM role_function t");
		sb.append(" JOIN function p on t.function_id=p.id");
		sb.append(" JOIN user_role ur on t.role_id=t.role_id");
		sb.append(" WHERE ur.user_id=?");
		return new HashSet<>(jdbcTemplate.queryForList(sb.toString(), String.class, user_id));
	}
}