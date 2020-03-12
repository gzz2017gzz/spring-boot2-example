package com.gzz.study.sys.sysuser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.gzz.common.base.Page;

/**
 * @类说明 【用户】业务逻辑层
 * @author 高振中
 * @date 2020-03-12 12:11:06
 **/
//@Slf4j
@Service
@CacheConfig(cacheNames = "user")
public class SysUserService {

	@Autowired
	private SysUserDao sysUserDao; // 注入【用户】数据访问层

	/**
	 * @方法说明 新增【用户】记录
	 */
	// @Transactional
	public int save(SysUser sysUser) {
		return sysUserDao.save(sysUser);
	}

	/**
	 * @方法说明 删除【用户】记录
	 */
	public int delete(Long[] ids) {
		return sysUserDao.delete(ids);
	}

	/**
	 * @方法说明 更新【用户】记录
	 */
	public int update(SysUser sysUser) {
		return sysUserDao.update(sysUser);
	}

	/**
	 * @方法说明 按条件查询分页【用户】列表
	 */
//	@Cacheable
	public Page<SysUser> page(SysUserCond cond) {
		return sysUserDao.page(cond);
	}

	/**
	 * @方法说明 按条件查询不分页【用户】列表
	 */
	@Cacheable
	public List<SysUser> list(SysUserCond cond) {
		return sysUserDao.list(cond);
	}

	/**
	 * @方法说明 按主键查找单个【用户】记录
	 */
	@Cacheable
	public SysUser findById(Long id) {
		return sysUserDao.findById(id);
	}

	/**
	 * @方法说明 按条件查询【用户】记录个数
	 */
	public int count(SysUserCond cond) {
		return sysUserDao.count(cond);
	}
}