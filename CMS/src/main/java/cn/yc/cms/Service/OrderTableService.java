package cn.yc.cms.Service;

import java.util.Map;

import cn.yc.cms.pojo.OrderTable;

public interface OrderTableService {
	
	/**
	 * 查询所有订单信息并分页
	 * @author yangcong
	 * @return List<OrderTable>
	 * */
	Map<String, Object> selectByLimit(Integer start);
	/**
	 * 删除单个
	 * */
	void deleteOrder(Integer orderId);
	/**
	 * 删除多个
	 * */
	void deleteSomeOrder(Integer[] integers);
	
	/**
	 * 录入订单
	 * */
	public void insertOrder(OrderTable orderTable);
}
