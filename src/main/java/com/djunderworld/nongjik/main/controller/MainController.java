package com.djunderworld.nongjik.main.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.djunderworld.nongjik.domain.Category;
import com.djunderworld.nongjik.domain.User;
import com.djunderworld.nongjik.main.service.MainService;
import com.djunderworld.nongjik.model.CategoryModel;
import com.djunderworld.nongjik.model.UserModel;

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
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		UserModel userModel = new UserModel();
		model.addAttribute("user",userModel);
	
		return "main/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("user") @Valid UserModel userModel,BindingResult result, Model model) {

		return "main/login";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join( Model model) {
		UserModel userModel = new UserModel();
		model.addAttribute("user",userModel);
		
		return "main/join";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute("user") @Valid UserModel userModel,BindingResult result, Model model) {
	
		return "main/join";
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
