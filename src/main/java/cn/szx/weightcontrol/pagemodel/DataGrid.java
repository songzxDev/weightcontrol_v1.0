package cn.szx.weightcontrol.pagemodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName: DataGrid
 * @Description: 前台 jquery-easyui 框架执行 datagrid 数据展示，要求的 json 数据格式为： { "rows": [ { 对象集合 } ], "total": "数据总数" } ，故创建此类
 * @author: 宋桢熙
 * @date: 2014年9月2日 下午3:53:30
 */
public class DataGrid implements Serializable {
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	private Long total = 0L;
	private Double amount = 0.00;
	private List rows = new ArrayList();

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}
}
