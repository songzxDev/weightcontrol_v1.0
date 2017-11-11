package cn.szx.weightcontrol.model;

import java.util.Date;

public class WMoneyIncomeExpenditure {
    private String id;

    private String userId;

    private String incomeExpenditureCategory;

    private String incomeExpenditureSubdivision;

    private Double incomeExpenditureAmount;

    private Date incomeExpenditureDatetime;

    private Date createDatetime;

    private Date modifyDatetime;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    private String reserve4;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getIncomeExpenditureCategory() {
        return incomeExpenditureCategory;
    }

    public void setIncomeExpenditureCategory(String incomeExpenditureCategory) {
        this.incomeExpenditureCategory = incomeExpenditureCategory == null ? null : incomeExpenditureCategory.trim();
    }

    public String getIncomeExpenditureSubdivision() {
        return incomeExpenditureSubdivision;
    }

    public void setIncomeExpenditureSubdivision(String incomeExpenditureSubdivision) {
        this.incomeExpenditureSubdivision = incomeExpenditureSubdivision == null ? null : incomeExpenditureSubdivision.trim();
    }

    public Double getIncomeExpenditureAmount() {
        return incomeExpenditureAmount;
    }

    public void setIncomeExpenditureAmount(Double incomeExpenditureAmount) {
        this.incomeExpenditureAmount = incomeExpenditureAmount;
    }

    public Date getIncomeExpenditureDatetime() {
        return incomeExpenditureDatetime;
    }

    public void setIncomeExpenditureDatetime(Date incomeExpenditureDatetime) {
        this.incomeExpenditureDatetime = incomeExpenditureDatetime;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getModifyDatetime() {
        return modifyDatetime;
    }

    public void setModifyDatetime(Date modifyDatetime) {
        this.modifyDatetime = modifyDatetime;
    }

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1 == null ? null : reserve1.trim();
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2 == null ? null : reserve2.trim();
    }

    public String getReserve3() {
        return reserve3;
    }

    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3 == null ? null : reserve3.trim();
    }

    public String getReserve4() {
        return reserve4;
    }

    public void setReserve4(String reserve4) {
        this.reserve4 = reserve4 == null ? null : reserve4.trim();
    }
}