package cn.qyl.ebuy.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *基础Dao
 *
 * 1.获取连接
 * 2.释放连接
 * 通过ThreadLocal对象管理SqlSession
 */
public class BaseDao {
	private static SqlSessionFactory factory;
	private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
	//静态代码块
	static{
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("数据库连接失败！");
		}
	}
	//获取SqlSession
	public SqlSession getSqlSession(){
		SqlSession sqlSession = threadLocal.get();
		if(sqlSession == null){
			//通过SqlSessionFactory获取session
			sqlSession=factory.openSession();
		}
		//再把sqlSession存储到threadLocal
		threadLocal.set(sqlSession);
		return sqlSession;
	}
	//释放SqlSession
	public void closeSqlSession(){
		SqlSession sqlSession = threadLocal.get();
		if(sqlSession != null){
			//关闭sqlSession
			sqlSession.close();
		}
		//把当前的threadLocal对象清空
		threadLocal.remove();
	}
}
