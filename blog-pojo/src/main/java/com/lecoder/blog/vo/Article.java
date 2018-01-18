package com.lecoder.blog.vo;

import java.util.Date;

public class Article {
	
	private int id;//唯一标识
	
	private String title;//文章标题
	
	private String summary;//摘要
	
	private int userId;//用户id
	
	private String username;//用户名
	
	private String fullname;//博客名
	
	private int categoryId;//分类id
	
	private String extraUrl;//更多文章的地址 
	
	private String articleContent;//内容
	
	private int readCount;//阅读数
	
	private int commentCount;//评论数
	
	private Date gmtCreate;//创建时间
	
	private Date gmtModified;//修改时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getExtraUrl() {
		return extraUrl;
	}

	public void setExtraUrl(String extraUrl) {
		this.extraUrl = extraUrl;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Article() {
		super();
	}

	public Article(int id, String title, String summary, int userId, String username, String fullname, int categoryId,
			String extraUrl, String articleContent, int readCount, int commentCount, Date gmtCreate, Date gmtModified) {
		super();
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.userId = userId;
		this.username = username;
		this.fullname = fullname;
		this.categoryId = categoryId;
		this.extraUrl = extraUrl;
		this.articleContent = articleContent;
		this.readCount = readCount;
		this.commentCount = commentCount;
		this.gmtCreate = gmtCreate;
		this.gmtModified = gmtModified;
	}
	
}
