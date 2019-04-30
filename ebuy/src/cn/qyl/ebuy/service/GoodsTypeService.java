package cn.qyl.ebuy.service;

import java.util.List;
import java.util.Map;

import cn.qyl.ebuy.common.PageModel;
import cn.qyl.ebuy.dto.GoodsType;
import cn.qyl.ebuy.dto.GoodsTypes;

public interface GoodsTypeService {
	//获取商品类型列表
	List<GoodsType> getGoodsTypeList(PageModel pageModel,GoodsType goodsType);
	//获取商品总记录数
	int getCount(GoodsType goodsType);
	//添加商品类型
	void addGoodsType(GoodsType goodsType);
	//根据code获取商品类型
	GoodsType getGoodsTypeByCode(String code);
	//更新商品类型
	int updateGoodsType(GoodsType goodsType);
	//异步获取商品类型map
	List<Map<String, String>> getMapGoodsTypes();
	//删除单个商品类型
	int delGoodsType(String code);
	//异步获取导航下拉列表数据
	List<GoodsTypes> getGoodsTypesMenu();

}
