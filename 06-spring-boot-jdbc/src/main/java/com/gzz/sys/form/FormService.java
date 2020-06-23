package com.gzz.sys.form;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzz.common.base.Page;

/**
 * @类说明 【字段定义】业务逻辑层
 * @author 高振中
 * @date 2020-06-17 18:03:53
 **/
//@Slf4j
@Service
public class FormService {

	@Autowired
	private FormDao formDao; // 注入【字段定义】数据访问层

	/**
	 * @方法说明 新增【字段定义】记录
	 */
	// @Transactional
	public int save(Form form) {
		return formDao.save(form);
	}

	/**
	 * @方法说明 删除【字段定义】记录
	 */
	public int delete(String[] ids) {
		return formDao.delete(ids);
	}

	/**
	 * @方法说明 更新【字段定义】记录
	 */
	public int update(Form form) {
		return formDao.update(form);
	}

	/**
	 * @方法说明 按条件查询分页【字段定义】列表
	 */
	public Page<Form> page(FormCond cond) {
		return formDao.page(cond);
	}

	/**
	 * @方法说明 按条件查询【字段定义】列表
	 */
	public List<Form> list(FormCond cond) {
		return formDao.list(cond);
	}

	/**
	 * @方法说明 按主键查找单个【字段定义】记录
	 */
	public Form findById(String id) {
		return formDao.findById(id);
	}

	/**
	 * @方法说明 按条件查询【字段定义】记录个数
	 */
	public int count(FormCond cond) {
		return formDao.count(cond);
	}
}