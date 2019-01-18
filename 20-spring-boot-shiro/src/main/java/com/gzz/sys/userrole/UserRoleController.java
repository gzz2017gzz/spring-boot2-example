package com.gzz.sys.userrole;
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
 * @类说明 [用户角色关系]控制器
 * @author 高振中
 * @date 2018-12-24 21:36:34
 **/
@RestController
@RequestMapping("userRole")
public class UserRoleController {

	@SuppressWarnings("unused")
	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private UserRoleService service; //注入用户角色关系数据逻辑层

    /**
     * @方法说明  新增[用户角色关系]记录
     */
	@PostMapping("save")
	public int save(@RequestBody UserRole userRole) {
		return service.save(userRole);
	}

    /**
     * @方法说明 删除用户角色关系记录(多条)
     */
	@PostMapping("delete")
	public int delete(@RequestParam("ids[]") Long ids[]) {
		return service.delete(ids);
	}

    /**
     * @方法说明 修改用户角色关系记录
     */
	@PostMapping("update")
	public int update(@RequestBody UserRole userRole) {
		return service.update(userRole);
	}

    /**
     * @方法说明 按条件查询分页用户角色关系列表
     */
	@PostMapping("queryPage")
	public Page<UserRole> queryPage(@RequestBody UserRoleCond cond ){
		return service.queryPage(cond);
	}

    /**
     * @方法说明 按条件查询不分页用户角色关系列表
     */
	@PostMapping("queryList")
	public List<UserRole> queryList(@RequestBody UserRoleCond cond ){
		return service.queryList(cond);
	}

    /**
     * @方法说明 按主键查单个用户角色关系记录
     */
	@PostMapping("findById")
	public UserRole findById(@RequestParam("id") Long id) {
		return service.findById(id);
	}

    /**
     * @方法说明 按条件查询用户角色关系记录个数
     */
	@PostMapping("queryCount")
	public long queryCount(@RequestBody UserRoleCond cond ){
		return service.queryCount(cond);
	}
}