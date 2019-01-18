package com.gzz.study.sys.syslog;
import java.util.List;
import com.gzz.common.base.Page;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @类说明 [请求日志]业务逻辑层
 * @author 高振中
 * @date 2019-01-12 23:40:32
 **/
@Service
public class SysLogService {

	@SuppressWarnings("unused")
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private SysLogDao dao; //注入请求日志数据访问层

	/**
	 * @方法说明 新增[请求日志]记录
	 */
	@Transactional
	public int save(SysLog sysLog) {
		return dao.save(sysLog);
	}

	/**
	 * @方法说明 删除请求日志记录(多条)
	 */
	public int delete(Integer ids[]) {
		//return dao.deleteLogic(ids);//逻辑删除
		return dao.delete(ids);//物理删除
	}

	/**
	 * @方法说明 更新请求日志记录
	 */
	@Transactional
	public int update(SysLog sysLog) {
		return dao.update(sysLog); 
	}

	/**
	 * @方法说明 按条件查询分页请求日志列表
	 */
	public Page<SysLog> queryPage(SysLogCond cond) {
		return dao.queryPage(cond);
	}

	/**
	 * @方法说明  按条件查询不分页请求日志列表 
	 */
	public List<SysLog> queryList(SysLogCond cond) {
		return dao.queryList(cond);
	}

	/**
	 * @方法说明 按主键查找单个请求日志记录
	 */
	public SysLog findById(Integer id) {
		return dao.findById(id);
	}

	/**
	 * @方法说明 按条件查询请求日志记录个数
	 */
	public long queryCount(SysLogCond cond) {
		return dao.queryCount(cond);
	}
}