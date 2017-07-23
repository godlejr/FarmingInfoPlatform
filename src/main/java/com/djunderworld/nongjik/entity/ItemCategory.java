package com.djunderworld.nongjik.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "item_categories")
public class ItemCategory extends Base {

	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonManagedReference
	private Category category;
	private String name;

	@OneToMany(mappedBy = "itemCategory", fetch = FetchType.LAZY)
	@JsonBackReference
	private List<Story> stories = new ArrayList<Story>();

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		if (this.category != null) {
			this.category.getItemCategories().remove(this);
		}

		this.category = category;
		this.category.getItemCategories().add(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Story> getStories() {
		return stories;
	}

	public void setStories(List<Story> stories) {
		this.stories = stories;
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
	public String getCreatedAt() {
		return super.getCreatedAt();
	}

	@Override
	public void setCreatedAt(String createdAt) {
		super.setCreatedAt(createdAt);
	}

	@Override
	public String getUpdatedAt() {
		return super.getUpdatedAt();
	}

	@Override
	public void setUpdatedAt(String updatedAt) {
		super.setUpdatedAt(updatedAt);
	}

}
