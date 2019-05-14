package com.edu.mall.product;

import com.edu.mall.product.bean.Product;
import com.edu.mall.product.mapper.ProductMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MallProductApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MallProductApplication.class, args);
//		context.close();
	}

}
