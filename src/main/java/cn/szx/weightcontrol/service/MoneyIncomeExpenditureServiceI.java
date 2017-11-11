/**
 * 
 */
package cn.szx.weightcontrol.service;

import java.util.List;
import java.util.Map;

import cn.szx.weightcontrol.pagemodel.DataGrid;
import cn.szx.weightcontrol.pagemodel.MoneyIncomeExpenditure;

/**
 * 
 * @ClassName: MoneyIncomeExpenditureServiceI
 * @Description: TODO
 * @author: 宋桢熙
 * @date: 2014年9月19日 上午9:45:56
 */
public interface MoneyIncomeExpenditureServiceI {
	/**
	 * 
	 * @Title: save
	 * @Description: 新增
	 * @param moneyIncomeExpenditure
	 * @throws Exception
	 * @return: MoneyIncomeExpenditure
	 */
	public MoneyIncomeExpenditure save(MoneyIncomeExpenditure moneyIncomeExpenditure) throws Exception;

	/**
	 * 
	 * @Title: edit
	 * @Description: 修改
	 * @param moneyIncomeExpenditure
	 * @throws Exception
	 * @return: MoneyIncomeExpenditure
	 */
	public MoneyIncomeExpenditure edit(MoneyIncomeExpenditure moneyIncomeExpenditure) throws Exception;

	/**
	 * 
	 * @Title: remove
	 * @Description: 删除
	 * @param moneyIncomeExpenditure
	 * @throws Exception
	 * @return: MoneyIncomeExpenditure
	 */
	public MoneyIncomeExpenditure remove(MoneyIncomeExpenditure moneyIncomeExpenditure) throws Exception;

	/**
	 * 
	 * @Title: datagrid
	 * @Description: 查询
	 * @param moneyIncomeExpenditure
	 * @throws Exception
	 * @return: DataGrid
	 */
	public DataGrid datagrid(MoneyIncomeExpenditure moneyIncomeExpenditure) throws Exception;

	/**
	 * 
	 * @Title: getCategory
	 * @Description: TODO
	 * @throws Exception
	 * @return: List<Map<String,Object>>
	 */
	public List<Map<String, Object>> getCategorys() throws Exception;

	/**
	 * 
	 * @Title: getSubdivision
	 * @Description: TODO
	 * @param categoryId
	 * @throws Exception
	 * @return: List<Map<String,Object>>
	 */
	public List<Map<String, Object>> getSubdivisions(String categoryId) throws Exception;

	/**
	 * 
	 * @Title: sum
	 * @Description: 求和
	 * @param moneyIncomeExpenditure
	 * @throws Exception
	 * @return: double
	 */
	public double sum(MoneyIncomeExpenditure moneyIncomeExpenditure) throws Exception;
}
