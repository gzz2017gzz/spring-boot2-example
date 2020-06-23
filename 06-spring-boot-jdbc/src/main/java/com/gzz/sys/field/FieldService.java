package com.gzz.sys.field;
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
public class FieldService {

	@Autowired
	private FieldDao fieldDao; // 注入【字段定义】数据访问层

	/**
	 * @方法说明 新增【字段定义】记录
	 */
	// @Transactional
	public int save(Field field) {
		return fieldDao.save(field);
	}

	/**
	 * @方法说明 删除【字段定义】记录
	 */
	public int delete(String[] ids) {
		return fieldDao.delete(ids);
	}

	/**
	 * @方法说明 更新【字段定义】记录
	 */
	public int update(Field field) {
		return fieldDao.update(field);
	}

	/**
	 * @方法说明 按条件查询分页【字段定义】列表
	 */
	public Page<Field> page(FieldCond cond) {
		return fieldDao.page(cond);
	}

	/**
	 * @方法说明 按条件查询【字段定义】列表
	 */
	public List<Field> list(FieldCond cond) {
		return fieldDao.list(cond);
	}

	/**
	 * @方法说明 按主键查找单个【字段定义】记录
	 */
	public Field findById(String id) {
		return fieldDao.findById(id);
	}

	/**
	 * @方法说明 按条件查询【字段定义】记录个数
	 */
	public int count(FieldCond cond) {
		return fieldDao.count(cond);
	}
}