/**  
 * Copyright © 2014公司名字. All rights reserved.
 *
 * @Title: MoneyIncomeExpenditure.java
 * @Prject: weightcontrol_v1.0
 * @Package: cn.szx.weightcontrol.pagemodel
 * @Description: TODO
 * @author: 宋桢熙  
 * @date: 2014年9月15日 下午4:50:07
 * @version: V1.0  
 */
package cn.szx.weightcontrol.pagemodel;

import java.util.Date;

/**
 * @ClassName: MoneyIncomeExpenditure
 * @Description: 钱财收支记录实体类
 * @author: 宋桢熙
 * @date: 2014年9月15日 下午4:50:07
 */
public class MoneyIncomeExpenditure {
	/** 主键ID */
	private String id;

	/** 关联用户的外键 */
	private String userId;

	/** 收支大类 */
	private String incomeExpenditureCategory;

	/** 收支小类 */
	private String incomeExpenditureSubdivision;

	/** 收支金额 */
	private Double incomeExpenditureAmount;

	/** 收支日期 */
	private Date incomeExpenditureDatetime;

	/** 用于接受前台传递的起始日期 */
	private Date incomeExpenditureDatetimeStart;

	/**用于接受前台传递的结束日期 */
	private Date incomeExpenditureDatetimeEnd;

	/** 数据录入日期 */
	private Date createDatetime;

	/** 数据更新日期 */
	private Date modifyDatetime;

	/***/
	private int page;

	/***/
	private int rows;
	
	/** jquery-easyui 返回给后台的是以 "," 为分隔符的字符串 */
	private String ids;

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

	public String getIncomeExpenditureCategory() {
		return incomeExpenditureCategory;
	}

	public void setIncomeExpenditureCategory(String incomeExpenditureCategory) {
		this.incomeExpenditureCategory = incomeExpenditureCategory;
	}

	public String getIncomeExpenditureSubdivision() {
		return incomeExpenditureSubdivision;
	}

	public void setIncomeExpenditureSubdivision(String incomeExpenditureSubdivision) {
		this.incomeExpenditureSubdivision = incomeExpenditureSubdivision;
	}

	public Double getIncomeExpenditureAmount() {
		return incomeExpenditureAmount;
	}

	public void setIncomeExpenditureAmount(Double incomeExpenditureAmount) {
		this.incomeExpenditureAmount = incomeExpenditureAmount;
	}

	public Date getIncomeExpenditureDatetime() {
		return incomeExpenditureDatetime;
	}

	public void setIncomeExpenditureDatetime(Date incomeExpenditureDatetime) {
		this.incomeExpenditureDatetime = incomeExpenditureDatetime;
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

	public Date getIncomeExpenditureDatetimeStart() {
		return incomeExpenditureDatetimeStart;
	}

	public void setIncomeExpenditureDatetimeStart(Date incomeExpenditureDatetimeStart) {
		this.incomeExpenditureDatetimeStart = incomeExpenditureDatetimeStart;
	}

	public Date getIncomeExpenditureDatetimeEnd() {
		return incomeExpenditureDatetimeEnd;
	}

	public void setIncomeExpenditureDatetimeEnd(Date incomeExpenditureDatetimeEnd) {
		this.incomeExpenditureDatetimeEnd = incomeExpenditureDatetimeEnd;
	}

}
