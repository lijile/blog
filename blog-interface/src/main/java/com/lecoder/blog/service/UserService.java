package com.lecoder.blog.service;

import java.util.Set;

import com.lecoder.blog.po.BlogUser;
import com.lecoder.blog.vo.User;
import com.lecoder.common.exception.UserException;
import com.lecoder.common.web.Pager;

public interface UserService {
	
	public User signUp(String username,String password) throws UserException;
	
	public User signIn(String username,String password) throws UserException;

	public Pager listUser(Integer page, Integer pageSize, Integer record);

	public User saveUser(String username, String fullname, String cellphone, String password) throws UserException;

	public BlogUser findByUsername(String username);

	public Set<String> findRoles(String username);

	public Set<String> findPermissions(String username);
	
}
