package com.djunderworld.nongjik.model;

import java.util.ArrayList;
import java.util.List;

import com.djunderworld.nongjik.domain.Category;
import com.djunderworld.nongjik.domain.ItemCategory;

public class CategoryModel extends BaseModel {
	private String name;

	private List<ItemCategoryModel> itemCategoryModels = new ArrayList<ItemCategoryModel>();

	public CategoryModel() {
		super();
	}

	public CategoryModel(String name, List<ItemCategoryModel> itemCategoryModels) {
		super();
		this.name = name;
		this.itemCategoryModels = itemCategoryModels;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ItemCategoryModel> getItemCategoryModels() {
		return itemCategoryModels;
	}

	public void setItemCategoryModels(List<ItemCategoryModel> itemCategoryModels) {
		this.itemCategoryModels = itemCategoryModels;
	}

	public Category buildDomain() {
		Category category = new Category();
		category.setId(getId());
		category.setName(name);
		category.setCreatedAt(getCreatedAt());
		category.setUpdatedAt(getUpdatedAt());

		List<ItemCategory> itemCategories = new ArrayList<ItemCategory>();

		for (ItemCategoryModel model : itemCategoryModels) {
			ItemCategory itemCategory = model.buildDomainForBackRef();
			itemCategories.add(itemCategory);
		}
		category.setItemCategories(itemCategories);

		return category;
	}

	public void buildModel(Category category) {
		setId(category.getId());
		name = category.getName();
		setCreatedAt(category.getCreatedAt());
		setUpdatedAt(category.getUpdatedAt());

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
