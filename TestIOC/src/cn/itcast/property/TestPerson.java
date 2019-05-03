package cn.itcast.property;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPerson {

	public static void main(String[] args) {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person = (Person) ctx.getBean("person");
		person.testPerson();
	}
}
