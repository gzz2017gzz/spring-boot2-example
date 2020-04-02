package com.gzz.demo.sys.role;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gzz.common.util.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @类说明 【角色】控制器
 * @author 高振中
 * @date 2020-04-02 20:40:14
 **/
@Api(tags = "角色接口")
@RestController
@RequestMapping("role")
public class RoleController {

	@Autowired
	private IRoleService roleService;//注入【角色】业务逻辑接口
	
	/**
	 * @方法说明  新增【角色】记录
	 */
	@PostMapping("add")
	@ApiOperation(value = "新增【角色】记录")
	 public Result<Boolean> add(@RequestBody @Valid Role role) {
 		return Result.success(roleService.save(role));
	}
	
	/**
	 * @方法说明 按主键删除【角色】记录
	 */
	@PostMapping("delete")
	@ApiOperation(value = "按主键删除【角色】记录")
	public Result<Boolean> delete(Integer id) {
		return Result.success(roleService.removeById(id));
	}
	
	/**
	 * @方法说明 修改【角色】记录
	 */
	@PostMapping("edit")
	@ApiOperation(value = "修改【角色】记录")
	public Result<Boolean> edit(@RequestBody @Valid Role role) {
 		return Result.success(roleService.updateById(role));
	}
	
	/**
	 * @方法说明 按条件查询分页【角色】列表
	 */
	@PostMapping("page")
	@ApiOperation(value = "按条件查询分页【角色】列表")
	public Result<IPage<Role>> page(@RequestBody RoleCond cond) {
		Role role= new Role();
		BeanUtils.copyProperties(cond, role);
		return Result.success(roleService.page(new Page<Role>(cond.getPage(),cond.getSize()), new QueryWrapper<Role>(role)));
	}
	
	/**
	 * @方法说明 按主键查单个【角色】记录
	 */
	@PostMapping("findById")
	@ApiOperation(value = "按主键查单个【角色】记录")
	public Result<Role> get(Integer id) {
		return Result.success(roleService.getById(id));
	}
}
