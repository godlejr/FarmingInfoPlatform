package com.djunderworld.nongjik.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.djunderworld.nongjik.domain.Professional;

@Entity
@Table(name = "professionals")
public class ProfessionalEntity extends BaseEntity {
	@OneToOne
	@JoinColumn(name = "user_id")
	private UserEntity userEntity;

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

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
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

	public Professional buildDomain() {
		Professional professional = new Professional();
		professional.setId(super.getId());
		professional.setUser(userEntity.buildDomain());
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
		professional.setCreatedAt(super.getCreatedAt());
		professional.setUpdatedAt(super.getUpdatedAt());

		return professional;
	}

	public void buildEntity(Professional professional) {
		super.setId(professional.getId());

		UserEntity user = new UserEntity();
		user.buildEntity(professional.getUser());

		userEntity = user;
		businessNo = professional.getBusinessNo();
		phone = professional.getPhone();
		homepage = professional.getHomepage();
		address = professional.getAddress();
		subAddress = professional.getSubAddress();
		intro = professional.getIntro();
		postCode = professional.getPostCode();
		sidoCode = professional.getSidoCode();
		sigunguCode= professional.getSigunguCode();
		sido = professional.getSido();
		sigungu = professional.getSigungu();

		super.setCreatedAt(professional.getCreatedAt());
		super.setUpdatedAt(professional.getUpdatedAt());
	}

}
