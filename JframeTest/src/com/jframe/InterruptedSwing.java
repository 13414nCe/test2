package com.jframe;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
/**
 * 线程的中断
 * @author Administrator
 *
 */
public class InterruptedSwing extends JFrame {
	Thread thread;
	
	public static void main(String[] args) {
		init(new InterruptedSwing(), 100, 100);
	}
	public InterruptedSwing(){
		super();
		final JProgressBar progressBar = new JProgressBar();
		getContentPane().add(progressBar,BorderLayout.NORTH);
		//设置进度条上显示数字
		progressBar.setStringPainted(true);
		thread = new Thread(new Runnable() {
			int count = 0;
			@Override
			public void run() {
				while(true){
					progressBar.setValue(++count);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("当前线程被中断");
						break;
					}
				}
			}
		});
		//启动线程
		thread.start();
		//中断线程
		thread.interrupt();
	}
	
	//设置窗体的各种属性的方法
		public static void init(JFrame frame,int width,int height){
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(width,height);
			frame.setVisible(true);
		}
}
