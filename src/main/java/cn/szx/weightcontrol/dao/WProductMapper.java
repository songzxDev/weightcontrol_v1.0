package cn.szx.weightcontrol.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Select;

import cn.szx.weightcontrol.model.WProduct;

public interface WProductMapper {
	int deleteByPrimaryKey(String id);

	int insert(WProduct record);

	int insertSelective(WProduct record);

	WProduct selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(WProduct record);

	int updateByPrimaryKey(WProduct record);

	List<WProduct> selectAllByUserId(Map<String, Object> params);

	@Select("select count(*) from w_product where user_id=#{userId,jdbcType=VARCHAR}")
	long getTotalByUserId(String userId);

	/**
	 * 
	 * @Title: sumPurchaseAmountByProductNameAndUserId
	 * @Description: 根据产品的名称统计当前用户购买此种产品的总个数
	 * @param params
	 *          userId：当前登录用户的主键 id 值 <br/>
	 *          productName：产品名称 <br/>
	 *          productStatus：产品存储状态
	 * @return: long类型的总数
	 */
	long sumPurchaseAmountByProductNameAndUserId(Map<String, Object> params);

	/**
	 * 
	 * @Title: sumRemainingAmountsByProductNameAndUserId
	 * @Description: 根据产品的名称统计当前用户剩余此种产品的总个数
	 * @param params
	 *          userId：当前登录用户的主键 id 值 <br/>
	 *          productName：产品名称 <br/>
	 *          productStatus：产品存储状态
	 * @return: long类型的总数
	 */
	long sumRemainingAmountsByProductNameAndUserId(Map<String, Object> params);

	/**
	 * 
	 * @Title: getProductNameByUserId
	 * @Description: 获取用户所购买的所有产品名称
	 * @param userId
	 * @return: Set<String><br/>
	 *          获取用户所购买的产品名称用来统计同类产品所购买的总数，因数据库中存储的同名称产品记录较多故需要去重复名称
	 */
	@Select("select distinct(product_name) from w_product where user_id=#{userId,jdbcType=VARCHAR}")
	Set<String> getProductNameByUserId(String userId);
}