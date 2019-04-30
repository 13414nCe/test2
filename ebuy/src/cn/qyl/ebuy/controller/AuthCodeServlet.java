package cn.qyl.ebuy.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qyl.ebuy.common.PageConstant;
import cn.qyl.ebuy.utils.AuthCode;

/**
 * 验证码处理类
 */
@WebServlet("/authCode.do")
public class AuthCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取随机数
		String code = AuthCode.getRandomNum();
		request.getSession().setAttribute(PageConstant.AUTH_CODE, code);
		//获取验证码图片
		BufferedImage img = AuthCode.getAuthCodeImg(code);
		ImageIO.write(img, "jpg", response.getOutputStream());
	}

}
