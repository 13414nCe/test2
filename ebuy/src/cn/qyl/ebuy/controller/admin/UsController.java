package cn.qyl.ebuy.controller.admin;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.qyl.ebuy.common.PageConstant;
import cn.qyl.ebuy.dto.User;
import cn.qyl.ebuy.service.UserService;
import cn.qyl.ebuy.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/admin/user")
public class UsController {
	UserService userService = new UserServiceImpl();
	//获取用户列表
	@RequestMapping("/userList")
	public String userList(User user,ModelMap map){
		
		
		List<User> users = userService.getUsers(user);
		//把用户列表存到request域中
		map.addAttribute("users", users);
		//把条件回显到输入框
		map.addAttribute("user",user);
		return "user/userList";
	}
	
	//跳转到新增用户页面
	@RequestMapping("toAddUser")
	public String toAddUser(){
		return "user/addUser";
	}
	
	//保存用户
	@RequestMapping("/addUser")
	public String addUser(User user,ModelMap map,HttpServletRequest request) throws UnsupportedEncodingException{
		
		//设置用户创建时间
		user.setCreateDate(new Date());
		userService.addUser(user);
		map.put(PageConstant.TIP,"保存成功");
		return "user/addUser";
	}
	
	//跳到更新页面
	@RequestMapping("/toUserUpdate")
	public String toUserUpdate(int id,ModelMap map){
		User user = userService.getUserById(id);
		map.addAttribute("user", user);
		return "user/userUpdate";
	}
	
	//更新用户
	@RequestMapping("/updateUser")
	public String updateUser(User user,Map<String,String> map){
		
		//更新用户
		int count = userService.updateUser(user);
		if(count>0){
			map.put(PageConstant.TIP, "更新成功!");
		}else{
			map.put(PageConstant.TIP, "更新失败!");
		}
		return "user/userUpdate";
	}
	
	
	//删除单个用户
	@RequestMapping("/delUser")
	public String delUser(int id,ModelMap map){
		
		//根据id删除用户
		int count = userService.delUserById(id);
		if(count>0){
			map.put(PageConstant.TIP, "删除成功!");
		}else{
			map.put(PageConstant.TIP, "删除失败!");
		}
		return "forward:userList";
	}
	
	@RequestMapping("/delUserByIds")
	public String delUserByIds(int[] ids,ModelMap map){
		
		int count = userService.delUserByIds(ids);
		//判断是否删除成功
		if(count>0){//删除成功
			map.addAttribute(PageConstant.TIP, "成功删除["+count+"]条记录");
		}else{//删除失败
			map.addAttribute(PageConstant.TIP, "删除失败!");
		}
		return "forward:userList";
	}
}
