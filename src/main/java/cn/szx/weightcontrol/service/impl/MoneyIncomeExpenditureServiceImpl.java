/**  
 * Copyright © 2014练习. All rights reserved.
 *
 * @Title: MoneyIncomeExpenditureServiceImpl.java
 * @Prject: weightcontrol_v1.0
 * @Package: cn.szx.weightcontrol.service.impl
 * @Description: TODO
 * @author: 宋桢熙  
 * @date: 2014年9月19日 上午9:48:25
 * @version: V1.0  
 */
package cn.szx.weightcontrol.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.szx.weightcontrol.dao.WMoneyIncomeExpenditureCategoryMapper;
import cn.szx.weightcontrol.dao.WMoneyIncomeExpenditureMapper;
import cn.szx.weightcontrol.dao.WMoneyIncomeExpenditureSubdivisionMapper;
import cn.szx.weightcontrol.model.WMoneyIncomeExpenditure;
import cn.szx.weightcontrol.model.WMoneyIncomeExpenditureCategory;
import cn.szx.weightcontrol.model.WMoneyIncomeExpenditureSubdivision;
import cn.szx.weightcontrol.pagemodel.DataGrid;
import cn.szx.weightcontrol.pagemodel.MoneyIncomeExpenditure;
import cn.szx.weightcontrol.service.MoneyIncomeExpenditureServiceI;
import cn.szx.weightcontrol.util.WPrimaryKeyUtil;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName: MoneyIncomeExpenditureServiceImpl
 * @Description: TODO
 * @author: 宋桢熙
 * @date: 2014年9月19日 上午9:48:25
 */
