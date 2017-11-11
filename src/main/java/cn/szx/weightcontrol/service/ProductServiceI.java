/**  
 * Copyright © 2014公司名字. All rights reserved.
 *
 * @Title: ProductServiceI.java
 * @Prject: weightcontrol_v1.0
 * @Package: cn.szx.weightcontrol.service
 * @Description: TODO
 * @author: 宋桢熙  
 * @date: 2014年9月3日 下午3:04:00
 * @version: V1.0  
 */
package cn.szx.weightcontrol.service;

import cn.szx.weightcontrol.pagemodel.DataGrid;
import cn.szx.weightcontrol.pagemodel.Product;

/**
 * @ClassName: ProductServiceI
 * @Description: TODO
 * @author: 宋桢熙
 * @date: 2014年9月3日 下午3:04:00
 */
public interface ProductServiceI {
	/**
	 * 
	 * @Title: save
	 * @Description: 增加
	 * @param product
	 * @throws Exception
	 * @return: Product
	 */
	public Product save(Product product) throws Exception;

	/**
	 * 
	 * @Title: edit
	 * @Description: 更新
	 * @param product
	 * @throws Exception
	 * @return: Product
	 */
	public Product edit(Product product) throws Exception;

	/**
	 * 
	 * @Title: remove
	 * @Description: 删除
	 * @param product
	 * @throws Exception
	 * @return: Product
	 */
	public Product remove(Product product) throws Exception;

	/**
	 * 
	 * @Title: datagrid
	 * @Description: 查询
	 * @param product
	 * @throws Exception
	 * @return: DataGrid
	 */
	public DataGrid datagrid(Product product) throws Exception;

	/**
	 * 
	 * @Title: productAmountDatagrid
	 * @Description: TODO
	 * @param product
	 * @return
	 * @throws Exception
	 * @return: DataGrid
	 */
	public DataGrid productAmountDatagrid(Product product) throws Exception;

}
