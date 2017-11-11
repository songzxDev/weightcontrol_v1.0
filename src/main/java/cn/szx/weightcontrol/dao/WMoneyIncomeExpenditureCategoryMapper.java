package cn.szx.weightcontrol.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.szx.weightcontrol.model.WMoneyIncomeExpenditureCategory;

public interface WMoneyIncomeExpenditureCategoryMapper {
	int deleteByPrimaryKey(String id);

	int insert(WMoneyIncomeExpenditureCategory record);

	int insertSelective(WMoneyIncomeExpenditureCategory record);

	WMoneyIncomeExpenditureCategory selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(WMoneyIncomeExpenditureCategory record);

	int updateByPrimaryKey(WMoneyIncomeExpenditureCategory record);

	List<WMoneyIncomeExpenditureCategory> selectAllCategorys();
}