package cn.qyl.ebuy.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.qyl.ebuy.dto.OrderItem;
import cn.qyl.ebuy.service.OrderItemService;
import cn.qyl.ebuy.service.impl.OrderItemServiceImpl;


@Controller
@RequestMapping("/admin/orderItem")
public class OrderItemController {

	@RequestMapping("/getOrderItemsByOrderId")
	public String getOrderItemsByOrderId(int oid,ModelMap map){
		System.out.println("=============================");
		OrderItemService orderItemService = new OrderItemServiceImpl();
		List<OrderItem> orderItems = orderItemService.getOrderItemsByOid(oid);
		map.addAttribute("orderItems", orderItems);
		return "order/orderItemList";
	}
}
