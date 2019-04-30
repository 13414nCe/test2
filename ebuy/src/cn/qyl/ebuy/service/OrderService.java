package cn.qyl.ebuy.service;

import java.util.List;

import cn.qyl.ebuy.common.PageModel;
import cn.qyl.ebuy.dto.Goods;
import cn.qyl.ebuy.dto.Order;
import cn.qyl.ebuy.dto.User;

public interface OrderService {

	//根据条件获取订单总记录数
	int getCountByOrder(Order order);
	//根据条件分页展示订单列表
	List<Order> getOrderListByPage(Order order, PageModel pageModel);
	//保存订单
	//int addOrder(User user, double totalCount);
	void addOrder(User user, double totalCount, List<Goods> goodsList);

}
