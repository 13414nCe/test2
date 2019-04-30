package cn.qyl.ebuy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.qyl.ebuy.dao.BaseDao;
import cn.qyl.ebuy.dao.OrderItemDao;
import cn.qyl.ebuy.dto.Goods;
import cn.qyl.ebuy.dto.Order;
import cn.qyl.ebuy.dto.OrderItem;
import cn.qyl.ebuy.dto.User;
import cn.qyl.ebuy.mapper.OrderItemMapper;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {

	//新增订单中间表
	@Override
	public void addOrderItem(int orderId, List<Goods> goodsList) {
		//获取SqlSession
		SqlSession session = getSqlSession();
		OrderItemMapper orderItemMapper = session.getMapper(OrderItemMapper.class);
		OrderItem orderItem = new OrderItem();
		Order order = new Order();
		order.setId(orderId);
		orderItem.setOrder(order);
		for(Goods goods : goodsList){
			//设置商品id
			orderItem.setGoods(goods);
			//设置商品数量
			orderItem.setOrderNum(goods.getBuyNum());
			
			orderItemMapper.saveOrderItem(orderItem);
		}
		
		
		//提交事务
		session.commit();
		//释放资源
		closeSqlSession();
		
	}

	//查询我的订单
	@Override
	public List<OrderItem> getOrderItemsByUserId(User user) {
		SqlSession session = getSqlSession();
		OrderItemMapper orderItemMapper = session.getMapper(OrderItemMapper.class);
		List<OrderItem> orderItems = orderItemMapper.getOrderItemsByUserId(user);
		closeSqlSession();
		return orderItems;
	}
	
	
	@Override
	public List<OrderItem> getOrderItemsByOid(int oid) {
		SqlSession session  = getSqlSession();
		OrderItemMapper orderItemMapper = session.getMapper(OrderItemMapper.class);
		List<OrderItem> orderItem = orderItemMapper.getOrderItemsByOid(oid);
		//释放资源
		closeSqlSession();
		return orderItem;
	}
	

}
