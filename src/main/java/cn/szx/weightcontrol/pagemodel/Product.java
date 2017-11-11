/**  
 * Copyright © 2014公司名字. All rights reserved.
 *
 * @Title: Product.java
 * @Prject: weightcontrol_v1.0
 * @Package: cn.szx.weightcontrol.pagemodel
 * @Description: TODO
 * @author: 宋桢熙  
 * @date: 2014年9月3日 下午2:28:09
 * @version: V1.0  
 */
package cn.szx.weightcontrol.pagemodel;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: Product
 * @Description: WProduct类的pagemodel类
 * @author: 宋桢熙
 * @date: 2014年9月3日 下午2:28:09
 */
public class Product implements Serializable {
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;

	/** 数据表 w_product 的主键 */
	private String id;
	/** 用于关联 w_user 的外键 */
	private String userId;
	/** 产品名称 */
	private String productName;
	/** 产品个数 */
	private Integer purchaseAmount;
	/** 日期 */
	private Date purchaseDatatime;
	/** 数据录入日期 */
	private Date createDatetime;
	/** 数据更新日期 */
	private Date modifyDatetime;

	private int page;

	private int rows;

	/** 不关联数据表 w_product 中的字段，用于前台页面中展示当前用户的真实姓名 */
	private String userRealName;
	
	/** （产品状态）状态值：” expense” 取出，” income” 买入。数据库中存贮为CHAR类型，简写 ”e” 和 ”i”。 */
	private String productStatus;

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	/** jquery-easyui 返回给后台的是以 "," 为分隔符的字符串 */
	private String ids;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(Integer purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public Date getPurchaseDatatime() {
		return purchaseDatatime;
	}

	public void setPurchaseDatatime(Date purchaseDatatime) {
		this.purchaseDatatime = purchaseDatatime;
	}

	public Date getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}

	public Date getModifyDatetime() {
		return modifyDatetime;
	}

	public void setModifyDatetime(Date modifyDatetime) {
		this.modifyDatetime = modifyDatetime;
	}

}
