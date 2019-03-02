package cn.yc.cms.Service.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yc.cms.Exception.ServiceException;
import cn.yc.cms.ResultData.PageObject;
import cn.yc.cms.Service.OrderTableService;
import cn.yc.cms.dao.OrderTableDao.OrderTableMapper;
import cn.yc.cms.pojo.OrderTable;

@Service
@Transactional(rollbackFor= {ServiceException.class})
public class OrderTableServiceImpl implements OrderTableService{

	@Autowired
	private OrderTableMapper orderDao;
	
	/**
	 * 查询所有并分页
	 * */
	@Override
	public Map<String, Object> selectByLimit(Integer start) {
		PageObject object = new PageObject();
		object.setPageCurrent(start);
		object.setPageSize(10);
		object.setRowCount(orderDao.countOrderList());
		List<OrderTable> list = orderDao.selectAllByLimit(object.getStartIndex(), object.getPageSize());
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("order", list);
		map.put("page", object);
		return map;
	}
	
	/**
	 * 删除数据
	 * */
	public void deleteOrder(Integer orderId) {
		if(orderDao.deleteByPrimaryKey(orderId)!=1) {
			throw new ServiceException("删除失败");
		}
	}
	
	/**
	 * 批量删除数据
	 * */
	public void deleteSomeOrder(Integer[] integers) {
		if (orderDao.deleteSomeOrder(integers)==0) {
			throw new ServiceException("删除多项失败");
		}
	}

	/**
	 * 录入数据
	 * */
	public void insertOrder(OrderTable orderTable) {
		if(orderDao.insertSelective(orderTable)!=1) {
			throw new ServiceException("录入失败");
		}
	}
}
