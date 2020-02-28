package com.gzz.sys.customer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzz.common.base.Page;

/**
 * @类说明 【客户】业务逻辑层
 * @author 高振中
 * @date 2020-02-28 14:34:06
 **/
//@Slf4j
@Service
public class CustomerService {
 
	@Autowired
	private CustomerDao dao; //注入客户数据访问层

	/**
	 * @方法说明 新增【客户】记录
	 */
	//@Transactional
	public int save(Customer customer) {
		return dao.save(customer);
	}

	/**
	 * @方法说明 删除【客户】记录(多条)
	 */
	public int delete(Integer ids[]) {
		return dao.delete(ids);//物理删除
	}

	/**
	 * @方法说明 更新【客户】记录
	 */
	public int update(Customer customer) {
		return dao.update(customer); 
	}

	/**
	 * @方法说明 按条件查询分页【客户】列表
	 */
	public Page<Customer> queryPage(CustomerCond cond) {
		return dao.queryPage(cond);
	}

	/**
	 * @方法说明  按条件查询不分页【客户】列表 
	 */
	public List<Customer> queryList(CustomerCond cond) {
		return dao.queryList(cond);
	}

	/**
	 * @方法说明 按主键查找单个【客户】记录
	 */
	public Customer findById(Integer id) {
		return dao.findById(id);
	}

	/**
	 * @方法说明 按条件查询【客户】记录个数
	 */
	public long queryCount(CustomerCond cond) {
		return dao.queryCount(cond);
	}
}