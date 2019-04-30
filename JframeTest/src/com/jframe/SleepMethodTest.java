package com.jframe;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.*;

/**
 * 线程的休眠
 * 
 * @author Administrator
 *
 */
public class SleepMethodTest extends JFrame {

	private Thread t;
	// 定义颜色数组
	private static Color[] color = { Color.BLACK, Color.BLUE, Color.CYAN,
			Color.GREEN, Color.ORANGE, Color.YELLOW, Color.RED, Color.PINK,
			Color.LIGHT_GRAY };
	// 创建随机数
	private static final Random rand = new Random();

	// 获取随机颜色值得方法
	private static Color getColor() {
		return color[rand.nextInt(color.length)];
	}

	public SleepMethodTest() {
		t = new Thread(new Runnable() {
			// 定义初始坐标
			int x = 30;
			int y = 50;

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					// 获取组件绘图上下文对象
					Graphics graphics = getGraphics();
					// 设置绘图颜色
					graphics.setColor(getColor());
					// 绘制直线并递增垂直坐标
					graphics.drawLine(x, y, 100, y++);
					if (y >= 80) {
						y = 50;
					}
				}
			}
		});
		t.start();
	}

	public static void main(String[] args) {
		init(new SleepMethodTest(), 200, 200);
	}

	// 初始化程序界面的方法
	public static void init(JFrame frame, int width, int height) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setVisible(true);
	}

}
