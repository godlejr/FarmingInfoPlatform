package com.djunderworld.nongjik.model;

import com.djunderworld.nongjik.domain.Professional;

public class ProfessionalModel extends BaseModel {
	private UserModel userModel;
	private String businessNo;
	private String phone;
	private String homepage;
	private String address;
	private String subAddress;
	private String intro;
	private String postCode;
	private String sidoCode;
	private String sigunguCode;
	private String sido;
	private String sigungu;

	public ProfessionalModel() {
		super();
	}

	public ProfessionalModel(UserModel userModel, String businessNo, String phone, String homepage, String address,
			String subAddress, String intro, String postCode, String sidoCode, String sigunguCode, String sido,
			String sigungu) {
		super();
		this.userModel = userModel;
		this.businessNo = businessNo;
		this.phone = phone;
		this.homepage = homepage;
		this.address = address;
		this.subAddress = subAddress;
		this.intro = intro;
		this.postCode = postCode;
		this.sidoCode = sidoCode;
		this.sigunguCode = sigunguCode;
		this.sido = sido;
		this.sigungu = sigungu;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSubAddress() {
		return subAddress;
	}

	public void setSubAddress(String subAddress) {
		this.subAddress = subAddress;
	}

	public String getIntro() {
		return intro;
	}

	public void setInro(String intro) {
		this.intro = intro;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getSidoCode() {
		return sidoCode;
	}

	public void setSidoCode(String sidoCode) {
		this.sidoCode = sidoCode;
	}

	public String getSigunguCode() {
		return sigunguCode;
	}

	public void setSigunguCode(String sigunguCode) {
		this.sigunguCode = sigunguCode;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getSigungu() {
		return sigungu;
	}

	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}

	public Professional buildDomain() {
		Professional professional = new Professional();
		professional.setId(getId());
		professional.setUser(userModel.buildDomain());
		professional.setBusinessNo(businessNo);
		professional.setPhone(phone);
		professional.setHomepage(homepage);
		professional.setAddress(address);
		professional.setSubAddress(subAddress);
		professional.setIntro(intro);
		professional.setPostCode(postCode);
		professional.setSidoCode(sidoCode);
		professional.setSigunguCode(sigunguCode);
		professional.setSido(sido);
		professional.setSigungu(sigungu);
		professional.setCreatedAt(getCreatedAt());
		professional.setUpdatedAt(getUpdatedAt());
		return professional;
	}

	public void buildModel(Professional professional) {
		setId(professional.getId());
		UserModel user = new UserModel();
		user.buildModel(professional.getUser());
		userModel = user;
		businessNo = professional.getBusinessNo();
		phone = professional.getPhone();
		homepage = professional.getHomepage();
		address = professional.getAddress();
		subAddress = professional.getSubAddress();
		intro = professional.getIntro();
		postCode = professional.getPostCode();
		sidoCode = professional.getSidoCode();
		sigunguCode = professional.getSigunguCode();
		sido = professional.getSido();
		sigungu = professional.getSigungu();
		setCreatedAt(professional.getCreatedAt());
		setUpdatedAt(professional.getUpdatedAt());
	}

}
