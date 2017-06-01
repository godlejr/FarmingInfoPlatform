package com.djunderworld.nongjik.model;


import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.djunderworld.nongjik.domain.User;


public class UserModel {
	
	
	private long id;
	
	@NotEmpty (message="비밀번호 입력하세요.")
	private String password;
	
	@NotNull (message="비밀번호가 일치하지 않습니다.")
	private String passwordConfirm;
	
	@NotEmpty (message="이름을 입력하세요.")
	private String name;
	
	@NotEmpty (message="이메일을 입력하세요.")
	@Email(message="올바른 이메일형식이 아닙니다.")
	private String email;
	
	private String avatar;
	private int level;
	private String createdAt;
	private String updatedAt;
	
	
	@NotEmpty (message="사업자 등록번호를 입력하세요.")
	private String businessNo;

	public UserModel(long id, String password,String passwordConfirm, String name, String avatar,
			int level, String createdAt, String updatedAt, String email) {
		super();
		this.id = id;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.name = name;
		this.avatar = avatar;
		this.level = level;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserModel() {
		super();
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
	
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
		checkPassword();
	}
	
	private void checkPassword() {
	    if(this.password == null || this.passwordConfirm == null){
	        return;
	    }else if(!this.password.equals(passwordConfirm)){
	        this.passwordConfirm = null;
	        this.password = null;
	    }
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

	public void buildModel(User user) { 
		id = user.getId();
		name = user.getName();
		password = user.getPassword();
		avatar = user.getAvatar();
		level = user.getLevel();
		createdAt = user.getCreatedAt();
		updatedAt = user.getUpdatedAt();
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}


}
