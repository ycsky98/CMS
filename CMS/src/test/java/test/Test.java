package test;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.yc.cms.Controller.ServiceController.AdminController;
import cn.yc.cms.Controller.ServiceController.OrderTableController;
import cn.yc.cms.Controller.ServiceController.VipController;
import cn.yc.cms.dao.LoginDao.AdminMapper;
import cn.yc.cms.dao.LoginDao.PermissionsMapper;
import cn.yc.cms.dao.LoginDao.RoleMapper;
import cn.yc.cms.dao.OrderTableDao.OrderTableMapper;
import cn.yc.cms.dao.VipDao.Vip_UserMapper;
import cn.yc.cms.pojo.Admin;
import cn.yc.cms.pojo.OrderTable;
import cn.yc.cms.pojo.Permissions;
import cn.yc.cms.pojo.Role;
import cn.yc.cms.pojo.Vip_User;
import cn.yc.cms.util.ControllerGetValue;



public class Test {
	//加载配置文件
	ApplicationContext app =
			new ClassPathXmlApplicationContext("spring-mvc.xml","spring-pool.xml","spring-mybatis.xml");
	@org.junit.Test
	public void test() {
		Vip_User user = new Vip_User();
		user.setVipName("123");
		user.setVipUsername("admin1");
		user.setVipPassword("aaaaa");
		user.setVipPhone("12345678912379");
		user.setVipAddress("12312312313131");
		user.setVipEmail("dadasdasdaddssds");
		user.setVipSex(1);
		user.setVipState(1);
		user.setVipTime(new Date());
		Vip_UserMapper vip = app.getBean("vip_UserMapper",Vip_UserMapper.class);
		vip.insert(user);
	}
	
	@org.junit.Test
	public void test2() {
		String str = "";
		ControllerGetValue value = new ControllerGetValue();
		List<String> url = value.getValues(VipController.class);
		List<String> urls = value.getValues(OrderTableController.class);
		List<String> urls2 = value.getValues(AdminController.class);
		url.addAll(urls);
		url.addAll(urls2);
		for (int i = 0; i < url.size(); i++) {
			if (str.equals("")) {
				str+=url.get(i);
			}else {
				str = str + "," + url.get(i);
			}
		}
		System.out.println(str);
		PermissionsMapper mapper = app.getBean(PermissionsMapper.class,"permissionsMapper");
		Permissions permissions = new Permissions();
		permissions.setpId(1);
		permissions.setpName("Root");
		permissions.setpLevel(20);
		permissions.setpController(str);
		System.out.println(mapper.updateByPrimaryKeySelective(permissions));
	}
	
	@org.junit.Test
	public void test3() {
		Role role = new Role();
		role.setrName("管理员2");
		role.setrPerm(2);
		RoleMapper mapper = app.getBean(RoleMapper.class,"roleMapper");
		mapper.insertSelective(role);
	}
	
	@org.junit.Test
	public void test4() {
		Admin admin = new Admin();
		admin.setaName("Root2");
		admin.setaPwd("123456");
		admin.setaRole(2);
		admin.setaTime(new Date());
		AdminMapper mapper = app.getBean(AdminMapper.class,"adminMapper");
		mapper.insertSelective(admin);
	}
	
	@org.junit.Test
	public void test5() {
		AdminMapper mapper = app.getBean(AdminMapper.class,"adminMapper");
		/*Map<String, Object> map = mapper.selectPer(1);
		System.out.println(map);*/
		Admin admin = mapper.selectByNamePwd("Root", "123456");
		System.out.println(admin);
	}
	
	@org.junit.Test
	public void test6() {
		OrderTableMapper mapper = app.getBean("orderTableMapper", OrderTableMapper.class);
		OrderTable table = new OrderTable();
		table.setVipId(1);
		table.setOrderNumber("654321");
		table.setOrderConsignee("My");
		table.setOrderAllpaynumber(100);
		table.setOrderPaynumber(100);
		table.setOrderOrderstate(1);
		table.setOrderPaystate(1);
		table.setOrderGostate(1);
		table.setOrderPayway(1);
		table.setOrderDistributionway(1);
		table.setOrderTime(new Date());
		System.out.println(mapper.insertSelective(table));
	}
	
	@org.junit.Test
	public void test7() {
		AdminMapper mapper = app.getBean("adminMapper",AdminMapper.class);
		System.out.println(mapper.selectAllByLimit(0, 10, 20));
	}
	
	@org.junit.Test
	public void test8() {
		AdminMapper mapper = app.getBean("adminMapper",AdminMapper.class);
		System.out.println(mapper.selectAdminById(1));
	}
	
	@org.junit.Test
	public void test9() {
		RoleMapper mapper = app.getBean("roleMapper", RoleMapper.class);
		System.out.println(mapper.selectAllRole(20));
	}
}
