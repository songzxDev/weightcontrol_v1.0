package cn.szx.weightcontrol.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.szx.weightcontrol.dao.WUserMapper;
import cn.szx.weightcontrol.model.WUser;
import cn.szx.weightcontrol.pagemodel.DataGrid;
import cn.szx.weightcontrol.pagemodel.User;
import cn.szx.weightcontrol.service.UserServiceI;
import cn.szx.weightcontrol.util.WEncryptUtil;
import cn.szx.weightcontrol.util.WPrimaryKeyUtil;

@Service("userService")
public class UserServiceImpl implements UserServiceI {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	private WUserMapper userMapper;

	public WUserMapper getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(WUserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User save(User user) throws Exception {
		WUser wuser = userMapper.selectByUsername(user.getUsername());
		if (wuser == null) {
			wuser = new WUser();
			BeanUtils.copyProperties(user, wuser, new String[] { "id", "password" });
			wuser.setId(WPrimaryKeyUtil.producePrimayKeyByUUID());
			/** 此预留字段 reserve1 用于存储用户的真实姓名 */
			wuser.setReserve1(user.getName());
			/** 此预留字段 reserve2 用于存储用户的性别 */
			wuser.setReserve2(user.getSex());
			wuser.setPassword(WEncryptUtil.e(user.getPassword()));
			userMapper.insertSelective(wuser);
			logger.info(wuser.getPassword());
			BeanUtils.copyProperties(wuser, user);
			user.setName(wuser.getReserve1());
			user.setSex(wuser.getReserve2());
			user.setStatus(true);
			return user;
		} else {
			user.setStatus(false);
			return user;
		}
	}

	@Override
	public User login(User user) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username", user.getUsername());
		params.put("password", WEncryptUtil.e(user.getPassword()));
		WUser wuser = userMapper.selectForLogin(params);
		if (wuser != null) {
			BeanUtils.copyProperties(wuser, user);
			user.setName(wuser.getReserve1());
			user.setSex(wuser.getReserve2());
			user.setStatus(true);
			return user;
		} else {
			user.setStatus(false);
			return null;
		}
	}

	@Override
	public DataGrid datagrid(User user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(String id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public User edit(User user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
