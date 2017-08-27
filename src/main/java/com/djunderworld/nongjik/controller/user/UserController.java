package com.djunderworld.nongjik.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.djunderworld.nongjik.service.user.UserService;

@Controller
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/{id}/follow", method = RequestMethod.POST)
	@ResponseBody
	public void follow(@PathVariable long id, @RequestParam("userId") long userId, @RequestParam("storyUserId") long storyUserId) throws Exception{
		userService.saveOrDeleteUserFollowerByIdAndUserIdAndStoryUserId(id, userId, storyUserId);
	}
}
