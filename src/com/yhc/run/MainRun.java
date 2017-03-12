/**
 * Project Name:SendWeatherMail
 * File Name:MainRun.java
 * Package Name:com.yhc.run
 * Date:2017年3月1日下午2:17:45
 * Copyright (c) 2017, yhc8023tm@foxmail.com All Rights Reserved.
 *
*/

package com.yhc.run;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.yhc.model.Friend;
import com.yhc.model.FriendList;
import com.yhc.util.HttpUtil;
import com.yhc.util.MailUtil;
import com.yhc.util.PropertiesUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * ClassName:MainRun <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年3月1日 下午2:17:45 <br/>
 * 
 * @author YHC
 * @version
 * @since JDK 1.8
 * @see
 */
public class MainRun {

	/**
	 * getWeather:取得城市的天气. <br/>
	 * @author YHC
	 * @param city	获取天气的城市
	 * @return 邮件内容
	 * @since JDK 1.8
	 */
	public static String getWeather(String city) {
		String content = "";

		String strUrl = "http://api.map.baidu.com/telematics/v3/weather";

		Map<String, String> params = new HashMap<String, String>();
		params.put("location", city);
		params.put("output", "json");
		params.put("ak", "6tYzTvGZSOpYB5Oc2YGGOKt8");

		String full_weather = HttpUtil.request(strUrl, params, "GET");
		JSONObject full_weather_object = JSONObject.fromObject(full_weather);
		JSONArray main_weather_array = full_weather_object.getJSONArray("results");
		JSONObject main_weather_object = main_weather_array.getJSONObject(0);
		JSONArray weather_data_array = main_weather_object.getJSONArray("weather_data");
		JSONObject today_weather = weather_data_array.getJSONObject(0);
		
		System.out.println("今日天气："+today_weather.toString());		

		StringBuffer sbf = new StringBuffer("<div style='background-color: #FFFFCC'>");
		sbf.append("<h1 style='color: red'>愿你成为一个坚毅的人</h1>");
		sbf.append("<div style='color: #FF6666;background-color: #FFFF99;'>多少蛰伏于苦难的人，大约便能够有所安慰与鼓舞，相信希望的存在，收起悲哀，去守望破土的明亮。</div>");
		sbf.append("<h3 style='color: #CC9966'>在<span style='color: #FF0066'>");
		sbf.append(city);
		sbf.append("</span>的你过得怎样，你那里今天是<span style='color: #FF0066'>");
		sbf.append(today_weather.getString("weather"));
		sbf.append("天</span>，注意天气变化哦！</h3>");

		sbf.append("<p>城市：");
		sbf.append(city);
		sbf.append("<br>日期：");
		sbf.append(today_weather.getString("date"));
		sbf.append("<br>天气：");
		sbf.append(today_weather.getString("weather"));
		sbf.append("<br>温度：");
		sbf.append(today_weather.getString("temperature"));
		sbf.append("<br>pm2.5：");
		sbf.append(main_weather_object.getString("pm25"));
		sbf.append("<br>风向：");
		sbf.append(today_weather.getString("wind"));
		sbf.append("</p>");

		sbf.append("<h3>今日推歌：</h3>");

		sbf.append("<p><a href='http://music.163.com/#/song?id=462523414'>妄为</a></p>");
		sbf.append("</div>");

		content = sbf.toString();

		return content;
	}

	public static void main(String[] args) {

		// TODO 给邮箱好友发送天气

		String smtp = PropertiesUtil.getProperty("163.smtp");
		String from = PropertiesUtil.getProperty("163.account");
		String pwd = PropertiesUtil.getProperty("163.pwd");

		MailUtil email = new MailUtil(smtp, from, pwd);

		List<Friend> friendList = FriendList.getFriendList();
		
		for(Friend fd:friendList){
			String content = getWeather(fd.getCity());
			email.sendMail(fd.getEmail(), fd.getName(), "来自好人的一份问候", content);
		}
		
		System.out.println("您已向好友送完温暖！");
	}

}
