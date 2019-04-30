package cn.qyl.ebuy.controller.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qyl.ebuy.common.PageConstant;
import cn.qyl.ebuy.dto.Goods;
import cn.qyl.ebuy.service.GoodsService;
import cn.qyl.ebuy.service.impl.GoodsServiceImpl;
/**
 * 购物车
 *
 *
 */
@Controller
@RequestMapping("/customer/shopCar")
public class ShopCarController {
	
	GoodsService goodsService = new GoodsServiceImpl();
	
	@RequestMapping("/addShopCar")
	@ResponseBody
	public Map<String,String> addShopCar(int goodsId,int buyNum,HttpSession session){
		
		Map<String,String> map = new HashMap<>();
		//获取购物车
		Map<Integer,Integer> shopCar = (Map<Integer, Integer>) session.getAttribute(PageConstant.SHOP_CAR);
		if(shopCar==null){//购物车为空，说明第一次添加商品
			shopCar = new LinkedHashMap<>();
		}
		
		if(shopCar.containsKey(goodsId)){//判断买的商品是否已经存在购物车
			//获取购物车中该商品的数量
			int num = shopCar.get(goodsId);
			shopCar.put(goodsId, buyNum+num);
		}else{//该商品在购物车中不存在
			shopCar.put(goodsId, buyNum);
		}
		
		//把存储成功后的购物车map(shopCar)重新存到session中
		session.setAttribute(PageConstant.SHOP_CAR, shopCar);
		map.put("status", "success");
		return map;
	}
	
	@RequestMapping("/myShopCar")
	public String myShopCar(HttpSession session,ModelMap map){
		/*
		 *数组:[1,2,3,4,5]
		 *Json:{name:"张三"}
		 *Map:{key=val,key=val}
		 */
		//获取购物车
		Map<Integer,Integer> shopCar = (Map<Integer, Integer>) session.getAttribute(PageConstant.SHOP_CAR);
		
		List<Goods> goodsList = new ArrayList<>();
		
		if(shopCar != null){
			Set<Entry<Integer, Integer>> cars = shopCar.entrySet();
			for(Map.Entry<Integer, Integer> car:cars){
				//获取商品id
				int goodsId = car.getKey();
				
				Goods goods = goodsService.getGoodsById(goodsId);
				//获取商品数量
				int buyCount = car.getValue();
				goods.setBuyNum(buyCount);
				//把goods商品存到list中
				goodsList.add(goods);
			}
			
		}
		map.addAttribute("goodsList", goodsList);
		return "buycar";
	}
	
	//更新购物车
	@RequestMapping("/updateShopCar")
	@ResponseBody
	public Map<String,String> updateShopCar(HttpSession session,int goodsId,int num){
		
		Map<String,String> map = new HashMap<>();
		Map<Integer,Integer> shopCar = (Map<Integer, Integer>) session.getAttribute(PageConstant.SHOP_CAR);
		
		shopCar.put(goodsId, num);
		map.put("status", "success");
		
		return map;
	}
	//删除购物车商品
	@RequestMapping("/delShopCar")
	public String delShopCar(int goodsId,HttpSession session){
		Map<Integer,Integer> shopCar = (Map<Integer, Integer>) session.getAttribute(PageConstant.SHOP_CAR);
		//根据key清楚对应的键值对
		shopCar.remove(goodsId);
		return "forward:myShopCar";
	}
	
	@RequestMapping("/getAjaxCount")
	@ResponseBody
	public Map<String,String> getAjaxCount(HttpSession session){
		Map<Integer,Integer> shopCar = (Map<Integer, Integer>) session.getAttribute(PageConstant.SHOP_CAR);
		//定义总数量
		int count = 0;
		if(shopCar != null){
			Set<Entry<Integer, Integer>> cars = shopCar.entrySet();
			for(Map.Entry<Integer, Integer> car : cars){
				count +=car.getValue();
			}
		}
		//把总数量存到count中
		Map<String,String> map = new HashMap<>();
		map.put("count", count+"");
		
		return map;
	}
	
}
