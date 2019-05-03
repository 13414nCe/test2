package cn.qyl.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadFile {

	//文件上传
	@RequestMapping("/upload")
	public String test(MultipartFile myFile,HttpServletRequest request,
			           ModelMap map) throws Exception{
		//获取服务器发布路径
		String serverPath = request.getServletContext().getRealPath("/upload");
		System.out.println("======="+serverPath);
		//获取上传文件名
		String fileName = myFile.getOriginalFilename();
		/**
		 * serverPath:父路径
		 * fileName:子路径
		 */
		File file = new File(serverPath+File.separator+fileName);
		//判断该文件是否存在
		if(!file.exists()){
			file.mkdirs();
		}
		//文件上传
		myFile.transferTo(file);
		//把上传后的图片名传到页面
		/*map.addAttribute("imgUrl", serverPath+File.separator+fileName);*/
		map.addAttribute("imgName", fileName);
		return "success";
	}
	//多文件上传
	@RequestMapping("/uploadManyFile")
	public String uploadManyFile(MultipartFile[] files,HttpSession session,ModelMap map) throws Exception{
		
		//获取服务器发布路径
		String serverPath = session.getServletContext().getRealPath("/upload");
		List<String> list = new ArrayList<>();
		for(MultipartFile file :files){
			//获取文件名
			String fileName = file.getOriginalFilename();
			String[] nameArr = fileName.split(".");
			UUID name = UUID.randomUUID();
			String finalName = name+nameArr[0];
			File targetFile = new File(serverPath+File.separator+finalName);
			//文件转储
			file.transferTo(targetFile);
			
			list.add(finalName);
		}
		//存储到request域中
		map.addAttribute("imgs", list);
		return "success2";
	}
	
	//文件下载
	@RequestMapping("/downloadFile")
	public void downloadFile(String fileName,HttpServletRequest request,	
			                HttpServletResponse response) throws Exception{
		
		/**
		 * 下载文件中，文件名可能存在中文。使用URLEncoder进行编码转换
		 * encode(fileName,code)
		 */
		response.setHeader("Content-Disposition", "attachement;filName"+URLEncoder.encode(fileName,"UTF-8"));
		//获取服务器路径
		String serverPath = request.getServletContext().getRealPath("/upload");
		//创建输入流，读取目标文件
		FileInputStream fis = new FileInputStream(new File(serverPath+File.separator+fileName));
		//创建输出流
		OutputStream os = response.getOutputStream();
		//创建缓存区
		byte[] buff = new byte[1024];
		int len = -1;
		while((len = fis.read(buff)) > 0){
			os.write(buff, 0, len);
		}
		//释放流
		os.close();
		fis.close();
	}
}
