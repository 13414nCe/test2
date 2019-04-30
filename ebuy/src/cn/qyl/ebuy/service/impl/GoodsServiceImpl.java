package cn.qyl.ebuy.service.impl;

import java.util.List;
import java.util.Map;

import cn.qyl.ebuy.common.PageModel;
import cn.qyl.ebuy.dao.GoodsDao;
import cn.qyl.ebuy.dao.impl.GoodsDaoImpl;
import cn.qyl.ebuy.dto.Goods;
import cn.qyl.ebuy.service.GoodsService;

public class GoodsServiceImpl implements GoodsService{
	
	GoodsDao goodsDao = new GoodsDaoImpl();
	//根据商品条件获取总记录数
	@Override
	public int getCountByGoods(Goods goods) {
		
		return goodsDao.getCountByGoods(goods);
	}
	//分页查询商品列表
	@Override
	public List<Goods> getGoodsByPage(Goods goods,PageModel pageModel) {
		List<Goods> goodsList = goodsDao.getGoodsListByPage(goods,pageModel);
		for(Goods g:goodsList){
			String oldName = g.getGoodsType().getName();
			String newName = oldName.replace("-", "");
			g.getGoodsType().setName(newName);
		}
		
		return goodsList;
	}
	//添加商品
	@Override
	public void addGoods(Goods goods) {
		
		goodsDao.aadGoods(goods);
	}
	
	//根据id获取商品
	@Override
	public Goods getGoodsById(int id) {
		
		return goodsDao.getGoodsById(id);
	}
	
	//修改商品
	@Override
	public int updateGoods(Goods goods) {
		
		return goodsDao.updateGoods(goods);
	}
	
	//根据id删除单个商品
	@Override
	public int delGoods(int id) {
		
		return goodsDao.delGoods(id);
	}
	
	//批量删除商品
	@Override
	public int delGoodsByGids(int[] gids) {
		
		return goodsDao.delGoodsByGids(gids);
	}
	//通过Ajax异步获取商品信息列表
	@Override
	public List<Goods> getGoodsList() {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsList();
	}
	
	//根据title查询商品列表
	@Override
	public List<Goods> getGoodsListByTitle(Goods goods,PageModel pageModel) {
		
		return goodsDao.getGoodsListByTitle(goods,pageModel);
	}

}
