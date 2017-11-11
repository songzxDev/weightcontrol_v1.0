package cn.szx.weightcontrol.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.szx.weightcontrol.dao.WUserinfoMapper;
import cn.szx.weightcontrol.model.WUserinfo;
import cn.szx.weightcontrol.pagemodel.DataGrid;
import cn.szx.weightcontrol.pagemodel.Userinfo;
import cn.szx.weightcontrol.service.UserinfoServiceI;
import cn.szx.weightcontrol.util.WPrimaryKeyUtil;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @ClassName: UserinfoServiceImpl
 * @Description: 用户对个人体检信息执行相应操作的 "Service" 类
 * @author: 宋桢熙
 * @date: 2014年9月2日 上午10:06:54
 */
@Service("userinfoService")
public class UserinfoServiceImpl implements UserinfoServiceI {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(UserinfoServiceImpl.class);

	private WUserinfoMapper userinfoMapper;

	public WUserinfoMapper getUserinfoMapper() {
		return userinfoMapper;
	}

	@Autowired
	public void setUserinfoMapper(WUserinfoMapper userinfoMapper) {
		this.userinfoMapper = userinfoMapper;
	}

	/**
	 * 
	 * @Title: save
	 * @Description: 用户执行 "新增" 操作时，将前台传递过来的数据存储至数据表 w_userinfo 中
	 * @param userinfo
	 *          用户执行 "新增" 操作时，前台传递过来的 Userinfo 对象
	 * @return 用户执行 "新增" 操作成功后，对应此新增数据的 Userinfo 对象
	 * @throws Exception
	 * @see cn.szx.weightcontrol.service.UserinfoServiceI#save(cn.szx.weightcontrol.pagemodel.Userinfo)
	 * @see cn.szx.weightcontrol.dao.WUserinfoMapper#insertSelective(cn.szx.weightcontrol.model.WUserinfo)
	 */
	@Override
	public Userinfo save(Userinfo userinfo) throws Exception {
		WUserinfo wuserinfo = new WUserinfo();
		// 使用org.springframework.beans.BeanUtils下提供的的类与类之间属性值复制的方法
		BeanUtils.copyProperties(userinfo, wuserinfo);
		wuserinfo.setId(WPrimaryKeyUtil.producePrimayKeyByUUID());
		userinfoMapper.insertSelective(wuserinfo);
		BeanUtils.copyProperties(wuserinfo, userinfo);
		/*
		 * 前台展示和后台存储存在不一致性， 因此将要返回给前台的数据进行稍加处理以满足前台展示需求 ， 数据表 w_userinfo中对应用户性别的字段 sex 的值 "m" "male" 的缩写代表 "男性"， 数据表 w_userinfo 中对应用户性别的字段sex 的值 "f" "female" 的缩写代表 "女性"， 数据表 w_userinfo 中对应用户性别的字段 sex 的值"l" "ladyboy" 的缩写代表 "中性"。
		 */
		if (userinfo.getSex().trim().equals("m")) {
			userinfo.setSex("男性");
		} else if (userinfo.getSex().trim().equals("f")) {
			userinfo.setSex("女性");
		} else {
			userinfo.setSex("中性");
		}
		return userinfo;
	}

	/**
	 * 
	 * @Title: edit
	 * @Description: 用户执行 "更新" 操作时，将前台传递过来的数据存储至数据表 w_userinfo 中
	 * @param userinfo
	 *          用户执行 "更新" 操作时，前台传递过来的 Userinfo 对象
	 * @return 用户执行 "更新" 操作成功后，对应此新增数据的 Userinfo 对象
	 * @throws Exception
	 * @see cn.szx.weightcontrol.service.UserinfoServiceI#edit(cn.szx.weightcontrol.pagemodel.Userinfo)
	 * @see cn.szx.weightcontrol.dao.WUserinfoMapper#updateByPrimaryKeySelective(cn.szx.weightcontrol.model.WUserinfo)
	 */
	@Override
	public Userinfo edit(Userinfo userinfo) throws Exception {
		WUserinfo wuserinfo = userinfoMapper.selectByPrimaryKey(userinfo.getId());
		logger.info("################################ 待修改的记录信息为：" + JSON.toJSONStringWithDateFormat(wuserinfo, "yyyy-MM-dd HH:mm:ss") + "################################");
		BeanUtils.copyProperties(userinfo, wuserinfo);
		wuserinfo.setModifyDatetime(new Date());
		userinfoMapper.updateByPrimaryKeySelective(wuserinfo);
		BeanUtils.copyProperties(wuserinfo, userinfo);
		/*
		 * 前台展示和后台存储存在不一致性， 因此将要返回给前台的数据进行稍加处理以满足前台展示需求 ， 数据表 w_userinfo中对应用户性别的字段 sex 的值 "m" "male" 的缩写代表 "男性"， 数据表 w_userinfo 中对应用户性别的字段sex 的值 "f" "female" 的缩写代表 "女性"， 数据表 w_userinfo 中对应用户性别的字段 sex 的值"l" "ladyboy" 的缩写代表 "中性"。
		 */
		if (userinfo.getSex().trim().equals("m")) {
			userinfo.setSex("男性");
		} else if (userinfo.getSex().trim().equals("f")) {
			userinfo.setSex("女性");
		} else {
			userinfo.setSex("中性");
		}
		logger.info("################################ 修改后的记录信息为：" + JSON.toJSONStringWithDateFormat(userinfo, "yyyy-MM-dd HH:mm:ss") + "################################");
		return userinfo;
	}

