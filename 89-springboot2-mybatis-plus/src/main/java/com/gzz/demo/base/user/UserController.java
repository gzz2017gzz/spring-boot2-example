package com.gzz.demo.base.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gzz.common.util.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @类说明 【用户】控制器
 * @author 高振中
 * @date 2020-03-17 17:22:53
 **/
@Api(tags = "用户接口")
@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private IUserService service;// 注入【用户】业务逻辑接口

	/**
	 * @方法说明 新增【用户】记录
	 */
	@PostMapping
	@ApiOperation(value = "新增【客户】记录")
	public Response add(@RequestBody @Valid User user) {
		return Response.success(service.save(user));
	}

	/**
	 * @方法说明 按主键删除【用户】记录
	 */
	@DeleteMapping
	public Response delete(Integer id) {
		return Response.success(service.removeById(id));
	}

	/**
	 * @方法说明 修改【用户】记录
	 */
	@PutMapping
	public Response edit(@RequestBody @Valid User user) {
		return Response.success(service.updateById(user));
	}

	/**
	 * @方法说明 按条件查询分页【用户】列表
	 */
	@PostMapping("page")
	public Response page(@RequestBody User user, long current, long size) {
		return Response.success(service.page(new Page<User>(current, size), new QueryWrapper<User>(user)));
	}

	/**
	 * @方法说明 按主键查单个【用户】记录
	 */
	@GetMapping
	public Response get(Integer id) {
		return Response.success(service.getById(id));
	}
}
