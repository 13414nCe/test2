package cn.qyl.ebuy.utils;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import cn.qyl.ebuy.common.PageConstant;

public class UpLoadUtils {
	/**
	 * 
	 * @param file	传一个file参数
	 * @return		返回文件名
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static String saveFile(MultipartFile file) throws IllegalStateException, IOException{
		//文件上传
		String serverUploadPath = PageConstant.FILE_PATH;
		//根据UUID生成文件名
		Serializable uuid = UUID.randomUUID();
		//获取文件名
		String fileName = file.getOriginalFilename();
		//根据.来分隔文件名
		String[] nameArray = fileName.split("\\.");
		String suffix = "";
		if(nameArray.length>1){
			//获取文件名后缀
			suffix = nameArray[1];
		}
		//生成新的文件名	uuid + . + 后缀(jpg)
		StringBuilder newName = new StringBuilder();
		newName.append(uuid+"."+suffix);
		File imgFile = new File(serverUploadPath,newName.toString());
		
		if(!imgFile.exists()){//如果该路径不存在
			imgFile.mkdirs();
		}
		//把表单传递过来的file进行转储到指定的服务器位置
		file.transferTo(imgFile);
		
		return newName.toString();
		
	}
}
