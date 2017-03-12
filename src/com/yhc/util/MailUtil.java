/**
 * Project Name:SendWeatherMail
 * File Name:MailUtil.java
 * Package Name:com.yhc.util
 * Date:2017年3月1日下午2:14:16
 * Copyright (c) 2017, yhc8023tm@foxmail.com All Rights Reserved.
 *
*/

package com.yhc.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * ClassName:MailUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年3月1日 下午2:14:16 <br/>
 * @author   YHC
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class MailUtil {
	
	private String smtp = "";//smtp服务器
	private String from = "";//发件人邮箱
	private String pwd = "";//发件人密码
	
	
	/**
	 * 创建MailUtil实例并赋上初值.
	 * @param smtp	发件箱协议
	 * @param from	发件人邮箱地址
	 * @param pwd	发件人授权码
	 */
	public MailUtil(String smtp, String from, String pwd) {
		super();
		this.smtp = smtp;
		this.from = from;
		this.pwd = pwd;	
	}
	
	/**
	 * sendMail:发送邮件. <br/>
	 * @author YHC
	 * @param to	收件人邮箱
	 * @param toName	收件人姓名（昵称）
	 * @param subject	邮件标题
	 * @param content	邮件内容
	 * @return
	 * @since JDK 1.8
	 */
	public boolean sendMail(String to,String toName, String subject, String content){
		
		boolean result = false;
		
		Properties props = new Properties();
		props.put("mail.smtp.host", smtp);
		props.put("mail.smtp.auth", "true");
		
		Session session = Session.getDefaultInstance(props);
		//显示发送过程，供调试
		//session.setDebug(true);
		
		MimeMessage message = new MimeMessage(session);
		
		try {
			message.setFrom(new InternetAddress(from,"好人","UTF-8"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to,toName,"UTF-8"));
			message.setSubject(subject);
			message.setContent(content, "text/html;charset=gb2312");
			message.saveChanges();
			
			Transport transport = session.getTransport("smtp");
			transport.connect(smtp, from, pwd);
			transport.sendMessage(message, message.getAllRecipients());		
			transport.close();
			
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("发送失败！");
		}
		return result;
	}
	
	
}

