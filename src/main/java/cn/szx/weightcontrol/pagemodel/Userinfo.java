package cn.szx.weightcontrol.pagemodel;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @ClassName: Userinfo
 * @Description: TODO
 * @author: 宋桢熙
 * @date: 2014年9月2日 上午10:31:57
 */
public class Userinfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 对应数据表 w_userinfo 的主键 */
	private String id;
	/** 关联数据表 w_user 的外键 */
	private String userId;
	/** 姓名 */
	private String name;
	/** 年龄 */
	private String age;
	/** 性别 */
	private String sex;
	/** 体重 */
	private String weight;
	/** 身高 */
	private String stature;
	/** 体脂肪 */
	private String bodyFat;
	/** 肌肉量 */
	private String muscleMass;
	/** 骨量 */
	private String boneMass;
	/** 内脏脂肪 */
	private String internalFat;
	/** 体水分 */
	private String bodyWater;
	/** 肥胖指数 */
	private String bmi;
	/** 基础代谢率 */
	private String bmr;
	/** 脏器年龄 */
	private String organAge;
	/** 创建日期 */
	private Date createDatetime;
	/** 修改日期 */
	private Date modifyDatetime;

	private int page;

	private int rows;
	/** jquery-easyui 返回给后台的是以 "," 为分隔符的字符串 */
	private String ids;

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getStature() {
		return stature;
	}

	public void setStature(String stature) {
		this.stature = stature;
	}

	public String getBodyFat() {
		return bodyFat;
	}

	public void setBodyFat(String bodyFat) {
		this.bodyFat = bodyFat;
	}

	public String getMuscleMass() {
		return muscleMass;
	}

	public void setMuscleMass(String muscleMass) {
		this.muscleMass = muscleMass;
	}

	public String getBoneMass() {
		return boneMass;
	}

	public void setBoneMass(String boneMass) {
		this.boneMass = boneMass;
	}

	public String getInternalFat() {
		return internalFat;
	}

	public void setInternalFat(String internalFat) {
		this.internalFat = internalFat;
	}

	public String getBodyWater() {
		return bodyWater;
	}

	public void setBodyWater(String bodyWater) {
		this.bodyWater = bodyWater;
	}

	public String getBmi() {
		return bmi;
	}

	public void setBmi(String bmi) {
		this.bmi = bmi;
	}

	public String getBmr() {
		return bmr;
	}

	public void setBmr(String bmr) {
		this.bmr = bmr;
	}

	public String getOrganAge() {
		return organAge;
	}

	public void setOrganAge(String organAge) {
		this.organAge = organAge;
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
}
