package com.gzz.sys.user;
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
 * @类说明 【用户】控制器
 * @author 高振中
 * @date 2020-02-28 15:14:25
 **/
//@Slf4j
@RestController
@RequestMapping("user")
public class UserController {
 
	@Autowired
	private UserService service; //注入用户业务逻辑层

    /**
     * @方法说明  新增【用户】记录
     */
	@PostMapping("save")
	public Result save(@RequestBody @Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return Result.error(1, "验证失败！", result.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList()));
		}
		return Result.success(service.save(user));
	}

    /**
     * @方法说明 删除【用户】记录
     */
	@PostMapping("delete")
	public Result delete(Integer ids[]) {
		return Result.success(service.delete(ids));
	}

    /**
     * @方法说明 修改【用户】记录
     */
	@PostMapping("update")
	public Result update(@RequestBody @Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return Result.error(1, "验证失败！", result.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList()));
		}
		return Result.success(service.update(user));
	}

    /**
     * @方法说明 按条件查询分页【用户】列表
     */
	@PostMapping("queryPage")
	public Result queryPage(@RequestBody UserCond cond ){
		return Result.success(service.queryPage(cond));
	}

    /**
     * @方法说明 按条件查询不分页【用户】列表
     */
	@PostMapping("queryList")
	public Result queryList(@RequestBody UserCond cond ){
		return Result.success(service.queryList(cond));
	}

    /**
     * @方法说明 按主键查单个【用户】记录
     */
	@PostMapping("findById")
	public Result findById(@RequestParam("id") Integer id) {
		return Result.success(service.findById(id));
	}

    /**
     * @方法说明 按条件查询【用户】记录个数
     */
	@PostMapping("queryCount")
	public Result queryCount(@RequestBody UserCond cond ){
		return Result.success(service.queryCount(cond));
	}
}