package com.gzz.demo.sys.dict;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

/**
 * @类说明 【枚举字典】业务逻辑实现
 * @author 高振中
 * @date 2020-04-02 20:40:14
 **/
//@Slf4j
@Service
public class DictServiceImpl extends ServiceImpl<IDictMapper, Dict> implements IDictService {
//	@Autowired
//	private IDictMapper dictMapper;//注入【枚举字典】数据访问接口
//	
//	/**
//	 * @方法说明 自定义联表查询
//	 **/
//	@Override
//	public IPage<Dict> queryList(IPage<Dict> page, Dict param){
//		return dictMapper.queryList(page,param);
//	}
}