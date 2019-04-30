package cn.qyl.ebuy.service;

import java.util.List;

import cn.qyl.ebuy.dto.User;

public interface UserService {
	//用户登录
	User getUserByUserNameAndPwd(String username, String password);
	//根据条件获取用户列表
	List<User> getUsers(User user);
	//新增用户
	void addUser(User user);
	//根据id获取User对象
	User getUserById(int id);
	//更新用户
	int updateUser(User user);
	//根据id删除用户
	int delUserById(int id);
	//批量删除
	int delUserByIds(int[] ids);

}
