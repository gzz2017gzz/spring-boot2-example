package com.gzz.sys.user;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.gzz.common.base.BaseDao;
import com.gzz.common.base.Page;

/**
 * @类说明 [user]数据访问层
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 **/
@Repository
public class UserDao extends BaseDao {

	private StringBuilder insert = new StringBuilder();
	private StringBuilder select = new StringBuilder();

	/**
	 * @方法说明 构造方法-拼加SQL
	 */
	public UserDao() {
		select.append("SELECT t.id,t.name,t.sex,t.age,t.phone,t.create_time");
		select.append(" FROM user t ");

		insert.append("INSERT INTO user (name,sex,age,phone,create_time) ");
		insert.append(" VALUES (:name,:sex,:age,:phone,:create_time)");
	}

	/**
	 * @方法说明 新增user记录
	 */
	public int save(User vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO user (id,name,sex,age,phone,create_time)");
		sql.append(" VALUES (?,?,?,?,?,?)");
		Object[] params = { vo.getId(), vo.getName(), vo.getSex(), vo.getAge(), vo.getPhone(), vo.getCreate_time() };
		// logger.info(SqlUtil.showSql(sql.toString(), params));//显示SQL语句
		return jdbcTemplate.update(sql.toString(), params);
	}

	/**
	 * @方法说明 新增user记录并返回自增涨主键值
	 */
	public long saveReturnPK(User vo) {
		return saveKey(vo, insert.toString(), "id");
	}

	/**
	 * @方法说明 批量插入user记录
	 */
	public int[] insertBatch(List<User> list) {
		return batchOperate(list, insert.toString());
	}

	/**
	 * @方法说明 物理删除user记录(多条)
	 */
	public int delete(Integer ids[]) {
		String sql = "DELETE FROM user WHERE id" + super.toIn(ids);
		return jdbcTemplate.update(sql);
	}

	/**
	 * @方法说明 更新user记录
	 */
	public int update(User vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE user SET name=?,sex=?,age=?,phone=?,create_time=? ");
		sql.append(" WHERE id=? ");
		Object[] params = { vo.getName(), vo.getSex(), vo.getAge(), vo.getPhone(), vo.getCreate_time(), vo.getId() };
		return jdbcTemplate.update(sql.toString(), params);
	}

	/**
	 * @方法说明 按条件查询分页user列表
	 */
	public Page<User> queryPage(UserCond cond) {
		StringBuilder sb = new StringBuilder(select);
		sb.append(cond.where());
		// sb.append(cond.getOrderSql());//增加排序子句;
		// logger.info(SqlUtil.showSql(sb.toString(),cond.getArray()));//显示SQL语句
		return queryPage(sb.toString(), cond, User.class);
	}

	/**
	 * @方法说明 按条件查询不分页user列表
	 */
	public List<User> queryList(UserCond cond) {
		StringBuilder sb = new StringBuilder(select);
		sb.append(cond.where());
		// sb.append(" ORDER BY operate_time DESC");
		return jdbcTemplate.query(sb.toString(), cond.array(), new BeanPropertyRowMapper<>(User.class));
	}

	/**
	 * @方法说明 按ID查找单个user实体
	 */
	public User findById(Integer id) {
		StringBuilder sb = new StringBuilder(select);
		sb.append(" AND t.id=?");
		return jdbcTemplate.queryForObject(sb.toString(), new Object[] { id }, new BeanPropertyRowMapper<>(User.class));
	}

	/**
	 * @方法说明 按条件查询user记录个数
	 */
	public long queryCount(UserCond cond) {
		String countSql = "SELECT COUNT(1) FROM user t " + cond.where();
		return jdbcTemplate.queryForObject(countSql, cond.array(), Long.class);
	}

}