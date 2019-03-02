package cn.yc.cms.Service;

import java.util.Map;

import cn.yc.cms.pojo.Vip_User;

public interface VipService {
	
	/**查询所有VIP用户*/
	public Map<String,Object> selectAll(Integer start);
	
	/**添加VIP用户*/
	public void AddVipUser(Vip_User vip);
	
	/**修改VIP用户*/
	public void UpdateVipUser(Vip_User vip_User);
	
	/**删除VIP用户*/
	public void DeleteVipUser(Integer id);
	
	/**批量删除*/
	public void DeleteSomeVip(Integer[] ids);
	
	/**根据ID查出单独用户*/
	public Vip_User selectById(Integer id);
	
	/**统计用户数量*/
	public Integer CountVipUser();
}
