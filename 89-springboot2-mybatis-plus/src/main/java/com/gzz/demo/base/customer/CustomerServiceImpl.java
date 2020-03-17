package com.gzz.demo.base.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @类说明 【客户】业务逻辑实现
 * @author 高振中
 * @date 2020-03-17 17:22:53
 **/
//@Slf4j
@Service
public class CustomerServiceImpl extends ServiceImpl<ICustomerMapper, Customer> implements ICustomerService {
	@Autowired
	private ICustomerMapper customerMapper;//注入【客户】数据访问接口
	
	/**
	 * @方法说明 自义联表查询
	 **/
	@Override
	public IPage<Customer> queryList(IPage<Customer> page, Customer param){
		return customerMapper.queryList(page,param);
	}
}