@Service("moneyIncomeExpenditureService")
public class MoneyIncomeExpenditureServiceImpl implements MoneyIncomeExpenditureServiceI {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MoneyIncomeExpenditureServiceImpl.class);

	private WMoneyIncomeExpenditureMapper moneyIncomeExpenditureMapper;

	private WMoneyIncomeExpenditureCategoryMapper moneyIncomeExpenditureCategoryMapper;

	private WMoneyIncomeExpenditureSubdivisionMapper moneyIncomeExpenditureSubdivisionMapper;

	public WMoneyIncomeExpenditureMapper getMoneyIncomeExpenditureMapper() {
		return moneyIncomeExpenditureMapper;
	}

	@Autowired
	public void setMoneyIncomeExpenditureMapper(WMoneyIncomeExpenditureMapper moneyIncomeExpenditureMapper) {
		this.moneyIncomeExpenditureMapper = moneyIncomeExpenditureMapper;
	}

	public WMoneyIncomeExpenditureCategoryMapper getMoneyIncomeExpenditureCategoryMapper() {
		return moneyIncomeExpenditureCategoryMapper;
	}

	@Autowired
	public void setMoneyIncomeExpenditureCategoryMapper(WMoneyIncomeExpenditureCategoryMapper moneyIncomeExpenditureCategoryMapper) {
		this.moneyIncomeExpenditureCategoryMapper = moneyIncomeExpenditureCategoryMapper;
	}

	public WMoneyIncomeExpenditureSubdivisionMapper getMoneyIncomeExpenditureSubdivisionMapper() {
		return moneyIncomeExpenditureSubdivisionMapper;
	}

	@Autowired
	public void setMoneyIncomeExpenditureSubdivisionMapper(WMoneyIncomeExpenditureSubdivisionMapper moneyIncomeExpenditureSubdivisionMapper) {
		this.moneyIncomeExpenditureSubdivisionMapper = moneyIncomeExpenditureSubdivisionMapper;
	}

	/**
	 * @Title: save
	 * @Description: TODO
	 * @param moneyIncomeExpenditure
	 * @return
	 * @throws Exception
	 * @see cn.szx.weightcontrol.service.MoneyIncomeExpenditureServiceI#save(cn.szx.weightcontrol.pagemodel.MoneyIncomeExpenditure)
	 */
	@Override
	public MoneyIncomeExpenditure save(MoneyIncomeExpenditure moneyIncomeExpenditure) throws Exception {
		WMoneyIncomeExpenditure wm = new WMoneyIncomeExpenditure();
		BeanUtils.copyProperties(moneyIncomeExpenditure, wm);
		wm.setId(WPrimaryKeyUtil.producePrimayKeyByUUID());
		moneyIncomeExpenditureMapper.insertSelective(wm);
		BeanUtils.copyProperties(wm, moneyIncomeExpenditure);
		return moneyIncomeExpenditure;
	}

	/**
	 * @Title: edit
	 * @Description: TODO
	 * @param moneyIncomeExpenditure
	 * @return
	 * @throws Exception
	 * @see cn.szx.weightcontrol.service.MoneyIncomeExpenditureServiceI#edit(cn.szx.weightcontrol.pagemodel.MoneyIncomeExpenditure)
	 */
	@Override
	public MoneyIncomeExpenditure edit(MoneyIncomeExpenditure moneyIncomeExpenditure) throws Exception {
		WMoneyIncomeExpenditure wmInEx = moneyIncomeExpenditureMapper.selectByPrimaryKey(moneyIncomeExpenditure.getId());
		logger.info("################################ 待修改的记录信息为：" + JSON.toJSONStringWithDateFormat(wmInEx, "yyyy-MM-dd HH:mm:ss") + "################################");
		BeanUtils.copyProperties(moneyIncomeExpenditure, wmInEx);
		wmInEx.setModifyDatetime(new Date());
		moneyIncomeExpenditureMapper.updateByPrimaryKeySelective(wmInEx);
		BeanUtils.copyProperties(wmInEx, moneyIncomeExpenditure);
		logger.info("################################ 修改后的记录信息为：" + JSON.toJSONStringWithDateFormat(moneyIncomeExpenditure, "yyyy-MM-dd HH:mm:ss") + "################################");
		return moneyIncomeExpenditure;
	}

	/**
	 * @Title: remove
	 * @Description: TODO
	 * @param moneyIncomeExpenditure
	 * @return
	 * @throws Exception
	 * @see cn.szx.weightcontrol.service.MoneyIncomeExpenditureServiceI#remove(cn.szx.weightcontrol.pagemodel.MoneyIncomeExpenditure)
	 */
	@Override
	public MoneyIncomeExpenditure remove(MoneyIncomeExpenditure moneyIncomeExpenditure) throws Exception {
		String[] idsArray = moneyIncomeExpenditure.getIds().split(",");
		logger.info(idsArray);
		moneyIncomeExpenditureMapper.deleteByPrimaryKeyArray(idsArray);
		return null;
	}

	/**
	 * @Title: datagrid
	 * @Description: TODO
	 * @param moneyIncomeExpenditure
	 * @return
	 * @throws Exception
	 * @see cn.szx.weightcontrol.service.MoneyIncomeExpenditureServiceI#datagrid(cn.szx.weightcontrol.pagemodel.MoneyIncomeExpenditure)
	 */
	@Override
	public DataGrid datagrid(MoneyIncomeExpenditure moneyIncomeExpenditure) throws Exception {
		DataGrid dataGrid = new DataGrid();
		dataGrid.setTotal(moneyIncomeExpenditureMapper.getTotalByUserId(moneyIncomeExpenditure.getUserId()));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", moneyIncomeExpenditure.getUserId());
		params.put("page", (moneyIncomeExpenditure.getPage() - 1) * moneyIncomeExpenditure.getRows());
		params.put("rows", moneyIncomeExpenditure.getRows());
		Date startInExDate = moneyIncomeExpenditure.getIncomeExpenditureDatetimeStart();
		Date endInExDate = moneyIncomeExpenditure.getIncomeExpenditureDatetimeEnd();

		logger.info("经处理后的截至日期为：" + JSON.toJSONStringWithDateFormat(endInExDate, "yyyy-MM-dd HH:mm:ss"));
		if (startInExDate != null && endInExDate != null) {
			/*
			 * 经测试验证如果用户在前台选择起始日期：2014-1-1，截至日期：2014-1-31， 后台实际查询出来的是从 2014-1-1 00:00:00 至 2014-1-31 00:00:00， 为解决此问题需对前台传递过来的截至日期 endInExDate 进行处理，使用 Calendar类提供的方法为其添加 23:59:59
			 */
			Calendar c = Calendar.getInstance();
			c.setTime(endInExDate);
			c.add(Calendar.HOUR, 23);
			c.add(Calendar.MINUTE, 59);
			c.add(Calendar.SECOND, 59);
			endInExDate = c.getTime();
			params.put("incomeExpenditureDatetimeStart", startInExDate);
			params.put("incomeExpenditureDatetimeEnd", endInExDate);
		}
		List<MoneyIncomeExpenditure> moneyIncomeExpenditureList = new ArrayList<MoneyIncomeExpenditure>();
		List<WMoneyIncomeExpenditure> wmoneyIncomeExpenditureList = moneyIncomeExpenditureMapper.selectAllByUserId(params);
		logger.info(JSON.toJSONStringWithDateFormat(wmoneyIncomeExpenditureList, "yyyy-MM-dd HH:mm:ss"));
		if (wmoneyIncomeExpenditureList != null && wmoneyIncomeExpenditureList.size() > 0) {
			for (WMoneyIncomeExpenditure wMoneyIncomeExpenditure : wmoneyIncomeExpenditureList) {
				MoneyIncomeExpenditure m = new MoneyIncomeExpenditure();
				BeanUtils.copyProperties(wMoneyIncomeExpenditure, m);
				moneyIncomeExpenditureList.add(m);
			}
		}
		dataGrid.setRows(moneyIncomeExpenditureList);
		return dataGrid;
	}

	@Override
	public List<Map<String, Object>> getCategorys() throws Exception {
		Map<String, Object> categoryMap;
		List<Map<String, Object>> categoryList = new ArrayList<Map<String, Object>>();
		List<WMoneyIncomeExpenditureCategory> wcategoryList = moneyIncomeExpenditureCategoryMapper.selectAllCategorys();
		logger.info(JSON.toJSONStringWithDateFormat(wcategoryList, "yyyy-MM-dd HH:mm:ss"));
		for (WMoneyIncomeExpenditureCategory wMoneyIncomeExpenditureCategory : wcategoryList) {
			categoryMap = new HashMap<String, Object>();
			categoryMap.put("id", wMoneyIncomeExpenditureCategory.getId());
			categoryMap.put("text", wMoneyIncomeExpenditureCategory.getCategoryName());
			categoryList.add(categoryMap);
		}
		return categoryList;
	}

	@Override
	public List<Map<String, Object>> getSubdivisions(String categoryId) throws Exception {
		Map<String, Object> subdivisionMap;
		List<Map<String, Object>> subdivisionList = new ArrayList<Map<String, Object>>();
		List<WMoneyIncomeExpenditureSubdivision> wsubdivisionList = moneyIncomeExpenditureSubdivisionMapper.selectAllSubdivisions(categoryId);
		for (WMoneyIncomeExpenditureSubdivision wMoneyIncomeExpenditureSubdivision : wsubdivisionList) {
			subdivisionMap = new HashMap<String, Object>();
			subdivisionMap.put("id", wMoneyIncomeExpenditureSubdivision.getId());
			subdivisionMap.put("text", wMoneyIncomeExpenditureSubdivision.getSubdivisionName());
			subdivisionList.add(subdivisionMap);
		}
		return subdivisionList;
	}

	@Override
	public double sum(MoneyIncomeExpenditure moneyIncomeExpenditure) throws Exception {
		String[] idsArray = moneyIncomeExpenditure.getIds().split(",");
		logger.info(idsArray);
		double inExAmountSum = moneyIncomeExpenditureMapper.sumIncomeExpenditureAmountByPrimaryKeyArray(idsArray);
		logger.info("求和结果为：" + inExAmountSum);
		return inExAmountSum;
	}

}
