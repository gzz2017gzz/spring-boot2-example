package com.gzz.demo.base.customer;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
/**
 * @类说明 【客户】数据访问层
 * @author 高振中
 * @date 2020-03-17 17:22:53
 **/
@Mapper
public interface ICustomerMapper extends BaseMapper<Customer> {
	
	/**
	 * @方法说明 自义联表查询
	 **/
	IPage<Customer> queryList(IPage<Customer> page, Customer param);
}
