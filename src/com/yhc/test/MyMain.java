/**
 * Project Name:SendWeatherMail
 * File Name:MyMain.java
 * Package Name:com.yhc.test
 * Date:2017年3月1日下午1:44:02
 * Copyright (c) 2017, yhc8023tm@foxmail.com All Rights Reserved.
 *
*/

package com.yhc.test;

import com.yhc.util.PropertiesUtil;

/**
 * ClassName:MyMain <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年3月1日 下午1:44:02 <br/>
 * @author   YHC
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class MyMain {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		System.out.println("协议："+PropertiesUtil.getProperty("163.smtp"));
	}

}

