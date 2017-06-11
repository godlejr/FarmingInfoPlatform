package com.djunderworld.nongjik.main.controller;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.djunderworld.nongjik.common.flag.UserLevelFlag;
import com.djunderworld.nongjik.domain.Category;
import com.djunderworld.nongjik.main.service.MainService;
import com.djunderworld.nongjik.model.CategoryModel;
import com.djunderworld.nongjik.model.UserModel;

@Controller
public class MainController {

	@Autowired
	private MainService mainService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		List<Category> categories = mainService.selectCategories();
		List<CategoryModel> categoryModels = convert(categories);

		model.addAttribute("categories", categoryModels);
		return "main/index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, HttpSession session, @RequestParam(required = false) boolean isJoined)
			throws Exception {
		UserModel userModel = new UserModel();
		model.addAttribute("user", userModel);

		if (isJoined) {
			model.addAttribute("message", "회원가입이 완료되었습니다.");
			model.addAttribute("isJoined", isJoined);
		}

		return "main/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("user") UserModel userModel, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model, HttpSession session) throws Exception {

		String page = mainService.selectLogin(userModel.buildDomain(), model, session);
		return page;
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Model model) throws Exception {
		UserModel userModel = new UserModel();
		model.addAttribute("user", userModel);

		return "main/join";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute("user") @Valid UserModel userModel, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) throws Exception {
		
		if (bindingResult.hasErrors()) {
			boolean isValid = false;

			if (userModel.getLevel() == UserLevelFlag.USER) {
				List<ObjectError> errors = bindingResult.getAllErrors();
				int errorSize = errors.size();
				if (errorSize == 1 && errors.get(0) instanceof FieldError) {
					FieldError fieldError = (FieldError) errors.get(0);
					if (fieldError.getField().equals("businessNo")) {
						isValid = true;
					} 
				}
			}
			
			if(!isValid){
				return "main/join";
			}
		}

		mainService.insertUser(userModel.buildDomain());
		redirectAttributes.addAttribute("isJoined", true);

		return "redirect:/login";
	}

	private List<CategoryModel> convert(List<Category> categories) throws Exception {
		List<CategoryModel> categoryModels = new ArrayList<CategoryModel>();
		for (Category category : categories) {
			CategoryModel categoryModel = new CategoryModel();
			categoryModel.buildModel(category);
			categoryModels.add(categoryModel);
		}
		return categoryModels;
	}

}
