package com.gzz.sys.customer;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.common.config.Result;

/**
 * @类说明 【客户】控制器
 * @author 高振中
 * @date 2020-03-02 23:38:39
 **/
//@Slf4j
@RestController
@RequestMapping("customer")
public class CustomerController {
 
	@Autowired
	private CustomerService customerService; //注入【客户】业务逻辑层

    /**
     * @方法说明  新增【客户】记录
     */
	@PostMapping("save")
	public Result save(@RequestBody @Valid Customer customer, BindingResult result) {
		if (result.hasErrors()) {
			return Result.error(1, "验证失败！", result.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList()));
		}
		return Result.success(customerService.save(customer));
	}

    /**
     * @方法说明 删除【客户】记录
     */
	@PostMapping("delete")
	public Result delete(Integer ids[]) {
		return Result.success(customerService.delete(ids));
	}

    /**
     * @方法说明 修改【客户】记录
     */
	@PostMapping("update")
	public Result update(@RequestBody @Valid Customer customer, BindingResult result) {
		if (result.hasErrors()) {
			return Result.error(1, "验证失败！", result.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList()));
		}
		return Result.success(customerService.update(customer));
	}

    /**
     * @方法说明 按条件查询分页【客户】列表
     */
	@PostMapping("page")
	public Result page(@RequestBody CustomerCond cond ){
		return Result.success(customerService.page(cond));
	}

    /**
     * @方法说明 按条件查询不分页【客户】列表
     */
	@PostMapping("list")
	public Result list(@RequestBody CustomerCond cond ){
		return Result.success(customerService.list(cond));
	}

    /**
     * @方法说明 按主键查单个【客户】记录
     */
	@PostMapping("findById")
	public Result findById(@RequestParam("id") Integer id) {
		return Result.success(customerService.findById(id));
	}

    /**
     * @方法说明 按条件查询【客户】记录个数
     */
	@PostMapping("count")
	public Result count(@RequestBody CustomerCond cond ){
		return Result.success(customerService.count(cond));
	}
}