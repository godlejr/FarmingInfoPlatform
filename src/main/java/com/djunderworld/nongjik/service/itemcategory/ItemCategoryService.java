package com.djunderworld.nongjik.service.itemcategory;

import java.util.List;

import com.djunderworld.nongjik.entity.ItemCategory;

public interface ItemCategoryService {

	List<ItemCategory> getItemCategoriesByCategoryId(long categoryId) throws Exception;

}
