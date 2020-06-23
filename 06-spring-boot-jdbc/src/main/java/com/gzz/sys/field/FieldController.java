package com.gzz.sys.field;

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
 * @类说明 【字段定义】控制器
 * @author 高振中
 * @date 2020-06-17 18:03:53
 **/
//@Slf4j
@RestController
@RequestMapping("field")
@Api(tags = "【字段定义】API")
public class FieldController {

	@Autowired
	private FieldService fieldService; // 注入【字段定义】业务逻辑层

	/**
	 * @方法说明 新增【字段定义】记录
	 */
	@PostMapping("save")
	@ApiOperation(value = "新增【字段定义】记录")
	public Result<Integer> save(@RequestBody @Valid Field field) {
		return Result.success(fieldService.save(field));
	}

	/**
	 * @方法说明 删除【字段定义】记录
	 */
	@PostMapping("delete")
	@ApiOperation(value = "删除【字段定义】记录")
	public Result<Integer> delete(String[] ids) {
		return Result.success(fieldService.delete(ids));
	}

	/**
	 * @方法说明 修改【字段定义】记录
	 */
	@PostMapping("update")
	@ApiOperation(value = "修改【字段定义】记录")
	public Result<Integer> update(@RequestBody @Valid Field field) {
		return Result.success(fieldService.update(field));
	}

	/**
	 * @方法说明 按条件查询分页【字段定义】列表
	 */
	@PostMapping("page")
	@ApiOperation(value = "按条件查询分页【字段定义】列表")
	public Result<Page<Field>> page(@RequestBody FieldCond cond) {
		return Result.success(fieldService.page(cond));
	}

	/**
	 * @方法说明 按条件查询【字段定义】列表
	 */
	@PostMapping("list")
	@ApiOperation(value = "按条件查询不分页【字段定义】列表")
	public Result<List<Field>> list(@RequestBody FieldCond cond) {
		return Result.success(fieldService.list(cond));
	}

	/**
	 * @方法说明 按主键查单个【字段定义】记录
	 */
	@PostMapping("findById")
	@ApiOperation(value = "按主键查单个【字段定义】记录")
	public Result<Field> findById(@RequestParam("id") String id) {
		return Result.success(fieldService.findById(id));
	}

	/**
	 * @方法说明 按条件查询【字段定义】记录个数
	 */
	@PostMapping("count")
	@ApiOperation(value = "【字段定义】记录个数")
	public Result<Integer> count(@RequestBody FieldCond cond) {
		return Result.success(fieldService.count(cond));
	}
}