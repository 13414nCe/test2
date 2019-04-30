package cn.qyl.ebuy.dao;

import java.util.List;

import cn.qyl.ebuy.common.PageModel;
import cn.qyl.ebuy.dto.Goods;
import cn.qyl.ebuy.dto.Order;

public interface OrderDao {
	
	//根据条件获取订单总记录数
	int getCountByOrder(Order order);
	//根据条件分页展示订单列表
	List<Order> getOrdersByPage(Order order, PageModel pageModel);
	//保存订单
	//int saveOrder(Order order);
	void saveOrder(Order order, List<Goods> goodsList);
	

}
