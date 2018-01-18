package com.lecoder.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lecoder.blog.dao.mapper.UserInfoMapper;
import com.lecoder.blog.dao.mapper.UserMapper;
import com.lecoder.blog.po.BlogGender;
import com.lecoder.blog.po.BlogUser;
import com.lecoder.blog.po.BlogUserInfo;
import com.lecoder.blog.service.UserService;
import com.lecoder.blog.vo.User;
import com.lecoder.common.exception.UserException;
import com.lecoder.common.utils.PasswordUtils;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserInfoMapper userInfoMapper;

	/**
	 * 注册，初始化用户信息
	 */
	@Override
	@Transactional
	public User signUp(String username, String password) throws UserException{
		BlogUser blogUser = new BlogUser();
		blogUser.setUsername(username);
		blogUser.setPassword(PasswordUtils.encode(password));
		blogUser.setStatus(1);
		Integer flag = userMapper.saveUser(blogUser);
		if (flag == 0) {
			throw new UserException(UserException.USER_EXISTED,"用户已经存在");
		}else {
			BlogUserInfo blogUserInfo = new BlogUserInfo();
			blogUserInfo.setUserId(blogUser.getId());
			blogUserInfo.setUsername(blogUser.getUsername());
			blogUserInfo.setGender(BlogGender.NOTSET);
			userInfoMapper.saveUserInfo(blogUserInfo);
			User user = new User(blogUser.getId(), username, blogUser.getStatus(), 
					blogUserInfo.getFullname(), blogUserInfo.getCellphone(), 
					blogUserInfo.getGender().getId(), blogUserInfo.getProfile(), 
					blogUser.getGmtCreate(), blogUserInfo.getGmtModified());
			return user;
		}
	}

	/**
	 * 登录
	 */
	@Override
	public User signIn(String username, String password) throws UserException {
		BlogUser blogUser = userMapper.findUserByUsername(username);
		if (blogUser == null) {
			throw new UserException(UserException.USER_NOT_EXIST,"用户不存在");
		}else if (!PasswordUtils.encode(password).equals(blogUser.getPassword())) {
			throw new UserException(UserException.USER_PASSWORD_ERROR,"用户名或密码错误");
		}
		BlogUserInfo blogUserInfo = userInfoMapper.findUserInfoByUsername(blogUser.getUsername());
		if (blogUserInfo == null) {
			blogUserInfo = new BlogUserInfo();
			blogUserInfo.setUserId(blogUser.getId());
			blogUserInfo.setUsername(blogUser.getUsername());
			blogUserInfo.setGender(BlogGender.NOTSET);
			userInfoMapper.saveUserInfo(blogUserInfo);
		}
		User user = new User(blogUser.getId(), username, blogUser.getStatus(), 
				blogUserInfo.getFullname(), blogUserInfo.getCellphone(), 
				blogUserInfo.getGender().getId(), blogUserInfo.getProfile(), 
				blogUser.getGmtCreate(), blogUserInfo.getGmtModified());
		return user;
	}
	

}
