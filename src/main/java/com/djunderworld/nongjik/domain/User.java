package com.djunderworld.nongjik.domain;

public class User {
	private long id;
	private String email;
	private String password;
	private String name;
	private String avatar;
	private int level;
	private String createdAt;
	private String updatedAt;



	public User(long id, String password, String name, String avatar, int level, String createdAt, String updatedAt) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.avatar = avatar;
		this.level = level;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.email = email;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
