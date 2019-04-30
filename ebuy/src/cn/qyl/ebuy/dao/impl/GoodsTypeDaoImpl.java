package cn.qyl.ebuy.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cn.qyl.ebuy.common.PageModel;
import cn.qyl.ebuy.dao.BaseDao;
import cn.qyl.ebuy.dao.GoodsTypeDao;
import cn.qyl.ebuy.dto.GoodsType;
import cn.qyl.ebuy.dto.GoodsTypes;
import cn.qyl.ebuy.mapper.GoodsTypeMapper;

public class GoodsTypeDaoImpl extends BaseDao implements GoodsTypeDao{

	@Override
	public List<GoodsType> getGoodsTypeList(PageModel pageModel,GoodsType goodsType) {
		//获取SqlSession
		SqlSession session = getSqlSession();
		GoodsTypeMapper goodsTypeMapper = session.getMapper(GoodsTypeMapper.class);
		List<GoodsType> goodsTypes = goodsTypeMapper.getGoodsTypeList(pageModel,goodsType);
		//释放资源
		closeSqlSession();
		return goodsTypes;
	}

	//获取商品总记录数
	@Override
	public int getCount(GoodsType goodsType) {
		//获取SqlSession
		SqlSession session = getSqlSession();
		GoodsTypeMapper goodsTypeMapper = session.getMapper(GoodsTypeMapper.class);
		int count = goodsTypeMapper.getCount(goodsType);
		//释放资源
		closeSqlSession();
		return count;
	}
	
	//添加商品类型
	@Override
	public void addGoodsType(GoodsType goodsType) {
		//获取Sqlsession
		SqlSession session = getSqlSession();
		GoodsTypeMapper goodsTypeMapper = session.getMapper(GoodsTypeMapper.class);
		goodsTypeMapper.addGoodsType(goodsType);
		//提交事务
		session.commit();
		//释放资源
		closeSqlSession();
		
	}
	//根据code获取商品类型
	@Override
	public GoodsType getGoodsTypeByCode(String code) {
		//获取SqlSession
		SqlSession session = getSqlSession();
		GoodsTypeMapper goodsTypeMapper = session.getMapper(GoodsTypeMapper.class);
		GoodsType goodsType = goodsTypeMapper.getGoodsTypeByCode(code);
		
		//释放资源
		closeSqlSession();
		return goodsType;
	}
	
	//更新商品类型
	@Override
	public int updateGoodsType(GoodsType goodsType) {
		//获取SqlSession
		SqlSession session = getSqlSession();
		GoodsTypeMapper goodsTypeMapper = session.getMapper(GoodsTypeMapper.class);
		int count = goodsTypeMapper.updateGoodsType(goodsType);
		//提交事务
		session.commit();
		//释放资源
		closeSqlSession();
		
		return count;
	}
	
	//异步获取商品类型map
	@Override
	public List<Map<String, String>> getMapGoodsTypes() {
		//获取SqlSession
		SqlSession session = getSqlSession();
		GoodsTypeMapper goodsTypeMapper = session.getMapper(GoodsTypeMapper.class);
		List<Map<String,String>> goodsTypes = goodsTypeMapper.getMapGoodsTypes();
		//释放资源
		closeSqlSession();
		return goodsTypes;
	}
	
	//删除单个商品类型
	@Override
	public int delGoodsType(String code) {
		//获取SqlSession
		SqlSession session = getSqlSession();
		GoodsTypeMapper goodsTypeMapper = session.getMapper(GoodsTypeMapper.class);
		int count = goodsTypeMapper.delGoodsType(code);
		//提交事务
		session.commit();
		//释放资源
		closeSqlSession();
		return count;
	}
	
	//获取主菜单列表数据
	@Override
	public List<Map<String, String>> getMainMenu() {
		SqlSession session = getSqlSession();
		GoodsTypeMapper goodsTypeMapper = session.getMapper(GoodsTypeMapper.class);
		List<Map<String,String>> maxTypes = goodsTypeMapper.getMainMenu();
		closeSqlSession();
		return maxTypes;
	}

	//获取每个主菜单所对应的子菜单
	@Override
	public List<Map<String, String>> getSubMenu(String code) {
		SqlSession session = getSqlSession();
		GoodsTypeMapper goodsTypeMapper = session.getMapper(GoodsTypeMapper.class);
		List<Map<String,String>> minTypes = goodsTypeMapper.getSubMenu(code);
		closeSqlSession();
		return minTypes;
	}


	
	
}
