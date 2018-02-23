package com.lecoder.blog.admin.test;

import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;

public class MD5Test {

	@Test
	public void testMd5Encode(){
		DefaultHashService hashService = new DefaultHashService(); //默认算法SHA-512
		HashRequest request = new HashRequest.Builder()
			.setAlgorithmName("MD5")
			.setSource(ByteSource.Util.bytes("123456"))
			.setSalt("lijilelecoder")
			.setIterations(1).build();
		String hex = hashService.computeHash(request).toHex();
		System.out.println(hex);
	}
	
}
