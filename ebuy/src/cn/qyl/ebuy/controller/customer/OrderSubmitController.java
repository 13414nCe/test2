package cn.qyl.ebuy.controller.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.qyl.ebuy.common.PageConstant;
import cn.qyl.ebuy.dto.Goods;
import cn.qyl.ebuy.dto.OrderItem;
import cn.qyl.ebuy.dto.User;
import cn.qyl.ebuy.service.GoodsService;
import cn.qyl.ebuy.service.OrderItemService;
import cn.qyl.ebuy.service.OrderService;
import cn.qyl.ebuy.service.impl.GoodsServiceImpl;
import cn.qyl.ebuy.service.impl.OrderItemServiceImpl;
import cn.qyl.ebuy.service.impl.OrderServiceImpl;

@Controller
@RequestMapping("/customer/order")
public class OrderSubmitController {

	GoodsService goodsService = new GoodsServiceImpl();
	OrderService orderService = new OrderServiceImpl();
	OrderItemService orderItemService = new OrderItemServiceImpl();
	//提交订单
	@RequestMapping("/toSubmitOrder")
	public String toSubmitOrder(int[] ids,ModelMap map,HttpSession session){
		
		Map<Integer,Integer> shopCar = (Map<Integer, Integer>) session.getAttribute(PageConstant.SHOP_CAR);
		List<Goods> goodsList = new ArrayList<>();
		//统计总价格
		double totalCount = 0.00;
		for(int id:ids){
			System.out.println(id);
			//根据key获取value值
			int buyNum = shopCar.get(id);
			//根据key获取商品对象
			Goods goods = goodsService.getGoodsById(id);
			//设置商品数量
			goods.setBuyNum(buyNum);
			//获取总价格
			totalCount += goods.getFavorablePrice() * goods.getBuyNum();
			goodsList.add(goods);
		}
		
		map.put("totalCount", totalCount);
		map.put("goodsList", goodsList);
		
		return "orderSubmit";
	}
	
	//保存订单
	@RequestMapping("/saveOrder")
	public String saveOrder(int[] ids,HttpSession session){
		
		
		//获取购物车
		Map<Integer,Integer> shopCar = (Map<Integer, Integer>) session.getAttribute(PageConstant.SHOP_CAR);
		
		double totalCount = 0.00;
		List<Goods> goodsList = new ArrayList<>();
		for(int id : ids){
			int buyNum = shopCar.get(id);
			Goods goods = goodsService.getGoodsById(id);
			goods.setBuyNum(buyNum);
			//计算总金额
			totalCount += goods.getFavorablePrice() * goods.getBuyNum();
			goodsList.add(goods);
		}
		
		/*订单保存*/
		//获取用户
		User user = (User) session.getAttribute(PageConstant.SESSION_USER);
		orderService.addOrder(user,totalCount,goodsList);
		
		//保存订单中间表
		/*orderItemService.addOrderItem(orderId,goodsList);*/
		//注销购物车
		session.removeAttribute(PageConstant.SHOP_CAR);
		
		return "forward:getMyOrders";
	}
	
	//查询我的订单
	@RequestMapping("/getMyOrders")
	public String getMyOrders(HttpSession session,ModelMap map){
		OrderItemService orderItemService  = new OrderItemServiceImpl();
		//获取Session
		User user = (User) session.getAttribute(PageConstant.SESSION_USER);
		List<OrderItem>  orderItems = orderItemService.getOrderItemsByUserId(user);
		map.addAttribute("orderItems", orderItems);
		return "myOrder";
	}
	
	
	
}
