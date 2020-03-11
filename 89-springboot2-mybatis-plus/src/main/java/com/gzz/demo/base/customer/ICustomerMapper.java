package com.gzz.demo.base.customer;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
 
import org.apache.ibatis.annotations.Mapper;
/**
 * @类说明 【客户】数据访问层
 * @author 高振中
 * @date 2020-03-11 17:57:13
 **/
@Mapper
public interface ICustomerMapper extends BaseMapper<Customer> {
	
	/**
	 * @方法说明 自义联表查询
	 **/
	IPage<Customer> queryList(IPage<Customer> page, Customer param);
}
