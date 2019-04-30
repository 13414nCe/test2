package cn.qyl.ebuy.controller.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.qyl.ebuy.common.PageConstant;
import cn.qyl.ebuy.dto.Picturcarousel;
import cn.qyl.ebuy.service.PicService;
import cn.qyl.ebuy.service.impl.PicServiceImpl;
import cn.qyl.ebuy.utils.UpLoadUtils;

@Controller
@RequestMapping("/admin/pic")
public class PicController {

	PicService picService = new PicServiceImpl();
	
	@RequestMapping("/getPics")
	public String getPics(ModelMap map){
		
		//通过业务层获取图片轮播列表
		List<Picturcarousel> pics = picService.getPics();
		//把list数据存到request域中
		map.addAttribute("pics", pics);
		return "pic/picList";
	}
	
	//跳到添加图片页面
	@RequestMapping("/toAddPic")
	public String toAddPic(){
		
		return "pic/addPic";
	}
	
	//新增轮播图
	@RequestMapping("/addPic")
	public String addPic(Picturcarousel pic,ModelMap map){
		
		picService.addPic(pic);
		map.addAttribute(PageConstant.TIP, "新增成功!");
		return "pic/addPic";
	}
	
	//删除轮播图
	@RequestMapping("/delPicById")
	public String delPicById(int pid,ModelMap map){
		int count = picService.delPicById(pid);
		if(count>0){
			map.addAttribute(PageConstant.TIP, "删除成功！");
		}else{
			map.addAttribute(PageConstant.TIP, "删除失败！");
		}
		
		return "forward:getPics";
	}
	
	
	
	
	//异步上传banner图
	@RequestMapping("/uploadImgAjax")
	@ResponseBody
	public Map<String,String> uploadImgAjax(@RequestParam("myFile")MultipartFile file){
		
		Map<String,String> map = new HashMap<>();
		//保存文件
		try{
			String fileName = UpLoadUtils.saveFile(file);
			map.put("status", "success");
			map.put("fileName", fileName);
		}catch(Exception ex){
			ex.printStackTrace();
			map.put("status", "fail");
		}
		return map;
	}
	
	
}
