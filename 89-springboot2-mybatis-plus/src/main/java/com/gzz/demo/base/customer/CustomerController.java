package com.gzz.demo.base.customer;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gzz.common.util.Result;

/**
 * @类说明 [客户]控制器
 * @author 高振中
 * @date 2020-02-25 23:45:20
 **/
@RestController
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService service;// 注入[客户]业务逻辑接口

	/**
	 * @方法说明 新增[客户]记录
	 */
	@PostMapping
	public Result add(@RequestBody @Valid Customer customer, BindingResult result) {
		if (result.hasErrors()) {
			return Result.error(1, result.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList()).toString());
		}
		return Result.success(service.save(customer));
	}

	/**
	 * @方法说明 按主键删除客户记录
	 */
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable Integer id) {
		return Result.success(service.removeById(id));
	}

	/**
	 * @方法说明 修改客户记录
	 */
	@PutMapping
	public Result edit(@RequestBody @Valid Customer customer, BindingResult result) {
		if (result.hasErrors()) {
			return Result.error(1, result.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList()).toString());
		}
		return Result.success(service.updateById(customer));
	}

	/**
	 * @方法说明 按条件查询分页客户列表
	 */
	@PostMapping("/page/{current}/{size}")
	public Result page(@RequestBody Customer customer, @PathVariable long current, @PathVariable long size) {
		return Result.success(service.page(new Page<Customer>(current, size), new QueryWrapper<Customer>(customer)));
	}

	/**
	 * @方法说明 按主键查单个客户记录
	 */
	@GetMapping("/{id}")
	public Result get(@PathVariable Integer id) {
		return Result.success(service.getById(id));
	}
}
