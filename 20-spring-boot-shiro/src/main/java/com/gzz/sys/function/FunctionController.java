package com.gzz.sys.function;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.base.Page;

/**
 * @类说明 [功能]控制器
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 **/
@RestController
@RequestMapping("function")
public class FunctionController {

	@SuppressWarnings("unused")
	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private FunctionService service; //注入功能数据逻辑层

    /**
     * @方法说明  新增[功能]记录
     */
	@PostMapping("save")
	public int save(@RequestBody Function function) {
		return service.save(function);
	}

    /**
     * @方法说明 删除功能记录(多条)
     */
	@PostMapping("delete")
	public int delete(@RequestParam("ids[]") Long ids[]) {
		return service.delete(ids);
	}

    /**
     * @方法说明 修改功能记录
     */
	@PostMapping("update")
	public int update(@RequestBody Function function) {
		return service.update(function);
	}

    /**
     * @方法说明 按条件查询分页功能列表
     */
	@PostMapping("queryPage")
	public Page<Function> queryPage(@RequestBody FunctionCond cond ){
		return service.queryPage(cond);
	}

    /**
     * @方法说明 按条件查询不分页功能列表
     */
	@PostMapping("queryList")
	public List<Function> queryList(@RequestBody FunctionCond cond ){
		return service.queryList(cond);
	}

    /**
     * @方法说明 按主键查单个功能记录
     */
	@PostMapping("findById")
	public Function findById(@RequestParam("id") Long id) {
		return service.findById(id);
	}

    /**
     * @方法说明 按条件查询功能记录个数
     */
	@PostMapping("queryCount")
	public long queryCount(@RequestBody FunctionCond cond ){
		return service.queryCount(cond);
	}
}