package com.gzz.study.sys.syslog;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzz.common.base.Page;

/**
 * @类说明 【请求日志】业务逻辑层
 * @author 高振中
 * @date 2020-03-12 12:11:06
 **/
//@Slf4j
@Service
public class SysLogService {

	@Autowired
	private SysLogDao sysLogDao; // 注入【请求日志】数据访问层

	/**
	 * @方法说明 新增【请求日志】记录
	 */
	// @Transactional
	public int save(SysLog sysLog) {
		return sysLogDao.save(sysLog);
	}

	/**
	 * @方法说明 删除【请求日志】记录
	 */
	public int delete(Integer[] ids) {
		return sysLogDao.delete(ids);
	}

	/**
	 * @方法说明 更新【请求日志】记录
	 */
	public int update(SysLog sysLog) {
		return sysLogDao.update(sysLog);
	}

	/**
	 * @方法说明 按条件查询分页【请求日志】列表
	 */
	public Page<SysLog> page(SysLogCond cond) {
		return sysLogDao.page(cond);
	}

	/**
	 * @方法说明 按条件查询不分页【请求日志】列表
	 */
	public List<SysLog> list(SysLogCond cond) {
		return sysLogDao.list(cond);
	}

	/**
	 * @方法说明 按主键查找单个【请求日志】记录
	 */
	public SysLog findById(Integer id) {
		return sysLogDao.findById(id);
	}

	/**
	 * @方法说明 按条件查询【请求日志】记录个数
	 */
	public int count(SysLogCond cond) {
		return sysLogDao.count(cond);
	}
}