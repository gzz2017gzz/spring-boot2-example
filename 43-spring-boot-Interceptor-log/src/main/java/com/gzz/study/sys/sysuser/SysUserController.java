package com.gzz.study.sys.sysuser;
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
 * @类说明 [用户]控制器
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 **/
@RestController
@RequestMapping("sysUser")
public class SysUserController {

	@SuppressWarnings("unused")
	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private SysUserService service; //注入用户数据逻辑层

    /**
     * @方法说明  新增[用户]记录
     */
	@PostMapping("save")
	public int save(@RequestBody SysUser sysUser) {
		return service.save(sysUser);
	}

    /**
     * @方法说明 删除用户记录(多条)
     */
	@PostMapping("delete")
	public int delete(@RequestParam("ids[]") Long ids[]) {
		return service.delete(ids);
	}

    /**
     * @方法说明 修改用户记录
     */
	@PostMapping("update")
	public int update(@RequestBody SysUser sysUser) {
		return service.update(sysUser);
	}

    /**
     * @方法说明 按条件查询分页用户列表
     */
	@PostMapping("queryPage")
	public Page<SysUser> queryPage(@RequestBody SysUserCond cond ){
		return service.queryPage(cond);
	}

    /**
     * @方法说明 按条件查询不分页用户列表
     */
	@PostMapping("queryList")
	public List<SysUser> queryList(@RequestBody SysUserCond cond ){
		return service.queryList(cond);
	}

    /**
     * @方法说明 按主键查单个用户记录
     */
	@PostMapping("findById")
	public SysUser findById(@RequestParam("id") Long id) {
		return service.findById(id);
	}

    /**
     * @方法说明 按条件查询用户记录个数
     */
	@PostMapping("queryCount")
	public long queryCount(@RequestBody SysUserCond cond ){
		return service.queryCount(cond);
	}
}