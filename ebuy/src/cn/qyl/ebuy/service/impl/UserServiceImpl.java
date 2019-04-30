package cn.qyl.ebuy.service.impl;

import java.util.List;

import cn.qyl.ebuy.dao.UserDao;
import cn.qyl.ebuy.dao.impl.UserDaoImpl;
import cn.qyl.ebuy.dto.User;
import cn.qyl.ebuy.service.UserService;

public class UserServiceImpl implements UserService{
	UserDao userDao = new UserDaoImpl();

	@Override
	public User getUserByUserNameAndPwd(String username, String password) {
		User user = userDao.getUserByUserNameAndPwd(username,password);
		return user;
	}

	@Override
	public List<User> getUsers(User user) {
		List<User> users = userDao.getUsers(user);
		return users;
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
		
	}

	@Override
	public User getUserById(int id) {
		
		return userDao.getUserById(id);
	}

	@Override
	public int updateUser(User user) {
		
		return userDao.updateUser(user);
	}
	//删除单个记录
	@Override
	public int delUserById(int id) {
		
		return userDao.delUserById(id);
	}
	
	//批量删除
	@Override
	public int delUserByIds(int[] ids) {
		
		return userDao.delUserByIds(ids);
	}
		
}
