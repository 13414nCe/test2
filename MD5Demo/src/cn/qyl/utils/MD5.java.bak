package cn.qyl.utils;

import java.security.MessageDigest;

/**
 * MD5加密的工具类

 */
public final class MD5 {
	
	public static void main(String[] args) throws Exception {
		System.out.println(getMD5("zhangsan"));
	}
	/**
	 * MD5加密的方法
	 * @param str 明文
	 * @return 加密后的字符串
	 * @throws Exception 
	 */
	public static String getMD5(String str) throws Exception {
		// 获取MD5加密的对象
		MessageDigest  md = MessageDigest.getInstance("MD5");
		// 加密
		md.update(str.getBytes());
		// 获取加密过后的字符串数组
		byte[] md5Bytes = md.digest();
		
		String res = "";
		for (int i = 0; i < md5Bytes.length; i++){
			//0xFF 是计算机十六进制
			int temp = md5Bytes[i] & 0xff;
			if (temp <= 0xf){
				res += "0";
			}
			res += Integer.toHexString(temp);
		}
		return res;
	}
}