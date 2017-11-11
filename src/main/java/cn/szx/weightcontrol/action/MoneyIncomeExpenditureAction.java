/**  
 * Copyright © 2014练习. All rights reserved.
 *
 * @Title: MoneyIncomeExpenditureAction.java
 * @Prject: weightcontrol_v1.0
 * @Package: cn.szx.weightcontrol.action
 * @Description: TODO
 * @author: 宋桢熙  
 * @date: 2014年9月19日 下午1:29:29
 * @version: V1.0  
 */
package cn.szx.weightcontrol.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import cn.szx.weightcontrol.pagemodel.DataGrid;
import cn.szx.weightcontrol.pagemodel.Json;
import cn.szx.weightcontrol.pagemodel.MoneyIncomeExpenditure;
import cn.szx.weightcontrol.pagemodel.User;
import cn.szx.weightcontrol.service.MoneyIncomeExpenditureServiceI;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @ClassName: MoneyIncomeExpenditureAction
 * @Description: TODO
 * @author: 宋桢熙
 * @date: 2014年9月19日 下午1:29:29
 */
@Namespace("/user")
@Action(value = "moneyIncomeExpenditureAction")
public class MoneyIncomeExpenditureAction extends BaseAction implements ModelDriven<MoneyIncomeExpenditure> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MoneyIncomeExpenditureAction.class);

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	MoneyIncomeExpenditure moneyIncomeExpenditure = new MoneyIncomeExpenditure();

	@Override
	public MoneyIncomeExpenditure getModel() {
		return moneyIncomeExpenditure;
	}

	private MoneyIncomeExpenditureServiceI moneyIncomeExpenditureService;

	public MoneyIncomeExpenditureServiceI getMoneyIncomeExpenditureService() {
		return moneyIncomeExpenditureService;
	}

	@Autowired
	public void setMoneyIncomeExpenditureService(MoneyIncomeExpenditureServiceI moneyIncomeExpenditureService) {
		this.moneyIncomeExpenditureService = moneyIncomeExpenditureService;
	}

	public void getCategorys() {
		try {
			super.writeJson(moneyIncomeExpenditureService.getCategorys());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getSubdivisions() {
		try {
			super.writeJson(moneyIncomeExpenditureService.getSubdivisions(moneyIncomeExpenditure.getId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void add() {
		Json j = new Json();
		try {
			User user = (User) session.get("user");
			logger.info("#########################      当前登录用户信息为：" + JSON.toJSONStringWithDateFormat(user, "yyyy-MM-dd HH:mm:ss") + "      #########################");
			moneyIncomeExpenditure.setUserId(user.getId());
			moneyIncomeExpenditure = moneyIncomeExpenditureService.save(moneyIncomeExpenditure);
			j.setSuccess(true);
			j.setMsg("增加成功！");
			j.setObj(moneyIncomeExpenditure);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		super.writeJson(j);
	}

	public void datagrid() {
		try {
			User user = (User) session.get("user");
			logger.info("#########################      当前登录用户信息为：" + JSON.toJSONStringWithDateFormat(user, "yyyy-MM-dd HH:mm:ss") + "      #########################");
			moneyIncomeExpenditure.setUserId(user.getId());
			DataGrid dataGrid = moneyIncomeExpenditureService.datagrid(moneyIncomeExpenditure);
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
			moneyIncomeExpenditureService.remove(moneyIncomeExpenditure);
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
			moneyIncomeExpenditure.setUserId(user.getId());
			moneyIncomeExpenditure = moneyIncomeExpenditureService.edit(moneyIncomeExpenditure);
			j.setSuccess(true);
			j.setMsg("更新成功！");
			j.setObj(moneyIncomeExpenditure);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		super.writeJson(j);
	}

	/**
	 * 
	 * @Title: remove
	 * @Description: 用户执行 "求和" 操作
	 * @return: void
	 */
	public void sum() {
		Json j = new Json();
		try {
			double inExAmoutSum = moneyIncomeExpenditureService.sum(moneyIncomeExpenditure);
			j.setSuccess(true);
			j.setMsg("求和成功，您所选的记录中收支金额总和为：￥" + inExAmoutSum);
			j.setObj(inExAmoutSum);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		super.writeJson(j);
	}
}
