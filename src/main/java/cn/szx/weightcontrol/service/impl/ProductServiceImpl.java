/**  
 * Copyright © 2014公司名字. All rights reserved.
 *
 * @Title: ProductServiceImpl.java
 * @Prject: weightcontrol_v1.0
 * @Package: cn.szx.weightcontrol.service.impl
 * @Description: TODO
 * @author: 宋桢熙  
 * @date: 2014年9月3日 下午3:09:31
 * @version: V1.0  
 */
package cn.szx.weightcontrol.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.szx.weightcontrol.dao.WProductAccessLoggerMapper;
import cn.szx.weightcontrol.dao.WProductMapper;
import cn.szx.weightcontrol.model.WProduct;
import cn.szx.weightcontrol.model.WProductAccessLogger;
import cn.szx.weightcontrol.pagemodel.DataGrid;
import cn.szx.weightcontrol.pagemodel.Product;
import cn.szx.weightcontrol.service.ProductServiceI;
import cn.szx.weightcontrol.util.WPrimaryKeyUtil;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName: ProductServiceImpl
 * @Description: TODO
 * @author: 宋桢熙
 * @date: 2014年9月3日 下午3:09:31
 */
@Service("productService")
public class ProductServiceImpl implements ProductServiceI {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ProductServiceImpl.class);

	private WProductMapper productMapper;

	public WProductMapper getProductMapper() {
		return productMapper;
	}

	@Autowired
	public void setProductMapper(WProductMapper productMapper) {
		this.productMapper = productMapper;
	}

	private WProductAccessLoggerMapper productAccessLoggerMapper;

	public WProductAccessLoggerMapper getProductAccessLoggerMapper() {
		return productAccessLoggerMapper;
	}

	@Autowired
	public void setProductAccessLoggerMapper(WProductAccessLoggerMapper productAccessLoggerMapper) {
		this.productAccessLoggerMapper = productAccessLoggerMapper;
	}

	/**
	 * @Title: save
	 * @Description: 新增一条产品操作记录
	 * @param product
	 * @return
	 * @throws Exception
	 * @see cn.szx.weightcontrol.service.ProductServiceI#save(cn.szx.weightcontrol.pagemodel.Product)
	 * @see cn.szx.weightcontrol.dao.WProductMapper#insertSelective(cn.szx.weightcontrol.model.WProduct)
	 */
	@Override
	public Product save(Product product) throws Exception {
		/*
		 * {"id":"J_cac182ec-39a1-4768-ac46-7167ec5bc07d","page":0,"productName":"奈沃科粉","purchaseAmount":10,"purchaseDatatime":"2014-09-04 16:24:58","rows":0,"userId":"J_c60b8ac5-0911-4e72-ba0f-c27a678341e0","userRealName":"马丽"}
		 */
		WProduct wproduct = new WProduct();
		BeanUtils.copyProperties(product, wproduct, new String[] { "purchaseAmount" });
		wproduct.setId(WPrimaryKeyUtil.producePrimayKeyByUUID());

		// w_product 的 reserve1 字段（产品状态）状态值：” expense” 取出，” income” 存入。数据库中存贮为CHAR类型，简写 ”e” 和 ”i”
		if (product.getProductStatus().trim().equals("e")) {
			wproduct.setReserve1("e");
			wproduct.setPurchaseAmount(-product.getPurchaseAmount());
		} else if (product.getProductStatus().trim().equals("i")) {
			wproduct.setReserve1("i");
			wproduct.setPurchaseAmount(product.getPurchaseAmount());
		} else {

		}
		productMapper.insertSelective(wproduct);
		BeanUtils.copyProperties(wproduct, product);
		// 向 w_product_access_logger 日志表中插入一条数据作为日志
		produceProductAccessLogger(product);
		// w_product 的 reserve1 字段（产品状态）状态值：” expense” 取出，” income” 存入。数据库中存贮为CHAR类型，简写 ”e” 和 ”i”
		if (wproduct.getReserve1().trim().equals("i")) {
			product.setProductStatus("存入");
		} else if (wproduct.getReserve1().trim().equals("e")) {
			product.setProductStatus("取出");
		} else {

		}
		return product;
	}

	/**
	 * @Title: edit
	 * @Description: TODO
	 * @param product
	 * @return
	 * @throws Exception
	 * @see cn.szx.weightcontrol.service.ProductServiceI#edit(cn.szx.weightcontrol.pagemodel.Product)
	 */
	@Override
	public Product edit(Product product) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @Title: remove
	 * @Description: TODO
	 * @param product
	 * @return
	 * @throws Exception
	 * @see cn.szx.weightcontrol.service.ProductServiceI#remove(cn.szx.weightcontrol.pagemodel.Product)
	 */
	@Override
	public Product remove(Product product) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @Title: datagrid
	 * @Description: 当前用户执行买入、取出产品个操作的记录
	 * @param product
	 * @return 当前用户执行买入、取出产品个操作的记录
	 * @throws Exception
	 * @see cn.szx.weightcontrol.service.ProductServiceI#datagrid(cn.szx.weightcontrol.pagemodel.Product)
	 * @see cn.szx.weightcontrol.pagemodel.DataGrid
	 * @see cn.szx.weightcontrol.dao.WProductMapper#selectAllByUserId(Map)
	 * @see cn.szx.weightcontrol.pagemodel.Product
	 */
	@Override
	public DataGrid datagrid(Product product) throws Exception {
		/*
		 * 前台需要后台返回 json 数据格式 {"rows": [ { 转换成json数据格式的对象集合 } ], "total": "数值" }， 故将返回值类型定义为 cn.szx.weightcontrol.pagemodel.DataGrid 对象。
		 */
		DataGrid dataGrid = new DataGrid();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", product.getUserId());
		params.put("page", (product.getPage() - 1) * product.getRows());
		params.put("rows", product.getRows());
		params.put("productStatus", product.getProductStatus());
		List<Product> productList = new ArrayList<Product>();

		// mybaits 查询数据时，如果查询条件有个多个，就需要将这些参数名称和值放入到 Map 集合中传递给 mybaits 框架进行处理
		List<WProduct> wproductList = productMapper.selectAllByUserId(params);
		logger.info(JSON.toJSONStringWithDateFormat(wproductList, "yyyy-MM-dd HH:mm:ss"));

		// 前台需要后台返回 json 数据中含有例如：{"total":"1"} 这样的数据格式
		dataGrid.setTotal(productMapper.getTotalByUserId(product.getUserId()));
		for (WProduct wproduct : wproductList) {
			Product pro = new Product();

			// 将前台传递回来的 product 对象中的userRealName属性的值拷贝到 新建对象 pro 对应的同名属性中
			BeanUtils.copyProperties(wproduct, pro);

			// w_product 的 reserve1 字段（产品状态）状态值：” expense” 取出，” income” 存入。数据库中存贮为CHAR类型，简写 ”e” 和 ”i”
			if (wproduct.getReserve1().trim().equals("i")) {
				pro.setProductStatus("存入");
			} else if (wproduct.getReserve1().trim().equals("e")) {
				pro.setProductStatus("取出");
			} else {

			}
			pro.setUserRealName(product.getUserRealName());
			productList.add(pro);
		}
		dataGrid.setRows(productList);
		return dataGrid;
	}

	/**
	 * 
	 * @Title: productAmountDatagrid
	 * @Description: 统计用户购买产品中同名产品的剩余总数、取出总数、买入总数
	 * @param product
	 * @return 所有产品中同名产品的剩余总数、取出总数、买入总数、产品名称、用户姓名、编号、当前日期
	 * @throws Exception
	 * @see cn.szx.weightcontrol.service.ProductServiceI#productAmountDatagrid(cn.szx.weightcontrol.pagemodel.Product)
	 * @see cn.szx.weightcontrol.dao.WProductMapper#getProductNameByUserId(String)
	 * @see cn.szx.weightcontrol.dao.WProductMapper#sumPurchaseAmountByProductNameAndUserId(Map)
	 * @see cn.szx.weightcontrol.dao.WProductMapper#sumRemainingAmountsByProductNameAndUserId(Map)
	 * @see cn.szx.weightcontrol.pagemodel.DataGrid
	 */
	@Override
	public DataGrid productAmountDatagrid(Product product) throws Exception {
		DataGrid dataGrid = new DataGrid();
		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
		Set<String> productNames = productMapper.getProductNameByUserId(product.getUserId());
		if (productNames != null && !productNames.isEmpty()) {
			// 生成页面显示中的编号
			int i = 1;
			// 买入商品的总数
			long productIncomeAmounts = 0;
			// 已经取出的商品总数
			long productExpenseAmounts = 0;
			// 产品剩余总数
			long productRemainingAmounts = 0;
			for (String productName : productNames) {
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("userId", product.getUserId());
				params.put("productName", productName);
				params.put("productStatus", "i");
				productIncomeAmounts = productMapper.sumPurchaseAmountByProductNameAndUserId(params);
				logger.info("产品总共买入了：" + productIncomeAmounts + " 个");
				productRemainingAmounts = productMapper.sumRemainingAmountsByProductNameAndUserId(params);
				logger.info("产品总共剩余了：" + productRemainingAmounts + " 个");
				productExpenseAmounts = productIncomeAmounts - productRemainingAmounts;
				logger.info("产品总共取出了：" + productExpenseAmounts + " 个");
				params = new HashMap<String, Object>();
				params.put("id", i++);
				params.put("productName", productName);
				params.put("currentDatetime", new Date());
				params.put("userRealName", product.getUserRealName());
				params.put("productIncomeAmounts", productIncomeAmounts);
				params.put("productExpenseAmounts", productExpenseAmounts);
				params.put("productRemainingAmounts", productRemainingAmounts);
				rows.add(params);
			}
		}
		dataGrid.setRows(rows);
		return dataGrid;
	}

	/**
	 * 
	 * @Title: produceProductAccessLogger
	 * @Description: 生成产品日志记录的方法
	 * @param product
	 *          将对应的产品操作信息插入到 表w_product_access_logger 中
	 * @return: void
	 * @see cn.szx.weightcontrol.model.WProductAccessLogger
	 */
	public void produceProductAccessLogger(Product product) {
		WProductAccessLogger wproductAccessLogger = new WProductAccessLogger();
		wproductAccessLogger.setId(WPrimaryKeyUtil.producePrimayKeyByUUID());
		wproductAccessLogger.setUserId(product.getUserId());
		wproductAccessLogger.setUserRealName(product.getUserRealName());
		wproductAccessLogger.setProductName(product.getProductName());
		wproductAccessLogger.setProductStatus(product.getProductStatus());
		wproductAccessLogger.setProductAccessNumber(product.getPurchaseAmount());
		productAccessLoggerMapper.insertSelective(wproductAccessLogger);
	}

}
