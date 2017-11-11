package cn.szx.weightcontrol.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import cn.szx.weightcontrol.pagemodel.Json;
import cn.szx.weightcontrol.pagemodel.User;
import cn.szx.weightcontrol.service.UserServiceI;

import com.opensymphony.xwork2.ModelDriven;

@Namespace("/user")
@Action(value = "userAction")
public class UserAction extends BaseAction implements ModelDriven<User> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	User user = new User();

	@Override
	public User getModel() {
		return user;
	}

	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(UserAction.class);
	private UserServiceI userService;

	public UserServiceI getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}

	public void regist() {
		Json j = new Json();
		try {
			user = userService.save(user);
			if (user.isStatus() == true) {
				j.setSuccess(true);
				j.setMsg("注册成功！");
			} else {
				j.setSuccess(false);
				j.setMsg("注册失败，用户名已存在！");
			}
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}

		super.writeJson(j);
	}

	public void login() {
		Json j = new Json();
		try {
			user = userService.login(user);
			if (user.isStatus() == true) {
				j.setSuccess(true);
				j.setMsg("登录成功！");
				session.put("user", user);
			} else {
				j.setSuccess(false);
				j.setMsg("登录失败，用户名不存在或者密码错误！");
			}
		} catch (Exception e) {
			j.setMsg("登录失败，用户名或密码错误！");
		}

		super.writeJson(j);
	}

	public void add() {

	}

	public void datagrid() {
	}

	public void remove() {
	}

	public void edit() {
	}
}