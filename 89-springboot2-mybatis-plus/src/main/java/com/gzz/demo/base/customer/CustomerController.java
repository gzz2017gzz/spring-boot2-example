package com.gzz.demo.base.customer;

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
 * @类说明 【客户】控制器
 * @author 高振中
 * @date 2020-04-02 20:56:51
 **/
@Api(tags = "客户接口")
@RestController
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;//注入【客户】业务逻辑接口
	
	/**
	 * @方法说明  新增【客户】记录
	 */
	@PostMapping("add")
	@ApiOperation(value = "新增【客户】记录")
	 public Result<Boolean> add(@RequestBody @Valid Customer customer) {
 		return Result.success(customerService.save(customer));
	}
	
	/**
	 * @方法说明 按主键删除【客户】记录
	 */
	@PostMapping("delete")
	@ApiOperation(value = "按主键删除【客户】记录")
	public Result<Boolean> delete(Integer id) {
		return Result.success(customerService.removeById(id));
	}
	
	/**
	 * @方法说明 修改【客户】记录
	 */
	@PostMapping("edit")
	@ApiOperation(value = "修改【客户】记录")
	public Result<Boolean> edit(@RequestBody @Valid Customer customer) {
 		return Result.success(customerService.updateById(customer));
	}
	
	/**
	 * @方法说明 按条件查询分页【客户】列表
	 */
	@PostMapping("page")
	@ApiOperation(value = "按条件查询分页【客户】列表")
	public Result<IPage<Customer>> page(@RequestBody CustomerCond cond) {
		Customer customer= new Customer();
		BeanUtils.copyProperties(cond, customer);
		return Result.success(customerService.page(new Page<Customer>(cond.getPage(),cond.getSize()), new QueryWrapper<Customer>(customer)));
	}
	
	/**
	 * @方法说明 按主键查单个【客户】记录
	 */
	@PostMapping("findById")
	@ApiOperation(value = "按主键查单个【客户】记录")
	public Result<Customer> get(Integer id) {
		return Result.success(customerService.getById(id));
	}
}
