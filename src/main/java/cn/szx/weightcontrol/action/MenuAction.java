package cn.szx.weightcontrol.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import cn.szx.weightcontrol.pagemodel.Menu;
import cn.szx.weightcontrol.service.MenuServiceI;

import com.opensymphony.xwork2.ModelDriven;

@Namespace("/menu")
@Action(value = "menuAction")
public class MenuAction extends BaseAction implements ModelDriven<Menu> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	Menu menu = new Menu();

	@Override
	public Menu getModel() {
		return menu;
	}

	private MenuServiceI menuService;

	public MenuServiceI getMenuService() {
		return menuService;
	}

	@Autowired
	public void setMenuService(MenuServiceI menuService) {
		this.menuService = menuService;
	}

	public void getTreeNode() {
		try {
			super.writeJson(menuService.getTreeNode(menu.getId()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
