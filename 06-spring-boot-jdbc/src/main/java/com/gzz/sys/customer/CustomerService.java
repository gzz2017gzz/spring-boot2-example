package com.gzz.sys.customer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzz.common.base.Page;

/**
 * @类说明 【客户】业务逻辑层
 * @author 高振中
 * @date 2020-03-18 14:31:03
 **/
//@Slf4j
@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao; // 注入【客户】数据访问层

	/**
	 * @方法说明 新增【客户】记录
	 */
	// @Transactional
	public int save(Customer customer) {
		return customerDao.save(customer);
	}

	/**
	 * @方法说明 删除【客户】记录
	 */
	public int delete(Integer[] ids) {
		return customerDao.delete(ids);
	}

	/**
	 * @方法说明 更新【客户】记录
	 */
	public int update(Customer customer) {
		return customerDao.update(customer);
	}

	/**
	 * @方法说明 按条件查询分页【客户】列表
	 */
	public Page<Customer> page(CustomerCond cond) {
		return customerDao.page(cond);
	}

	/**
	 * @方法说明 按条件查询【客户】列表
	 */
	public List<Customer> list(CustomerCond cond) {
		return customerDao.list(cond);
	}

	/**
	 * @方法说明 按主键查找单个【客户】记录
	 */
	public Customer findById(Integer id) {
		return customerDao.findById(id);
	}

	/**
	 * @方法说明 按条件查询【客户】记录个数
	 */
	public int count(CustomerCond cond) {
		return customerDao.count(cond);
	}
}