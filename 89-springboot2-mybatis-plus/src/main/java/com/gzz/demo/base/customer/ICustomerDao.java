package com.gzz.demo.base.customer;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @类说明 【客户】数据访问层
 * @author 高振中
 * @date 2020-02-26 00:57:08
 **/
@Mapper
public interface ICustomerDao extends BaseMapper<Customer> {

}
