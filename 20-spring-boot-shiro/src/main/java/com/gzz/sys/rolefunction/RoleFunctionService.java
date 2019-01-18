package com.gzz.sys.rolefunction;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzz.base.Page;

/**
 * @类说明 [角色功能关系]业务逻辑层
 * @author 高振中
 * @date 2018-12-24 21:36:34
 **/
@Service
public class RoleFunctionService {

	@SuppressWarnings("unused")
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private RoleFunctionDao dao; //注入角色功能关系数据访问层

	/**
	 * @方法说明 新增[角色功能关系]记录
	 */
	@Transactional
	public int save(RoleFunction roleFunction) {
		return dao.save(roleFunction);
	}

	/**
	 * @方法说明 删除角色功能关系记录(多条)
	 */
	public int delete(Long ids[]) {
		//return dao.deleteLogic(ids);//逻辑删除
		return dao.delete(ids);//物理删除
	}

	/**
	 * @方法说明 更新角色功能关系记录
	 */
	@Transactional
	public int update(RoleFunction roleFunction) {
		return dao.update(roleFunction); 
	}

	/**
	 * @方法说明 按条件查询分页角色功能关系列表
	 */
	public Page<RoleFunction> queryPage(RoleFunctionCond cond) {
		return dao.queryPage(cond);
	}

	/**
	 * @方法说明  按条件查询不分页角色功能关系列表 
	 */
	public List<RoleFunction> queryList(RoleFunctionCond cond) {
		return dao.queryList(cond);
	}

	/**
	 * @方法说明 按主键查找单个角色功能关系记录
	 */
	public RoleFunction findById(Long id) {
		return dao.findById(id);
	}

	/**
	 * @方法说明 按条件查询角色功能关系记录个数
	 */
	public long queryCount(RoleFunctionCond cond) {
		return dao.queryCount(cond);
	}
}