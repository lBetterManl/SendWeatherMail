/**
 * Project Name:SendWeatherMail
 * File Name:Friend.java
 * Package Name:com.yhc.model
 * Date:2017年3月1日下午6:08:28
 * Copyright (c) 2017, yhc8023tm@foxmail.com All Rights Reserved.
 *
*/

package com.yhc.model;
/**
 * ClassName:Friend <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年3月1日 下午6:08:28 <br/>
 * @author   YHC
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class Friend {
	
	private String name;
	private String city;
	private String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Friend() {
		super();
	}
	public Friend(String name, String city, String email) {
		super();
		this.name = name;
		this.city = city;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Friend [name=" + name + ", city=" + city + ", email=" + email + "]";
	}	

}

