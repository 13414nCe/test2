package com.dodi;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;


/**
 * 
 * @author zhangsheng
 * @version 1.0
 */
public class Demo {
	
	
	 public static void main(String[] args) throws MessagingException {
	        // 配置发送邮件的环境属性
	        final Properties props = new Properties();
	        // 表示SMTP发送邮件，需要进行身份验证
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.host", "smtp.163.com");
	        // 发件人的账号
	        props.put("mail.user", "13422040073@163.com");
	        // 访问SMTP服务时需要提供的密码
	        props.put("mail.password", "zhangsheng123");

	        // 构建授权信息，用于进行SMTP进行身份验证
	        Authenticator authenticator = new Authenticator() {
	            @Override
	            protected PasswordAuthentication getPasswordAuthentication() {
	                // 用户名、密码
	                String userName = props.getProperty("mail.user");
	                String password = props.getProperty("mail.password");
	                return new PasswordAuthentication(userName, password);
	            }
	        };
	        // 使用环境属性和授权信息，创建邮件会话
	        Session mailSession = Session.getInstance(props, authenticator);
	        // 创建邮件消息
	        MimeMessage message = new MimeMessage(mailSession);
	        // 设置发件人
	        InternetAddress form = new InternetAddress(
	                props.getProperty("mail.user"));
	        message.setFrom(form);

	        // 设置收件人(页面传递过来的参数)
	        InternetAddress to = new InternetAddress("734351162@qq.com");
	        message.setRecipient(RecipientType.TO, to);

	        // 设置抄送
	       /* InternetAddress cc = new InternetAddress("xxxxxxx@yeah.net");
	        message.setRecipient(RecipientType.CC, cc);*/

	        // 设置密送，其他的收件人不能看到密送的邮件地址
	       /* InternetAddress bcc = new InternetAddress("xxxxxxxxx@163.com");
	        message.setRecipient(RecipientType.CC, bcc);*/

	        // 设置邮件标题
	        message.setSubject("E购通商城-邮件激活码");
	        StringBuilder emailContent = new StringBuilder();
			emailContent.append("尊敬的"+"wanwu"+":<br/>");
			emailContent.append("欢迎您注册E购通商城账号，请点击");
			emailContent.append("<a href='http://eshop.com/ebuy/customer/activeUser?code=111'>激活码</a>");
			emailContent.append("进行激活您的账号，才能进行正常登录!");
			emailContent.append("感谢您对E购通信任，么么哒!");
	        // 设置邮件的内容体(邮件主题部分，由动态数据拼接而成)
			message.setContent(emailContent.toString(), "text/html;charset=UTF-8");

	        // 发送邮件
	        Transport.send(message);
	    }
}
