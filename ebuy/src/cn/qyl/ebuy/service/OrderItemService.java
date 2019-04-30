package cn.qyl.ebuy.service;

import java.util.List;

import cn.qyl.ebuy.dto.Goods;
import cn.qyl.ebuy.dto.OrderItem;
import cn.qyl.ebuy.dto.User;

public interface OrderItemService {

	//新增订单中间表
	void addOrderItem(int orderId, List<Goods> goodsList);
	//查询我的订单
	List<OrderItem> getOrderItemsByUserId(User user);
	//根据订单id获取订单中间表列表
	List<OrderItem> getOrderItemsByOid(int oid);

}
