package com.djunderworld.nongjik.domain;

import java.util.ArrayList;
import java.util.List;

public class User extends Base {
	private String email;
	private String password;
	private String name;
	private String avatar;
	private String cover;
	private int level;

	private Professional professional;

	private List<Story> stories = new ArrayList<Story>();
	//for the join
	private String businessNo;
	
	public User() {
		super();
	}

	public User(String email, String password, String name, String avatar, String cover, int level,
			Professional professional) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.avatar = avatar;
		this.cover = cover;
		this.level = level;
		this.professional = professional;
	}

	@Override
	public long getId() {
		return super.getId();
	}

	@Override
	public void setId(long id) {
		super.setId(id);
	}

	@Override
	public String getCreatedAt() {
		return super.getCreatedAt();
	}

	@Override
	public void setCreatedAt(String createdAt) {
		super.setCreatedAt(createdAt);
	}

	@Override
	public String getUpdatedAt() {
		return super.getUpdatedAt();
	}

	@Override
	public void setUpdatedAt(String updatedAt) {
		super.setUpdatedAt(updatedAt);
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getCover() {
		return cover;
	}

	public Professional getProfessional() {
		return professional;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public List<Story> getStories() {
		return stories;
	}

	public void setStories(List<Story> stories) {
		this.stories = stories;
	}

}
