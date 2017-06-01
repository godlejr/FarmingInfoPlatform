package com.djunderworld.nongjik.model;

import com.djunderworld.nongjik.domain.ItemCategory;

public class ItemCategoryModel {

	private long id;
	private CategoryModel categoryModel;
	private String name;
	private String createdAt;
	private String updatedAt;

	public ItemCategoryModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemCategoryModel(long id, CategoryModel categoryModel, String name, String createdAt, String updatedAt) {
		super();
		this.id = id;
		this.categoryModel = categoryModel;
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

	public CategoryModel getCategory() {
		return categoryModel;
	}

	public void setCategoryModel(CategoryModel categoryModel) {
		this.categoryModel = categoryModel;
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

	public ItemCategory buildDomainForBackRef() {
		ItemCategory itemCategory = new ItemCategory();
		itemCategory.setId(id);
		itemCategory.setName(name);
		itemCategory.setCreatedAt(createdAt);
		itemCategory.setUpdatedAt(updatedAt);
		return itemCategory;
	}

	
	public ItemCategory buildDomain() {
		ItemCategory itemCategory = new ItemCategory();
		
		itemCategory.setId(id);
		itemCategory.setCategory(categoryModel.buildDomain());
		itemCategory.setName(name);
		itemCategory.setCreatedAt(createdAt);
		itemCategory.setUpdatedAt(updatedAt);
		return itemCategory;
	}

	public void buildModelForBackRef(ItemCategory itemCategory) { 
		id = itemCategory.getId();
		name = itemCategory.getName();
		createdAt = itemCategory.getCreatedAt();
		updatedAt = itemCategory.getUpdatedAt();
	}
	
	
	public void buildModel(ItemCategory itemCategory) { 
		id = itemCategory.getId();
		CategoryModel category = new CategoryModel();
		category.buildModel(itemCategory.getCategory());
		categoryModel = category;
		name = itemCategory.getName();
		createdAt = itemCategory.getCreatedAt();
		updatedAt = itemCategory.getUpdatedAt();
	}

}
