package com.lecoder.blog.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lecoder.blog.po.BlogPermission;

public interface PermissionMapper {

	List<BlogPermission> findPermissionsByUsername(@Param("username") String username);


}
