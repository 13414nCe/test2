package cn.qyl.ebuy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.qyl.ebuy.common.PageModel;
import cn.qyl.ebuy.dto.Goods;

public interface GoodsMapper {
	//根据商品条件获取总记录数
	int getCountByGoods(@Param("goods") Goods goods);
	//分页查询商品列表
	List<Goods> getGoodsListByPage(@Param("goods") Goods goods,@Param("pageModel")PageModel pageModel);
	//添加商品
	void addGoods(Goods goods);
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
	List<Goods> getGoodsListByTitle(@Param("goods") Goods goods,@Param("pageModel") PageModel pageModel);
	
	
}
