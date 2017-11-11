package cn.szx.weightcontrol.model;

import java.util.Date;
/**
 * 
 * @ClassName: WUserinfo
 * @Description: 对应数据表 w_userinfo 的实体类
 * @author: 宋桢熙
 * @date: 2014年9月2日 下午4:01:14
 */
public class WUserinfo {
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

	private String reserve1;

	private String reserve2;

	private String reserve3;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age == null ? null : age.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight == null ? null : weight.trim();
	}

	public String getStature() {
		return stature;
	}

	public void setStature(String stature) {
		this.stature = stature == null ? null : stature.trim();
	}

	public String getBodyFat() {
		return bodyFat;
	}

	public void setBodyFat(String bodyFat) {
		this.bodyFat = bodyFat == null ? null : bodyFat.trim();
	}

	public String getMuscleMass() {
		return muscleMass;
	}

	public void setMuscleMass(String muscleMass) {
		this.muscleMass = muscleMass == null ? null : muscleMass.trim();
	}

	public String getBoneMass() {
		return boneMass;
	}

	public void setBoneMass(String boneMass) {
		this.boneMass = boneMass == null ? null : boneMass.trim();
	}

	public String getInternalFat() {
		return internalFat;
	}

	public void setInternalFat(String internalFat) {
		this.internalFat = internalFat == null ? null : internalFat.trim();
	}

	public String getBodyWater() {
		return bodyWater;
	}

	public void setBodyWater(String bodyWater) {
		this.bodyWater = bodyWater == null ? null : bodyWater.trim();
	}

	public String getBmi() {
		return bmi;
	}

	public void setBmi(String bmi) {
		this.bmi = bmi == null ? null : bmi.trim();
	}

	public String getBmr() {
		return bmr;
	}

	public void setBmr(String bmr) {
		this.bmr = bmr == null ? null : bmr.trim();
	}

	public String getOrganAge() {
		return organAge;
	}

	public void setOrganAge(String organAge) {
		this.organAge = organAge == null ? null : organAge.trim();
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
}