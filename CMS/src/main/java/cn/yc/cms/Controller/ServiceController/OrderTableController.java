package cn.yc.cms.Controller.ServiceController;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yc.cms.ResultData.JsonResult;
import cn.yc.cms.Service.OrderTableService;
import cn.yc.cms.pojo.OrderTable;

@Controller
@RequestMapping(value="/order")
public class OrderTableController {
	
	@Autowired
	private OrderTableService service;
	
	/**
	 * 获取数据并分页
	 * */
	@RequestMapping(value="/GetData",method= RequestMethod.POST)
	@ResponseBody
	public JsonResult GetData(Integer start) {
		return new JsonResult(service.selectByLimit(start));
	}
	
	/**
	 * 删除数据
	 * */
	@RequestMapping(value="/DeleteOrder/{url}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult DeleteOrder(String[] ids,String id,@PathVariable("url")String url) {
		if ("one".equals(url)) {
			service.deleteOrder(Integer.parseInt(id));
			return new JsonResult();
		}
		Integer[] all = new Integer[ids.length];
		for (int i = 0; i < all.length; i++) {
			all[i] = Integer.parseInt(ids[i]);
		}
		service.deleteSomeOrder(all);
		return new JsonResult();
	}
	
	/**
	 * 录入数据
	 * */
	@RequestMapping(value="/insertOrder",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult InsertData(OrderTable data) {
		service.insertOrder(data);
		return new JsonResult();
	}
}
