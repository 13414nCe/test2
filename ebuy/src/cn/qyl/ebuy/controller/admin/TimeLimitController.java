package cn.qyl.ebuy.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.qyl.ebuy.common.PageConstant;
import cn.qyl.ebuy.dto.Timlimited;
import cn.qyl.ebuy.service.TimeLimitService;
import cn.qyl.ebuy.service.impl.TimeLimitServiceImpl;

@Controller
@RequestMapping("/admin/time")
public class TimeLimitController {

	TimeLimitService timeService = new TimeLimitServiceImpl();
	//获取限时抢购列表
	@RequestMapping("/getTimeList")
	public String getTimeList(ModelMap map){
		
		List<Timlimited> times = timeService.getTimeList();
		map.addAttribute("times", times);
		return "time/timeLimitList";
	}
	
	//跳到添加限时抢购页面
	@RequestMapping("/toAddTime")
	public String toAddTime(){
		return "time/addTime";
	}
	
	//添加限时抢购商品
	@RequestMapping("/addTime")
	public String addTime(Timlimited time,ModelMap map){
		timeService.addTime(time);
		
		map.addAttribute(PageConstant.TIP, "保存成功!");
		return "time/addTime";
	}
	
}
