package cn.szx.weightcontrol.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import cn.szx.weightcontrol.model.WMoneyIncomeExpenditure;

public interface WMoneyIncomeExpenditureMapper {
	int deleteByPrimaryKey(String id);
	
	int deleteByPrimaryKeyArray(String[] ids);

	int insert(WMoneyIncomeExpenditure record);

	int insertSelective(WMoneyIncomeExpenditure record);

	WMoneyIncomeExpenditure selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(WMoneyIncomeExpenditure record);

	int updateByPrimaryKey(WMoneyIncomeExpenditure record);

	List<WMoneyIncomeExpenditure> selectAllByUserId(Map<String, Object> params);

	long getTotalByUserId(String userId);

	/**
	 * 
	 * @Title: incomeExpenditureAmountSum
	 * @Description: 当前登录用户的收支金额总和
	 * @param params
	 * @return: double
	 */
	double selectIncomeExpenditureAmountSumByUserId(Map<String, Object> params);
	
	/**
	 * 
	 * @Title: sumIncomeExpenditureAmountByPrimaryKeyArray
	 * @Description: 对用户所选择的收支记录中收支金额进行求和操作
	 * @param ids
	 * @return: double
	 */
	double sumIncomeExpenditureAmountByPrimaryKeyArray(String[] ids);
}