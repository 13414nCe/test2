package cn.qyl.ebuy.service;

import java.util.List;

import cn.qyl.ebuy.dto.Picturcarousel;

/**
 * 轮播管理业务层
 * @author Administrator
 *
 */
public interface PicService {
	//获取轮播图片列表
	List<Picturcarousel> getPics();
	//根据id删除轮播图
	int delPicById(int pid);
	//新增轮播图片对象
	void addPic(Picturcarousel pic);

}
