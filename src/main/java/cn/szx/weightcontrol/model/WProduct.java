package cn.szx.weightcontrol.model;

import java.util.Date;

/**
 * 
 * @ClassName: WProduct
 * @Description: 关联数据表 w_product 的实体类
 * @author: 宋桢熙
 * @date: 2014年9月3日 下午2:20:04
 */
public class WProduct {
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
	/** （产品状态）状态值：” expense” 取出，” income” 买入。数据库中存贮为CHAR类型，简写 ”e” 和 ”i”。 */
	private String reserve1;
	/** 预留字段 */
	private String reserve2;
	/** 预留字段 */
	private String reserve3;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName == null ? null : productName.trim();
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

	public String getReserve1() {
		return reserve1;
	}

	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1 == null ? null : reserve1.trim();
	}

	public String getReserve2() {
		return reserve2;
	}

	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2 == null ? null : reserve2.trim();
	}

	public String getReserve3() {
		return reserve3;
	}

	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3 == null ? null : reserve3.trim();
	}
}