package com.gzz.sys.user;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzz.common.base.Page;

/**
 * @类说明 【用户】业务逻辑层
 * @author 高振中
 * @date 2020-02-28 15:14:25
 **/
//@Slf4j
@Service
public class UserService {
 
	@Autowired
	private UserDao dao; //注入用户数据访问层

	/**
	 * @方法说明 新增【用户】记录
	 */
	//@Transactional
	public int save(User user) {
		return dao.save(user);
	}

	/**
	 * @方法说明 删除【用户】记录(多条)
	 */
	public int delete(Integer ids[]) {
		return dao.delete(ids);//物理删除
	}

	/**
	 * @方法说明 更新【用户】记录
	 */
	public int update(User user) {
		return dao.update(user); 
	}

	/**
	 * @方法说明 按条件查询分页【用户】列表
	 */
	public Page<User> queryPage(UserCond cond) {
		return dao.queryPage(cond);
	}

	/**
	 * @方法说明  按条件查询不分页【用户】列表 
	 */
	public List<User> queryList(UserCond cond) {
		return dao.queryList(cond);
	}

	/**
	 * @方法说明 按主键查找单个【用户】记录
	 */
	public User findById(Integer id) {
		return dao.findById(id);
	}

	/**
	 * @方法说明 按条件查询【用户】记录个数
	 */
	public long queryCount(UserCond cond) {
		return dao.queryCount(cond);
	}
}