package cn.qyl.ebuy.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.qyl.ebuy.common.PageModel;
import cn.qyl.ebuy.dto.GoodsType;

public interface GoodsTypeMapper {
	//获取商品类型列表
	List<GoodsType> getGoodsTypeList(@Param("pageModel") PageModel pageModel,@Param("goodsType") GoodsType goodsType);
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
	//获取主菜单列表数据
	List<Map<String, String>> getMainMenu();
	//获取每个主菜单所对应的子菜单
	List<Map<String, String>> getSubMenu(String code);
	
	
	
	
}
