package com.djunderworld.nongjik.main.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.djunderworld.nongjik.main.service.MainService;
import com.djunderworld.nongjik.repository.user.UserRepository;

@Controller
public class MainController {

	@Autowired
	private MainService mainService;

	@Autowired
	private UserRepository userRepository;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {


		System.out.println(userRepository.findById(1).getName());


		return "home";
	}

}
