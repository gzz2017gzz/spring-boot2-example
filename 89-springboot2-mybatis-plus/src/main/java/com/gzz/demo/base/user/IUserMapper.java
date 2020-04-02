package com.gzz.demo.base.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
 
import org.apache.ibatis.annotations.Mapper;
/**
 * @类说明 【用户】数据访问层
 * @author 高振中
 * @date 2020-04-02 20:37:42
 **/
@Mapper
public interface IUserMapper extends BaseMapper<User> {
	
//	/**
//	 * @方法说明 自义联表查询
//	 **/
//	IPage<User> queryList(IPage<User> page, User param);
}
