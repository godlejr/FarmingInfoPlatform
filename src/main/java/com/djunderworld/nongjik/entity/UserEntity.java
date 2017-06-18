package com.djunderworld.nongjik.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.djunderworld.nongjik.domain.User;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity implements Serializable{

	private String email;
	private String password;
	private String name;
	private String avatar;
	private String cover;
	private int level;
	
	@OneToOne(mappedBy = "userEntity")
	private ProfessionalEntity professionalEntity;
	
	@OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY)
	private List<StoryEntity> storyEntities = new ArrayList<StoryEntity>();
	
	public UserEntity() {
		super();
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

	public ProfessionalEntity getProfessionalEntity() {
		return professionalEntity;
	}

	public void setProfessionalEntity(ProfessionalEntity professionalEntity) {
		this.professionalEntity = professionalEntity;
	}
	

	public List<StoryEntity> getStoryEntities() {
		return storyEntities;
	}

	public void setStoryEntities(List<StoryEntity> storyEntities) {
		this.storyEntities = storyEntities;
	}

	public User buildDomain() {
		User user = new User();

		if (professionalEntity != null) {
			user.setProfessional(professionalEntity.buildDomainForBackRef());
		}
		user.setId(super.getId());
		user.setName(name);
		user.setAvatar(avatar);
		user.setCover(cover);
		user.setPassword(password);
		user.setLevel(level);
		user.setCreatedAt(super.getCreatedAt());
		user.setUpdatedAt(super.getUpdatedAt());
		return user;
	}

	public void buildEntity(User user) {
		super.setId(user.getId());

		if (user.getProfessional() != null) {
			ProfessionalEntity professional = new ProfessionalEntity();
			professional.buildEntityForBackRef(user.getProfessional());
			professionalEntity = professional;
		}
		email = user.getEmail();
		name = user.getName();
		password = user.getPassword();
		avatar = user.getAvatar();
		cover = user.getCover();
		level = user.getLevel();
		super.setCreatedAt(user.getCreatedAt());
		super.setUpdatedAt(user.getUpdatedAt());
	}

}
