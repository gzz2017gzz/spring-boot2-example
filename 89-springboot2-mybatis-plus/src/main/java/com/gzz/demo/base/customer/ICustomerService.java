package com.gzz.demo.base.customer;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
/**
 * @类说明 【客户】业务逻辑接口
 * @author 高振中
 * @date 2020-03-17 17:22:53
 **/
public interface ICustomerService extends IService<Customer> {
	
	/**
	 * @方法说明 自义联表查询
	 **/
	IPage<Customer> queryList(IPage<Customer> page, Customer param);
}
