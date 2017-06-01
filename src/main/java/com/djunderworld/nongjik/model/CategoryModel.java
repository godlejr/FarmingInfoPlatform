package com.djunderworld.nongjik.model;

import java.util.ArrayList;
import java.util.List;

import com.djunderworld.nongjik.domain.Category;
import com.djunderworld.nongjik.domain.ItemCategory;

public class CategoryModel {
	private long id;
	private String name;
	private String createdAt;
	private String updatedAt;
	
	private List<ItemCategoryModel> itemCategoryModels = new ArrayList<ItemCategoryModel>();


	public CategoryModel(long id, String name, String createdAt, String updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public CategoryModel() {
		super();
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

	public List<ItemCategoryModel> getItemCategoryModels() {
		return itemCategoryModels;
	}

	public void setItemCategoryModels(List<ItemCategoryModel> itemCategoryModels) {
		this.itemCategoryModels = itemCategoryModels;
	}
	
	public Category buildDomain() {
		Category category = new Category();
		category.setId(id);
		category.setName(name);
		category.setCreatedAt(createdAt);
		category.setUpdatedAt(updatedAt);
		
		List<ItemCategory> itemCategories = new ArrayList<ItemCategory>();

		for (ItemCategoryModel model : itemCategoryModels) {
			ItemCategory itemCategory = model.buildDomainForBackRef();
			itemCategories.add(itemCategory);
		}
		category.setItemCategories(itemCategories);
		
		return category;
	}

	public void buildModel(Category category) {
		id = category.getId();
		name = category.getName();
		createdAt = category.getCreatedAt();
		updatedAt = category.getUpdatedAt();
		
		List<ItemCategoryModel> itemCategoryModels = new ArrayList<ItemCategoryModel>();
		List<ItemCategory> itemCategories = category.getItemCategories();
		
		for (ItemCategory itemCategory : itemCategories) {
			ItemCategoryModel itemCategoryModel = new ItemCategoryModel();
			itemCategoryModel.buildModelForBackRef(itemCategory);
			itemCategoryModels.add(itemCategoryModel);
		}
		this.itemCategoryModels = itemCategoryModels;
	}

}
