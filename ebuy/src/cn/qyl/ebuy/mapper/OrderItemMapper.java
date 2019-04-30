package cn.qyl.ebuy.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.qyl.ebuy.dto.OrderItem;
import cn.qyl.ebuy.dto.User;

public interface OrderItemMapper {
	
	//保存订单中间表
	void saveOrderItem(OrderItem orderItem);
	//查询我的订单
	List<OrderItem> getOrderItemsByUserId(User user);

	//根据订单id获取订单中间表列表
	List<OrderItem> getOrderItemsByOid(@Param("oid")int oid);
	
	
	
}
