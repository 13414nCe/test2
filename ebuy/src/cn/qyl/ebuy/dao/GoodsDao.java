package cn.qyl.ebuy.dao;

import java.util.List;
import java.util.Map;

import cn.qyl.ebuy.common.PageModel;
import cn.qyl.ebuy.dto.Goods;

public interface GoodsDao {
	//根据商品条件获取总记录数
	int getCountByGoods(Goods goods);
	//分页查询商品列表
	List<Goods> getGoodsListByPage(Goods goods,PageModel pageModel);
	//添加商品
	void aadGoods(Goods goods);
	//根据id获取商品
	Goods getGoodsById(int id);
	//修改商品
	int updateGoods(Goods goods);
	//根据id删除单个商品
	int delGoods(int id);
	//批量删除商品
	int delGoodsByGids(int[] gids);
	//通过Ajax异步获取商品列表
	List<Goods> getGoodsList();
	//根据标题获取商品列表
	List<Goods> getGoodsListByTitle(Goods goods,PageModel pageModel);

}
