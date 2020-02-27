package com.gzz.sys.menu;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.common.utils.Result;

/**
 * @类说明 [菜单]控制器
 * @author 高振中
 * @date 2020-02-26 22:07:45
 **/
@RestController
@RequestMapping("menu")
//@Slf4j
public class MenuController {

	@Autowired
	private MenuService service; // 注入菜单业务逻辑层

	/**
	 * @方法说明 新增[菜单]记录
	 */
	@PostMapping("save")
	public Result save(@RequestBody @Valid Menu menu, BindingResult result) {
		if (result.hasErrors()) {
			return Result.error(1, "验证失败！", result.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList()));
		}
		return Result.success(service.save(menu));
	}

	/**
	 * @方法说明 删除菜单记录(多条)
	 */
	@DeleteMapping("delete")
	public Result delete(Integer ids[]) {
		return Result.success(service.delete(ids));
	}

	/**
	 * @方法说明 修改菜单记录
	 */
	@PostMapping("update")
	public Result update(@RequestBody Menu menu, BindingResult result) {
		if (result.hasErrors()) {
			return Result.error(1, "验证失败！", result.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList()));
		}
		return Result.success(service.update(menu));
	}

	/**
	 * @方法说明 按条件查询分页菜单列表
	 */
	@PostMapping("queryPage")
	public Result queryPage(@RequestBody MenuCond cond) {
		return Result.success(service.queryPage(cond));
	}

	/**
	 * @方法说明 按条件查询不分页菜单列表
	 */
	@PostMapping("queryList")
	public Result queryList(@RequestBody MenuCond cond) {
		return Result.success(service.queryList(cond));
	}

	/**
	 * @方法说明 按主键查单个菜单记录
	 */
//	@PostMapping("findById")
//	public Result findById(@RequestParam("id") Integer id) {
//		return Result.success(service.findById(id));
//	}

	/**
	 * @方法说明 按条件查询菜单记录个数
	 */
//	@PostMapping("queryCount")
//	public Result queryCount(@RequestBody MenuCond cond ){
//		return Result.success(service.queryCount(cond));
//	}
}