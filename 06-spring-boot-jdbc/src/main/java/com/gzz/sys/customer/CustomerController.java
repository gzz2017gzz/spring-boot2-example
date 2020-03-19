package com.gzz.sys.customer;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.common.base.Page;
import com.gzz.common.config.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @类说明 【客户】控制器
 * @author 高振中
 * @date 2020-03-18 14:31:03
 **/
//@Slf4j
@RestController
@RequestMapping("customer")
@Api(tags = "【客户】API")
public class CustomerController {

	@Autowired
	private CustomerService customerService; // 注入【客户】业务逻辑层

	/**
	 * @方法说明 新增【客户】记录
	 */
	@PostMapping("save")
	@ApiOperation(value = "新增【客户】记录")
	public Result<Integer> save(@RequestBody @Valid Customer customer) {
		return Result.success(customerService.save(customer));
	}

	/**
	 * @方法说明 删除【客户】记录
	 */
	@PostMapping("delete")
	@ApiOperation(value = "删除【客户】记录")
	public Result<Integer> delete(Integer[] ids) {
		return Result.success(customerService.delete(ids));
	}

	/**
	 * @方法说明 修改【客户】记录
	 */
	@PostMapping("update")
	@ApiOperation(value = "修改【客户】记录")
	public Result<Integer> update(@RequestBody @Valid Customer customer) {
		return Result.success(customerService.update(customer));
	}

	/**
	 * @方法说明 按条件查询分页【客户】列表
	 */
	@PostMapping("page")
	@ApiOperation(value = "按条件查询分页【客户】列表")
	public Result<Page<Customer>> page(@RequestBody CustomerCond cond) {
		return Result.success(customerService.page(cond));
	}

	/**
	 * @方法说明 按条件查询【客户】列表
	 */
	@PostMapping("list")
//	@ApiOperation(value = "按条件查询不分页【客户】列表")
	public Result<List<Customer>> list(@RequestBody CustomerCond cond) {
		return Result.success(customerService.list(cond));
	}

	/**
	 * @方法说明 按主键查单个【客户】记录
	 */
	@PostMapping("findById")
//	@ApiOperation(value = "按主键查单个【客户】记录")
	public Result<Customer> findById(@RequestParam("id") Integer id) {
		return Result.success(customerService.findById(id));
	}

	/**
	 * @方法说明 按条件查询【客户】记录个数
	 */
	@PostMapping("count")
//	@ApiOperation(value = "【客户】记录个数")
	public Result<Integer> count(@RequestBody CustomerCond cond) {
		return Result.success(customerService.count(cond));
	}
}