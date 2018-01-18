package com.lecoder.blog.dao.mapper;

import com.lecoder.blog.po.BlogUserInfo;

public interface UserInfoMapper {

	Integer saveUserInfo(BlogUserInfo userInfo);

	BlogUserInfo findUserInfoByUsername(String username);

	BlogUserInfo findUserInfoByUserId(int userId);

}
