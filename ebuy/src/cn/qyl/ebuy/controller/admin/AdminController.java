package cn.qyl.ebuy.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qyl.ebuy.common.PageConstant;
import cn.qyl.ebuy.dto.User;
import cn.qyl.ebuy.service.UserService;
import cn.qyl.ebuy.service.impl.UserServiceImpl;
/**
 *后台控制器
 *处理后台登陆页面，后台主页面，后台欢迎界面 
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	//跳转到后台登录页面
	@RequestMapping("/toLogin")
	public String toLogin(){
		
		return "toLogin";
	}
	@RequestMapping("/adminHome")
	public String adminHome(){
		return "adminHome";
	}
	@RequestMapping("/welcome")
	public String welcome(){
		
		return "welcome";
	}
	
	//后台ajax登录
	@RequestMapping("/userLogin")
	@ResponseBody
	public Map<String,String> userLogin(String userId,String password,
								String vcode, HttpSession session){
		String authCode = (String) session.getAttribute(PageConstant.AUTH_CODE);
		Map<String,String> map = new HashMap<>();
		if(authCode.equals(vcode)){//验证码正确
			
			UserService userService = new UserServiceImpl();
			User user = userService.getUserByUserNameAndPwd(userId,password);
			if(user != null){//用户存在
				if(user.getRole() > 1){//1.普通用户	2.管理员	3.超级管理员
					//把user存到session中
					session.setAttribute(PageConstant.SESSION_USER, user);
					map.put("status", "success");
				}else{
					map.put("status", "fail");
					map.put(PageConstant.TIP, "普通用户不能登录后台");
				}
			}else{//用户不存在
				map.put("status", "fail");
				map.put(PageConstant.TIP, "用户名或密码错误！");
			}
		}else{//验证码不正确
			map.put("status", "fail");
			map.put(PageConstant.TIP, "验证码不正确！");
		}
		
		return map;
	} 
}
