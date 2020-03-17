package com.gzz.demo.base.customer;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gzz.common.util.Response;

import io.swagger.annotations.Api;

/**
 * @类说明 【客户】控制器
 * @author 高振中
 * @date 2020-03-17 17:22:53
 **/
@Api(tags = "客户接口")
@RestController
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private ICustomerService service;// 注入【客户】业务逻辑接口

	/**
	 * @方法说明 新增【客户】记录
	 */
	@PostMapping
	public Response<Boolean> add(@RequestBody @Valid Customer customer) {
		return Response.success(service.save(customer));
	}

	/**
	 * @方法说明 按主键删除【客户】记录
	 */
	@DeleteMapping
	public Response<Boolean> delete(Integer id) {
		return Response.success(service.removeById(id));
	}

	/**
	 * @方法说明 修改【客户】记录
	 */
	@PutMapping
	public Response<Boolean> edit(@RequestBody @Valid Customer customer) {
		return Response.success(service.updateById(customer));
	}

	/**
	 * @方法说明 按条件查询分页【客户】列表
	 */
	@PostMapping("page")
	public Response<IPage<Customer>> page(@RequestBody Customer customer, long current, long size) {
		return Response.success(service.queryList(new Page<Customer>(current, size), customer));
	}

	/**
	 * @方法说明 按主键查单个【客户】记录
	 */
	@GetMapping
	public Response<Customer> get(Integer id) {
		return Response.success(service.getById(id));
	}
}
