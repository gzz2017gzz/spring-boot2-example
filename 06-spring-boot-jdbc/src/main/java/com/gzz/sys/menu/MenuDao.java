package com.gzz.sys.menu;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import com.gzz.common.base.BaseDao;
import com.gzz.common.base.Page;
import com.gzz.common.base.SqlUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * @类说明 [菜单]数据访问层
 * @author 高振中
 * @date 2020-02-26 22:07:45
 **/
@Slf4j
@Repository
public class MenuDao extends BaseDao {

	private StringBuilder insert = new StringBuilder();
	private StringBuilder select = new StringBuilder();

	/**
	 * @方法说明 构造方法-拼加SQL
	 */
	public MenuDao() {
		select.append("SELECT t.id,t.parentId,t.level,t.type,t.icon,t.name,t.path,t.orderNum,t.remark");
		select.append(" FROM sys_menu t ");
		insert.append("INSERT INTO sys_menu (id,parentId,level,type,icon,name,path,orderNum,remark) ");
		insert.append(" VALUES (:id,:parentId,:level,:type,:icon,:name,:path,:orderNum,:remark)");
	}

	/**
	 * @方法说明 新增菜单记录
	 */
	public int save(Menu vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO sys_menu (id,parentId,level,type,icon,name,path,orderNum,remark)");
		sql.append(" VALUES (?,?,?,?,?,?,?,?,?)");
		Object[] params = { vo.getId(), vo.getParentId(), vo.getLevel(), vo.getType(), vo.getIcon(), vo.getName(), vo.getPath(), vo.getOrderNum(), vo.getRemark() };
		log.info(SqlUtil.showSql(sql.toString(), params));// 显示SQL语句
		return jdbcTemplate.update(sql.toString(), params);
	}

	/**
	 * @方法说明 物理删除菜单记录(多条)
	 */
	public int delete(Object ids[]) {
		String sql = "DELETE FROM sys_menu WHERE id IN " + SqlUtil.ArrayToIn(ids);
		return jdbcTemplate.update(sql, ids);
	}

	/**
	 * @方法说明 更新菜单记录
	 */
	public int update(Menu vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE sys_menu SET parentId=?,level=?,type=?,icon=?,name=?,path=?,orderNum=?,remark=? ");
		sql.append(" WHERE id=? ");
		Object[] params = { vo.getParentId(), vo.getLevel(), vo.getType(), vo.getIcon(), vo.getName(), vo.getPath(), vo.getOrderNum(), vo.getRemark(), vo.getId() };
		return jdbcTemplate.update(sql.toString(), params);
	}

	/**
	 * @方法说明 按条件查询分页菜单列表
	 */
	public Page<Menu> queryPage(MenuCond cond) {
		StringBuilder sb = new StringBuilder(select);
		sb.append(cond.getWhere());
		// sb.append(cond.getOrderSql());//增加排序子句;
		log.info(SqlUtil.showSql(sb.toString(), cond.getArray()));// 显示SQL语句
		return queryPage(sb.toString(), cond, Menu.class);
	}

	/**
	 * @方法说明 按条件查询不分页菜单列表
	 */
	public List<Menu> queryList(MenuCond cond) {
		StringBuilder sb = new StringBuilder(select);
		sb.append(cond.getWhere());
		// sb.append(" ORDER BY operate_time DESC");
		return jdbcTemplate.query(sb.toString(), cond.getArray(), new BeanPropertyRowMapper<>(Menu.class));
	}

	/**
	 * @方法说明 按ID查找单个菜单实体
	 */
	public Menu findById(Integer id) {
		StringBuilder sb = new StringBuilder(select);
		sb.append(" AND t.id=?");
		return jdbcTemplate.queryForObject(sb.toString(), new Object[] { id }, new BeanPropertyRowMapper<>(Menu.class));
	}

	/**
	 * @方法说明 按条件查询菜单记录个数
	 */
	public long queryCount(MenuCond cond) {
		String countSql = "SELECT COUNT(1) FROM sys_menu t " + cond.getWhere();
		return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
	}

	/**
	 * @方法说明 逻辑删除菜单记录
	 */
	public int deleteLogic(Object ids[]) {
		String sql = "UPDATE sys_menu SET delete_remark=1 WHERE id IN " + SqlUtil.ArrayToIn(ids);
		return jdbcTemplate.update(sql, ids);
	}

	/**
	 * @方法说明 新增菜单记录并返回自增涨主键值
	 */
	public long saveReturnPK(Menu vo) {
		return saveKey(vo, insert.toString(), "id");
	}

	/**
	 * @方法说明 批量插入菜单记录
	 */
	public int[] insertBatch(List<Menu> list) {
		return batchOperate(list, insert.toString());
	}

}