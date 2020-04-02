package com.gzz.demo.base.customer;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
 
import org.apache.ibatis.annotations.Mapper;
/**
 * @类说明 【客户】数据访问层
 * @author 高振中
 * @date 2020-04-02 20:56:51
 **/
@Mapper
public interface ICustomerMapper extends BaseMapper<Customer> {
	
//	/**
//	 * @方法说明 自义联表查询
//	 **/
//	IPage<Customer> queryPage(IPage<Customer> page, Customer param);
}
