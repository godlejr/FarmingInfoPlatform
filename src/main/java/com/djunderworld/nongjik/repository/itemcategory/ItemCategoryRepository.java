package com.djunderworld.nongjik.repository.itemcategory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.djunderworld.nongjik.entity.ItemCategory;

public interface ItemCategoryRepository extends JpaRepository<ItemCategory, Long> {

	List<ItemCategory> findByCategoryId(long categoryId);

}
