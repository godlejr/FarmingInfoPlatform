package com.djunderworld.nongjik.controller.main;

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
import com.djunderworld.nongjik.entity.Category;
import com.djunderworld.nongjik.entity.Story;
import com.djunderworld.nongjik.entity.User;
import com.djunderworld.nongjik.service.category.CategoryService;
import com.djunderworld.nongjik.service.story.StoryService;
import com.djunderworld.nongjik.service.user.UserService;

@Controller
public class MainController {


	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private StoryService storyService;
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		List<Category> categories = categoryService.getCategories();
		List<Story> stories = storyService.getStoriesWithPageRequest(0, 6);
		
		model.addAttribute("categories", categories);
		model.addAttribute("stories",stories);
		return "main/index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, HttpSession session, @RequestParam(required = false) boolean isJoined)
			throws Exception {
		User user = new User();
		model.addAttribute("user", user);

		if (isJoined) {
			model.addAttribute("message", "회원가입이 완료되었습니다.");
			model.addAttribute("isJoined", isJoined);
		}

		return "main/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("user") User user, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model, HttpSession session) throws Exception {
		String email = user.getEmail();
		String password = user.getPassword();
		String page = "main/login";
		
		user = userService.getUserByEmailAndPassword(email, password);
		
		if(user == null){
			model.addAttribute("message","이메일과 비밀번호를 확인해주세요.");
		}else{
			session.setAttribute("user", user);
			page = "redirect:/";
		}
		return page;
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Model model) throws Exception {
		User user = new User();
		model.addAttribute("user", user);

		return "main/join";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) throws Exception {

		if (bindingResult.hasErrors()) {
			boolean isValid = false;

			if (user.getLevel() == UserLevelFlag.USER) {
				List<ObjectError> errors = bindingResult.getAllErrors();
				int errorSize = errors.size();
				if (errorSize == 1 && errors.get(0) instanceof FieldError) {
					FieldError fieldError = (FieldError) errors.get(0);
					if (fieldError.getField().equals("businessNo")) {
						isValid = true;
					}
				}
			}

			if (!isValid) {
				return "main/join";
			}
		}

		userService.saveUser(user);
		redirectAttributes.addAttribute("isJoined", true);

		return "redirect:/login";
	}


}
