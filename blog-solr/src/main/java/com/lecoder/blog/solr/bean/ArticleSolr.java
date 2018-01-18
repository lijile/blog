package com.lecoder.blog.solr.bean;

import java.util.Date;

import org.apache.solr.client.solrj.beans.Field;

public class ArticleSolr {
	
	@Field("id")
	private int id;
	
	@Field("title")
	private String title;
	
	@Field("summary")
	private String summary;
	
	@Field("user_id")
	private int userId;
	
	@Field("username")
	private String username;
	
	@Field("gmt_modified")
	private Date gmt_modified;
	
	@Field("article_content")
	private String articleContent;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public Date getGmt_modified() {
		return gmt_modified;
	}

	public void setGmt_modified(Date gmt_modified) {
		this.gmt_modified = gmt_modified;
	}

	@Override
	public String toString() {
		return "ArticleSolr [id=" + id + ", title=" + title + ", summary=" + summary + ", userId=" + userId
				+ ", username=" + username + ", gmt_modified=" + gmt_modified + ", articleContent=" + articleContent
				+ "]";
	}

	public ArticleSolr(int id, String title, String summary, int userId, String username, Date gmt_modified,
			String articleContent) {
		super();
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.userId = userId;
		this.username = username;
		this.gmt_modified = gmt_modified;
		this.articleContent = articleContent;
	}

	public ArticleSolr() {
	}
	
	

}
