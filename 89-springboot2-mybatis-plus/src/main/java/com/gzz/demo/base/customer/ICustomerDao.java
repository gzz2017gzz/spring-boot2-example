package com.gzz.demo.base.customer;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
/**
 * @类说明 [客户]数据访问层
 * @author 高振中
 * @date 2020-02-25 23:45:20
 **/
@Mapper
public interface ICustomerDao extends BaseMapper<Customer> {

}
