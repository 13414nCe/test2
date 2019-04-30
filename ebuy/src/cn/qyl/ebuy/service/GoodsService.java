package cn.qyl.ebuy.service;

import java.util.List;
import java.util.Map;

import cn.qyl.ebuy.common.PageModel;
import cn.qyl.ebuy.dto.Goods;

public interface GoodsService {
	//获取总记录数
	int getCountByGoods(Goods goods);
	//分页查询商品列表
	List<Goods> getGoodsByPage(Goods goods,PageModel pageModel);
	//添加商品
	void addGoods(Goods goods);
	//根据id获取商品
	Goods getGoodsById(int id);
	//修改商品
	int updateGoods(Goods goods);
	//根据id删除商品
	int delGoods(int id);
	//批量删除
	int delGoodsByGids(int[] gids);
	//通过Ajax异步获取商品信息列表
	List<Goods> getGoodsList();
	//根据title查询商品列表
	List<Goods> getGoodsListByTitle(Goods goods,PageModel pageModel);

	
}
