package cn.szx.weightcontrol.service.impl;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.szx.weightcontrol.pagemodel.DataGrid;
import cn.szx.weightcontrol.pagemodel.Userinfo;
import cn.szx.weightcontrol.service.UserinfoServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestUserinfoServiceImpl {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TestUserinfoServiceImpl.class);

	private UserinfoServiceI userinfoService;

	public UserinfoServiceI getUserinfoService() {
		return userinfoService;
	}

	@Autowired
	public void setUserinfoService(UserinfoServiceI userinfoService) {
		this.userinfoService = userinfoService;
	}

	@Test
	public void testDatagrid() throws Exception {
		// Userinfo userinfo = new Userinfo();
		// userinfo.setUserId("J_5c478c21-5e0d-4b51-9503-e30d276ed8f6");
		// DataGrid dataGrid = userinfoService.datagrid(userinfo);
		// logger.info(JSON.toJSONString(dataGrid));
	}

	@Test
	public void testSave() throws Exception {
		// Userinfo userinfo = new Userinfo();
		// userinfo.setAge("25");
		// userinfo.setName("宋桢熙");
		// userinfo.setWeight("88.5");
		// userinfo.setUserId("J_d92175fa-662c-4b76-830e-5da93a4dd9d5");
		// userinfo.setSex("m");
		// userinfo.setStature("173");
		// userinfo.setBodyFat("27.3/26.0");
		// userinfo.setMuscleMass("62.1");
		// userinfo.setBoneMass("3.4");
		// userinfo.setInternalFat("12");
		// userinfo.setBodyWater("50.7");
		// userinfo.setBmi("29.6");
		// userinfo.setBmr("1995");
		// userinfo.setOrganAge("37");
		// userinfo = userinfoService.save(userinfo);
		// logger.info(JSON.toJSONStringWithDateFormat(userinfo, "yyyy-MM-dd HH:mm:ss"));
	}

	@Test
	public void testRemove() throws Exception {
//		Userinfo userinfo = new Userinfo();
//		userinfo.setIds("J_1e7a9925-ab21-4383-9f0e-31f936b4673a,J_2f3bca31-2420-4f6a-afc2-cb8b31273796,J_6537afda-fde2-4321-80ef-0540001c1c99,J_dbc87e62-5114-4b56-a19e-2706a105c3ff");
//		userinfoService.remove(userinfo);
	}

	@Test
	public void testEdit() throws Exception {
		// Userinfo userinfo = new Userinfo();
		// userinfo.setId("fffff-fffff-eeeee-aaaaa-11111-jjjjjjj");
		// userinfo.setAge("25");
		// userinfo.setName("宋桢熙");
		// userinfo.setWeight("88.5");
		// userinfo.setUserId("J_d92175fa-662c-4b76-830e-5da93a4dd9d5");
		// userinfo.setSex("m");
		// userinfo.setStature("173");
		// userinfo.setBodyFat("27.3/26.0");
		// userinfo.setMuscleMass("62.1");
		// userinfo.setBoneMass("3.4");
		// userinfo.setInternalFat("12");
		// userinfo.setBodyWater("50.7");
		// userinfo.setBmi("29.6");
		// userinfo.setBmr("1995");
		// userinfo.setOrganAge("37");
		// userinfoService.edit(userinfo);
	}
}
