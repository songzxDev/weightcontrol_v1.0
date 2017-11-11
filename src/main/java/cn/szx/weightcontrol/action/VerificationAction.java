package cn.szx.weightcontrol.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import cn.szx.weightcontrol.pagemodel.MoneyIncomeExpenditure;

import com.opensymphony.xwork2.ModelDriven;

@Namespace("/money")
@Action(value = "verificationAction")
public class VerificationAction extends BaseAction implements ModelDriven<MoneyIncomeExpenditure> {
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	MoneyIncomeExpenditure moneyIncomeExpenditure = new MoneyIncomeExpenditure();

	@Override
	public MoneyIncomeExpenditure getModel() {
		return moneyIncomeExpenditure;
	}
	
	public void verifyIncomeExpenditureAmount() {
		super.writeJson(false);
	}
	
}
