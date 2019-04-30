package cn.mbx.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author mbx
 *
 */
@Controller
public class UserController {

	@RequestMapping("/getJSON")
	@ResponseBody
	public String getJSON(){
		System.out.println("=====ajax请求=====");
		return "success";
	}
	
	
	@RequestMapping("/register")
	public String register(){
		System.out.println("===register===");
		return "index2";
	}
	
}
