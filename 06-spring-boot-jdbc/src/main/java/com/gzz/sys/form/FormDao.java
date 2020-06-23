package com.gzz.sys.form;

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
public class FormDao extends BaseDao {

	/**
	 * @方法说明 新增【字段定义】记录
	 */
	public int save(Form vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO cf_form (field_id,type,value,title,props,validate,col,dataSource,");
		sql.append("options,order_num)");
		sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?)");
		Object[] params = { vo.getField_id(), vo.getType(), vo.getValue(), vo.getTitle(), vo.getProps(), vo.getValidate(), vo.getCol(), vo.getDataSource(), //
				vo.getOptions(), vo.getOrder_num() };
		// log.info(super.sql(sql.toString(), params));// 显示SQL语句
		return jdbcTemplate.update(sql.toString(), params);
	}

	/**
	 * @方法说明 删除【字段定义】记录
	 */
	public int delete(Object[] ids) {
		String sql = "DELETE FROM cf_form WHERE field_id IN" + toIn(ids);
		// log.info(super.sql(sql, ids));// 显示SQL语句
		return jdbcTemplate.update(sql, ids);
	}

	/**
	 * @方法说明 更新【字段定义】记录
	 */
	public int update(Form vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE cf_form SET field_id=?,type=?,value=?,title=?,props=?,validate=?,col=?,dataSource=?,");
		sql.append("options=?,order_num=?");
		sql.append(" WHERE field_id=? ");
		Object[] params = { vo.getType(), vo.getValue(), vo.getTitle(), vo.getProps(), vo.getValidate(), vo.getCol(), vo.getDataSource(), vo.getOptions(), //
				vo.getOrder_num(), vo.getField_id() };
		// log.info(super.sql(sql.toString(), params));// 显示SQL语句
		return jdbcTemplate.update(sql.toString(), params);
	}

	/**
	 * @方法说明 按条件查询分页【字段定义】列表
	 */
	public Page<Form> page(FormCond cond) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t.field_id,t.type,t.value,t.title,t.props,t.validate,t.col,t.dataSource,");
		sql.append("t.options,t.order_num");
		sql.append(" FROM cf_form t");
		sql.append(cond.where());
		log.info(super.sql(sql.toString(), cond.array()));// 显示SQL语句
		return queryPage(sql.toString(), cond, Form.class);
	}

	/**
	 * @方法说明 按条件查询【字段定义】列表
	 */
	public List<Form> list(FormCond cond) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t.field_id,t.type,t.value,t.title,t.props,t.validate,t.col,t.dataSource,");
		sql.append("t.options,t.order_num,f.field_name");
		sql.append(" FROM cf_form t join cf_field f on t.field_id=f.field_id");
		sql.append(cond.where());
		sql.append(" ORDER BY order_num");
		log.info(super.sql(sql.toString(), cond.array()));// 显示SQL语句
		return jdbcTemplate.query(sql.toString(), cond.array(), new BeanPropertyRowMapper<>(Form.class));
	}

	/**
	 * @方法说明 按主键查找单个【字段定义】记录
	 */
	public Form findById(String id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t.field_id,t.type,t.value,t.title,t.props,t.validate,t.col,t.dataSource,");
		sql.append("t.options,t.order_num");
		sql.append(" FROM cf_form t WHERE t.field_id=?");
		// log.info(super.sql(sql.toString(),id));//显示SQL语句
		return jdbcTemplate.queryForObject(sql.toString(), new BeanPropertyRowMapper<>(Form.class), id);
	}

	/**
	 * @方法说明 按条件查询【字段定义】记录个数
	 */
	public int count(FormCond cond) {
		String sql = "SELECT COUNT(1) FROM cf_form t " + cond.where();
		// log.info(super.sql(sql,cond.array()));//显示SQL语句
		return jdbcTemplate.queryForObject(sql, cond.array(), Integer.class);
	}

	/**
	 * @方法说明 新增【字段定义】记录并返回自增涨主键值
	 */
	public int saveReturnPK(Form vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO cf_form (field_id,type,value,title,props,validate,col,dataSource,");
		sql.append("options,order_num)");
		sql.append(" VALUES (:field_id,:type,:value,:title,:props,:validate,:col,:dataSource,");
		sql.append(":options,:order_num)");
		// log.info(super.sqlp(sql.toString(), vo));// 显示SQL语句
		return saveKey(vo, sql.toString(), "field_id");
	}

	/**
	 * @方法说明 批量插入【字段定义】记录
	 */
	public int[] insertBatch(List<Form> list) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO cf_form (field_id,type,value,title,props,validate,col,dataSource,");
		sql.append("options,order_num)");
		sql.append(" VALUES (:field_id,:type,:value,:title,:props,:validate,:col,:dataSource,");
		sql.append(":options,:order_num)");
		// log.info(super.sqlp(sql.toString(), list));// 显示SQL语句
		return batchOperate(list, sql.toString());
	}

	/**
	 * @方法说明 逻辑删除【字段定义】记录
	 */
//	public int delete(Object... ids) {
//		String sql = "UPDATE cf_form SET dr=1 WHERE field_id IN " + toIn(ids);
//		return jdbcTemplate.update(sql,ids);
//	}	

}