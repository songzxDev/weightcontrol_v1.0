package cn.szx.weightcontrol.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import cn.szx.weightcontrol.model.WUserinfo;

public interface WUserinfoMapper {
	int deleteByPrimaryKey(String id);
	
	int deleteByPrimaryKeyArray(String[] ids);

	int insert(WUserinfo record);

	int insertSelective(WUserinfo record);

	WUserinfo selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(WUserinfo record);

	int updateByPrimaryKey(WUserinfo record);

	List<WUserinfo> selectAllByUserId(Map<String,Object> params);

	@Select("select count(*) from w_userinfo where user_id=#{userId,jdbcType=VARCHAR}")
	long getTotalByUserId(String userId);
}