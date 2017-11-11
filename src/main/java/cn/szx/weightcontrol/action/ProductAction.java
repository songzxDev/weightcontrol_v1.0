/**  
 * Copyright © 2014公司名字. All rights reserved.
 *
 * @Title: ProductAction.java
 * @Prject: weightcontrol_v1.0
 * @Package: cn.szx.weightcontrol.action
 * @Description: TODO
 * @author: 宋桢熙  
 * @date: 2014年9月4日 下午3:09:22
 * @version: V1.0  
 */
package cn.szx.weightcontrol.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import cn.szx.weightcontrol.pagemodel.DataGrid;
import cn.szx.weightcontrol.pagemodel.Json;
import cn.szx.weightcontrol.pagemodel.Product;
import cn.szx.weightcontrol.pagemodel.User;
import cn.szx.weightcontrol.service.ProductServiceI;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @ClassName: ProductAction
 * @Description: TODO
 * @author: 宋桢熙
 * @date: 2014年9月4日 下午3:09:22
 */
@Namespace("/user")
@Action(value = "productAction")
public class ProductAction extends BaseAction implements ModelDriven<Product> {
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ProductAction.class);

	Product product = new Product();

	@Override
	public Product getModel() {
		return product;
	}

	private ProductServiceI productService;

	public ProductServiceI getProductService() {
		return productService;
	}

	@Autowired
	public void setProductService(ProductServiceI productService) {
		this.productService = productService;
	}

	public void add() {
		Json j = new Json();
		try {
			User user = (User) session.get("user");
			logger.info("#########################      当前登录用户信息为：" + JSON.toJSONStringWithDateFormat(user, "yyyy-MM-dd HH:mm:ss") + "      #########################");
			product.setUserId(user.getId());
			product.setUserRealName(user.getName());
			product = productService.save(product);
			j.setSuccess(true);
			j.setMsg("增加成功！");
			j.setObj(product);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		super.writeJson(j);
	}

	public void edit() {

	}

	public void remove() {

	}

	public void datagrid() {
		try {
			User user = (User) session.get("user");
			logger.info("#########################      当前登录用户信息为：" + JSON.toJSONStringWithDateFormat(user, "yyyy-MM-dd HH:mm:ss") + "      #########################");
			product.setUserId(user.getId());
			product.setUserRealName(user.getName());
			DataGrid dataGrid = productService.datagrid(product);
			super.writeJson(dataGrid);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void productAmountDatagrid() {
		try {
			User user = (User) session.get("user");
			logger.info("#########################      当前登录用户信息为：" + JSON.toJSONStringWithDateFormat(user, "yyyy-MM-dd HH:mm:ss") + "      #########################");
			product.setUserId(user.getId());
			product.setUserRealName(user.getName());
			DataGrid dataGrid = productService.productAmountDatagrid(product);
			super.writeJson(dataGrid);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
