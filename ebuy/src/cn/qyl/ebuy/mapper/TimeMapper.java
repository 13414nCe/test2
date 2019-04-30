package cn.qyl.ebuy.mapper;

import java.util.List;

import cn.qyl.ebuy.dto.Timlimited;

public interface TimeMapper {

	//获取限时抢购列表
	List<Timlimited> getTimeList();
	//添加限时抢购
	void addTime(Timlimited time);

}
