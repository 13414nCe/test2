package cn.qyl.ebuy.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cn.qyl.ebuy.common.PageModel;
import cn.qyl.ebuy.dao.BaseDao;
import cn.qyl.ebuy.dao.GoodsDao;
import cn.qyl.ebuy.dto.Goods;
import cn.qyl.ebuy.mapper.GoodsMapper;

public class GoodsDaoImpl extends BaseDao implements GoodsDao{

	@Override
	public int getCountByGoods(Goods goods) {
		//获取SqlSession
		SqlSession session = getSqlSession();
		GoodsMapper goodsMapper = session.getMapper(GoodsMapper.class);
		int count = goodsMapper.getCountByGoods(goods);
		//释放资源
		closeSqlSession();
		return count;
	}
	
	//分页查询商品列表
	@Override
	public List<Goods> getGoodsListByPage(Goods goods,PageModel pageModel) {
		//获取SqlSession
		SqlSession session = getSqlSession();
		GoodsMapper goodsMapper = session.getMapper(GoodsMapper.class);
		List<Goods> goodsList = goodsMapper.getGoodsListByPage(goods,pageModel);
		//释放资源
		closeSqlSession();
		return goodsList;
	}

	//添加商品
	@Override
	public void aadGoods(Goods goods) {
		//获取SqlSession
		SqlSession seesion = getSqlSession();
		GoodsMapper goodsMapper = seesion.getMapper(GoodsMapper.class);
		goodsMapper.addGoods(goods);
		//提交事务
		seesion.commit();
		//释放资源
		closeSqlSession();
	}
	
	//根据id获取商品
	@Override
	public Goods getGoodsById(int id) {
		//获取SqlSession
		SqlSession session = getSqlSession();
		GoodsMapper goodsMapper = session.getMapper(GoodsMapper.class);
		Goods goods = goodsMapper.getGoodsById(id);
		//释放资源
		closeSqlSession();
		return goods;
	}

	//修改商品
	@Override
	public int updateGoods(Goods goods) {
		//获取SqlSession
		SqlSession session = getSqlSession();
		GoodsMapper goodsMapper = session.getMapper(GoodsMapper.class);
		int count = goodsMapper.updateGoods(goods);
		//提交事务
		session.commit();
		//释放资源
		closeSqlSession();
		return count;
	}

	//根据id删除单个商品
	@Override
	public int delGoods(int id) {
		//获取SqlSession
		SqlSession session = getSqlSession();
		GoodsMapper goodsMapper = session.getMapper(GoodsMapper.class);
		int count = goodsMapper.delGoods(id);
		//提交事务
		session.commit();
		//释放资源
		closeSqlSession();
		return count;
	}

	//批量删除商品
	@Override
	public int delGoodsByGids(int[] gids) {
		//获取SqlSession
		SqlSession session = getSqlSession();
		GoodsMapper goodsMapper = session.getMapper(GoodsMapper.class);
		int count = goodsMapper.delGoodsByGids(gids);
		//提交事务
		session.commit();
		//释放资源
		closeSqlSession();
		return count;
	}

	//通过Ajax异步获取商品列表
	@Override
	public List<Goods> getGoodsList() {
		//获取SqlSession
		SqlSession session = getSqlSession();
		GoodsMapper goodsMapper = session.getMapper(GoodsMapper.class);
		List<Goods> goodsList = goodsMapper.getGoodsList();
		//释放资源
		closeSqlSession();
		return goodsList;
	}

	//根据标题获取商品列表
	@Override
	public List<Goods> getGoodsListByTitle(Goods goods,PageModel pageModel) {
		SqlSession session = getSqlSession();
		GoodsMapper goodsMapper = session.getMapper(GoodsMapper.class);
		List<Goods> goodsList = goodsMapper.getGoodsListByTitle(goods,pageModel);
		closeSqlSession();
		return goodsList;
	}
	
}
