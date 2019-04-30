package cn.qyl.ebuy.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.qyl.ebuy.common.PageModel;
import cn.qyl.ebuy.dto.Order;
import cn.qyl.ebuy.service.OrderService;
import cn.qyl.ebuy.service.impl.OrderServiceImpl;

@Controller
@RequestMapping("/admin/order")
public class OrderController {
		
	OrderService orderService = new OrderServiceImpl();
	
	@RequestMapping("/getOrders")
	public String getOrders(@RequestParam(name="pageIndex",defaultValue="0") Integer pageIndex,
							Order order,ModelMap map){
		PageModel pageModel = new PageModel();
		//设置当前页
		pageModel.setPageIndex(pageIndex);
		
		//设置 总记录数
		int count = orderService.getCountByOrder(order);
		pageModel.setRecordCount(count);
		
		//获取订单列表
		List<Order> orders = orderService.getOrderListByPage(order,pageModel);
		
		//返回数据
		map.addAttribute("orders", orders);
		map.addAttribute("order", order);
		map.addAttribute("pageModel", pageModel);
		return "order/orderList";
	}

}
