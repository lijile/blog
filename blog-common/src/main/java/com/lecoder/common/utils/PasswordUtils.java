package com.lecoder.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

public class PasswordUtils {
	
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
	
	public static void main(String[] args) {
		System.out.println(encode("123456"));
	}

}
