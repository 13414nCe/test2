package cn.qyl.ebuy.controller.customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qyl.ebuy.common.PageConstant;
import cn.qyl.ebuy.dto.GoodsTypes;
import cn.qyl.ebuy.dto.Picturcarousel;
import cn.qyl.ebuy.dto.Timlimited;
import cn.qyl.ebuy.dto.User;
import cn.qyl.ebuy.service.GoodsTypeService;
import cn.qyl.ebuy.service.PicService;
import cn.qyl.ebuy.service.TimeLimitService;
import cn.qyl.ebuy.service.UserService;
import cn.qyl.ebuy.service.impl.GoodsTypeServiceImpl;
import cn.qyl.ebuy.service.impl.PicServiceImpl;
import cn.qyl.ebuy.service.impl.TimeLimitServiceImpl;
import cn.qyl.ebuy.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/customer")
public class UserController {
	//轮播图模块的业务层
	PicService picService = new PicServiceImpl();
	//限时抢购模块的业务层
	TimeLimitService timeService = new TimeLimitServiceImpl();
	
	GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
	@RequestMapping("/home")
	public String home(ModelMap map){
		//获取banner列表
		List<Picturcarousel> pics = picService.getPics();
		//获取限时抢购列表
		List<Timlimited> times = timeService.getTimeList();
		map.addAttribute("pics", pics);
		map.addAttribute("times", times);
		return "home";
	}
	@RequestMapping("/toLogin")
	public String toLogin(){
		
		return "login";
	}
	@RequestMapping("/userLogin")
	@ResponseBody
	public Map<String,String> login(String username,String pwd,
			String code,String rember,HttpSession session,HttpServletResponse response){
		Map<String,String> map = new HashMap<>();
		UserService userService = new UserServiceImpl();
		//获取验证码
		String vcode = (String) session.getAttribute(PageConstant.AUTH_CODE);
		
		if(vcode.equals(code)){//如果验证码相等
			//调用Service层获取User对象
			User user = userService.getUserByUserNameAndPwd(username, pwd);
			if(user!=null){
				//把user对象存入到session缓存中
				session.setAttribute(PageConstant.SESSION_USER, user);
				//判断是否需要记住密码
				if("1".equals(rember)){//记住密码
					Cookie cookie = new Cookie("userId",user.getName()+"-"+user.getPassWord());
					//setMaxAge():设置cookie的存活时间，单位:秒
					cookie.setMaxAge(60*60*24);
					//设置cookie的存储路径
					cookie.setPath("/");
					response.addCookie(cookie);
				}
				map.put("status", "success");
				return map;
			}else{
				//设置status状态
				map.put("status", "fail");
				map.put(PageConstant.TIP, "用户名或密码不正确!");
				return map;
			}
		}else{ 
			map.put("status", "fail");
			map.put(PageConstant.TIP, "验证码不正确!");
			return map;
		}
	
	}
	/**
	 * Map<String,String>	maxType
	 * List<Map<String,String>>	 minType
	 * @return
	 */
	@RequestMapping("/getAjaxMenu")
	@ResponseBody
	public List<GoodsTypes> getAjaxMenu(){
		//获取导航下拉列表数据
		List<GoodsTypes> goodsTypesList = goodsTypeService.getGoodsTypesMenu();
		return goodsTypesList;
	}
	
	@RequestMapping("/loginOut")
	public String loginOut(HttpSession session){
		//注销用户
		session.removeAttribute(PageConstant.SESSION_USER);
		
		return "forward:home";
	}
}
