package com.gzz.sys.user;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.common.base.Page;

/**
 * @类说明:用户数据控制器层
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 **/
@RestController
@RequestMapping("user")
public class UserController {
	@SuppressWarnings("unused")
	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private UserService service; // 注入用户数据逻辑层

	/**
	 * @方法说明:新增用户记录
	 **/
	@PostMapping("save")
	public int save(@RequestBody User user) {
		return service.save(user);
	}

	/**
	 * @方法说明:删除用户记录(多条)
	 **/
	@PostMapping("delete")
	public int delete(@RequestParam("ids[]") Long ids[]) {
		return service.delete(ids);
	}

	/**
	 * @方法说明:修改用户记录
	 **/
	@PostMapping("update")
	public int update(@RequestBody User user) {
		return service.update(user);
	}

	/**
	 * @方法说明:按条件查询分页用户列表
	 **/
	@PostMapping("queryPage")
	public Page<User> queryPage(@RequestBody UserCond cond) {
		return service.queryPage(cond);
	}

	/**
	 * @方法说明:按条件查询不分页用户列表
	 **/
	@PostMapping("queryList")
	public List<User> queryList(@RequestBody UserCond cond) {
		return service.queryList(cond);
	}

	/**
	 * @方法说明:按主键查单个用户记录
	 **/
	@GetMapping("findById")
	public User findById(@RequestParam("id") Long id) {
		return service.findById(id);
	}

	/**
	 * @方法说明:按条件查询用户记录个数
	 **/
	@PostMapping("queryCount")
	public long queryCount(@RequestBody UserCond cond) {
		return service.queryCount(cond);
	}
}