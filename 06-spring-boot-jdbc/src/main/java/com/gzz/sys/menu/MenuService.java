package com.gzz.sys.menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.List;
import com.gzz.common.base.Page;

/**
 * @类说明 [菜单]业务逻辑层
 * @author 高振中
 * @date 2020-02-26 22:07:45
 **/
//@Slf4j
@Service
public class MenuService {
 
	@Autowired
	private MenuDao dao; //注入菜单数据访问层

	/**
	 * @方法说明 新增[菜单]记录
	 */
	//@Transactional
	public int save(Menu menu) {
		return dao.save(menu);
	}

	/**
	 * @方法说明 删除菜单记录(多条)
	 */
	public int delete(Integer ids[]) {
		//return dao.deleteLogic(ids);//逻辑删除
		return dao.delete(ids);//物理删除
	}

	/**
	 * @方法说明 更新菜单记录
	 */
	public int update(Menu menu) {
		return dao.update(menu); 
	}

	/**
	 * @方法说明 按条件查询分页菜单列表
	 */
	public Page<Menu> queryPage(MenuCond cond) {
		return dao.queryPage(cond);
	}

	/**
	 * @方法说明  按条件查询不分页菜单列表 
	 */
//	public List<Menu> queryList(MenuCond cond) {
//		return dao.queryList(cond);
//	}

	/**
	 * @方法说明 按主键查找单个菜单记录
	 */
//	public Menu findById(Integer id) {
//		return dao.findById(id);
//	}

	/**
	 * @方法说明 按条件查询菜单记录个数
	 */
//	public long queryCount(MenuCond cond) {
//		return dao.queryCount(cond);
//	}
}