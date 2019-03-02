package cn.yc.cms.Service;

import java.util.Map;

import cn.yc.cms.pojo.Admin;

public interface AdminService {
	
	/**
	 * 查询所属级别一下的所有管理员
	 * @param 起始页
	 * @param 级别
	 * */
	public Map<String, Object> selectAdmin(Integer start,Integer level);
	
	public Map<String, Object> selectById(Integer id);
	
	public void UpdateAdmin(Admin admin);
}
