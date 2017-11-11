package cn.szx.weightcontrol.dao;

import java.util.List;

import cn.szx.weightcontrol.model.WMenu;

public interface WMenuMapper {
	int deleteByPrimaryKey(String id);

	int insert(WMenu record);

	int insertSelective(WMenu record);

	WMenu selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(WMenu record);

	int updateByPrimaryKey(WMenu record);

	WMenu selectAllByParamsIsNull();

	List<WMenu> selectAllByParentId(String id);

}