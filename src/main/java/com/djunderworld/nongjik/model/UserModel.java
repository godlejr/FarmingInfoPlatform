package com.djunderworld.nongjik.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.djunderworld.nongjik.common.annotation.BusinessNumber;
import com.djunderworld.nongjik.common.annotation.EmailConfirm;
import com.djunderworld.nongjik.common.annotation.Password;
import com.djunderworld.nongjik.domain.User;

public class UserModel extends BaseModel  {

	

	@NotEmpty(message = "이름을 입력하세요.")
	private String name;

	@NotEmpty(message = "이메일을 입력하세요.")
	@Email(message = "올바른 이메일형식이 아닙니다.")
	@EmailConfirm
	private String email;
	
	@Password
	@NotEmpty(message = "비밀번호 입력하세요.")
	private String password;

	@NotNull(message = "비밀번호가 일치하지 않습니다.")
	private String passwordConfirm;
	private String avatar;
	private String cover;
	private int level;

	@BusinessNumber
	private String businessNo;

	private ProfessionalModel professionalModel;

	public UserModel(String password, String name, String email, String avatar, String cover, int level,
			ProfessionalModel professionalModel) {
		super();
		this.password = password;
		this.name = name;
		this.email = email;
		this.avatar = avatar;
		this.cover = cover;
		this.level = level;
		this.professionalModel = professionalModel;
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
	public String getUpdatedAt() {
		return super.getUpdatedAt();
	}

	@Override
	public void setUpdatedAt(String updatedAt) {
		super.setUpdatedAt(updatedAt);
	}

	@Override
	public String getCreatedAt() {
		return super.getCreatedAt();
	}

	@Override
	public void setCreatedAt(String createdAt) {
		super.setCreatedAt(createdAt);
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

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public ProfessionalModel getProfessionalModel() {
		return professionalModel;
	}

	public void setProfessionalModel(ProfessionalModel professionalModel) {
		this.professionalModel = professionalModel;
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

	public User buildDomain() {
		User user = new User();
		user.setId(getId());
		user.setEmail(email);
		user.setName(name);
		user.setAvatar(avatar);
		user.setCover(cover);
		user.setPassword(password);
		user.setLevel(level);
		if (professionalModel != null) {
			user.setProfessional(professionalModel.buildDomainForBackRef());
		}
		user.setBusinessNo(businessNo);
		user.setCreatedAt(getCreatedAt());
		user.setUpdatedAt(getUpdatedAt());
		return user;
	}

	public void buildModel(User user) {
		setId(user.getId());
		name = user.getName();
		password = user.getPassword();
		avatar = user.getAvatar();
		level = user.getLevel();
		cover = user.getCover();

		ProfessionalModel professional = new ProfessionalModel();
		professional.buildModel(user.getProfessional());

		professionalModel = professional;
		setCreatedAt(user.getCreatedAt());
		setUpdatedAt(user.getUpdatedAt());
	}

}
