package cn.itcast.property;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBook {
	
	public static void main(String[] args) {
		//加载Spring配置文件，把配置文件中的对象进行创建
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		Book book = (Book) ctx.getBean("book");
		book.testBook();
	}
	
	
}
