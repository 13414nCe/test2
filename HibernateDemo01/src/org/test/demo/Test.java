package org.test.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.test.dto.User;


public class Test {
	public static void main(String[] args) {
		//获取configuration对象
		Configuration configuration =new Configuration();
		configuration.configure();//默认加载src目录下的hibernate.cfg.xml文件
		//根据配置构建SessionFactory对象
		SessionFactory sf = configuration.buildSessionFactory();
		System.out.println("=======");
		//获取回话对象(相当于与mysql的一次交互)
		Session session = sf.openSession();
		//开启事务
		Transaction ts = session.beginTransaction();
		//准备数据
		User user = new User(1,"admin","234566",new Date());
		//保存用户
		session.save(user);
		//提交事务
		ts.commit();
		System.out.println("====执行结束====");
		session.close();
		sf.close();
	}
}
