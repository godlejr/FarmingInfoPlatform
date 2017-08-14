package com.djunderworld.nongjik.controller.story;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.djunderworld.nongjik.common.annotation.LoginRequired;
import com.djunderworld.nongjik.entity.Story;
import com.djunderworld.nongjik.service.story.StoryService;

@Controller
@RequestMapping("/stories")
public class StoryController {
	@Autowired
	private StoryService storyService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable long id, Model model, HttpSession session) throws Exception {
		Story story = storyService.getStoryById(id);
		
		model.addAttribute("story", story);
		return "story/detail";
	}
}
