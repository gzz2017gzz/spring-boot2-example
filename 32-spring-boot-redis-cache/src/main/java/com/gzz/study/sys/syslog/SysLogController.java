package com.gzz.study.sys.syslog;

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
 * @类说明 【请求日志】控制器
 * @author 高振中
 * @date 2020-03-12 12:11:06
 **/
//@Slf4j
@RestController
@RequestMapping("sysLog")
public class SysLogController {

	@Autowired
	private SysLogService sysLogService; // 注入【请求日志】业务逻辑层

	/**
	 * @方法说明 新增【请求日志】记录
	 */
	@PostMapping("save")
	public Result save(@RequestBody @Valid SysLog sysLog, BindingResult result) {
		if (result.hasErrors()) {
			return Result.error(1, "验证失败！", result.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList()));
		}
		return Result.success(sysLogService.save(sysLog));
	}

	/**
	 * @方法说明 删除【请求日志】记录
	 */
	@PostMapping("delete")
	public Result delete(Integer[] ids) {
		return Result.success(sysLogService.delete(ids));
	}

	/**
	 * @方法说明 修改【请求日志】记录
	 */
	@PostMapping("update")
	public Result update(@RequestBody @Valid SysLog sysLog, BindingResult result) {
		if (result.hasErrors()) {
			return Result.error(1, "验证失败！", result.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList()));
		}
		return Result.success(sysLogService.update(sysLog));
	}

	/**
	 * @方法说明 按条件查询分页【请求日志】列表
	 */
	@PostMapping("page")
	public Result page(@RequestBody SysLogCond cond) {
		return Result.success(sysLogService.page(cond));
	}

	/**
	 * @方法说明 按条件查询不分页【请求日志】列表
	 */
	@PostMapping("list")
	public Result list(@RequestBody SysLogCond cond) {
		return Result.success(sysLogService.list(cond));
	}

	/**
	 * @方法说明 按主键查单个【请求日志】记录
	 */
	@PostMapping("findById")
	public Result findById(@RequestParam("id") Integer id) {
		return Result.success(sysLogService.findById(id));
	}

	/**
	 * @方法说明 按条件查询【请求日志】记录个数
	 */
	@PostMapping("count")
	public Result count(@RequestBody SysLogCond cond) {
		return Result.success(sysLogService.count(cond));
	}
}