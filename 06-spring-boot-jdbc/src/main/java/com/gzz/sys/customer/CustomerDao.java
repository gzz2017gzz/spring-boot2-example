package com.gzz.sys.customer;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.gzz.common.base.BaseDao;
import com.gzz.common.base.Page;

import lombok.extern.slf4j.Slf4j;

/**
 * @类说明 【客户】数据访问层
 * @author 高振中
 * @date 2020-03-13 02:22:25
 **/
@Slf4j
@Repository
public class CustomerDao extends BaseDao {

	/**
	 * @方法说明 新增【客户】记录
	 */
	public int save(Customer vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO sys_customer (id,name,tradeType,title,address,url,contacts,contactsJob,");
		sql.append("contactsTel,contactsMail,contactsOther,phoneNo,remark)");
		sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
		Object[] params = { vo.getId(), vo.getName(), vo.getTradeType(), vo.getTitle(), vo.getAddress(), vo.getUrl(), vo.getContacts(), vo.getContactsJob(), //
				vo.getContactsTel(), vo.getContactsMail(), vo.getContactsOther(), vo.getPhoneNo(), vo.getRemark() };
		// log.info(super.sql(sql.toString(), params));// 显示SQL语句
		return jdbcTemplate.update(sql.toString(), params);
	}

	/**
	 * @方法说明 删除【客户】记录
	 */
	public int delete(Object[] ids) {
		String sql = "DELETE FROM sys_customer WHERE id IN" + super.toIn(ids);
		// log.info(super.sql(sql, ids));// 显示SQL语句
		return jdbcTemplate.update(sql, ids);
	}

	/**
	 * @方法说明 更新【客户】记录
	 */
	public int update(Customer vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE sys_customer SET id=?,name=?,tradeType=?,title=?,address=?,url=?,contacts=?,contactsJob=?,");
		sql.append("contactsTel=?,contactsMail=?,contactsOther=?,phoneNo=?,remark=?");
		sql.append(" WHERE id=? ");
		Object[] params = { vo.getName(), vo.getTradeType(), vo.getTitle(), vo.getAddress(), vo.getUrl(), vo.getContacts(), vo.getContactsJob(), vo.getContactsTel(), //
				vo.getContactsMail(), vo.getContactsOther(), vo.getPhoneNo(), vo.getRemark(), vo.getId() };
		// log.info(super.sql(sql.toString(), params));// 显示SQL语句
		return jdbcTemplate.update(sql.toString(), params);
	}

	/**
	 * @方法说明 按条件查询分页【客户】列表
	 */
	public Page<Customer> page(CustomerCond cond) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t.id,t.name,t.tradeType,t.title,t.address,t.url,t.contacts,t.contactsJob,");
		sql.append("t.contactsTel,t.contactsMail,t.contactsOther,t.phoneNo,t.remark");
		sql.append(" FROM sys_customer t");
		sql.append(cond.where());
		log.info(super.sql(sql.toString(), cond.array()));// 显示SQL语句
		return queryPage(sql.toString(), cond, Customer.class);
	}

	/**
	 * @方法说明 按条件查询不分页【客户】列表
	 */
	public List<Customer> list(CustomerCond cond) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t.id,t.name,t.tradeType,t.title,t.address,t.url,t.contacts,t.contactsJob,");
		sql.append("t.contactsTel,t.contactsMail,t.contactsOther,t.phoneNo,t.remark");
		sql.append(" FROM sys_customer t");
		sql.append(cond.where());
		sql.append(" ORDER BY id DESC");
		// log.info(super.sql(sql.toString(),cond.array()));//显示SQL语句
		return jdbcTemplate.query(sql.toString(), cond.array(), new BeanPropertyRowMapper<>(Customer.class));
	}

	/**
	 * @方法说明 按主键查找单个【客户】记录
	 */
	public Customer findById(Integer id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t.id,t.name,t.tradeType,t.title,t.address,t.url,t.contacts,t.contactsJob,");
		sql.append("t.contactsTel,t.contactsMail,t.contactsOther,t.phoneNo,t.remark");
		sql.append(" FROM sys_customer t WHERE t.id=?");
		// log.info(super.sql(sql.toString(),id));//显示SQL语句
		return jdbcTemplate.queryForObject(sql.toString(), new BeanPropertyRowMapper<>(Customer.class), id);
	}

	/**
	 * @方法说明 按条件查询【客户】记录个数
	 */
	public int count(CustomerCond cond) {
		String sql = "SELECT COUNT(1) FROM sys_customer t " + cond.where();
		// log.info(super.sql(sql,cond.array()));//显示SQL语句
		return jdbcTemplate.queryForObject(sql, cond.array(), Integer.class);
	}

	/**
	 * @方法说明 新增【客户】记录并返回自增涨主键值
	 */
	public long saveReturnPK(Customer vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO sys_customer (id,name,tradeType,title,address,url,contacts,contactsJob,");
		sql.append("contactsTel,contactsMail,contactsOther,phoneNo,remark)");
		sql.append(" VALUES (:id,:name,:tradeType,:title,:address,:url,:contacts,:contactsJob,");
		sql.append(":contactsTel,:contactsMail,:contactsOther,:phoneNo,:remark)");
		// log.info(super.sqlp(sql.toString(), vo));// 显示SQL语句
		return saveKey(vo, sql.toString(), "id");
	}

	/**
	 * @方法说明 批量插入【客户】记录
	 */
	public int[] insertBatch(List<Customer> list) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO sys_customer (id,name,tradeType,title,address,url,contacts,contactsJob,");
		sql.append("contactsTel,contactsMail,contactsOther,phoneNo,remark)");
		sql.append(" VALUES (:id,:name,:tradeType,:title,:address,:url,:contacts,:contactsJob,");
		sql.append(":contactsTel,:contactsMail,:contactsOther,:phoneNo,:remark)");
		// log.info(super.sqlp(sql.toString(), list));// 显示SQL语句
		return batchOperate(list, sql.toString());
	}

	/**
	 * @方法说明 逻辑删除【客户】记录
	 */
//	public int delete(Object... ids) {
//		String sql = "UPDATE sys_customer SET dr=1 WHERE id IN " + super.toIn(ids);
//		return jdbcTemplate.update(sql,ids);
//	}	

}