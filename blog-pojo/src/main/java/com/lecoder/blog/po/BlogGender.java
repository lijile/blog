package com.lecoder.blog.po;

public enum BlogGender {
	
	NOTSET(0,"未设置"),MALE(1,"男"),FEMALE(2,"女");
	
	private int id;
	
	private String name;

	private BlogGender(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static BlogGender getGender(int id){
		switch (id) {
			case 1:
				return MALE;
			case 2:
				return FEMALE;
			default:
				return NOTSET;
		}
	}

}
