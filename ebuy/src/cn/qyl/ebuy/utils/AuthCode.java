package cn.qyl.ebuy.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/*
 * 随机验证码工具类
 * 1.生成4个随机数的字符串
 * 2.根据4个随机数绘制验证码图片
 */
public class AuthCode {
	static Random random = new Random();
	//生成随机数
	public static String getRandomNum(){
		StringBuilder code = new StringBuilder();
		
		//循环生成 4个随机数
		for(int i =0;i<4;i++){
			int num = random.nextInt(10);
			code.append(num+"");
		}
		return code.toString();
	}
	//根据随机数生成验证码图片
	public static BufferedImage getAuthCodeImg(String code){
		//绘制画布
		BufferedImage img = new BufferedImage(88,28,BufferedImage.TYPE_INT_RGB);
		//绘制画笔
		Graphics grap = img.getGraphics();
		//设置画布背景颜色
		grap.setColor(Color.YELLOW);
		//填充矩形
		grap.fillRect(0, 0, 88, 28);
		//设置字体颜色
		grap.setColor(Color.BLACK);
		//设置字体样式
		grap.setFont(new Font("宋体",Font.BOLD,20));
		//把随机数绘制到画布中
		for(int i = 0;i<code.length();i++){
			//charAt(index):根据索引值获取该字符串的字符
			char c = code.charAt(i);
			grap.drawString(c+"", 20*i+6, 22);
			
		}
		//绘制干扰线
		for(int i = 0;i<10;i++){
			//在画布中绘制干扰线
			//一条干扰线具备A点(x1,y1)与B点(x2,y2)相连
			int x1 = random.nextInt(88);
			int y1 = random.nextInt(28);
			int x2 = random.nextInt(88);
			int y2 = random.nextInt(28);
			grap.drawLine(x1, y1, x2, y2);
		}
		
		return img;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(getRandomNum());
	}
	
}
