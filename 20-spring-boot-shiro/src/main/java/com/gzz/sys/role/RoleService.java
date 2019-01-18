package com.gzz.sys.role;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzz.base.Page;

/**
 * @类说明 [角色]业务逻辑层
 * @author 高振中
 * @date 2018-12-24 21:36:34
 **/
@Service
public class RoleService {

	@SuppressWarnings("unused")
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private RoleDao dao; //注入角色数据访问层

	/**
	 * @方法说明 新增[角色]记录
	 */
	@Transactional
	public int save(Role role) {
		return dao.save(role);
	}

	/**
	 * @方法说明 删除角色记录(多条)
	 */
	public int delete(Long ids[]) {
		//return dao.deleteLogic(ids);//逻辑删除
		return dao.delete(ids);//物理删除
	}

	/**
	 * @方法说明 更新角色记录
	 */
	@Transactional
	public int update(Role role) {
		return dao.update(role); 
	}

	/**
	 * @方法说明 按条件查询分页角色列表
	 */
	public Page<Role> queryPage(RoleCond cond) {
		return dao.queryPage(cond);
	}

	/**
	 * @方法说明  按条件查询不分页角色列表 
	 */
	public List<Role> queryList(RoleCond cond) {
		return dao.queryList(cond);
	}

	/**
	 * @方法说明 按主键查找单个角色记录
	 */
	public Role findById(Long id) {
		return dao.findById(id);
	}

	/**
	 * @方法说明 按条件查询角色记录个数
	 */
	public long queryCount(RoleCond cond) {
		return dao.queryCount(cond);
	}
}