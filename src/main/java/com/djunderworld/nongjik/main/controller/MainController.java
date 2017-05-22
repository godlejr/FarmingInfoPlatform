package com.djunderworld.nongjik.main.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.djunderworld.nongjik.domain.Category;
import com.djunderworld.nongjik.main.service.MainService;
import com.djunderworld.nongjik.model.CategoryModel;

@Controller
public class MainController {

	@Autowired
	private MainService mainService;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<Category> categories = mainService.selectCategories();
		List<CategoryModel> categoryModels = convert(categories);
		
		model.addAttribute("categories", categoryModels);
		return "main/index";
	}
	
	
	private List<CategoryModel> convert(List<Category> categories ) {
		List<CategoryModel> categoryModels = new ArrayList<CategoryModel>();
		for(Category category : categories) {
			CategoryModel categoryModel = new CategoryModel();
			categoryModel.buildModel(category);
			categoryModels.add(categoryModel);
		}
		return categoryModels;
	}

}
