package com.djunderworld.nongjik.domain;

public class ItemCategory {

	private long id;
	private Category category;
	private String name;
	private String createdAt;
	private String updatedAt;

	public ItemCategory() {
		super();
	}

	public ItemCategory(long id, Category category, String name, String createdAt, String updatedAt) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
