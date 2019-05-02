package com.sxt.plane;

import java.awt.Graphics;
import java.awt.Image;

import com.sxt.util.GameUtil;
import com.sxt.util.MyFrame;

public class PlaneGameFrame extends MyFrame {
	Image bg = GameUtil.getImage("images/bg.jpg");
	Image plane = GameUtil.getImage("images/plane.jpg");
	
	public void paint(Graphics g){
		g.drawImage(bg, 0, 0, null);
		g.drawImage(plane, 100, 100, null);
	}
	
	public static void main(String[] args) {
		new PlaneGameFrame().launchFrame();
	}
}
