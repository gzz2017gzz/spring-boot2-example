package com.gzz.study.sys.sysuser;

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
 * @date 2020-03-12 12:11:06
 **/
//@Slf4j
@RestController
@RequestMapping("sysUser")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService; // 注入【用户】业务逻辑层

	/**
	 * @方法说明 新增【用户】记录
	 */
	@PostMapping("save")
	public Result save(@RequestBody @Valid SysUser sysUser, BindingResult result) {
		if (result.hasErrors()) {
			return Result.error(1, "验证失败！", result.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList()));
		}
		return Result.success(sysUserService.save(sysUser));
	}

	/**
	 * @方法说明 删除【用户】记录
	 */
	@PostMapping("delete")
	public Result delete(Long[] ids) {
		return Result.success(sysUserService.delete(ids));
	}

	/**
	 * @方法说明 修改【用户】记录
	 */
	@PostMapping("update")
	public Result update(@RequestBody @Valid SysUser sysUser, BindingResult result) {
		if (result.hasErrors()) {
			return Result.error(1, "验证失败！", result.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList()));
		}
		return Result.success(sysUserService.update(sysUser));
	}

	/**
	 * @方法说明 按条件查询分页【用户】列表
	 */
	@PostMapping("page")
	public Result page(@RequestBody SysUserCond cond) {
		return Result.success(sysUserService.page(cond));
	}

	/**
	 * @方法说明 按条件查询不分页【用户】列表
	 */
	@PostMapping("list")
	public Result list(@RequestBody SysUserCond cond) {
		return Result.success(sysUserService.list(cond));
	}

	/**
	 * @方法说明 按主键查单个【用户】记录
	 */
	@PostMapping("findById")
	public Result findById(@RequestParam("id") Long id) {
		return Result.success(sysUserService.findById(id));
	}

	/**
	 * @方法说明 按条件查询【用户】记录个数
	 */
	@PostMapping("count")
	public Result count(@RequestBody SysUserCond cond) {
		return Result.success(sysUserService.count(cond));
	}
}