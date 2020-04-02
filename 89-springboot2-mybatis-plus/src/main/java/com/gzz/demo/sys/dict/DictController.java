package com.gzz.demo.sys.dict;

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
 * @类说明 【枚举字典】控制器
 * @author 高振中
 * @date 2020-04-02 20:40:14
 **/
@Api(tags = "枚举字典接口")
@RestController
@RequestMapping("dict")
public class DictController {

	@Autowired
	private IDictService dictService;//注入【枚举字典】业务逻辑接口
	
	/**
	 * @方法说明  新增【枚举字典】记录
	 */
	@PostMapping("add")
	@ApiOperation(value = "新增【枚举字典】记录")
	 public Result<Boolean> add(@RequestBody @Valid Dict dict) {
 		return Result.success(dictService.save(dict));
	}
	
	/**
	 * @方法说明 按主键删除【枚举字典】记录
	 */
	@PostMapping("delete")
	@ApiOperation(value = "按主键删除【枚举字典】记录")
	public Result<Boolean> delete(Integer id) {
		return Result.success(dictService.removeById(id));
	}
	
	/**
	 * @方法说明 修改【枚举字典】记录
	 */
	@PostMapping("edit")
	@ApiOperation(value = "修改【枚举字典】记录")
	public Result<Boolean> edit(@RequestBody @Valid Dict dict) {
 		return Result.success(dictService.updateById(dict));
	}
	
	/**
	 * @方法说明 按条件查询分页【枚举字典】列表
	 */
	@PostMapping("page")
	@ApiOperation(value = "按条件查询分页【枚举字典】列表")
	public Result<IPage<Dict>> page(@RequestBody DictCond cond) {
		Dict dict= new Dict();
		BeanUtils.copyProperties(cond, dict);
		return Result.success(dictService.page(new Page<Dict>(cond.getPage(),cond.getSize()), new QueryWrapper<Dict>(dict)));
	}
	
	/**
	 * @方法说明 按主键查单个【枚举字典】记录
	 */
	@PostMapping("findById")
	@ApiOperation(value = "按主键查单个【枚举字典】记录")
	public Result<Dict> get(Integer id) {
		return Result.success(dictService.getById(id));
	}
}
