package com.djunderworld.nongjik.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.djunderworld.nongjik.common.annotation.BusinessNumber;
import com.djunderworld.nongjik.common.annotation.EmailConfirm;
import com.djunderworld.nongjik.common.annotation.Password;

@Entity
@Table(name = "users")
public class User extends Base implements Serializable {

	@NotEmpty(message = "이름을 입력하세요.")
	private String name;

	@NotEmpty(message = "이메일을 입력하세요.")
	@Email(message = "올바른 이메일형식이 아닙니다.")
	@EmailConfirm
	private String email;

	@Password
	@NotEmpty(message = "비밀번호 입력하세요.")
	private String password;

	@Transient
	@NotNull(message = "비밀번호가 일치하지 않습니다.")
	private String passwordConfirm;

	private String avatar;

	private String cover;
	private int level;

	@Transient
	@BusinessNumber
	private String businessNo;

	@OneToOne(mappedBy = "user")
	private Professional professional;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Story> stories = new ArrayList<Story>();

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<StoryLike> storyLikes = new ArrayList<StoryLike>();

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<StoryScrap> storyScraps = new ArrayList<StoryScrap>();

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<StoryComment> storyComments = new ArrayList<StoryComment>();

	public User() {
		super();
	}

	@PrePersist
	public void prePersist() {
		if (avatar == null) {
			avatar = "avatar.jpg";
		}

		if (cover == null) {
			cover = "cover.jpg";
		}
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Professional getProfessional() {
		return professional;
	}

	public void setProfessionalEntity(Professional professional) {
		this.professional = professional;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
		checkPassword();
	}

	private void checkPassword() {
		if (this.password == null || this.passwordConfirm == null) {
			return;
		} else if (!this.password.equals(passwordConfirm)) {
			this.passwordConfirm = null;
			this.password = null;
		}
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

	public List<StoryLike> getStoryLikes() {
		return storyLikes;
	}

	public void setStoryLikes(List<StoryLike> storyLikes) {
		this.storyLikes = storyLikes;
	}

	public List<StoryScrap> getStoryScraps() {
		return storyScraps;
	}

	public void setStoryScraps(List<StoryScrap> storyScraps) {
		this.storyScraps = storyScraps;
	}

	public List<StoryComment> getStoryComments() {
		return storyComments;
	}

	public void setStoryComments(List<StoryComment> storyComments) {
		this.storyComments = storyComments;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
	}

}
