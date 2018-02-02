package com.lecoder.blog.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lecoder.blog.po.BlogUser;
import com.lecoder.blog.po.UserDetail;

public interface UserMapper {

	Integer saveUser(BlogUser user);

	BlogUser findUserByUsername(@Param("username") String username);

	List<UserDetail> listUser(@Param("start")Integer start, @Param("offset") Integer offset);

	Integer queryForCount();

}
