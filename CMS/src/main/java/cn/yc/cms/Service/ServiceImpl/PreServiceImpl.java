package cn.yc.cms.Service.ServiceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yc.cms.Exception.ServiceException;
import cn.yc.cms.Service.PerService;
import cn.yc.cms.dao.LoginDao.AdminMapper;
import cn.yc.cms.dao.LoginDao.PermissionsMapper;
import cn.yc.cms.dao.LoginDao.RoleMapper;
import cn.yc.cms.pojo.Admin;

@Service
@Transactional(rollbackFor= {ServiceException.class})
public class PreServiceImpl implements PerService{
	
	@Autowired
	private AdminMapper adminMapper;

	@Autowired
	private PermissionsMapper permissionsMapper;
	
	@Autowired
	private RoleMapper roleMapper;
	
	/**
	 * 查询权限，角色，管理员
	 * */
	public Map<String, Object> CheckAdmin(Integer adminID) {
		return adminMapper.selectPer(adminID);
	}

	/**
	 * 查询管理员是否存在
	 * */
	public Admin checkUser(String username,String password) {
		return adminMapper.selectByNamePwd(username, password);
	}
	
	/**
	 * 查询当前管理级别以下的角色
	 * */
	public List<Map<String, Object>> selectAuth(Integer level){
		return roleMapper.selectAllRole(level);
	}
}
