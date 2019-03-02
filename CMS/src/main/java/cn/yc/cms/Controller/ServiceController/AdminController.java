package cn.yc.cms.Controller.ServiceController;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yc.cms.ResultData.JsonResult;
import cn.yc.cms.Service.AdminService;
import cn.yc.cms.Service.PerService;
import cn.yc.cms.pojo.Admin;

@Controller
@RequestMapping(value="/adminUser")
public class AdminController {
	
	@Autowired
	private AdminService serviceAdmin;
	
	@Autowired
	private PerService servicePre;
	
	@RequestMapping(value="/GetAdminData",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult GetAdminData(Integer start,HttpSession session) {
		//获取权限级别
		@SuppressWarnings("unchecked")
		Integer level = (Integer) ((Map<String, Object>)session.getAttribute("admin")).get("p_level");
		return new JsonResult(serviceAdmin.selectAdmin(start, level));
	}
	
	/**
	 * 根据id查询
	 * */
	@RequestMapping(value="/GetById",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult GetById(Integer id) {
		return new JsonResult(serviceAdmin.selectById(id));
	}
	
	/**
	 * 根据自身权限查询所有角色
	 * */
	@RequestMapping(value="/GetRole",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult GetAllRole(HttpSession session) {
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list =
				servicePre.selectAuth((Integer) ((Map<String, Object>)session.getAttribute("admin")).get("p_level"));
		return new JsonResult(list);
	}
	
	/**
	 * 修改管理员
	 * */
	@RequestMapping(value="/UpdateAdmin",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult UpdateAdmin(Admin admin) {
		serviceAdmin.UpdateAdmin(admin);
		return new JsonResult();
	}
}
