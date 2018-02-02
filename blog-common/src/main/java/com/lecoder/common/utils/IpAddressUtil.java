package com.lecoder.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpAddressUtil {
	
	private static String ip = null;
	
	private static String address = null;
	
	public static String getIp(){
		if (ip == null) {
			String result = HttpUtil.doGet("http://ip.chinaz.com/getip.aspx",null);
			Pattern p = Pattern.compile("ip:'(.*?)',address");
			Matcher m = p.matcher(result);
			if(m.find()){
				ip = m.group(1);
			}else {
				ip = "";
			}
		}
		return ip;
	}
	
	public static String getAddress(){
		if (address == null) {
			String result = HttpUtil.doGet("http://ip.chinaz.com/getip.aspx",null);
			Pattern p = Pattern.compile("address:'(.*?)'}");
			Matcher m = p.matcher(result);
			if(m.find()){
				address = m.group(1);
			}else {
				address = "";
			}
		}
		return address;
	}
}
