package cn.yc.cms.dao.VipDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.yc.cms.pojo.Vip_User;

public interface Vip_UserMapper {
	
    int deleteByPrimaryKey(Integer vipId);

    int insert(Vip_User record);

    int insertSelective(Vip_User record);

    Vip_User selectByPrimaryKey(Integer vipId);

    int updateByPrimaryKeySelective(Vip_User record);

    int updateByPrimaryKey(Vip_User record);
    
    int deleteSomeByKeys(@Param("ids")Integer[] ids);
    
    Integer count();
    
    List<Vip_User> selectAll(@Param("start")Integer start,@Param("end")Integer end);
    
    Integer selectByPhoneOrEmail(@Param("phone")String phone,@Param("email")String email);
}