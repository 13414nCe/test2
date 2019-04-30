package cn.qyl.ebuy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.qyl.ebuy.dto.User;

public interface UserMapper {
	//根据用户名、密码，获取User
	User getUserByUserNameAndPwd(@Param("userId") String userId,@Param("passWord") String password);
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
