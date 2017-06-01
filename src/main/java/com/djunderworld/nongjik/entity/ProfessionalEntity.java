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
	@JoinColumn(name = "id")
	private UserEntity userEntity;

	private String businessNo;

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

	public Professional buildDomain() {
		Professional professional = new Professional();
		professional.setId(super.getId());
		professional.setUser(userEntity.buildDomain());
		professional.setBusinessNo(businessNo);
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

		super.setCreatedAt(professional.getCreatedAt());
		super.setUpdatedAt(professional.getUpdatedAt());
	}

}
