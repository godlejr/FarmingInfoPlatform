package com.djunderworld.nongjik.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.djunderworld.nongjik.domain.ItemCategory;

@Entity
@Table(name = "item_categories")
public class ItemCategoryEntity extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryEntity categoryEntity;
	private String name;

	@OneToMany(mappedBy = "itemCategoryEntity", fetch = FetchType.LAZY)
	private List<StoryEntity> storyEntities = new ArrayList<StoryEntity>();

	public CategoryEntity getCategoryEntity() {
		return categoryEntity;
	}

	public void setCategoryEntity(CategoryEntity categoryEntity) {
		if (this.categoryEntity != null) {
			this.categoryEntity.getItemCategoryEntities().remove(this);
		}

		this.categoryEntity = categoryEntity;
		this.categoryEntity.getItemCategoryEntities().add(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StoryEntity> getStoryEntities() {
		return storyEntities;
	}

	public void setStoryEntities(List<StoryEntity> storyEntities) {
		this.storyEntities = storyEntities;
	}

	public ItemCategory buildDomainForBackRef() {
		ItemCategory itemCategory = new ItemCategory();
		itemCategory.setId(super.getId());
		itemCategory.setName(name);
		itemCategory.setCreatedAt(super.getCreatedAt());
		itemCategory.setUpdatedAt(super.getUpdatedAt());

		return itemCategory;
	}

	public ItemCategory buildDomain() {
		ItemCategory itemCategory = new ItemCategory();
		itemCategory.setId(super.getId());
		itemCategory.setCategory(categoryEntity.buildDomain());
		itemCategory.setName(name);
		itemCategory.setCreatedAt(super.getCreatedAt());
		itemCategory.setUpdatedAt(super.getUpdatedAt());

		return itemCategory;
	}

	public void buildEntityForBackRef(ItemCategory itemCategory) {
		super.setId(itemCategory.getId());
		this.name = itemCategory.getName();
		super.setCreatedAt(itemCategory.getCreatedAt());
		super.setUpdatedAt(itemCategory.getUpdatedAt());
	}

	public void buildEntity(ItemCategory itemCategory) {
		super.setId(itemCategory.getId());

		CategoryEntity category = new CategoryEntity();
		category.buildEntity(itemCategory.getCategory());

		this.categoryEntity = category;
		this.name = itemCategory.getName();
		super.setCreatedAt(itemCategory.getCreatedAt());
		super.setUpdatedAt(itemCategory.getUpdatedAt());
	}

}
