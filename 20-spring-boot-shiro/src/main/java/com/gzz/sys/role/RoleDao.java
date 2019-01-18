package com.gzz.sys.role;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.gzz.base.BaseDao;
import com.gzz.base.Page;
import com.gzz.base.SqlUtil;

/**
 * @类说明 [角色]数据访问层
 * @author 高振中
 * @date 2018-12-24 21:36:34
 **/
@Repository
public class RoleDao extends BaseDao {

	private StringBuilder insert = new StringBuilder();
	private StringBuilder select = new StringBuilder();

	/**
	 * @方法说明 构造方法-拼加SQL
	 */
	public RoleDao() {
		select.append("SELECT t.id,t.role,t.name,t.available");
		select.append(" FROM role t WHERE 1=1");

		insert.append("INSERT INTO role (role,name,available) ");
		insert.append(" VALUES (:role,:name,:available)");
	}

	/**
	 * @方法说明 新增角色记录
	 */
	public int save(Role vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("REPLACE INTO role (id,role,name,available)");
		sql.append(" VALUES (?,?,?,?)");
		Object[] params = { vo.getId(), vo.getRole(), vo.getName(), vo.getAvailable() };
		// logger.info(SqlUtil.showSql(sql.toString(), params));//显示SQL语句
		return jdbcTemplate.update(sql.toString(), params);
	}

	/**
	 * @方法说明 新增角色记录并返回自增涨主键值
	 */
	public long saveReturnPK(Role vo) {
		return saveKey(vo, insert.toString(), "id");
	}

	/**
	 * @方法说明 批量插入角色记录
	 */
	public int[] insertBatch(List<Role> list) {
		return batchOperate(list, insert.toString());
	}

	/**
	 * @方法说明 物理删除角色记录(多条)
	 */
	public int delete(Long ids[]) {
		String sql = "DELETE FROM role WHERE id" + SqlUtil.ArrayToIn(ids);
		return jdbcTemplate.update(sql);
	}

	/**
	 * @方法说明 更新角色记录
	 */
	public int update(Role vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE role SET role=?,name=?,available=? ");
		sql.append(" WHERE id=? ");
		Object[] params = { vo.getRole(), vo.getName(), vo.getAvailable(), vo.getId() };
		return jdbcTemplate.update(sql.toString(), params);
	}

	/**
	 * @方法说明 按条件查询分页角色列表
	 */
	public Page<Role> queryPage(RoleCond cond) {
		StringBuilder sb = new StringBuilder(select);
		sb.append(cond.getCondition());
		// sb.append(cond.getOrderSql());//增加排序子句;
		// logger.info(SqlUtil.showSql(sb.toString(),cond.getArray()));//显示SQL语句
		return queryPage(sb.toString(), cond, Role.class);
	}

	/**
	 * @方法说明 按条件查询不分页角色列表
	 */
	public List<Role> queryList(RoleCond cond) {
		StringBuilder sb = new StringBuilder(select);
		sb.append(cond.getCondition());
		// sb.append(" ORDER BY operate_time DESC");
		return jdbcTemplate.query(sb.toString(), cond.getArray(), new BeanPropertyRowMapper<>(Role.class));
	}

	/**
	 * @方法说明 按ID查找单个角色实体
	 */
	public Role findById(Long id) {
		StringBuilder sb = new StringBuilder(select);
		sb.append(" AND t.id=?");
		return jdbcTemplate.queryForObject(sb.toString(), new Object[] { id }, new BeanPropertyRowMapper<>(Role.class));
	}

	/**
	 * @方法说明 按条件查询角色记录个数
	 */
	public long queryCount(RoleCond cond) {
		String countSql = "SELECT COUNT(1) FROM role t WHERE 1=1" + cond.getCondition();
		return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
	}

	/**
	 * @方法说明 按条件查询角色记录个数
	 */
	public int deleteLogic(Long ids[]) {
		String sql = "UPDATE role SET delete_remark=1 WHERE id" + SqlUtil.ArrayToIn(ids);
		return jdbcTemplate.update(sql);
	}

}