	/**
	 * 
	 * @Title: remove
	 * @Description: 用户执行 "删除" 操作时，根据前台传递过来的参数 ids 到数据表 w_userinfo 中找到对应的数据并执行删除操作
	 * @param userinfo
	 *          前台传递给后台的 Userinfo 对象中属性 ids 的值是要删除的记录的主键值，jquery- easyui 返回给后台的是以 "," 为分隔符的字符串，例：ids: "1,2,3,4,5,6"
	 * @throws Exception
	 * @see cn.szx.weightcontrol.service.UserinfoServiceI#remove(cn.szx.weightcontrol.pagemodel.Userinfo)
	 * @see cn.szx.weightcontrol.dao.WUserinfoMapper#deleteByPrimaryKey(java.lang.String)
	 * @see cn.szx.weightcontrol.dao.WUserinfoMapper#deleteByPrimaryKeyArray(String[])
	 */
	@Override
	public void remove(Userinfo userinfo) throws Exception {
		/*
		 * (1)jquery-easyui 返回给后台的是以 "," 为分隔符的字符串，例：ids: "1,2,3,4,5,6"； (2)将这个 "1,2,3,4,5,6"分隔成为{"1","2", "3","4","5","6"} ； (3)循环遍历数组，将数组中每个元素作为参数传递给userinfoMapper的deleteByPrimaryKey方法中执行对数据表记录的删除操作。
		 */
		String[] idsArray = userinfo.getIds().split(",");
		logger.info(idsArray);
		// for (int i = 0; i < idsArray.length; i++) {
		// logger.info("################  被删除的记录的主键ID：" + idsArray[i] + "  ################");
		// userinfoMapper.deleteByPrimaryKey(idsArray[i]);
		// }
		userinfoMapper.deleteByPrimaryKeyArray(idsArray);
	}

	/**
	 * 
	 * @Title: datagrid
	 * @Description: 将当前登录的 User 对象的属性 id 的值作为参数对表 w_userinfo 执行查询操作，将 w_user 表中字段 user_id 的值等于 id 的所有数据返回给前台用于数据展示。
	 * @param userinfo
	 *          前台返回给后台执行 "查询" 操作时用到的各个参数的值，这些参数值从前台返回的 Userinfo 的属性值中获取
	 * @return DataGrid 对象转换成json数据后，返回给前台 jquery-easyui 框架进行数据展示
	 * @throws Exception
	 * @see cn.szx.weightcontrol.service.UserinfoServiceI#datagrid(cn.szx.weightcontrol.pagemodel.Userinfo)
	 * @see cn.szx.weightcontrol.pagemodel.DataGrid
	 * @see cn.szx.weightcontrol.dao.WUserinfoMapper#selectAllByUserId(java.util.Map)
	 */
	@Override
	public DataGrid datagrid(Userinfo userinfo) throws Exception {
		/*
		 * 前台需要后台返回 json 数据格式 {"rows": [ { 转换成json数据格式的对象集合 } ], "total": "数值" }， 故将返回值类型定义为 cn.szx.weightcontrol.pagemodel.DataGrid 对象。
		 */
		DataGrid dataGrid = new DataGrid();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userinfo.getUserId());
		params.put("page", (userinfo.getPage() - 1) * userinfo.getRows());
		params.put("rows", userinfo.getRows());
		List<Userinfo> userinfoList = new ArrayList<Userinfo>();

		// mybaits 查询数据时，如果查询条件有个多个，就需要将这些参数名称和值放入到 Map 集合中传递给 mybaits 框架进行处理
		List<WUserinfo> wuserinfoList = userinfoMapper.selectAllByUserId(params);
		logger.info(JSON.toJSONStringWithDateFormat(wuserinfoList, "yyyy-MM-dd HH:mm:ss"));

		// 前台需要后台返回 json 数据中含有例如：{"total":"1"} 这样的数据格式
		dataGrid.setTotal(userinfoMapper.getTotalByUserId(userinfo.getUserId()));
		for (WUserinfo wUserinfo : wuserinfoList) {
			Userinfo userinfo2 = new Userinfo();
			BeanUtils.copyProperties(wUserinfo, userinfo2);
			/*
			 * 前台展示和后台存储存在不一致性， 因此将要返回给前台的数据进行稍加处理以满足前台展示需求 ， 数据表 w_userinfo中对应用户性别的字段 sex 的值 "m" "male" 的缩写代表 "男性"， 数据表 w_userinfo 中对应用户性别的字段sex 的值 "f" "female" 的缩写代表 "女性"， 数据表 w_userinfo 中对应用户性别的字段 sex 的值"l" "ladyboy" 的缩写代表 "中性"。
			 */
			if (userinfo2.getSex().trim().equals("m")) {
				userinfo2.setSex("男性");
			} else if (userinfo2.getSex().trim().equals("f")) {
				userinfo2.setSex("女性");
			} else {
				userinfo2.setSex("中性");
			}
			userinfoList.add(userinfo2);
		}
		dataGrid.setRows(userinfoList);
		return dataGrid;
	}

}
