package cn.qyl.ebuy.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qyl.ebuy.common.PageConstant;
import cn.qyl.ebuy.common.PageModel;
import cn.qyl.ebuy.dto.GoodsType;
import cn.qyl.ebuy.service.GoodsService;
import cn.qyl.ebuy.service.GoodsTypeService;
import cn.qyl.ebuy.service.impl.GoodsTypeServiceImpl;

@Controller
@RequestMapping("/admin/goodsType")
public class GoodsTypeController {
	
	GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
	
	@RequestMapping("/goodsTypeList")
	public String goodsTypeList(String pageIndex,String pageSize,GoodsType goodsType,ModelMap map,HttpServletRequest request){
		String tip = (String) request.getAttribute(PageConstant.TIP);
		
		//创建分页模型
		PageModel pageModel = new PageModel();
		if("".equals(pageIndex) || pageIndex == null){
			pageModel.setPageIndex(0);
		}else{
			request.removeAttribute(PageConstant.TIP);
			pageModel.setPageIndex(Integer.parseInt(pageIndex));
		}
		if(pageSize != null && pageSize!=""){
			pageModel.setPageSize(Integer.parseInt(pageSize));
		}
		
		
		//获取总记录数
		int recordCount = goodsTypeService.getCount(goodsType);
		pageModel.setRecordCount(recordCount);
		//调用业务层的方法获取商品类型列表
		List<GoodsType> goodsTypes = goodsTypeService.getGoodsTypeList(pageModel,goodsType);
		//把查询出来的数据存储到缓存中
		map.addAttribute("goodsTypes", goodsTypes);
		//把分页模型存到缓存中
		map.addAttribute("pageModel", pageModel);
		map.addAttribute("goodsType", goodsType);
		return "goodsType/goodsTypeList";
	}
	
	//跳到添加商品类型页
	@RequestMapping("/toGoodsType")
	public String toGoodsType(){
		
		return "goodsType/addGoodsType";
	}
	
	//添加商品类型
	@RequestMapping("/addGoodsType")
	public String addGoodsType(GoodsType goodsType,ModelMap map){
		
		goodsTypeService.addGoodsType(goodsType);
		//把数据存到缓存中
		map.put(PageConstant.TIP, "保存成功");
		
		return "goodsType/addGoodsType";
	}
	
	//跳到更新商品类型页面
	@RequestMapping("/toUpdateGoodsType")
	public String toUpdateGoodsType(String code,ModelMap map){
		
		GoodsType goodsType = goodsTypeService.getGoodsTypeByCode(code);
		map.addAttribute("goodsType", goodsType);
		return "goodsType/updateGoodsType";
	}
	
	//更新商品类型
	@RequestMapping("/updateGoodsType")
	public String updateGoodsType(GoodsType goodsType,ModelMap map){
		
		int count = goodsTypeService.updateGoodsType(goodsType);
		if(count>0){
			map.put(PageConstant.TIP, "更新成功!");
		}else{
			map.put(PageConstant.TIP, "更新失败!");
		}
		return "forward:toUpdateGoodsType";
	}
	
	//异步获取商品类型
	@RequestMapping("getAjaxGoodsTypes")
	@ResponseBody
	public List<Map<String,String>> getAjaxGoodsTypes(){
		
		List<Map<String,String>> goodsTypes = goodsTypeService.getMapGoodsTypes();
		
		return goodsTypes;
	}
	
	//删除单个商品类型
	@RequestMapping("/delGoodsType")
	public String delGoodsType(String typeCode,ModelMap map,HttpServletRequest request){
		
		int count = goodsTypeService.delGoodsType(typeCode);
		if(count>0){
			map.put(PageConstant.TIP,"删除成功!");
		}else{
			map.put(PageConstant.TIP, "删除失败!");
		}
		/*//清除参数
		request.removeAttribute("code");*/
		return "forward:goodsTypeList";
	}
	
	
}
