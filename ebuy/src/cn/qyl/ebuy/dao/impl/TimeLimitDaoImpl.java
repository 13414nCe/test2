package cn.qyl.ebuy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.qyl.ebuy.dao.BaseDao;
import cn.qyl.ebuy.dao.TimeLimitDao;
import cn.qyl.ebuy.dto.Timlimited;
import cn.qyl.ebuy.mapper.TimeMapper;

public class TimeLimitDaoImpl extends BaseDao implements TimeLimitDao {

	//获取限时抢购列表
	@Override
	public List<Timlimited> getTimeList() {
		//获取SqlSession
		SqlSession session = getSqlSession();
		TimeMapper timeMapper = session.getMapper(TimeMapper.class);
		List<Timlimited> times = timeMapper.getTimeList();
		//释放资源
		closeSqlSession();
		return times;
	}

	//添加限时抢购
	@Override
	public void addTime(Timlimited time) {
		SqlSession session = getSqlSession();
		TimeMapper timeMapper = session.getMapper(TimeMapper.class);
		timeMapper.addTime(time);
		//提交事务
		session.commit();
		//释放资源
		closeSqlSession();
	}

}
