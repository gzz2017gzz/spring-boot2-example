package com.gzz.demo.sys.dict;

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
 * @类说明 [枚举字典]控制器
 * @author 高振中
 * @date 2020-02-25 23:40:14
 **/
@RestController
@RequestMapping("dict")
public class DictController {

    @Autowired
    private DictService service;//注入[枚举字典]业务逻辑接口

    /**
     * @方法说明  新增[枚举字典]记录
     */
    @PostMapping
    public Result add(@RequestBody @Valid Dict dict, BindingResult result) {
		if (result.hasErrors()) {
			return Result.error(1, result.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList()).toString());
		}
        return Result.success(service.save(dict));
    }

    /**
     * @方法说明 按主键删除枚举字典记录
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.success( service.removeById(id) );
    }

    /**
     * @方法说明 修改枚举字典记录
     */
    @PutMapping
    public Result edit(@RequestBody @Valid Dict dict, BindingResult result) {
		if (result.hasErrors()) {
			return Result.error(1, result.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList()).toString());
		}
        return Result.success(service.updateById(dict));
    }
    /**
     * @方法说明 按条件查询分页枚举字典列表
     */
    @PostMapping("/page/{current}/{size}")
    public Result page(@RequestBody Dict dict, @PathVariable long current, @PathVariable long size) {
        return Result.success(service.page(new Page<Dict>(current,size), new QueryWrapper<Dict>(dict)));
    }

    /**
     * @方法说明 按主键查单个枚举字典记录
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id) {
        return Result.success(service.getById(id));
    }
}
