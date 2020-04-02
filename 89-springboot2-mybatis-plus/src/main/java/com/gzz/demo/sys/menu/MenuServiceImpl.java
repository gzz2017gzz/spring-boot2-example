package com.gzz.demo.sys.menu;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

/**
 * @类说明 【菜单】业务逻辑实现
 * @author 高振中
 * @date 2020-04-02 20:40:14
 **/
//@Slf4j
@Service
public class MenuServiceImpl extends ServiceImpl<IMenuMapper, Menu> implements IMenuService {
//	@Autowired
//	private IMenuMapper menuMapper;//注入【菜单】数据访问接口
//	
//	/**
//	 * @方法说明 自定义联表查询
//	 **/
//	@Override
//	public IPage<Menu> queryList(IPage<Menu> page, Menu param){
//		return menuMapper.queryList(page,param);
//	}
}