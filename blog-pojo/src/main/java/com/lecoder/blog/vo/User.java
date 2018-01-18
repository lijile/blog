package com.lecoder.blog.vo;

import java.util.Date;

public class User {
	
	private int id;//唯一标识
	
	private String username;//登录名
	
	private int status;//1:启动 0:禁用
	
	private String fullname;//博客用户名
	
	private String cellphone;//手机号
	
	private int gender;//性别,0:保密 1:男 2:女
	
	private String profile;//个人简介
	
	private Date gmtCreate;//创建时间
	
	private Date gmtModified;//修改时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
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
	
	

	public User(int id, String username, int status, String fullname, String cellphone, int gender, String profile,
			Date gmtCreate, Date gmtModified) {
		super();
		this.id = id;
		this.username = username;
		this.status = status;
		this.fullname = fullname;
		this.cellphone = cellphone;
		this.gender = gender;
		this.profile = profile;
		this.gmtCreate = gmtCreate;
		this.gmtModified = gmtModified;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", status=" + status + ", fullname=" + fullname
				+ ", cellphone=" + cellphone + ", gender=" + gender + ", profile=" + profile + ", gmtCreate="
				+ gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
	
	

}
