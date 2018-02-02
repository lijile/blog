package com.lecoder.blog.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lecoder.blog.po.BlogRole;

public interface RoleMapper {

	List<BlogRole> findRolesByUsername(@Param("username") String username);


}
