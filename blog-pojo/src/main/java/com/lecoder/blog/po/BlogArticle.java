package com.lecoder.blog.po;

import java.util.Date;

public class BlogArticle {
	
	private int id;//唯一标识
	
	private String title;//文章标题
	
	private String summary;//摘要
	
	private int userId;//用户id
	
	private int categoryId;//分类id
	
	private String extraUrl;//更多文章的地址 
	
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
