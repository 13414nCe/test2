package cn.qyl.ebuy.service.impl;

import java.util.Date;
import java.util.List;

import cn.qyl.ebuy.common.PageModel;
import cn.qyl.ebuy.dao.OrderDao;
import cn.qyl.ebuy.dao.impl.OrderDaoImpl;
import cn.qyl.ebuy.dto.Goods;
import cn.qyl.ebuy.dto.Order;
import cn.qyl.ebuy.dto.User;
import cn.qyl.ebuy.service.OrderService;
import cn.qyl.ebuy.utils.RandomOrderCodeUtils;

public class OrderServiceImpl implements OrderService{
	
	OrderDao orderDao = new OrderDaoImpl();
	@Override
	public int getCountByOrder(Order order) {
		
		return orderDao.getCountByOrder(order);
	}
	@Override
	public List<Order> getOrderListByPage(Order order, PageModel pageModel) {
		
		return orderDao.getOrdersByPage(order,pageModel);
	}
	
	//前台页面 保存订单
	/*@Override
	public int addOrder(User user, double totalCount) {
		//准备参数
		Order order = new Order();
		//设置订单编号
		order.setOrderCode(RandomOrderCodeUtils.getOrderCode());
		//设置创建订单的时间
		order.setCreateDate(new Date());
		order.setTotalAmount(totalCount);
		order.setUserId(user.getId());
		return orderDao.saveOrder(order);
	}*/
	
	
	@Override
	public void addOrder(User user, double totalCount, List<Goods> goodsList) {
		
		//准备参数
		Order order = new Order();
		//设置订单编号
		order.setOrderCode(RandomOrderCodeUtils.getOrderCode());
		//设置创建订单的时间
		order.setCreateDate(new Date());
		order.setTotalAmount(totalCount);
		order.setUserId(user.getId());
		orderDao.saveOrder(order,goodsList);
	}

}
