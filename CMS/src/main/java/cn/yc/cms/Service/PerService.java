package cn.yc.cms.Service;

import java.util.List;
import java.util.Map;

import cn.yc.cms.pojo.Admin;

public interface PerService {
	
	/**
	 * 查询账号密码验证
	 * @return 查询到的用户,角色,权限控制器
	 * */
	public Map<String, Object> CheckAdmin(Integer adminID);
	
	/**
	 * 查询管理员是否存在
	 * */
	public Admin checkUser(String username,String password);
	
	/**
	 * 查询当前管理级别以下的角色
	 * */
	public List<Map<String, Object>> selectAuth(Integer level);
}
