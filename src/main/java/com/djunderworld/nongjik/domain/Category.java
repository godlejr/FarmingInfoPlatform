package com.djunderworld.nongjik.domain;

import java.util.ArrayList;
import java.util.List;

public class Category extends Base{
	private String name;


	private List<ItemCategory> itemCategories = new ArrayList<ItemCategory>();

	public Category() {
		super();
	}

	
	
	public Category(String name, List<ItemCategory> itemCategories) {
		super();
		this.name = name;
		this.itemCategories = itemCategories;
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



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public List<ItemCategory> getItemCategories() {
		return itemCategories;
	}

	public void setItemCategories(List<ItemCategory> itemCategories) {
		this.itemCategories = itemCategories;
	}

}
