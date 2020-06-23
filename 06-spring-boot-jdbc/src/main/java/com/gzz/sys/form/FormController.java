package com.gzz.sys.form;

import java.util.List;
import java.util.stream.Collectors;

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
 * @类说明 【字段定义】控制器
 * @author 高振中
 * @date 2020-06-17 18:03:53
 **/
//@Slf4j
@RestController
@RequestMapping("form")
@Api(tags = "【字段定义】API")
public class FormController {

	@Autowired
	private FormService formService; // 注入【字段定义】业务逻辑层

	/**
	 * @方法说明 新增【字段定义】记录
	 */
	@PostMapping("save")
	@ApiOperation(value = "新增【字段定义】记录")
	public Result<Integer> save(@RequestBody @Valid Form form) {
		return Result.success(formService.save(form));
	}

	/**
	 * @方法说明 删除【字段定义】记录
	 */
	@PostMapping("delete")
	@ApiOperation(value = "删除【字段定义】记录")
	public Result<Integer> delete(String[] ids) {
		return Result.success(formService.delete(ids));
	}

	/**
	 * @方法说明 修改【字段定义】记录
	 */
	@PostMapping("update")
	@ApiOperation(value = "修改【字段定义】记录")
	public Result<Integer> update(@RequestBody @Valid Form form) {
		return Result.success(formService.update(form));
	}

	/**
	 * @方法说明 按条件查询分页【字段定义】列表
	 */
	@PostMapping("page")
	@ApiOperation(value = "按条件查询分页【字段定义】列表")
	public Result<Page<Form>> page(@RequestBody FormCond cond) {
		return Result.success(formService.page(cond));
	}

	/**
	 * @方法说明 按条件查询【字段定义】列表
	 */
	@PostMapping("list")
	@ApiOperation(value = "按条件查询不分页【字段定义】列表")
	public Result<List<?>> list(@RequestBody FormCond cond) {
		List<Form> forms = formService.list(cond);
		return Result.success(forms.stream().map(i->i.getJson()).collect(Collectors.toList()));
	}

	/**
	 * @方法说明 按主键查单个【字段定义】记录
	 */
	@PostMapping("findById")
	@ApiOperation(value = "按主键查单个【字段定义】记录")
	public Result<Form> findById(@RequestParam("id") String id) {
		return Result.success(formService.findById(id));
	}

	/**
	 * @方法说明 按条件查询【字段定义】记录个数
	 */
	@PostMapping("count")
	@ApiOperation(value = "【字段定义】记录个数")
	public Result<Integer> count(@RequestBody FormCond cond) {
		return Result.success(formService.count(cond));
	}
}