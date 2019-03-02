package cn.yc.cms.Service.ServiceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yc.cms.Exception.ServiceException;
import cn.yc.cms.ResultData.PageObject;
import cn.yc.cms.Service.VipService;
import cn.yc.cms.dao.VipDao.Vip_UserMapper;
import cn.yc.cms.pojo.Vip_User;

@Service
@Transactional(rollbackFor=ServiceException.class)
public class VipServiceImpl implements VipService{
	
	@Autowired
	private Vip_UserMapper vipDao;

	/**
	 * 录入VIP用户
	 * */
	@Override
	public void AddVipUser(Vip_User vip) {
		if (vipDao.selectByPhoneOrEmail(vip.getVipPhone(), vip.getVipEmail())==0) {
			if(vipDao.insert(vip)!=1) {
				throw new ServiceException("录入用户失败");
			}
		}else {
			throw new ServiceException("该手机号或邮箱以被使用!");
		}
		
	}

	/**
	 * 修改VIP用户信息
	 * */
	@Override
	public void UpdateVipUser(Vip_User vip_User) {
		if(vipDao.updateByPrimaryKeySelective(vip_User)!=1) {
			throw new ServiceException("修改失败,请稍后重试");
		}
	}

	/**
	 * 删除用户
	 * */
	@Override
	public void DeleteVipUser(Integer id) {
		if(vipDao.deleteByPrimaryKey(id)!=1) {
			throw new ServiceException("删除失败,请重试");
		}
	}

	/**
	 * 统计
	 * */
	@Override
	public Integer CountVipUser() {
		return vipDao.count();
	}

	/**
	 * 查询所有用户并分页
	 * */
	@Override
	public Map<String,Object> selectAll(Integer start) {
		Map<String, Object> map = new HashMap<String,Object>();
		PageObject object = new PageObject();
		if (start!=null) {
			object.setPageCurrent(start);
			object.setRowCount(vipDao.count());
			object.setPageSize(10);
		}
		map.put("page", object);
		map.put("user", vipDao.selectAll(start!=null?object.getStartIndex():null,start!=null?object.getPageSize():null));
		return map;
	}

	/**
	 * 根据ID查询用户
	 * */
	@Override
	public Vip_User selectById(Integer id) {
		return vipDao.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 * */
	@Override
	public void DeleteSomeVip(Integer[] ids) {
		vipDao.deleteSomeByKeys(ids);
	}

}
