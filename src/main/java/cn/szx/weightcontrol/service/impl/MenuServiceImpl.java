/**
 * 
 */
package cn.szx.weightcontrol.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.szx.weightcontrol.dao.WMenuMapper;
import cn.szx.weightcontrol.model.WMenu;
import cn.szx.weightcontrol.pagemodel.Menu;
import cn.szx.weightcontrol.service.MenuServiceI;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @ClassName: MenuServiceImpl
 * @Description: TODO
 * @author: 宋桢熙
 * @date: 2014年9月2日 上午10:18:12
 */
@Service("menuService")
public class MenuServiceImpl implements MenuServiceI {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MenuServiceImpl.class);

	private WMenuMapper menuMapper;

	public WMenuMapper getMenuMapper() {
		return menuMapper;
	}

	@Autowired
	public void setMenuMapper(WMenuMapper menuMapper) {
		this.menuMapper = menuMapper;
	}

	/**
	 * 
	 * @Title: getTreeNode
	 * @Description: 异步加载树结构，返回值为：List<Menu>，即父节点值为ID的所有根节点数据的集合
	 * @param id
	 *          前台返回给后台用于查询父节点值为ID的所有根节点数据
	 * @return List<Menu>,将查询的数据放入List集合中
	 * @throws Exception
	 * @see cn.szx.weightcontrol.service.MenuServiceI#getTreeNode(java.lang.String)
	 * @see cn.szx.weightcontrol.dao.WMenuMapper#selectAllByParamsIsNull()
	 * @see cn.szx.weightcontrol.dao.WMenuMapper#selectAllByParentId(String)
	 */
	@Override
	public List<Menu> getTreeNode(String id) throws Exception {
		/*
		 * jquery-easyui 框架 "异步加载" 时会根据后台返回给前台的 json 数据中 state 的值 ('open' or 'closed') 来判断是否向后台发请求，
		 * 故 getTreeNode()存在 id 为 Null 和 id 不为 Null 的两种情况
		 */
		List<Menu> menuList = new ArrayList<Menu>();
		Menu menu;
		// 刚进入页面时，jquery-easyui 以 "post" 方式向后台发送请求，参数为 Null，此时需要获得根节点对象
		if (id == null || id.equals("")) {
			/*
			 * 如果刚进入页面，前台会以POST方式，将NULL返回给后台，此时根据后台DAO层进行查询， 
			 * 如果数据库中表w_menu表中的数据，parent_id字段值为空 则为根节点。
			 */
			WMenu wmenu = menuMapper.selectAllByParamsIsNull();
			menu = new Menu();
			BeanUtils.copyProperties(wmenu, menu);
			/*
			 * attributes: 自定义的属性，可以添加到树形展示节点，官网给出的例子： "attributes":{ "url":"/demo/book/abc", "price":100}， 
			 * 因此将此属性定义为Map类型
			 */
			Map<String, Object> attributes = new HashMap<String, Object>();
			attributes.put("url", wmenu.getUrl());
			menu.setAttributes(attributes);
			/*
			 * menuMapper.selectAllByParentId(wmenu.getId())，的返回类型为List，
			 * 这段代码的意思是： 如果前台返回给后台一个id，后台根据这个id值进行查询对应数据表w_menu的parent_id字段， 
			 * 将所有parent_id = id的数据放入到Set集合中，如果Set不为空，则将state值设置为 "closed"，state的默认值为 "open"
			 */
			if (menuMapper.selectAllByParentId(wmenu.getId()) != null && menuMapper.selectAllByParentId(wmenu.getId()).size() > 0) {
				/*
				 * node state, 'open' or 'closed', default is 'open'. When set to 'closed', the node have children nodes and will load them from remote site 节点状态、 '打开' 关闭'，默认值为 '打开'。设置为关闭时，该节点有子节点和将从远程站点加载它们， 只有state的值为："closed"时，jquery-easyui才会向后台返回对应父节点的id。
				 */
				menu.setState("closed");
			}
			menuList.add(menu);
		} else {
			/*
			 * 如果前台返回非NULL的 id值，则根据此id的值查找所有parent_id的值为id的所有数据，
			 * 并将这些数据放入List集合中，将List集合处理为 前台要求的JSON格式数据，以完成树形展示
			 */
			List<WMenu> wmenuList = menuMapper.selectAllByParentId(id);
			logger.info(JSON.toJSONString(wmenuList));
			if (wmenuList != null && wmenuList.size() > 0) {
				for (WMenu wmenu : wmenuList) {
					menu = new Menu();
					BeanUtils.copyProperties(wmenu, menu);
					/*
					 * attributes: 自定义的属性，可以添加到树形展示节点，官网给出的例子： "attributes":{ "url":"/demo/book/abc", "price":100}，
					 * 因此将此属性定义为Map类型
					 */
					Map<String, Object> attributes = new HashMap<String, Object>();
					attributes.put("url", wmenu.getUrl());
					menu.setAttributes(attributes);
					/*
					 * menuMapper.selectAllByParentId(wmenu.getId())，的返回类型为List，
					 * 这段代码的意思是： 如果前台返回给后台一个id，后台根据这个id值进行查询对应数据表w_menu的parent_id字段， 
					 * 将所有parent_id = id的数据放入到Set集合中，如果Set不为空，则将state值设置为 "closed"，state的默认值为 "open"
					 */
					if (menuMapper.selectAllByParentId(wmenu.getId()) != null && menuMapper.selectAllByParentId(wmenu.getId()).size() > 0) {
						/*
						 * node state, 'open' or 'closed', default is 'open'. 
						 * When set to 'closed', the node have children nodes and will load them from remote site 
						 * 节点状态、 '打开' 关闭'，默认值为 '打开'。设置为关闭时，该节点有子节点和将从远程站点加载它们，
						 * 只有state的值为："closed"时，jquery-easyui才会向后台返回对应父节点的id。
						 */
						menu.setState("closed");
					}
					logger.info(menu.getState());
					menuList.add(menu);
				}
			}
		}
		return menuList;
	}

}