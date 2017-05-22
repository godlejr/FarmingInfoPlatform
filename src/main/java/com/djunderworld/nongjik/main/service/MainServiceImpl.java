package com.djunderworld.nongjik.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.djunderworld.nongjik.domain.Category;
import com.djunderworld.nongjik.entity.CategoryEntity;
import com.djunderworld.nongjik.repository.category.CategoryRepository;
import com.djunderworld.nongjik.repository.user.UserRepository;

@Service
public class MainServiceImpl implements MainService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> selectCategories() {
		List<Category> categories = new ArrayList<Category>();
		List<CategoryEntity> categoryEntities = categoryRepository.findAll();
		
		for(CategoryEntity entity : categoryEntities) {
			Category category = entity.buildDomain();
			categories.add(category);
		}
			
		return categories;
	}
	
	
}
