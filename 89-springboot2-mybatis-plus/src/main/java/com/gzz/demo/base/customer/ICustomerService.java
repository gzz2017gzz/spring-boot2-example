package com.gzz.demo.base.customer;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @类说明 【客户】业务逻辑接口
 * @author 高振中
 * @date 2020-04-02 20:34:07
 **/
public interface ICustomerService extends IService<Customer> {
	
	/**
	 * @方法说明 自定义联表查询
	 **/
	IPage<Customer> queryList(IPage<Customer> page, Customer param);
}
