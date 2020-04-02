package com.gzz.demo.sys.dict;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
 
import org.apache.ibatis.annotations.Mapper;
/**
 * @类说明 【枚举字典】数据访问层
 * @author 高振中
 * @date 2020-04-02 20:40:14
 **/
@Mapper
public interface IDictMapper extends BaseMapper<Dict> {
	
//	/**
//	 * @方法说明 自义联表查询
//	 **/
//	IPage<Dict> queryList(IPage<Dict> page, Dict param);
}
