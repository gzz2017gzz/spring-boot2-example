package com.gzz.demo.base.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
/**
 * @类说明 [用户]数据访问层
 * @author 高振中
 * @date 2020-02-25 23:45:20
 **/
@Mapper
public interface IUserDao extends BaseMapper<User> {

}
