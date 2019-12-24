package com.gzz.sys.role;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.base.Page;

/**
 * @类说明 [角色]控制器
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 **/
@RestController
@RequestMapping("role")
public class RoleController {

	@SuppressWarnings("unused")
	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private RoleService service; // 注入角色数据逻辑层

	/**
	 * @方法说明 新增[角色]记录
	 */
	@PostMapping("save")
	public int save(@RequestBody Role role) {
		return service.save(role);
	}

	/**
	 * @方法说明 删除角色记录(多条)
	 */
	@PostMapping("delete")
	public int delete(@RequestParam("ids[]") Long ids[]) {
		return service.delete(ids);
	}

	/**
	 * @方法说明 修改角色记录
	 */
	@PostMapping("update")
	public int update(@RequestBody Role role) {
		return service.update(role);
	}

	/**
	 * @方法说明 按条件查询分页角色列表
	 */
	@PostMapping("queryPage")
	public Page<Role> queryPage(@RequestBody RoleCond cond) {
		return service.queryPage(cond);
	}

	/**
	 * @方法说明 按条件查询不分页角色列表
	 */
	@PostMapping("queryList")
	public List<Role> queryList(@RequestBody RoleCond cond) {
		return service.queryList(cond);
	}

	/**
	 * @方法说明 按主键查单个角色记录
	 */
	@PostMapping("findById")
	public Role findById(@RequestParam("id") Long id) {
		return service.findById(id);
	}

	/**
	 * @方法说明 按条件查询角色记录个数
	 */
	@PostMapping("queryCount")
	public long queryCount(@RequestBody RoleCond cond) {
		return service.queryCount(cond);
	}
}