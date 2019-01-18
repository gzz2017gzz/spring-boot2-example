package com.gzz.study.sys.syslog;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.gzz.common.base.Page;

/**
 * @类说明 [请求日志]控制器
 * @author 高振中
 * @date 2019-01-12 23:40:32
 **/
@RestController
@RequestMapping("sysLog")
public class SysLogController {

	@SuppressWarnings("unused")
	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private SysLogService service; //注入请求日志数据逻辑层

    /**
     * @方法说明  新增[请求日志]记录
     */
	@PostMapping("save")
	public int save(@RequestBody SysLog sysLog) {
		return service.save(sysLog);
	}

    /**
     * @方法说明 删除请求日志记录(多条)
     */
	@PostMapping("delete")
	public int delete(@RequestParam("ids[]") Integer ids[]) {
		return service.delete(ids);
	}

    /**
     * @方法说明 修改请求日志记录
     */
	@PostMapping("update")
	public int update(@RequestBody SysLog sysLog) {
		return service.update(sysLog);
	}

    /**
     * @方法说明 按条件查询分页请求日志列表
     */
	@PostMapping("queryPage")
	public Page<SysLog> queryPage(@RequestBody SysLogCond cond ){
		return service.queryPage(cond);
	}

    /**
     * @方法说明 按条件查询不分页请求日志列表
     */
	@PostMapping("queryList")
	public List<SysLog> queryList(@RequestBody SysLogCond cond ){
		return service.queryList(cond);
	}

    /**
     * @方法说明 按主键查单个请求日志记录
     */
	@PostMapping("findById")
	public SysLog findById(@RequestParam("id") Integer id) {
		return service.findById(id);
	}

    /**
     * @方法说明 按条件查询请求日志记录个数
     */
	@PostMapping("queryCount")
	public long queryCount(@RequestBody SysLogCond cond ){
		return service.queryCount(cond);
	}
}