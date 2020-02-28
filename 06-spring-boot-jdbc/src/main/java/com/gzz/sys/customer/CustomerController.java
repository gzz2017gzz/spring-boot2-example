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
 * @date 2020-02-28 14:34:06
 **/
//@Slf4j
@RestController
@RequestMapping("customer")
public class CustomerController {
 
	@Autowired
	private CustomerService service; //注入客户业务逻辑层

    /**
     * @方法说明  新增【客户】记录
     */
	@PostMapping("save")
	public Result save(@RequestBody @Valid Customer customer, BindingResult result) {
		if (result.hasErrors()) {
			return Result.error(1, "验证失败！", result.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList()));
		}
		return Result.success(service.save(customer));
	}

    /**
     * @方法说明 删除【客户】记录
     */
	@PostMapping("delete")
	public Result delete(Integer ids[]) {
		return Result.success(service.delete(ids));
	}

    /**
     * @方法说明 修改【客户】记录
     */
	@PostMapping("update")
	public Result update(@RequestBody @Valid Customer customer, BindingResult result) {
		if (result.hasErrors()) {
			return Result.error(1, "验证失败！", result.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList()));
		}
		return Result.success(service.update(customer));
	}

    /**
     * @方法说明 按条件查询分页【客户】列表
     */
	@PostMapping("queryPage")
	public Result queryPage(@RequestBody CustomerCond cond ){
		return Result.success(service.queryPage(cond));
	}

    /**
     * @方法说明 按条件查询不分页【客户】列表
     */
	@PostMapping("queryList")
	public Result queryList(@RequestBody CustomerCond cond ){
		return Result.success(service.queryList(cond));
	}

    /**
     * @方法说明 按主键查单个【客户】记录
     */
	@PostMapping("findById")
	public Result findById(@RequestParam("id") Integer id) {
		return Result.success(service.findById(id));
	}

    /**
     * @方法说明 按条件查询【客户】记录个数
     */
	@PostMapping("queryCount")
	public Result queryCount(@RequestBody CustomerCond cond ){
		return Result.success(service.queryCount(cond));
	}
}