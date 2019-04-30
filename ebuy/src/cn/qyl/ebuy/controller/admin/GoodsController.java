package cn.qyl.ebuy.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.qyl.ebuy.common.PageConstant;
import cn.qyl.ebuy.common.PageModel;
import cn.qyl.ebuy.dto.Goods;
import cn.qyl.ebuy.service.GoodsService;
import cn.qyl.ebuy.service.impl.GoodsServiceImpl;
import cn.qyl.ebuy.utils.UpLoadUtils;

@Controller
@RequestMapping("/admin/goods")
public class GoodsController {
	
	GoodsService goodsService = new GoodsServiceImpl();
	@RequestMapping("/goodsList")
	public String getGoodsList(String pageIndex,Goods goods,ModelMap map,HttpServletRequest request){
		String tip = (String) request.getAttribute(PageConstant.TIP);
		PageModel pageModel = new PageModel();
		if(pageIndex!=null && pageIndex!=""){
			request.removeAttribute(PageConstant.TIP);
			pageModel.setPageIndex(Integer.parseInt(pageIndex));
		}else{
			pageModel.setPageIndex(0);
		}
		//获取总记录数
		
		int count = goodsService.getCountByGoods(goods);
		pageModel.setRecordCount(count);
		
		//分页查询商品列表
		List<Goods> goodsList = goodsService.getGoodsByPage(goods,pageModel);
		//把商品列表存到缓存中
		map.addAttribute("goodsList", goodsList);
		map.addAttribute("pageModel", pageModel);
		map.addAttribute("goods", goods);
		return "goods/goodsList";
	}
	
	@RequestMapping("/toAddGoods")
	public String toAddGoods(){
		return "goods/addGoods";
	}
	
	//新增商品
	@RequestMapping("/addGoods")
	public String addGoods(@RequestParam("myFile") MultipartFile file,
				Goods goods,HttpSession session,ModelMap map) throws Exception{
		//文件上传
		String fileName = UpLoadUtils.saveFile(file);
		goods.setImage(fileName);
		//商品对象保存
		goods.setGroundingDate(new Date());
		goods.setCreateDate(new Date());
		goodsService.addGoods(goods);
		map.addAttribute(PageConstant.TIP, "保存成功!");
		return "goods/addGoods";
	}
	
	//调到商品更新页面
	@RequestMapping("/toUpdateGoods")
	public String toUpdateGoods(int id,ModelMap map){
		Goods goods = goodsService.getGoodsById(id);
		map.addAttribute("goods", goods);
		return "goods/updateGoods";
	}
	
	//更新商品
	@RequestMapping("/updateGoods")
	public String updateGoods(Goods goods,ModelMap map){
		Date date = new Date();
		goods.setCreateDate(date);
		goods.setGroundingDate(new Date());
		int count = goodsService.updateGoods(goods);
		if(count>0){
			map.put(PageConstant.TIP, "修改成功！");
		}else{
			map.put(PageConstant.TIP, "修改失败！");
		}
		return "forward:toUpdateGoods";
	}
	
	//删除单个商品
	@RequestMapping("/delGoods")
	public String delGoods(int id,ModelMap map){
		//根据id删除商品
		int count = goodsService.delGoods(id);
		if(count>0){
			map.put(PageConstant.TIP, "删除成功！");
		}else{
			map.put(PageConstant.TIP, "删除失败！");
		}
		
		return "forward:goodsList";
	}
	
	//批量删除
	@RequestMapping("/delGoodsByGids")
	public String delGoodsByGids(int[] gids,ModelMap map){
		
		int count = goodsService.delGoodsByGids(gids);
		if(count>0){
			map.addAttribute(PageConstant.TIP, "成功删除["+count+"]条记录");
		}else{
			map.addAttribute(PageConstant.TIP, "删除失败!");
		}
		return "forward:goodsList";
	}
	
	//异步获取商品列表
	@RequestMapping("/getAjaxGoodsList")
	@ResponseBody
	public List<Goods> getAjaxGoodsList(){
		//获取商品信息列表
		List<Goods> goodsList = goodsService.getGoodsList();
		
		return goodsList;
	}
	
	
}
