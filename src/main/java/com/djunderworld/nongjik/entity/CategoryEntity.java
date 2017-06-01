package com.djunderworld.nongjik.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.djunderworld.nongjik.domain.Category;
import com.djunderworld.nongjik.domain.ItemCategory;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {
	private String name;

	@OneToMany(mappedBy = "categoryEntity", fetch = FetchType.EAGER)
	private List<ItemCategoryEntity> itemCategoryEntities = new ArrayList<ItemCategoryEntity>();

	public CategoryEntity() {
		super();
	}

	public CategoryEntity(long id, String name, String createdAt, String updatedAt) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ItemCategoryEntity> getItemCategoryEntities() {
		return itemCategoryEntities;
	}

	public void setItemCategoryEntities(List<ItemCategoryEntity> itemCategoryEntities) {
		this.itemCategoryEntities = itemCategoryEntities;
	}

	public Category buildDomain() {
		Category category = new Category();
		category.setId(super.getId());
		category.setName(name);

		List<ItemCategory> itemCategories = new ArrayList<ItemCategory>();

		for (ItemCategoryEntity entity : itemCategoryEntities) {
			ItemCategory itemCategory = entity.buildDomainForBackRef();
			itemCategories.add(itemCategory);
		}

		category.setItemCategories(itemCategories);

		category.setCreatedAt(super.getCreatedAt());
		category.setUpdatedAt(super.getUpdatedAt());
		return category;
	}

	public void buildEntity(Category category) {
		super.setId(category.getId());

		List<ItemCategoryEntity> itemCategoryEntities = new ArrayList<ItemCategoryEntity>();
		List<ItemCategory> itemCategories = category.getItemCategories();
		
		for (ItemCategory itemCategory : itemCategories) {
			ItemCategoryEntity itemCategoryEntity = new ItemCategoryEntity();
			itemCategoryEntity.buildEntityForBackRef(itemCategory);
			itemCategoryEntities.add(itemCategoryEntity);
		}
		this.itemCategoryEntities = itemCategoryEntities;
		this.name = category.getName();
		super.setCreatedAt(category.getCreatedAt());
		super.setUpdatedAt(category.getUpdatedAt());
	}

}
