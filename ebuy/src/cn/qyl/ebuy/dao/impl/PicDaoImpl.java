package cn.qyl.ebuy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.qyl.ebuy.dao.BaseDao;
import cn.qyl.ebuy.dao.PicDao;
import cn.qyl.ebuy.dto.Picturcarousel;
import cn.qyl.ebuy.mapper.PicMapper;

public class PicDaoImpl extends BaseDao implements PicDao{

	//获取轮播图片列表
	@Override
	public List<Picturcarousel> getPics() {
		//获取SqlSession
		SqlSession session = getSqlSession();
		PicMapper picMapper = session.getMapper(PicMapper.class);
		List<Picturcarousel> pics = picMapper.getPics();
		//释放资源
		closeSqlSession();
		return pics;
	}

	//根据id删除轮播图
	@Override
	public int delPicById(int pid) {
		//获取SqlSession
		SqlSession session = getSqlSession();
		PicMapper picMapper = session.getMapper(PicMapper.class);
		int count = picMapper.delPicById(pid);
		//提交事务
		session.commit();
		//释放资源
		closeSqlSession();
		return count;
	}

	//新增轮播图片
	@Override
	public void addPic(Picturcarousel pic) {
		//获取SqlSession
		SqlSession session = getSqlSession();
		PicMapper picMapper = session.getMapper(PicMapper.class);
		picMapper.addPic(pic);
		//提交事务
		session.commit();
		//释放资源
		closeSqlSession();
		
	}

}
