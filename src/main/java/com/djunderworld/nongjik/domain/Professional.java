package com.djunderworld.nongjik.domain;

public class Professional {
	private long id;
	private User user;
	private String businessNo;
	private String createdAt;
	private String updatedAt;

	public Professional() {
		super();
	}

	public Professional(long id, String businessNo, String createdAt, String updatedAt) {
		super();
		this.id = id;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
