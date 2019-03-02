package cn.yc.cms.Service.ServiceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yc.cms.Exception.ServiceException;
import cn.yc.cms.ResultData.PageObject;
import cn.yc.cms.Service.AdminService;
import cn.yc.cms.dao.LoginDao.AdminMapper;
import cn.yc.cms.pojo.Admin;

@Service
@Transactional(rollbackFor= {ServiceException.class})
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminMapper adminDao;

	/**
	 * 查询所有管理员并分页
	 * */
	@Override
	public Map<String, Object> selectAdmin(Integer start, Integer level) {
		Map<String, Object> map = new HashMap<String,Object>();
		PageObject page = new PageObject();
		page.setPageCurrent(start);
		page.setPageSize(10);
		page.setRowCount(adminDao.selectAllByCount(level));
		map.put("adminUser", adminDao.selectAllByLimit(page.getStartIndex(), page.getPageSize(), level));
		map.put("page", page);
		return map;
	}
	
	/**
	 * 查询单个管理员
	 * */
	public Map<String, Object> selectById(Integer id){
		return adminDao.selectAdminById(id);
	}
	
	/**
	 * 修改管理员
	 * */
	public void UpdateAdmin(Admin admin) {
		if(adminDao.updateByPrimaryKeySelective(admin)!=1) {
			throw new ServiceException("修改失败");
		}
		
	}

}
