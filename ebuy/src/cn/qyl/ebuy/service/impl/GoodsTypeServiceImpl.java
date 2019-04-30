package cn.qyl.ebuy.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.qyl.ebuy.common.PageModel;
import cn.qyl.ebuy.dao.GoodsTypeDao;
import cn.qyl.ebuy.dao.impl.GoodsTypeDaoImpl;
import cn.qyl.ebuy.dto.GoodsType;
import cn.qyl.ebuy.dto.GoodsTypes;
import cn.qyl.ebuy.service.GoodsTypeService;

public class GoodsTypeServiceImpl implements GoodsTypeService{
	
	GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
	@Override
	public List<GoodsType> getGoodsTypeList(PageModel pageModel,GoodsType goodsType) {
		List<GoodsType> goodsTypes = goodsTypeDao.getGoodsTypeList(pageModel,goodsType);
		for(GoodsType g:goodsTypes){
			String oldName = g.getName();
			String newName = oldName.replace("-", "");
			g.setName(newName);
		}
		return goodsTypes;
	}
	
	//获取商品总记录数
	@Override
	public int getCount(GoodsType goodsType) {
		
		return goodsTypeDao.getCount(goodsType);
	}
	//添加商品类型
	@Override
	public void addGoodsType(GoodsType goodsType) {
		
		goodsTypeDao.addGoodsType(goodsType);
	}
	//根据code获取商品类型
	@Override
	public GoodsType getGoodsTypeByCode(String code) {
		
		return goodsTypeDao.getGoodsTypeByCode(code);
	}
	
	//更新商品类型
	@Override
	public int updateGoodsType(GoodsType goodsType) {
		
		return goodsTypeDao.updateGoodsType(goodsType);
	}
	
	//异步获取商品类型map
	@Override
	public List<Map<String, String>> getMapGoodsTypes() {
		
		return goodsTypeDao.getMapGoodsTypes();
	}

	//删除单个商品类型
	@Override
	public int delGoodsType(String code) {
		
		return goodsTypeDao.delGoodsType(code);
	}

	//获取导航下拉列表数据
	@Override
	public List<GoodsTypes> getGoodsTypesMenu() {
		List<GoodsTypes> goodsTypesList = new ArrayList<>();
		//主菜单导航数据
		List<Map<String,String>> maxTypes = goodsTypeDao.getMainMenu();
		for(Map<String,String> maxType:maxTypes){
			GoodsTypes goodsTypes = new GoodsTypes();
			//把主菜单数据存储
			goodsTypes.setMaxType(maxType);
			System.out.println(maxType.get("code")+"----"+maxType.get("name"));
			//把主菜单对应的子菜单存储到minType中
			List<Map<String,String>> minTypes = goodsTypeDao.getSubMenu(maxType.get("code"));
			for(Map<String,String> minType:minTypes){
				String oldName = minType.get("NAME");
				String newName = oldName.replace("-", "");
				minType.put("NAME", newName);
			}
			
			goodsTypes.setMinType(minTypes);
			goodsTypesList.add(goodsTypes);
		}
		return goodsTypesList;
	}
	
	
}
