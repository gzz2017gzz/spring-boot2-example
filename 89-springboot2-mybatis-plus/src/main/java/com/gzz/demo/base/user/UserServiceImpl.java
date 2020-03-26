package com.gzz.demo.base.user;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @类说明 【用户】业务逻辑实现
 * @author 高振中
 * @date 2020-03-17 17:22:53
 **/
//@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<IUserMapper, User> implements IUserService {
//	@Autowired
//	private IUserMapper userMapper;//注入【用户】数据访问接口
//	
//	/**
//	 * @方法说明 自义联表查询
//	 **/
//	@Override
//	public IPage<User> queryList(IPage<User> page, User param){
//		return userMapper.queryList(page,param);
//	}
}