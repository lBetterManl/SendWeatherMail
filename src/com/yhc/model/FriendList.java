/**
 * Project Name:SendWeatherMail
 * File Name:FriendList.java
 * Package Name:com.yhc.model
 * Date:2017年3月1日下午6:10:15
 * Copyright (c) 2017, yhc8023tm@foxmail.com All Rights Reserved.
 *
*/

package com.yhc.model;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:FriendList <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年3月1日 下午6:10:15 <br/>
 * @author   YHC
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class FriendList {
	
	private static List<Friend> friendList = null;

	
	/**
	 * getFriendList:好友列表. <br/>
	 * @author YHC
	 * @return
	 * @since JDK 1.8
	 */
	public static List<Friend> getFriendList(){
		if(friendList == null){
			friendList = new ArrayList<Friend>();
		}
		
		Friend fd1 = new Friend("程进", "深圳", "392835832@qq.com");
	
		friendList.add(fd1);
		
		return friendList;
	}
}

