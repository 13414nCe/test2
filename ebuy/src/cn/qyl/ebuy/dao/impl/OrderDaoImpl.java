package cn.qyl.ebuy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.qyl.ebuy.common.PageModel;
import cn.qyl.ebuy.dao.BaseDao;
import cn.qyl.ebuy.dao.OrderDao;
import cn.qyl.ebuy.dto.Goods;
import cn.qyl.ebuy.dto.Order;
import cn.qyl.ebuy.dto.OrderItem;
import cn.qyl.ebuy.mapper.OrderItemMapper;
import cn.qyl.ebuy.mapper.OrderMapper;

public class OrderDaoImpl extends BaseDao implements OrderDao {

	//根据条件获取订单总记录数
	@Override
	public int getCountByOrder(Order order) {
		//获取SqlSession
		SqlSession session = getSqlSession();
		OrderMapper orderMapper = session.getMapper(OrderMapper.class);
		int count = orderMapper.getCountByOrder(order);
		//释放资源
		closeSqlSession();
		return count;
	}

	//根据条件分页展示订单列表
	@Override
	public List<Order> getOrdersByPage(Order order, PageModel pageModel) {
		//获取SqlSession
		SqlSession session = getSqlSession();
		OrderMapper orderMapper = session.getMapper(OrderMapper.class);
		List<Order> orders = orderMapper.getOrdersByPage(order,pageModel);
		
		return orders;
	}

	@Override
	public void saveOrder(Order order, List<Goods> goodsList) {
		//获取SqlSession
		SqlSession session = getSqlSession();
		OrderMapper orderMapper = session.getMapper(OrderMapper.class);
		OrderItemMapper orderItemMapper = session.getMapper(OrderItemMapper.class);
		try{
			//保存订单
			orderMapper.saveOrder(order);
			for(Goods goods : goodsList){
				//保存订单中间表
				OrderItem orderItem = new OrderItem();
				//订单id
				orderItem.setOrder(order);
				//商品id
				orderItem.setGoods(goods);
				//订单总数量
				orderItem.setOrderNum(goods.getBuyNum());
				orderItemMapper.saveOrderItem(orderItem);
			}
			//提交事务
			session.commit();
		}catch(Exception ex){
			//回滚事务
			session.rollback();
			ex.printStackTrace();
		}
		//释放资源
		closeSqlSession();
	}


}
