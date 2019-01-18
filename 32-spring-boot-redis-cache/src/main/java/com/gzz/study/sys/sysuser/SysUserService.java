package com.gzz.study.sys.sysuser;

import java.util.List;
import com.gzz.common.base.Page;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @类说明 [用户]业务逻辑层
 * @author 高振中
 * @date 2019-01-13 00:00:31
 **/
@Service
@CacheConfig(cacheNames = "user")
public class SysUserService {

	@SuppressWarnings("unused")
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private SysUserDao dao; // 注入用户数据访问层

	/**
	 * @方法说明 新增[用户]记录
	 */
	@Transactional
	public int save(SysUser sysUser) {
		return dao.save(sysUser);
	}

	/**
	 * @方法说明 删除用户记录(多条)
	 */
	public int delete(Long ids[]) {
		// return dao.deleteLogic(ids);//逻辑删除
		return dao.delete(ids);// 物理删除
	}

	/**
	 * @方法说明 更新用户记录
	 */
	@Transactional
	public int update(SysUser sysUser) {
		return dao.update(sysUser);
	}

	/**
	 * @方法说明 按条件查询分页用户列表
	 */
	public Page<SysUser> queryPage(SysUserCond cond) {
		return dao.queryPage(cond);
	}

	/**
	 * @方法说明 按条件查询不分页用户列表
	 */
	@Cacheable 
	public List<SysUser> queryList(SysUserCond cond) {
		return dao.queryList(cond);
	}

	/**
	 * @方法说明 按主键查找单个用户记录
	 */
	@Cacheable 
	public SysUser findById(Long id) {
		return dao.findById(id);
	}

	/**
	 * @方法说明 按条件查询用户记录个数
	 */
	public long queryCount(SysUserCond cond) {
		return dao.queryCount(cond);
	}
}