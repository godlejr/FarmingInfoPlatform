package com.djunderworld.nongjik.model;

import com.djunderworld.nongjik.domain.ItemCategory;

public class ItemCategoryModel extends BaseModel {

	private CategoryModel categoryModel;
	private String name;

	public ItemCategoryModel() {
		super();
	}

	public ItemCategoryModel(CategoryModel categoryModel, String name) {
		super();
		this.categoryModel = categoryModel;
		this.name = name;
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

	public ItemCategory buildDomainForBackRef() {
		ItemCategory itemCategory = new ItemCategory();
		itemCategory.setId(getId());
		itemCategory.setName(name);
		itemCategory.setCreatedAt(getCreatedAt());
		itemCategory.setUpdatedAt(getUpdatedAt());
		return itemCategory;
	}

	public ItemCategory buildDomain() {
		ItemCategory itemCategory = new ItemCategory();

		itemCategory.setId(getId());
		itemCategory.setCategory(categoryModel.buildDomain());
		itemCategory.setName(name);
		itemCategory.setCreatedAt(getCreatedAt());
		itemCategory.setUpdatedAt(getUpdatedAt());
		return itemCategory;
	}

	public void buildModelForBackRef(ItemCategory itemCategory) {
		setId(itemCategory.getId());
		name = itemCategory.getName();
		setCreatedAt(itemCategory.getCreatedAt());
		setUpdatedAt(itemCategory.getUpdatedAt());
	}

	public void buildModel(ItemCategory itemCategory) {
		setId(itemCategory.getId());
		CategoryModel category = new CategoryModel();
		category.buildModel(itemCategory.getCategory());
		categoryModel = category;
		name = itemCategory.getName();
		setCreatedAt(itemCategory.getCreatedAt());
		setUpdatedAt(itemCategory.getUpdatedAt());
	}

}
