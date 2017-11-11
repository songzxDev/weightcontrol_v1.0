package cn.szx.weightcontrol.dao;

import java.util.List;

import cn.szx.weightcontrol.model.WMoneyIncomeExpenditureSubdivision;

public interface WMoneyIncomeExpenditureSubdivisionMapper {
	int deleteByPrimaryKey(String id);

	int insert(WMoneyIncomeExpenditureSubdivision record);

	int insertSelective(WMoneyIncomeExpenditureSubdivision record);

	WMoneyIncomeExpenditureSubdivision selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(WMoneyIncomeExpenditureSubdivision record);

	int updateByPrimaryKey(WMoneyIncomeExpenditureSubdivision record);

	List<WMoneyIncomeExpenditureSubdivision> selectAllSubdivisions(String categoryId);
}