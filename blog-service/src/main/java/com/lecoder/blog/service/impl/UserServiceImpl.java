package com.lecoder.blog.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lecoder.blog.dao.mapper.PermissionMapper;
import com.lecoder.blog.dao.mapper.RoleMapper;
import com.lecoder.blog.dao.mapper.UserInfoMapper;
import com.lecoder.blog.dao.mapper.UserMapper;
import com.lecoder.blog.po.BlogGender;
import com.lecoder.blog.po.BlogPermission;
import com.lecoder.blog.po.BlogRole;
import com.lecoder.blog.po.BlogUser;
import com.lecoder.blog.po.BlogUserInfo;
import com.lecoder.blog.po.UserDetail;
import com.lecoder.blog.service.UserService;
import com.lecoder.blog.vo.User;
import com.lecoder.common.exception.UserException;
import com.lecoder.common.utils.PasswordUtils;
import com.lecoder.common.web.Pager;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private PermissionMapper permissionMapper;

	/**
	 * 注册，初始化用户信息
	 */
	@Override
	@Transactional
	public User signUp(String username, String password) throws UserException{
		BlogUser blogUser = new BlogUser();
		blogUser.setUsername(username);
		blogUser.setPassword(PasswordUtils.encode(password,username+"lecoder"));
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
		}else if (!PasswordUtils.encode(password,username+"lecoder").equals(blogUser.getPassword())) {
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

	@Override
	public Pager listUser(Integer page, Integer pageSize, Integer record) {
		int start = Pager.getStartOfPage(page, pageSize);
		int totalSize = record;
		if (record == 0) {
			totalSize = userMapper.queryForCount();
		}
		List<UserDetail> users = userMapper.listUser(start,pageSize);
		List<User> data = new ArrayList<>(users.size());
		for(UserDetail userDetail : users) {
			User user = new User();
			BeanUtils.copyProperties(userDetail, user);
			user.setGmtCreate(userDetail.getGmtCreate());
			data.add(user);
		}
		Pager pager = new Pager(start, totalSize, pageSize, data);
		return pager;
	}

	@Override
	@Transactional
	public User saveUser(String username, String fullname, String cellphone, String password) throws UserException {
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
			blogUserInfo.setFullname(fullname);
			blogUserInfo.setCellphone(cellphone);
			blogUserInfo.setGender(BlogGender.NOTSET);
			userInfoMapper.saveUserInfo(blogUserInfo);
			User user = new User(blogUser.getId(), username, blogUser.getStatus(), 
					blogUserInfo.getFullname(), blogUserInfo.getCellphone(), 
					blogUserInfo.getGender().getId(), blogUserInfo.getProfile(), 
					blogUser.getGmtCreate(), blogUserInfo.getGmtModified());
			return user;
		}
	}

	@Override
	public BlogUser findByUsername(String username) {
		return userMapper.findUserByUsername(username);
	}

	@Override
	public Set<String> findRoles(String username) {
		List<BlogRole> roleList = roleMapper.findRolesByUsername(username);
		if (roleList == null) {
			return null;
		}
		Set<String> roles = new HashSet<>();
		for(BlogRole role : roleList) {
			roles.add(role.getRole());
		}
		return roles;
	}

	@Override
	public Set<String> findPermissions(String username) {
		List<BlogPermission> permissionList = permissionMapper.findPermissionsByUsername(username);
		if (permissionList == null) {
			return null;
		}
		Set<String> permissions = new HashSet<>();
		for(BlogPermission permission : permissionList) {
			permissions.add(permission.getPermission());
		}
		return permissions;
	}
	

}
