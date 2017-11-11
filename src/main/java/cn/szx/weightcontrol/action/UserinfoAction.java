package cn.szx.weightcontrol.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import cn.szx.weightcontrol.pagemodel.DataGrid;
import cn.szx.weightcontrol.pagemodel.Json;
import cn.szx.weightcontrol.pagemodel.User;
import cn.szx.weightcontrol.pagemodel.Userinfo;
import cn.szx.weightcontrol.service.UserinfoServiceI;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/user")
@Action(value = "userinfoAction")
public class UserinfoAction extends BaseAction implements ModelDriven<Userinfo> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(UserinfoAction.class);

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	Userinfo userinfo = new Userinfo();

	@Override
	public Userinfo getModel() {
		return userinfo;
	}

	private UserinfoServiceI userinfoService;

	public UserinfoServiceI getUserinfoService() {
		return userinfoService;
	}

	@Autowired
	public void setUserinfoService(UserinfoServiceI userinfoService) {
		this.userinfoService = userinfoService;
	}

	/**
	 * 
	 * @Title: add
	 * @Description: 用户执行 "新增" 操作
	 * @return: void
	 */
	public void add() {
		Json j = new Json();
		try {
			User user = (User) session.get("user");
			logger.info("#########################      当前登录用户信息为：" + JSON.toJSONStringWithDateFormat(user, "yyyy-MM-dd HH:mm:ss") + "      #########################");
			userinfo.setUserId(user.getId());
			userinfo.setName(user.getName());
			userinfo.setSex(user.getSex());
			userinfo = userinfoService.save(userinfo);
			j.setSuccess(true);
			j.setMsg("增加成功！");
			j.setObj(userinfo);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		super.writeJson(j);
	}

	/**
	 * 
	 * @Title: datagrid
	 * @Description: 用户查看个人体检信息
	 * @return: void
	 */
	public void datagrid() {
		try {
			User user = (User) session.get("user");
			logger.info("#########################      当前登录用户信息为：" + JSON.toJSONStringWithDateFormat(user, "yyyy-MM-dd HH:mm:ss") + "      #########################");
			userinfo.setUserId(user.getId());
			DataGrid dataGrid = userinfoService.datagrid(userinfo);
			super.writeJson(dataGrid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: remove
	 * @Description: 用户执行 "删除" 操作
	 * @return: void
	 */
	public void remove() {
		Json j = new Json();
		try {
			userinfoService.remove(userinfo);
			j.setSuccess(true);
			j.setMsg("删除成功！");
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		super.writeJson(j);
	}

	/**
	 * 
	 * @Title: edit
	 * @Description: 用户执行 "更新" 操作
	 * @return: void
	 */
	public void edit() {
		Json j = new Json();
		try {
			User user = (User) session.get("user");
			logger.info("#########################      当前登录用户信息为：" + JSON.toJSONStringWithDateFormat(user, "yyyy-MM-dd HH:mm:ss") + "      #########################");
			userinfo.setUserId(user.getId());
			userinfo.setName(user.getName());
			userinfo.setSex(user.getSex());
			userinfo = userinfoService.edit(userinfo);
			j.setSuccess(true);
			j.setMsg("更新成功！");
			j.setObj(userinfo);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		super.writeJson(j);
	}
}
