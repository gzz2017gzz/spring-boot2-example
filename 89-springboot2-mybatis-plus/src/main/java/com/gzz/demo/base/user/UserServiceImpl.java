package com.gzz.demo.base.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

/**
 * @类说明 【用户】业务逻辑实现
 * @author 高振中
 * @date 2020-04-02 20:56:51
 **/
//@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<IUserMapper, User> implements IUserService {
//	@Autowired
//	private IUserMapper userMapper;//注入【用户】数据访问接口
//	
//	/**
//	 * @方法说明 自定义联表查询
//	 **/
//	@Override
//	public IPage<User> queryPage(IPage<User> page, User param){
//		return userMapper.queryPage(page,param);
//	}
}