package com.gzz.sys.userrole;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzz.base.Page;

/**
 * @类说明 [用户角色关系]业务逻辑层
 * @author 高振中
 * @date 2018-12-24 21:36:34
 **/
@Service
public class UserRoleService {

	@SuppressWarnings("unused")
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private UserRoleDao dao; //注入用户角色关系数据访问层

	/**
	 * @方法说明 新增[用户角色关系]记录
	 */
	@Transactional
	public int save(UserRole userRole) {
		return dao.save(userRole);
	}

	/**
	 * @方法说明 删除用户角色关系记录(多条)
	 */
	public int delete(Long ids[]) {
		//return dao.deleteLogic(ids);//逻辑删除
		return dao.delete(ids);//物理删除
	}

	/**
	 * @方法说明 更新用户角色关系记录
	 */
	@Transactional
	public int update(UserRole userRole) {
		return dao.update(userRole); 
	}

	/**
	 * @方法说明 按条件查询分页用户角色关系列表
	 */
	public Page<UserRole> queryPage(UserRoleCond cond) {
		return dao.queryPage(cond);
	}

	/**
	 * @方法说明  按条件查询不分页用户角色关系列表 
	 */
	public List<UserRole> queryList(UserRoleCond cond) {
		return dao.queryList(cond);
	}

	/**
	 * @方法说明 按主键查找单个用户角色关系记录
	 */
	public UserRole findById(Long id) {
		return dao.findById(id);
	}

	/**
	 * @方法说明 按条件查询用户角色关系记录个数
	 */
	public long queryCount(UserRoleCond cond) {
		return dao.queryCount(cond);
	}
}