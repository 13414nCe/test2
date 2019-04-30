package cn.qyl.ebuy.utils;

import java.util.Date;

public class RandomOrderCodeUtils {
	
	
	public static String getOrderCode(){
		
		StringBuilder code = new StringBuilder();
		Date date = new Date();
		long times = date.getTime();
		//Po_时间毫秒数
		code.append("PO_"+times);
		return code.toString();
	}
}
