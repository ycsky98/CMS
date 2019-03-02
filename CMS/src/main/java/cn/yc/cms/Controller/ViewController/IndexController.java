package cn.yc.cms.Controller.ViewController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	/**首页加载*/
	@RequestMapping("/index")
	public String toIndex(HttpServletRequest request) {
		//System.out.println(request.getContentType());
		return "index";
	}
	
	/**登陆页加载*/
	@RequestMapping("/login")
	public String toLogin() {
		return "login";
	}
	
	/**文章页及服务器运行版本*/
	@RequestMapping("/welcome")
	public String toWelcome() {
		return "welcome";
	}
	
	/**权限管理*/
	@RequestMapping("/add_Role")
	public String role() {
		return "role-add";
	}
	
	/**订单管列表*/
	@RequestMapping("/order_List")
	public String order_List() {
		return "order-list";
	}
	
	/**订单添加*/
	@RequestMapping("/order_add")
	public String order_add() {
		return "order-add";
	}
	
	/**会员列表*/
	@RequestMapping("/member_list")
	public String member_list(){
		return "member-list";
	}
	
	/**会员删除*/
	@RequestMapping("/member_del")
	public String member_del() {
		return "member-del";
	}
	
	/**会员编辑*/
	@RequestMapping("/member_edit")
	public String member_edit() {
		return "member-edit";
	}
	
	/**会员添加*/
	@RequestMapping("/member_add")
	public String member_add() {
		return "member-add";
	}
	
	/**会员用户名和密码*/
	@RequestMapping("/member_password")
	public String member_password() {
		return "member-password";
	}
	
	/**管理员列表*/
	@RequestMapping("/admin_list")
	public String admin_list() {
		return "admin-list";
	}
	
	/**角色管理*/
	@RequestMapping("/admin_role")
	public String admin_role() {
		return "admin-role";
	}
	
	/**管理员表修改*/
	@RequestMapping("/admin_edit")
	public String admin_edit() {
		return "admin-edit";
	}
	
	/**管理员添加*/
	@RequestMapping("/admin_add")
	public String admin_add() {
		return "admin-add";
	}
	
	/**权限管理*/
	@RequestMapping("/admin_rule")
	public String admin_rule() {
		return "admin-rule";
	}
	
	/**折现统计图*/
	@RequestMapping("/echarts1")
	public String echarts1() {
		return "echarts1";
	}
	
	/**柱状图*/
	@RequestMapping("/echarts2")
	public String echarts2() {
		return "echarts2";
	}
}
