package com.lecoder.blog.admin.shiro;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.crypto.hash.HashService;
import org.apache.shiro.crypto.hash.format.DefaultHashFormatFactory;
import org.apache.shiro.crypto.hash.format.Shiro1CryptFormat;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;

/**
 * 密码重复次数限制
 * @author lecoder
 *
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher{
	
	private Cache<String,AtomicInteger> passwordRetryCache;
	
	public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
		passwordRetryCache = cacheManager.getCache("passwordRetryCache");
	}
	
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		String username = (String) token.getPrincipal();
		AtomicInteger retryCount = passwordRetryCache.get(username);
		if (retryCount == null) {
			retryCount = new AtomicInteger(0);
			passwordRetryCache.put(username, retryCount);
		}
		if (retryCount.incrementAndGet() > 5) {
			throw new ExcessiveAttemptsException("密码输入错误超过5次");
		}
		boolean matches = super.doCredentialsMatch(token, info);
		//密码正确，移除之前的记录
		if (matches) {
			passwordRetryCache.remove(username);
		}
		return matches;
	}
	
	public static void main(String[] args) {
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
