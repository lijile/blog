package com.lecoder.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

public class PasswordUtils {
	
	private static char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','a','b','c','c','e','f'};         
	
	public static String encode(String password){
		if (password == null) {
			return null;
		}
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			BASE64Encoder encoder = new BASE64Encoder();
			String cipher1 = encoder.encode(messageDigest.digest(password.getBytes("utf-8")));
			String cipher2 = encoder.encode(messageDigest.digest(cipher1.getBytes("utf-8")));
			return cipher2;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String encode(String password,String salt) {
		  
        try {  
            byte[] btInput = (salt + password).getBytes();  
            // 获得MD5摘要算法的 MessageDigest 对象  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
            // 使用指定的字节更新摘要  
            mdInst.update(btInput);  
            // 获得密文  
            byte[] md = mdInst.digest();  
            // 把密文转换成十六进制的字符串形式  
            int j = md.length;  
            char str[] = new char[j * 2];  
            int k = 0;  
            for (int i = 0; i < j; i++) {  
                byte byte0 = md[i];  
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
                str[k++] = hexDigits[byte0 & 0xf];  
            }  
            return new String(str);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
	}
	
	public static void main(String[] args) {
		System.out.println(encode("123456","lijilelecoder"));
	}

}
