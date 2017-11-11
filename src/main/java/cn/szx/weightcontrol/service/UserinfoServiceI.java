package cn.szx.weightcontrol.service;

import cn.szx.weightcontrol.pagemodel.DataGrid;
import cn.szx.weightcontrol.pagemodel.Userinfo;

/**
 * 
 * @ClassName: UserinfoServiceI
 * @Description: TODO
 * @author: 宋桢熙
 * @date: 2014年9月2日 上午11:00:46
 */
public interface UserinfoServiceI {
	/**
	 * 
	 * @Title: save
	 * @Description: 用户执行 "新增" 操作时，将前台传递过来的数据存储至数据表 w_userinfo 中
	 * @param userinfo
	 * @throws Exception
	 * @return: Userinfo
	 */
	public Userinfo save(Userinfo userinfo) throws Exception;

	/**
	 * 
	 * @Title: edit
	 * @Description: 用户执行 "更新" 操作时，将前台传递过来的数据存储至数据表 w_userinfo 中
	 * @param userinfo
	 * @throws Exception
	 * @return: Userinfo
	 */
	public Userinfo edit(Userinfo userinfo) throws Exception;

	/**
	 * 
	 * @Title: remove
	 * @Description: 用户执行 "删除" 操作时，根据前台传递过来的参数 ids 到数据表 w_userinfo 中找到对应的数据并执行删除操作
	 * @param userinfo
	 * @throws Exception
	 * @return: void
	 */
	public void remove(Userinfo userinfo) throws Exception;

	/**
	 * 
	 * @Title: datagrid
	 * @Description: 将当前登录的 User 对象的属性 id 的值作为参数对表 w_userinfo 执行查询操作，将 w_user 表中字段 user_id 的值等于 id 的所有数据返回给前台用于数据展示。
	 * @param userinfo
	 * @throws Exception
	 * @return: DataGrid
	 */
	public DataGrid datagrid(Userinfo userinfo) throws Exception;
}
