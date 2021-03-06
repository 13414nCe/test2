package com.mbx.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mbx.crud.bean.Employee;
import com.mbx.crud.bean.Msg;
import com.mbx.crud.service.EmployeeService;
/**
 * 处理员工CRUD请求
 * @author mbx
 *
 */
@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	/**
	 * 检查用户名是否可用
	 * @param empName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkuser")
	public Msg checkuser(@RequestParam("empName") String empName){
		boolean b = employeeService.checkUser(empName);
		if(b){
			return Msg.success();
		}else{
			return Msg.fail();
		}
	}
	
	
	
	/**
	 * 员工保存
	 * @return
	 */
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveEmp(Employee employee){
		employeeService.saveEmp(employee);
		return Msg.success();
	}
	
	/**
	 * 导入jackson包
	 * @param pn
	 * @return
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJson(@RequestParam(value = "pn",defaultValue="1") Integer pn){
		//引入PageHelper插件
		//在查询之前只需要调用，传入页码，以及每页的大小
		PageHelper.startPage(pn, 5);
		//startPage后面紧跟的这个查询就是一个分页查询
		List<Employee> emps = employeeService.getAll();
		//使用PageInfo包装查询后的结果，只需要将PageInfo交给页面就行了。
		//封装了分页的详细信息，包括有我们查询出来的数据，传入连续显示的页数
		PageInfo page = new PageInfo(emps,5);
		return Msg.success().add("pageInfo", page);
		
	}
	/**
	 * 查询员工数据（分页查询）
	 * @return
	 */
	//@RequestMapping("/emps")
	public String getEmps(@RequestParam(value = "pn",defaultValue="1") Integer pn,
			Model model){
		
		//引入PageHelper插件
		//在查询之前只需要调用，传入页码，以及每页的大小
		PageHelper.startPage(pn, 5);
		//startPage后面紧跟的这个查询就是一个分页查询
		List<Employee> emps = employeeService.getAll();
		//使用PageInfo包装查询后的结果，只需要将PageInfo交给页面就行了。
		//封装了分页的详细信息，包括有我们查询出来的数据，传入连续显示的页数
		PageInfo page = new PageInfo(emps,5);
		model.addAttribute("pageInfo",page);
		return "list";
	}
}
