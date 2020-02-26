package com.gzz.demo.base.customer;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @类说明 【客户】业务逻辑实现
 * @author 高振中
 * @date 2020-02-26 00:57:08
 **/
//@Slf4j
@Service
public class CustomerService extends ServiceImpl<ICustomerDao, Customer> {
//    @Autowired
//    private ICustomerDao dao;//注入[客户]数据访问接口
}