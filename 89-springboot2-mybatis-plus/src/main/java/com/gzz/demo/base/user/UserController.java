package com.gzz.demo.base.user;

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
 * @类说明 【用户】控制器
 * @author 高振中
 * @date 2020-04-02 20:56:51
 **/
@Api(tags = "用户接口")
@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private IUserService userService;//注入【用户】业务逻辑接口
	
	/**
	 * @方法说明  新增【用户】记录
	 */
	@PostMapping("add")
	@ApiOperation(value = "新增【用户】记录")
	 public Result<Boolean> add(@RequestBody @Valid User user) {
 		return Result.success(userService.save(user));
	}
	
	/**
	 * @方法说明 按主键删除【用户】记录
	 */
	@PostMapping("delete")
	@ApiOperation(value = "按主键删除【用户】记录")
	public Result<Boolean> delete(Integer id) {
		return Result.success(userService.removeById(id));
	}
	
	/**
	 * @方法说明 修改【用户】记录
	 */
	@PostMapping("edit")
	@ApiOperation(value = "修改【用户】记录")
	public Result<Boolean> edit(@RequestBody @Valid User user) {
 		return Result.success(userService.updateById(user));
	}
	
	/**
	 * @方法说明 按条件查询分页【用户】列表
	 */
	@PostMapping("page")
	@ApiOperation(value = "按条件查询分页【用户】列表")
	public Result<IPage<User>> page(@RequestBody UserCond cond) {
		User user= new User();
		BeanUtils.copyProperties(cond, user);
		return Result.success(userService.page(new Page<User>(cond.getPage(),cond.getSize()), new QueryWrapper<User>(user)));
	}
	
	/**
	 * @方法说明 按主键查单个【用户】记录
	 */
	@PostMapping("findById")
	@ApiOperation(value = "按主键查单个【用户】记录")
	public Result<User> get(Integer id) {
		return Result.success(userService.getById(id));
	}
}
