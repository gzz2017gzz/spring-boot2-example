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
import com.gzz.common.util.Response;
 
/**
 * @类说明 【客户】控制器
 * @author 高振中
 * @date 2020-03-11 17:57:13
 **/
 
@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private ICustomerService service;//注入【客户】业务逻辑接口

	/**
	 * @方法说明  新增【客户】记录
	 */
	 @PostMapping
	 public Response add(@RequestBody @Valid Customer customer, BindingResult result) {
		if (result.hasErrors()) {
			return Response.failure("1", result.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList()).toString());
		}
		return Response.success(service.save(customer));
	}

	/**
	 * @方法说明 按主键删除【客户】记录
	 */
	@DeleteMapping("/{id}")
	public Response delete(@PathVariable Integer id) {
		return Response.success( service.removeById(id) );
	}

	/**
	 * @方法说明 修改【客户】记录
	 */
	@PutMapping
	public Response edit(@RequestBody @Valid Customer customer, BindingResult result) {
		if (result.hasErrors()) {
			return Response.failure("1", result.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList()).toString());
		}
		return Response.success(service.updateById(customer));
	}
	/**
	 * @方法说明 按条件查询分页【客户】列表
	 */
	@PostMapping("/page/{current}/{size}")
	public Response page(@RequestBody Customer customer, @PathVariable long current, @PathVariable long size) {
		return Response.success(service.page(new Page<Customer>(current,size), new QueryWrapper<Customer>(customer)));
	}

	/**
	 * @方法说明 按主键查单个【客户】记录
	 */
	@GetMapping("/{id}")
	public Response get(@PathVariable Integer id) {
		return Response.success(service.getById(id));
	}
}
