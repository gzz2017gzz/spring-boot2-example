package com.gzz.sys.function;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzz.base.Page;

/**
 * @类说明 [功能]业务逻辑层
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 **/
@Service
public class FunctionService {

	@SuppressWarnings("unused")
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private FunctionDao dao; //注入功能数据访问层

	/**
	 * @方法说明 新增[功能]记录
	 */
	@Transactional
	public int save(Function function) {
		return dao.save(function);
	}

	/**
	 * @方法说明 删除功能记录(多条)
	 */
	public int delete(Long ids[]) {
		//return dao.deleteLogic(ids);//逻辑删除
		return dao.delete(ids);//物理删除
	}

	/**
	 * @方法说明 更新功能记录
	 */
	@Transactional
	public int update(Function function) {
		return dao.update(function); 
	}

	/**
	 * @方法说明 按条件查询分页功能列表
	 */
	public Page<Function> queryPage(FunctionCond cond) {
		return dao.queryPage(cond);
	}

	/**
	 * @方法说明  按条件查询不分页功能列表 
	 */
	public List<Function> queryList(FunctionCond cond) {
		return dao.queryList(cond);
	}

	/**
	 * @方法说明 按主键查找单个功能记录
	 */
	public Function findById(Long id) {
		return dao.findById(id);
	}

	/**
	 * @方法说明 按条件查询功能记录个数
	 */
	public long queryCount(FunctionCond cond) {
		return dao.queryCount(cond);
	}
}