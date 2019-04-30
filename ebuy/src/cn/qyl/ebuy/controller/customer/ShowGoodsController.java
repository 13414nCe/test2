package cn.qyl.ebuy.controller.customer;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.qyl.ebuy.common.PageModel;
import cn.qyl.ebuy.dto.Goods;
import cn.qyl.ebuy.service.GoodsService;
import cn.qyl.ebuy.service.impl.GoodsServiceImpl;

@Controller
@RequestMapping("/customer/goods")
public class ShowGoodsController {
	
	GoodsService goodsService = new GoodsServiceImpl();
	//根据条件查询商品列表
	@RequestMapping("/showGoodsList")
	public String showGoodsList(String pageIndex,Goods goods,ModelMap map){
		PageModel pageModel = new PageModel();
		//设置分页当前页
		if(pageIndex != null && pageIndex !=""){
			pageModel.setPageIndex(Integer.parseInt(pageIndex));
		}else{
			pageModel.setPageIndex(0);
		}
		//设置总记录数
		
		int count = goodsService.getCountByGoods(goods);
		pageModel.setRecordCount(count);
		
		List<Goods> goodsList = goodsService.getGoodsListByTitle(goods,pageModel);
		map.addAttribute("goodsList", goodsList);
		//回显用户查询条件
		map.put("goods", goods);
		map.addAttribute("pageModel", pageModel);
		return "goodsList";
	}
	
	//根据条件查询商品详情
	@RequestMapping("/getGoodsDetails")
	public String getGoodsDetails(int id,ModelMap map){
		Goods goods = goodsService.getGoodsById(id);
		map.addAttribute("goods", goods);
		return "details";
	}
	
}
