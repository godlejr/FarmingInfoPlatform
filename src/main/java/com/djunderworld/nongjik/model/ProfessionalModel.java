package com.djunderworld.nongjik.model;

import com.djunderworld.nongjik.domain.Professional;

public class ProfessionalModel {
	private long id;
	private UserModel userModel;
	private String businessNo;
	private String createdAt;
	private String updatedAt;
	
	public ProfessionalModel() {
		super();
	}

	public ProfessionalModel(long id, UserModel userModel, String businessNo, String createdAt, String updatedAt) {
		super();
		this.id = id;
		this.userModel = userModel;
		this.businessNo = businessNo;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
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
	
	public Professional buildDomain() {
		Professional professional = new Professional();
		professional.setId(id);
		professional.setUser(userModel.buildDomain());
		professional.setBusinessNo(businessNo);
		professional.setCreatedAt(createdAt);
		professional.setUpdatedAt(updatedAt);
		return professional;
	}

	public void buildModel(Professional professional) { 
		id = professional.getId();
		UserModel user = new UserModel();
		user.buildModel(professional.getUser());
		userModel = user;
		businessNo = professional.getBusinessNo();
		createdAt = professional.getCreatedAt();
		updatedAt = professional.getUpdatedAt();
	}

	
}
