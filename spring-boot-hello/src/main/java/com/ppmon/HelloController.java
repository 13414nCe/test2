package com.ppmon;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController:相当于@Controller和@ResponseBody
 * @author mbx
 *
 */
@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String hello(){
		
		return "hello";
	}
	
	@RequestMapping("/getDemo")
	public Demo getDemo(){
		Demo demo = new Demo();
		demo.setId(1);
		demo.setName("李四");
		demo.setCreateTime(new Date());
		return demo;
	}
}
