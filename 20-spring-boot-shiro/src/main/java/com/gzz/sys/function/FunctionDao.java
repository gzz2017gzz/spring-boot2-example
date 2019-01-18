package com.gzz.sys.function;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.gzz.base.BaseDao;
import com.gzz.base.Page;
import com.gzz.base.SqlUtil;

/**
 * @类说明 [功能]数据访问层
 * @author 高振中
 * @date 2018-12-24 21:36:34
 **/
@Repository
public class FunctionDao extends BaseDao {

	private StringBuilder insert = new StringBuilder();
	private StringBuilder select = new StringBuilder();

	/**
	 * @方法说明 构造方法-拼加SQL
	 */
	public FunctionDao() {
		select.append("SELECT t.id,t.url,t.name,t.available");
		select.append(" FROM function t WHERE 1=1");

		insert.append("INSERT INTO function (url,name,available) ");
		insert.append(" VALUES (:url,:name,:available)");
	}

	/**
	 * @方法说明 新增功能记录
	 */
	public int save(Function vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("REPLACE INTO function (id,url,name,available)");
		sql.append(" VALUES (?,?,?,?)");
		Object[] params = { vo.getId(), vo.getUrl(), vo.getName(), vo.getAvailable() };
		// logger.info(SqlUtil.showSql(sql.toString(), params));//显示SQL语句
		return jdbcTemplate.update(sql.toString(), params);
	}

	/**
	 * @方法说明 新增功能记录并返回自增涨主键值
	 */
	public long saveReturnPK(Function vo) {
		return saveKey(vo, insert.toString(), "id");
	}

	/**
	 * @方法说明 批量插入功能记录
	 */
	public int[] insertBatch(List<Function> list) {
		return batchOperate(list, insert.toString());
	}

	/**
	 * @方法说明 物理删除功能记录(多条)
	 */
	public int delete(Long ids[]) {
		String sql = "DELETE FROM function WHERE id" + SqlUtil.ArrayToIn(ids);
		return jdbcTemplate.update(sql);
	}

	/**
	 * @方法说明 更新功能记录
	 */
	public int update(Function vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE function SET url=?,name=?,available=? ");
		sql.append(" WHERE id=? ");
		Object[] params = { vo.getUrl(), vo.getName(), vo.getAvailable(), vo.getId() };
		return jdbcTemplate.update(sql.toString(), params);
	}

	/**
	 * @方法说明 按条件查询分页功能列表
	 */
	public Page<Function> queryPage(FunctionCond cond) {
		StringBuilder sb = new StringBuilder(select);
		sb.append(cond.getCondition());
		// sb.append(cond.getOrderSql());//增加排序子句;
		// logger.info(SqlUtil.showSql(sb.toString(),cond.getArray()));//显示SQL语句
		return queryPage(sb.toString(), cond, Function.class);
	}

	/**
	 * @方法说明 按条件查询不分页功能列表
	 */
	public List<Function> queryList(FunctionCond cond) {
		StringBuilder sb = new StringBuilder(select);
		sb.append(cond.getCondition());
		// sb.append(" ORDER BY operate_time DESC");
		return jdbcTemplate.query(sb.toString(), cond.getArray(), new BeanPropertyRowMapper<>(Function.class));
	}

	/**
	 * @方法说明 按ID查找单个功能实体
	 */
	public Function findById(Long id) {
		StringBuilder sb = new StringBuilder(select);
		sb.append(" AND t.id=?");
		return jdbcTemplate.queryForObject(sb.toString(), new Object[] { id },
				new BeanPropertyRowMapper<>(Function.class));
	}

	/**
	 * @方法说明 按条件查询功能记录个数
	 */
	public long queryCount(FunctionCond cond) {
		String countSql = "SELECT COUNT(1) FROM function t WHERE 1=1" + cond.getCondition();
		return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
	}

	/**
	 * @方法说明 按条件查询功能记录个数
	 */
	public int deleteLogic(Long ids[]) {
		String sql = "UPDATE function SET delete_remark=1 WHERE id" + SqlUtil.ArrayToIn(ids);
		return jdbcTemplate.update(sql);
	}

}