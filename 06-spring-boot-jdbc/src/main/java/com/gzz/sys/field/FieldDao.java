package com.gzz.sys.field;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.gzz.common.base.BaseDao;
import com.gzz.common.base.Page;

import lombok.extern.slf4j.Slf4j;

/**
 * @类说明 【字段定义】数据访问层
 * @author 高振中
 * @date 2020-06-17 18:03:53
 **/
@Slf4j
@Repository
public class FieldDao extends BaseDao {

	/**
	 * @方法说明 新增【字段定义】记录
	 */
	public int save(Field vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO cf_field (field_id,bus_id,field_name,data_type,data_length,data_scale,field_remark)");
		sql.append(" VALUES (?,?,?,?,?,?,?)");
		Object[] params = { vo.getField_id(), vo.getBus_id(), vo.getField_name(), vo.getData_type(), vo.getData_length(), vo.getData_scale(), vo.getField_remark() };
		// log.info(super.sql(sql.toString(), params));// 显示SQL语句
		return jdbcTemplate.update(sql.toString(), params);
	}

	/**
	 * @方法说明 删除【字段定义】记录
	 */
	public int delete(Object[] ids) {
		String sql = "DELETE FROM cf_field WHERE field_id IN" + toIn(ids);
		// log.info(super.sql(sql, ids));// 显示SQL语句
		return jdbcTemplate.update(sql, ids);
	}

	/**
	 * @方法说明 更新【字段定义】记录
	 */
	public int update(Field vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE cf_field SET field_id=?,bus_id=?,field_name=?,data_type=?,data_length=?,data_scale=?,field_remark=?");
		sql.append(" WHERE field_id=? ");
		Object[] params = { vo.getBus_id(), vo.getField_name(), vo.getData_type(), vo.getData_length(), vo.getData_scale(), vo.getField_remark(), vo.getField_id() };
		// log.info(super.sql(sql.toString(), params));// 显示SQL语句
		return jdbcTemplate.update(sql.toString(), params);
	}

	/**
	 * @方法说明 按条件查询分页【字段定义】列表
	 */
	public Page<Field> page(FieldCond cond) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t.field_id,t.bus_id,t.field_name,t.data_type,t.data_length,t.data_scale,t.field_remark");
		sql.append(" FROM cf_field t");
		sql.append(cond.where());
		log.info(super.sql(sql.toString(), cond.array()));// 显示SQL语句
		return queryPage(sql.toString(), cond, Field.class);
	}

	/**
	 * @方法说明 按条件查询【字段定义】列表
	 */
	public List<Field> list(FieldCond cond) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t.field_id,t.bus_id,t.field_name,t.data_type,t.data_length,t.data_scale,t.field_remark");
		sql.append(" FROM cf_field t");
		sql.append(cond.where());
		sql.append(" ORDER BY field_id DESC");
		// log.info(super.sql(sql.toString(),cond.array()));//显示SQL语句
		return jdbcTemplate.query(sql.toString(), cond.array(), new BeanPropertyRowMapper<>(Field.class));
	}

	/**
	 * @方法说明 按主键查找单个【字段定义】记录
	 */
	public Field findById(String id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t.field_id,t.bus_id,t.field_name,t.data_type,t.data_length,t.data_scale,t.field_remark");
		sql.append(" FROM cf_field t WHERE t.field_id=?");
		// log.info(super.sql(sql.toString(),id));//显示SQL语句
		return jdbcTemplate.queryForObject(sql.toString(), new BeanPropertyRowMapper<>(Field.class), id);
	}

	/**
	 * @方法说明 按条件查询【字段定义】记录个数
	 */
	public int count(FieldCond cond) {
		String sql = "SELECT COUNT(1) FROM cf_field t " + cond.where();
		// log.info(super.sql(sql,cond.array()));//显示SQL语句
		return jdbcTemplate.queryForObject(sql, cond.array(), Integer.class);
	}

	/**
	 * @方法说明 新增【字段定义】记录并返回自增涨主键值
	 */
	public int saveReturnPK(Field vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO cf_field (field_id,bus_id,field_name,data_type,data_length,data_scale,field_remark)");
		sql.append(" VALUES (:field_id,:bus_id,:field_name,:data_type,:data_length,:data_scale,:field_remark)");
		// log.info(super.sqlp(sql.toString(), vo));// 显示SQL语句
		return saveKey(vo, sql.toString(), "field_id");
	}

	/**
	 * @方法说明 批量插入【字段定义】记录
	 */
	public int[] insertBatch(List<Field> list) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO cf_field (field_id,bus_id,field_name,data_type,data_length,data_scale,field_remark)");
		sql.append(" VALUES (:field_id,:bus_id,:field_name,:data_type,:data_length,:data_scale,:field_remark)");
		// log.info(super.sqlp(sql.toString(), list));// 显示SQL语句
		return batchOperate(list, sql.toString());
	}

	/**
	 * @方法说明 逻辑删除【字段定义】记录
	 */
//	public int delete(Object... ids) {
//		String sql = "UPDATE cf_field SET dr=1 WHERE field_id IN " + toIn(ids);
//		return jdbcTemplate.update(sql,ids);
//	}	

}