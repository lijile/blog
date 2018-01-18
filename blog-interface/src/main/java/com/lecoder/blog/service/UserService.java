package com.lecoder.blog.service;

import com.lecoder.blog.vo.User;
import com.lecoder.common.exception.UserException;

public interface UserService {
	
	public User signUp(String username,String password) throws UserException;
	
	public User signIn(String username,String password) throws UserException;
	
}
