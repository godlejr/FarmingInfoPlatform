package com.djunderworld.nongjik.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.djunderworld.nongjik.domain.User;

@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@GeneratedValue
	private long id;
	private String password;
	private String name;
	private String avatar;
	private int level;
	private String createdAt;
	private String updatedAt;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(long id, String password, String name, String avatar, int level, String createdAt,
			String updatedAt) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.avatar = avatar;
		this.level = level;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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

	public User buildDomain() {
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setAvatar(avatar);
		user.setPassword(password);
		user.setLevel(level);
		user.setCreatedAt(createdAt);
		user.setUpdatedAt(updatedAt);
		return user;
	}

	public void buildEntity(User user) { 
		id = user.getId();
		name = user.getName();
		password = user.getPassword();
		avatar = user.getAvatar();
		level = user.getLevel();
		createdAt = user.getCreatedAt();
		updatedAt = user.getUpdatedAt();
	}

}
