package cn.szx.weightcontrol.dao;

import cn.szx.weightcontrol.model.WProductAccessLogger;

public interface WProductAccessLoggerMapper {
    int deleteByPrimaryKey(String id);

    int insert(WProductAccessLogger record);

    int insertSelective(WProductAccessLogger record);

    WProductAccessLogger selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WProductAccessLogger record);

    int updateByPrimaryKey(WProductAccessLogger record);
}