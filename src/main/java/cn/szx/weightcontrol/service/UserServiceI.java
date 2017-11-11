package cn.szx.weightcontrol.service;

import cn.szx.weightcontrol.pagemodel.DataGrid;
import cn.szx.weightcontrol.pagemodel.User;

public interface UserServiceI {
	public User save(User user) throws Exception;

	public User login(User user) throws Exception;

	public DataGrid datagrid(User user) throws Exception;

	public void remove(String id) throws Exception;

	public User edit(User user) throws Exception;
}
