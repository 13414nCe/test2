package cn.qyl.ebuy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.qyl.ebuy.common.PageModel;
import cn.qyl.ebuy.dto.Order;

public interface OrderMapper {
	
	//根据条件获取订单总记录数
	int getCountByOrder(Order order);
	//根据条件分页展示订单列表
	List<Order> getOrdersByPage(@Param("order") Order order,@Param("pageModel") PageModel pageModel);
	//保存订单
	int saveOrder(Order order);
	//根据订单id获取订单对象
	Order getOrderByOid(int id);
	
}
