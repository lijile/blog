# 服务端DAO层
# 简介 
选择Mybatis作为项目的ORM框架
建表脚本
```
CREATE TABLE `blog_user` (
`id`  bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '唯一标识' ,
`username`  char(20) NOT NULL UNIQUE COMMENT '登录名' ,
`password`  char(32) NOT NULL COMMENT '密码的密文（md5）' ,
`status`  tinyint(1) UNSIGNED NULL DEFAULT 1 COMMENT '1:启动 0:禁用' ,
`gmt_create`  datetime DEFAULT NULL COMMENT '创建时间' ,
`gmt_modified`	timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

CREATE TABLE `blog_user_info` (
`id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '唯一标识' ,
`user_id` BIGINT(20) NOT NULL UNIQUE COMMENT '用户id' ,
`username` char(20) NOT NULL UNIQUE COMMENT '登录名' ,
`fullname` char(30) NULL COMMENT '博客用户名' ,
`cellphone` char(15) NULL COMMENT '手机号' ,
`gender` tinyint(1) NOT NULL DEFAULT 0 COMMENT '性别,0:保密 1:男 2:女' ,
`profile` varchar(200) NULL COMMENT '个人简介' , 
`gmt_create`  datetime DEFAULT NULL COMMENT '创建时间' ,
`gmt_modified`	timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

CREATE TABLE `blog_article` (
`id`  bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '唯一标识' ,
`title` varchar(50) NOT NULL COMMENT '文章标题' ,
`summary` varchar(300) NULL COMMENT '摘要' ,
`user_id` BIGINT(20) NOT NULL COMMENT '用户id' ,
`category_id` bigint(20) NOT NULL COMMENT '分类id' ,
`extra_url` VARCHAR(200) NULL COMMENT '更多文章的地址' , 
`gmt_create`  datetime DEFAULT NULL COMMENT '创建时间' ,
`gmt_modified`	timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

CREATE TABLE `blog_category` (
`id`  bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '唯一标识' ,
`category_code` char(10) NOT NULL COMMENT '分类编码' ,
`category_name` char(20) NOT NULL COMMENT '分类名称' ,
`gmt_create`  datetime DEFAULT NULL COMMENT '创建时间' ,
`gmt_modified`	timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

CREATE TABLE `blog_article_content` (
`id`  bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '唯一标识' ,
`article_id` bigint(20) NOT NULL COMMENT '文章id' ,
`article_content` text NOT NULL COMMENT '内容' ,
`gmt_create`  datetime DEFAULT NULL COMMENT '创建时间' ,
`gmt_modified`	timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

CREATE TABLE `blog_tag` (
`id`  bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '唯一标识' ,
`user_id`	bigint(20) NOT NULL COMMENT '用户id' ,
`tag_name` varchar(20) NOT NULL COMMENT '标签名' ,
`gmt_create`  datetime DEFAULT NULL COMMENT '创建时间' ,
`gmt_modified`	timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

CREATE TABLE `blog_article_tag` (
`id`  bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '唯一标识' ,
`article_id` bigint(20) NOT NULL COMMENT '文章id' ,
`tag_id` bigint(20) NOT NULL COMMENT '标签id' ,
`gmt_create`  datetime DEFAULT NULL COMMENT '创建时间' ,
`gmt_modified`	timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 ;
```