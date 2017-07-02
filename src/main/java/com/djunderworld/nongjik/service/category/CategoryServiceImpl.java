package com.djunderworld.nongjik.service.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.djunderworld.nongjik.entity.Category;
import com.djunderworld.nongjik.repository.category.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Override
	public List<Category> getCategories() throws Exception {
		return categoryRepository.findAll();
	}

}
