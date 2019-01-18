package com.gzz.sys.rolefunction;

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
 * @类说明 [角色功能关系]控制器
 * @author 高振中
 * @date 2018-12-24 21:36:34
 **/
@RestController
@RequestMapping("roleFunction")
public class RoleFunctionController {

	@SuppressWarnings("unused")
	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private RoleFunctionService service; // 注入角色功能关系数据逻辑层

	/**
	 * @方法说明 新增[角色功能关系]记录
	 */
	@PostMapping("save")
	public int save(@RequestBody RoleFunction roleFunction) {
		return service.save(roleFunction);
	}

	/**
	 * @方法说明 删除角色功能关系记录(多条)
	 */
	@PostMapping("delete")
	public int delete(@RequestParam("ids[]") Long ids[]) {
		return service.delete(ids);
	}

	/**
	 * @方法说明 修改角色功能关系记录
	 */
	@PostMapping("update")
	public int update(@RequestBody RoleFunction roleFunction) {
		return service.update(roleFunction);
	}

	/**
	 * @方法说明 按条件查询分页角色功能关系列表
	 */
	@PostMapping("queryPage")
	public Page<RoleFunction> queryPage(@RequestBody RoleFunctionCond cond) {
		return service.queryPage(cond);
	}

	/**
	 * @方法说明 按条件查询不分页角色功能关系列表
	 */
	@PostMapping("queryList")
	public List<RoleFunction> queryList(@RequestBody RoleFunctionCond cond) {
		return service.queryList(cond);
	}

	/**
	 * @方法说明 按主键查单个角色功能关系记录
	 */
	@PostMapping("findById")
	public RoleFunction findById(@RequestParam("id") Long id) {
		return service.findById(id);
	}

	/**
	 * @方法说明 按条件查询角色功能关系记录个数
	 */
	@PostMapping("queryCount")
	public long queryCount(@RequestBody RoleFunctionCond cond) {
		return service.queryCount(cond);
	}
}