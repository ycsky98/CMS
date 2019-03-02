package cn.yc.cms.Controller.ServiceController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yc.cms.Exception.ServiceException;
import cn.yc.cms.ResultData.JsonResult;
import cn.yc.cms.Service.PerService;
import cn.yc.cms.pojo.Admin;

@Controller
@RequestMapping("/admin")
public class LoginController {
	
	@Autowired
	private PerService perservice;
	
	@RequestMapping(value="/toLogin")
	@ResponseBody
	public JsonResult toLogin(String username,String password,HttpSession session,HttpServletRequest request) {
		session.invalidate();
		session = request.getSession();
		Admin admin = perservice.checkUser(username, password);
		if (admin==null) {
			throw new ServiceException("用户名密码错误");
		}else {
			//存储用户名,密码,权限,角色
			session.setAttribute("admin", perservice.CheckAdmin(admin.getaId()));
		}
		return new JsonResult();
	}
}
