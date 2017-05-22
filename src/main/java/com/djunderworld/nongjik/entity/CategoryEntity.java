package com.djunderworld.nongjik.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.djunderworld.nongjik.domain.Category;
import com.djunderworld.nongjik.domain.User;

@Entity
@Table(name = "categories")
public class CategoryEntity {
	
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String createdAt;
	private String updatedAt;
	
	
	public CategoryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryEntity(long id, String name, String createdAt, String updatedAt) {
		super();
		this.id = id;
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
	
	public Category buildDomain() {
		Category category = new Category();
		category.setId(id);
		category.setName(name);
		category.setCreatedAt(createdAt);
		category.setUpdatedAt(updatedAt);
		return category;
	}

	public void buildEntity(Category category) { 
		id = category.getId();
		name = category.getName();
		createdAt = category.getCreatedAt();
		updatedAt = category.getUpdatedAt();
	}
	
	
}
