package com.djunderworld.nongjik.service.itemcategory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.djunderworld.nongjik.entity.ItemCategory;
import com.djunderworld.nongjik.repository.itemcategory.ItemCategoryRepository;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService{
	
	@Autowired
	private ItemCategoryRepository itemCategoryRepository;

	@Override
	public List<ItemCategory> getItemCategoriesByCategoryId(long categoryId) throws Exception {
		return itemCategoryRepository.findByCategoryId(categoryId);
	}
	
	
}
