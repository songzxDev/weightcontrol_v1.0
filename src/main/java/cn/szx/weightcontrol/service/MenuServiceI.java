package cn.szx.weightcontrol.service;

import java.util.List;

import cn.szx.weightcontrol.pagemodel.Menu;

public interface MenuServiceI {
	public List<Menu> getTreeNode(String id) throws Exception;
	
}
