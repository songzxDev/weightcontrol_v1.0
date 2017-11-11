package cn.szx.weightcontrol.service.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.szx.weightcontrol.pagemodel.DataGrid;
import cn.szx.weightcontrol.pagemodel.Product;
import cn.szx.weightcontrol.service.ProductServiceI;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestProductServiceImpl {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TestProductServiceImpl.class);
	private ProductServiceI productService;

	public ProductServiceI getProductService() {
		return productService;
	}

	@Autowired
	public void setProductService(ProductServiceI productService) {
		this.productService = productService;
	}

	@Test
	public void testSave() throws Exception {
//		 Product product = new Product();
//		 product.setUserId("J_c60b8ac5-0911-4e72-ba0f-c27a678341e0");
//		 product.setProductName("奈沃科粉");
//		 product.setPurchaseAmount(10);
//		 product.setProductStatus("i");
//		 product.setPurchaseDatatime(new Date());
//		 product.setUserRealName("马丽");
//		 product = productService.save(product);
//		 product.setUserRealName("马丽");
//		 logger.info(JSON.toJSONStringWithDateFormat(product, "yyyy-MM-dd HH:mm:ss"));
	}

	@Test
	public void testProductAmountDatagrid() throws Exception {
//		DataGrid dataGrid = new DataGrid();
//		Product product = new Product();
//		product.setUserId("J_5c478c21-5e0d-4b51-9503-e30d276ed8f6");
//		product.setUserRealName("宋桢熙");
//		dataGrid = productService.productAmountDatagrid(product);
//		logger.info(JSON.toJSONStringWithDateFormat(dataGrid, "yyyy-MM-dd HH:mm:ss"));
	}
	
	@Test
	public void testDatagrid() throws Exception {
//	DataGrid dataGrid = new DataGrid();
//	Product product = new Product();
//	product.setUserId("J_5c478c21-5e0d-4b51-9503-e30d276ed8f6");
//	product.setUserRealName("宋桢熙");
//	product.setProductStatus("e");
//	dataGrid = productService.datagrid(product);
//	logger.info(JSON.toJSONStringWithDateFormat(dataGrid, "yyyy-MM-dd HH:mm:ss"));
	}

}
