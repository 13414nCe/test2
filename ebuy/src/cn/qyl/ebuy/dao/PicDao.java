package cn.qyl.ebuy.dao;

import java.util.List;

import cn.qyl.ebuy.dto.Picturcarousel;

public interface PicDao {
	

	//获取图片轮播列表
	List<Picturcarousel> getPics();
	//根据id删除轮播图
	int delPicById(int pid);
	//新增轮播图片
	void addPic(Picturcarousel pic);

}
