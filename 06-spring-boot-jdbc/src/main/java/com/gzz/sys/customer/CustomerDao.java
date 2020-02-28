package com.gzz.sys.customer;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import com.gzz.common.base.BaseDao;
import com.gzz.common.base.Page;
import com.gzz.common.base.SQLUnit;
import lombok.extern.slf4j.Slf4j;
/**
 * @类说明 【客户】数据访问层
 * @author 高振中
 * @date 2020-02-28 14:34:06
 **/
@Slf4j
@Repository
public class CustomerDao extends BaseDao{

//	private StringBuilder insert = new StringBuilder();
    private StringBuilder select = new StringBuilder();

    /**
     * @方法说明 构造方法-拼加SQL
     */
    public CustomerDao() {
    	select.append("SELECT t.id,t.name,t.tradeType,t.title,t.address,t.url,t.contacts,t.contactsJob,t.contactsTel,t.contactsMail,"); 
		select.append("t.contactsOther,t.phoneNo,t.remark");
    	select.append(" FROM sys_customer t ");
    	//insert.append("INSERT INTO sys_customer (id,name,tradeType,title,address,url,contacts,contactsJob,contactsTel,contactsMail,"); 
		//insert.append("contactsOther,phoneNo,remark) ");
    	//insert.append(" VALUES (:id,:name,:tradeType,:title,:address,:url,:contacts,:contactsJob,:contactsTel,:contactsMail,"); 
		//insert.append(":contactsOther,:phoneNo,:remark)");
    }

    /**
     * @方法说明  新增【客户】记录
     */
    public int save(Customer vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO sys_customer (id,name,tradeType,title,address,url,contacts,contactsJob,contactsTel,contactsMail,"); 
		sql.append("contactsOther,phoneNo,remark)");
        sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
        Object[] params ={ vo.getId(),vo.getName(),vo.getTradeType(),vo.getTitle(),vo.getAddress(),vo.getUrl(),vo.getContacts(),vo.getContactsJob(),vo.getContactsTel(),vo.getContactsMail(),//太长换行 
		vo.getContactsOther(),vo.getPhoneNo(),vo.getRemark() };
        //log.info(super.sql(sql.toString(), params));//显示SQL语句
        return jdbcTemplate.update(sql.toString(), params);
    }
    
    /**
     * @方法说明 物理删除【客户】记录(多条)
     */
    public int delete(Object ids[]) {
        String sql = "DELETE FROM sys_customer WHERE id IN" + SQLUnit.toIn(ids);
        return jdbcTemplate.update(sql,ids);
    }
    
    /**
     * @方法说明 更新【客户】记录
     */
    public int update(Customer vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE sys_customer SET name=?,tradeType=?,title=?,address=?,url=?,contacts=?,contactsJob=?,contactsTel=?,contactsMail=?,contactsOther=?,"); 
		sql.append("phoneNo=?,remark=?");
        sql.append(" WHERE id=? ");
        Object[] params = {vo.getName(),vo.getTradeType(),vo.getTitle(),vo.getAddress(),vo.getUrl(),vo.getContacts(),vo.getContactsJob(),vo.getContactsTel(),vo.getContactsMail(),vo.getContactsOther(),//太长换行 
		vo.getPhoneNo(),vo.getRemark(),vo.getId()};
        return jdbcTemplate.update(sql.toString(), params);
      }

    /**
     * @方法说明 按条件查询分页【客户】列表
     */
    public Page<Customer> queryPage(CustomerCond cond) {
        StringBuilder sb = new StringBuilder(select);
        sb.append(cond.where());
        log.info(super.sql(sb.toString(),cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, Customer.class);
    }
    
    /**
     * @方法说明 按条件查询不分页【客户】列表
     */
    public List<Customer> queryList(CustomerCond cond) {
    	StringBuilder sb = new StringBuilder(select);
    	sb.append(cond.where());
    	//sb.append(" ORDER BY id DESC");
    	return jdbcTemplate.query(sb.toString(), cond.getArray(), new BeanPropertyRowMapper<>(Customer.class));
    }
    
    /**
     * @方法说明 按ID查找单个【客户】实体
     */
	public Customer findById(Integer id) {
		StringBuilder sb = new StringBuilder(select);
		sb.append(" WHERE t.id=?");
		return jdbcTemplate.queryForObject(sb.toString(), new BeanPropertyRowMapper<>(Customer.class),id);
	}
    
    /**
     * @方法说明 按条件查询【客户】记录个数
     */
	public long queryCount(CustomerCond cond) {
		String countSql = "SELECT COUNT(1) FROM sys_customer t " + cond.where();
		return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
	}
    
    /**
     * @方法说明 逻辑删除【客户】记录 
     */
//	public int delete(Object ids[]) {
//		String sql = "UPDATE sys_customer SET dr=1 WHERE id IN " + SQLUnit.toIn(ids);
//		return jdbcTemplate.update(sql,ids);
//	}
    
    /**
     * @方法说明 新增【客户】记录并返回自增涨主键值
     */
//	public long saveReturnPK(Customer vo) {
//		return saveKey(vo, insert.toString(), "id");
//	}
    
    /**
     * @方法说明 批量插入【客户】记录
     */
//	public int[] insertBatch(List<Customer> list) {
//		return batchOperate(list, insert.toString());
//	}    
 
}