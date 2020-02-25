package com.gzz.demo.base.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @类说明 [用户]业务逻辑实现
 * @author 高振中
 * @date 2020-02-25 23:45:20
 **/
//@Slf4j
@Service
public class UserService extends ServiceImpl<IUserDao, User> {
//    @Autowired
//    private IUserDao dao;//注入[用户]数据访问接口
}