package com.djunderworld.nongjik.controller.story;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.djunderworld.nongjik.common.flag.PaginationFlag;
import com.djunderworld.nongjik.dto.StoryCommentDto;
import com.djunderworld.nongjik.entity.Story;
import com.djunderworld.nongjik.entity.StoryComment;
import com.djunderworld.nongjik.entity.User;
import com.djunderworld.nongjik.service.story.StoryService;
import com.djunderworld.nongjik.service.storycomment.StoryCommentService;

@Controller
@RequestMapping("/stories")
public class StoryController {
	@Autowired
	private StoryService storyService;

	@Autowired
	private StoryCommentService storyCommentService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable long id, Model model, HttpSession session) throws Exception {
		Story story = storyService.getStoryById(id);
		List<StoryComment> storyComments = storyCommentService.getStoryCommentsByStoryIdAndPageRequests(id, 0,
				PaginationFlag.STORY_COMMENT_MAX_LIMIT);

		User user = (User) session.getAttribute("user");

		boolean isLiked = false;
		boolean isScraped = false;
		boolean isFollowed = false;

		if (user != null) {
			long userId = user.getId();
			long storyUserId = story.getUser().getId();
			isLiked = storyService.isLikedByIdAndUserId(id, userId);
			isScraped = storyService.isScrapedByIdAndUserId(id, userId);
			isFollowed = storyService.isFollowedByStoryUserIdAndUserId(storyUserId, userId);
		}

		model.addAttribute("story", story);
		model.addAttribute("storyComments", storyComments);
		model.addAttribute("isLiked", isLiked);
		model.addAttribute("isScraped", isScraped);
		model.addAttribute("isFollowed", isFollowed);

		return "story/detail";
	}

	@RequestMapping(value = "/{id}/like", method = RequestMethod.POST)
	@ResponseBody
	public Integer like(@PathVariable long id, @RequestParam("userId") long userId,
			@RequestParam("storyUserId") long storyUserId) throws Exception {
		return storyService.getLikeCountSavedOrDeletedByIdAndUserIdAndStoryUserId(id, userId, storyUserId);
	}

	@RequestMapping(value = "/{id}/scrap", method = RequestMethod.POST)
	@ResponseBody
	public void scrap(@PathVariable long id, @RequestParam("userId") long userId,
			@RequestParam("storyUserId") long storyUserId) throws Exception {
		storyService.saveOrDeleteStoryScrapByIdAndUserIdAndStoryUserId(id, userId, storyUserId);
	}

	@RequestMapping(value = "/{id}/comments.json", method = RequestMethod.GET)
	@ResponseBody
	public List<StoryCommentDto> storyCommentDtos(@PathVariable long id,
			@RequestParam(name = "page", required = false, defaultValue = "0") int page) throws Exception {

		return storyCommentService.getStoryCommentDtosByStoryIdAndPageRequests(id, page,
				PaginationFlag.STORY_COMMENT_MAX_LIMIT);
	}

}
