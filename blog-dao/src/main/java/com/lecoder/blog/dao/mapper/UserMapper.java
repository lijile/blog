package com.lecoder.blog.dao.mapper;

import org.apache.ibatis.annotations.Param;

import com.lecoder.blog.po.BlogUser;

public interface UserMapper {

	Integer saveUser(BlogUser user);

	BlogUser findUserByUsername(@Param("username") String username);

}
