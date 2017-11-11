package cn.szx.weightcontrol.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.szx.weightcontrol.pagemodel.DataGrid;
import cn.szx.weightcontrol.pagemodel.MoneyIncomeExpenditure;
import cn.szx.weightcontrol.service.MoneyIncomeExpenditureServiceI;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestMoneyIncomeExpenditureServiceImpl {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TestMoneyIncomeExpenditureServiceImpl.class);

	private MoneyIncomeExpenditureServiceI moneyIncomeExpenditureService;

	public MoneyIncomeExpenditureServiceI getMoneyIncomeExpenditureService() {
		return moneyIncomeExpenditureService;
	}

	@Autowired
	public void setMoneyIncomeExpenditureService(MoneyIncomeExpenditureServiceI moneyIncomeExpenditureService) {
		this.moneyIncomeExpenditureService = moneyIncomeExpenditureService;
	}

	@Test
	public void testGetCategorys() throws Exception {
		// List<Map<String, Object>> categoryList = moneyIncomeExpenditureService.getCategorys();
		// logger.info(JSON.toJSONString(categoryList));
	}

	@Test
	public void testGetSubdivisions() throws Exception {
		// String categoryId = "20140312001";
		// List<Map<String, Object>> subdivisionList = moneyIncomeExpenditureService.getSubdivisions(categoryId);
		// logger.info(JSON.toJSONString(subdivisionList));
	}

	@Test
	public void testDatagrid() throws Exception {
//		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		 Date startDate = sdf.parse("2014-08-08");
//		 Date endDate = sdf.parse("2014-10-08");
//		 MoneyIncomeExpenditure moneyIncomeExpenditure = new MoneyIncomeExpenditure();
//		 moneyIncomeExpenditure.setUserId("J_5c478c21-5e0d-4b51-9503-e30d276ed8f6");
//		 moneyIncomeExpenditure.setPage(1);
//		 moneyIncomeExpenditure.setRows(10);
//		 moneyIncomeExpenditure.setIncomeExpenditureDatetimeStart(startDate);
//		 moneyIncomeExpenditure.setIncomeExpenditureDatetimeEnd(endDate);
//		 DataGrid dataGrid = moneyIncomeExpenditureService.datagrid(moneyIncomeExpenditure);
//		 logger.info(JSON.toJSONStringWithDateFormat(dataGrid, "yyyy-MM-dd HH:mm:ss"));
	}

	@Test
	public void testEdit() throws Exception {
//		MoneyIncomeExpenditure moneyIncomeExpenditure = new MoneyIncomeExpenditure();
//		moneyIncomeExpenditure.setId("J_45273acd-d1df-4bec-bc72-b599e3f3906b");
//		moneyIncomeExpenditure.setIncomeExpenditureCategory("换季衣物");
//		moneyIncomeExpenditure.setIncomeExpenditureSubdivision("英伦衬衫");
//		moneyIncomeExpenditure.setIncomeExpenditureAmount(-99.87);
//		moneyIncomeExpenditureService.edit(moneyIncomeExpenditure);
	}
	
	@Test
	public void testSum() throws Exception {
//		MoneyIncomeExpenditure moneyIncomeExpenditure = new MoneyIncomeExpenditure();
//		moneyIncomeExpenditure.setIds("1,2,3,4,5,6,7,8,9,10,11,12,13");
//		moneyIncomeExpenditureService.sum(moneyIncomeExpenditure);
	}

}
