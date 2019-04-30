package cn.qyl.ebuy.service.impl;

import java.util.List;

import cn.qyl.ebuy.dao.PicDao;
import cn.qyl.ebuy.dao.impl.PicDaoImpl;
import cn.qyl.ebuy.dto.Picturcarousel;
import cn.qyl.ebuy.service.PicService;

public class PicServiceImpl implements PicService{

	PicDao picDao = new PicDaoImpl();
	//获取轮播图片列表
	@Override
	public List<Picturcarousel> getPics() {
		
		return picDao.getPics();
	}
	
	//根据ID删除轮播图
	@Override
	public int delPicById(int pid) {
		
		return picDao.delPicById(pid);
	}

	//新增轮播图片
	@Override
	public void addPic(Picturcarousel pic) {
		
		picDao.addPic(pic);
	}
	
}
