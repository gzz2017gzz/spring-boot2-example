package com.gzz.demo.sys.role;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

/**
 * @类说明 【角色】业务逻辑实现
 * @author 高振中
 * @date 2020-04-02 20:40:14
 **/
//@Slf4j
@Service
public class RoleServiceImpl extends ServiceImpl<IRoleMapper, Role> implements IRoleService {
//	@Autowired
//	private IRoleMapper roleMapper;//注入【角色】数据访问接口
//	
//	/**
//	 * @方法说明 自定义联表查询
//	 **/
//	@Override
//	public IPage<Role> queryList(IPage<Role> page, Role param){
//		return roleMapper.queryList(page,param);
//	}
}