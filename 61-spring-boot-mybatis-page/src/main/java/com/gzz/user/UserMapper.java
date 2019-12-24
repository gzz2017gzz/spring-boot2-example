package com.gzz.user;

import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
	int countByUsername(String username);
}
