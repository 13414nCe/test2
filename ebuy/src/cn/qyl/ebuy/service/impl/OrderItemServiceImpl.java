package cn.qyl.ebuy.service.impl;

import java.util.List;

import cn.qyl.ebuy.dao.OrderItemDao;
import cn.qyl.ebuy.dao.impl.OrderItemDaoImpl;
import cn.qyl.ebuy.dto.Goods;
import cn.qyl.ebuy.dto.OrderItem;
import cn.qyl.ebuy.dto.User;
import cn.qyl.ebuy.service.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService{
	
	OrderItemDao orderItemDao  = new OrderItemDaoImpl();

	//新增订单中间表
	@Override
	public void addOrderItem(int orderId, List<Goods> goodsList) {
		OrderItemDao orderItemDao = new OrderItemDaoImpl();
		
		orderItemDao.addOrderItem(orderId,goodsList);
	}

	//查询我的订单
	@Override
	public List<OrderItem> getOrderItemsByUserId(User user) {
		
		return orderItemDao.getOrderItemsByUserId(user);
	}

	//根据订单id获取订单中间表列表
	@Override
	public List<OrderItem> getOrderItemsByOid(int oid) {
		// TODO Auto-generated method stub
		return orderItemDao.getOrderItemsByOid(oid);
	}
	
}
