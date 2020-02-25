package com.gzz.demo.sys.menu;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gzz.common.util.Result;

/**
 * @类说明 [菜单]控制器
 * @author 高振中
 * @date 2020-02-25 23:40:14
 **/
@RestController
@RequestMapping("menu")
public class MenuController {

	@Autowired
	private MenuService service;// 注入[菜单]业务逻辑接口

	/**
	 * @方法说明 新增[菜单]记录
	 */
	@PostMapping
	public Result add(@RequestBody @Valid Menu menu, BindingResult result) {
		if (result.hasErrors()) {
			return Result.error(1, result.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList()).toString());
		}
		return Result.success(service.save(menu));
	}

	/**
	 * @方法说明 按主键删除菜单记录
	 */
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable Integer id) {
		return Result.success(service.removeById(id));
	}

	/**
	 * @方法说明 修改菜单记录
	 */
	@PutMapping
	public Result edit(@RequestBody @Valid Menu menu, BindingResult result) {
		if (result.hasErrors()) {
			return Result.error(1, result.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList()).toString());
		}
		return Result.success(service.updateById(menu));
	}

	/**
	 * @方法说明 按条件查询分页菜单列表
	 */
	@PostMapping("/page/{current}/{size}")
	public Result page(@RequestBody Menu menu, @PathVariable long current, @PathVariable long size) {
		return Result.success(service.page(new Page<Menu>(current, size), new QueryWrapper<Menu>(menu)));
	}

	/**
	 * @方法说明 按主键查单个菜单记录
	 */
	@GetMapping("/{id}")
	public Result get(@PathVariable Integer id) {
		return Result.success(service.getById(id));
	}
}
