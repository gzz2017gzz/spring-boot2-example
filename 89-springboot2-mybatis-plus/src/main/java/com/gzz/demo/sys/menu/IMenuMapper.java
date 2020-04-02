package com.gzz.demo.sys.menu;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
 
import org.apache.ibatis.annotations.Mapper;
/**
 * @类说明 【菜单】数据访问层
 * @author 高振中
 * @date 2020-04-02 20:40:14
 **/
@Mapper
public interface IMenuMapper extends BaseMapper<Menu> {
	
//	/**
//	 * @方法说明 自义联表查询
//	 **/
//	IPage<Menu> queryList(IPage<Menu> page, Menu param);
}
