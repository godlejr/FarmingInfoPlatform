package com.djunderworld.nongjik.domain;

public class Professional extends Base {
	private User user;
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

	public Professional() {
		super();
	}

	
	public Professional(User user, String businessNo, String phone, String homepage, String address, String subAddress,
			String intro, String postCode, String sidoCode, String sigunguCode, String sido, String sigungu) {
		super();
		this.user = user;
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

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public void setIntro(String intro) {
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

}
