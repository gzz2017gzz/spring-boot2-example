package com.gzz.demo.sys.menu;

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
 * @类说明 【菜单】控制器
 * @author 高振中
 * @date 2020-04-02 20:40:14
 **/
@Api(tags = "菜单接口")
@RestController
@RequestMapping("menu")
public class MenuController {

	@Autowired
	private IMenuService menuService;//注入【菜单】业务逻辑接口
	
	/**
	 * @方法说明  新增【菜单】记录
	 */
	@PostMapping("add")
	@ApiOperation(value = "新增【菜单】记录")
	 public Result<Boolean> add(@RequestBody @Valid Menu menu) {
 		return Result.success(menuService.save(menu));
	}
	
	/**
	 * @方法说明 按主键删除【菜单】记录
	 */
	@PostMapping("delete")
	@ApiOperation(value = "按主键删除【菜单】记录")
	public Result<Boolean> delete(Integer id) {
		return Result.success(menuService.removeById(id));
	}
	
	/**
	 * @方法说明 修改【菜单】记录
	 */
	@PostMapping("edit")
	@ApiOperation(value = "修改【菜单】记录")
	public Result<Boolean> edit(@RequestBody @Valid Menu menu) {
 		return Result.success(menuService.updateById(menu));
	}
	
	/**
	 * @方法说明 按条件查询分页【菜单】列表
	 */
	@PostMapping("page")
	@ApiOperation(value = "按条件查询分页【菜单】列表")
	public Result<IPage<Menu>> page(@RequestBody MenuCond cond) {
		Menu menu= new Menu();
		BeanUtils.copyProperties(cond, menu);
		return Result.success(menuService.page(new Page<Menu>(cond.getPage(),cond.getSize()), new QueryWrapper<Menu>(menu)));
	}
	
	/**
	 * @方法说明 按主键查单个【菜单】记录
	 */
	@PostMapping("findById")
	@ApiOperation(value = "按主键查单个【菜单】记录")
	public Result<Menu> get(Integer id) {
		return Result.success(menuService.getById(id));
	}
}
