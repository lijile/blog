package com.lecoder.blog.vo;

public class ArticleTag {
	
	private int id;//唯一标识
	
	private int userId;//用户id
	
	private String tagName;//标签名

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public ArticleTag(int id, int userId, String tagName) {
		super();
		this.id = id;
		this.userId = userId;
		this.tagName = tagName;
	}

	public ArticleTag() {
		super();
	}
	
}
