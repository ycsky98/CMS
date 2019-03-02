package cn.yc.cms.Controller.ServiceController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yc.cms.ResultData.JsonResult;
import cn.yc.cms.Service.VipService;
import cn.yc.cms.pojo.Vip_User;

@Controller
@RequestMapping("/Vip")
public class VipController {
	
	@Autowired
	private VipService serviceDao;
	
	/**
	 * 查询所有VIP用户
	 * */
	@RequestMapping(value="/GetData",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult getData(Integer start,HttpServletRequest request) {
		return new JsonResult(serviceDao.selectAll(start));
	}
	
	/**
	 * 统计个数
	 * */
	@RequestMapping(value="/Count",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult getCount() {
		return new JsonResult(serviceDao.CountVipUser());
	}
	
	/**
	 * 查询用户的账号密码
	 * */
	@RequestMapping(value="/GetByID",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult getByID(Integer id) {
		Vip_User user = serviceDao.selectById(id);
		Object[] objects = {user.getVipUsername(),user.getVipPassword()};
		return new JsonResult(objects);
	}
	
	/**
	 * 修改用户数据
	 * */
	@RequestMapping(value="/Update/{Update}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult UpdatePwd(Vip_User user) {
		serviceDao.UpdateVipUser(user);
		return new JsonResult();
	}
	
	/**
	 * 删除数据
	 * */
	@RequestMapping(value="/DeleteVip/{id}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult DeleteVip(String[] ids,Integer id,@PathVariable("id")String path) {
		Integer[] idsint = null;
		if (path.equals("some")) {
			idsint = new Integer[ids.length];
			for (int i = 0; i < idsint.length; i++) {
				idsint[i] = Integer.parseInt(ids[i]);
			}
		}
		if (path.equals("one")) {
			serviceDao.DeleteVipUser(id);
		}else {
			serviceDao.DeleteSomeVip(idsint);
		}
		return new JsonResult();
	}
	
	@RequestMapping(value="/insertVip",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult InsertVip(Vip_User user) {
		serviceDao.AddVipUser(user);
		return new JsonResult();
	}
}
