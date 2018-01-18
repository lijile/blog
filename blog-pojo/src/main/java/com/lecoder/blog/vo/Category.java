package com.lecoder.blog.vo;

public class Category {
	
	private int id;//唯一标识
	
	private String categoryCode;//分类编码
	
	private String categoryName;//分类名称

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Category(int id, String categoryCode, String categoryName) {
		super();
		this.id = id;
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
	}

	public Category() {
		super();
	}
	
}
