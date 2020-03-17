package com.gzz.sys.user;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzz.common.base.Page;

/**
 * @类说明 【用户】业务逻辑层
 * @author 高振中
 * @date 2020-03-17 23:46:44
 **/
//@Slf4j
@Service
public class UserService {

	@Autowired
	private UserDao userDao; // 注入【用户】数据访问层

	/**
	 * @方法说明 新增【用户】记录
	 */
	// @Transactional
	public int save(User user) {
		return userDao.save(user);
	}

	/**
	 * @方法说明 删除【用户】记录
	 */
	public int delete(Long[] ids) {
		return userDao.delete(ids);
	}

	/**
	 * @方法说明 更新【用户】记录
	 */
	public int update(User user) {
		return userDao.update(user);
	}

	/**
	 * @方法说明 按条件查询分页【用户】列表
	 */
	public Page<User> page(UserCond cond) {
		return userDao.page(cond);
	}

	/**
	 * @方法说明 按条件查询不分页【用户】列表
	 */
	public List<User> list(UserCond cond) {
		return userDao.list(cond);
	}

	/**
	 * @方法说明 按主键查找单个【用户】记录
	 */
	public User findById(Long id) {
		return userDao.findById(id);
	}

	/**
	 * @方法说明 按条件查询【用户】记录个数
	 */
	public int count(UserCond cond) {
		return userDao.count(cond);
	}
}