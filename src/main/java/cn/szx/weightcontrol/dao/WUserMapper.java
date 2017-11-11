package cn.szx.weightcontrol.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Select;

import cn.szx.weightcontrol.model.WUser;

public interface WUserMapper {
	int deleteByPrimaryKey(String id);

	int insert(WUser record);

	int insertSelective(WUser record);

	WUser selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(WUser record);

	int updateByPrimaryKey(WUser record);

	@Select("select * from w_user where username=#{username}")
	WUser selectByUsername(String username);

	WUser selectForLogin(Map<String, Object> params);
	
}