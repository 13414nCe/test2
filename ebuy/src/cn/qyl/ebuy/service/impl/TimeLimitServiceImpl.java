package cn.qyl.ebuy.service.impl;

import java.util.List;

import cn.qyl.ebuy.dao.TimeLimitDao;
import cn.qyl.ebuy.dao.impl.TimeLimitDaoImpl;
import cn.qyl.ebuy.dto.Timlimited;
import cn.qyl.ebuy.service.TimeLimitService;

public class TimeLimitServiceImpl implements TimeLimitService{

	TimeLimitDao timeDao = new TimeLimitDaoImpl();
	//获取限时抢购列表
	@Override
	public List<Timlimited> getTimeList() {
		
		return timeDao.getTimeList();
	}
	
	//添加限时抢购
	@Override
	public void addTime(Timlimited time) {
		timeDao.addTime(time);
	}

}
