package cn.qyl.ebuy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.qyl.ebuy.dao.BaseDao;
import cn.qyl.ebuy.dao.UserDao;
import cn.qyl.ebuy.dto.User;
import cn.qyl.ebuy.mapper.UserMapper;

public class UserDaoImpl extends BaseDao implements UserDao{

	@Override
	public User getUserByUserNameAndPwd(String username, String password) {
		//获取SqlSession
		SqlSession sqlSession = getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.getUserByUserNameAndPwd(username,password);
		
		//释放资源
		closeSqlSession();
		return user;
	}

	@Override
	public List<User> getUsers(User user) {
		//获取SqlSession
		SqlSession sqlSession = getSqlSession();
		//获取文件对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> users = userMapper.getUsers(user);
		//释放资源
		closeSqlSession();
		return users;
	}

	@Override
	public void addUser(User user) {
		//获取SqlSession
		SqlSession session = getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		userMapper.addUser(user);
		//提交事务
		session.commit();
		//释放资源
		closeSqlSession();
		
	}

	@Override
	public User getUserById(int id) {
		//获取SqlSession
		SqlSession session = getSqlSession();
		//获取Mapper代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = userMapper.getUserById(id);
		session.commit();
		//释放资源
		closeSqlSession();
		return user;
	}

	@Override
	public int updateUser(User user) {
		//获取SqlSession
		SqlSession session = getSqlSession();
		//获取Mapper代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		int count = userMapper.updateUser(user);
		//提交事务
		session.commit();
		//关闭资源
		closeSqlSession();
		return count;
	}
	//删除单个记录
	@Override
	public int delUserById(int id) {
		//获取SqlSession
		SqlSession session = getSqlSession();
		//获取Mapper代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		int count = userMapper.delUserById(id);
		//提交事务
		session.commit();
		closeSqlSession();
		return count;
	}
	
	//批量删除
	@Override
	public int delUserByIds(int[] ids) {
		//获取SqlSession
		SqlSession session = getSqlSession();
		//获取Mapper代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		int count = userMapper.delUserByIds(ids);
		//提交事务
		session.commit();
		//释放资源
		closeSqlSession();
		return count;
	}

	
}
