package com.djunderworld.nongjik.service.story;

import java.util.List;

import com.djunderworld.nongjik.dto.StoryDto;
import com.djunderworld.nongjik.entity.Story;


public interface StoryService {
	
	List<Story> getStoriesWithPageRequest(long categoryId, long itemCategoryId, int orderId, int userLevel ,int page, int limit) throws Exception;

	List<StoryDto> getStoryDtosWithPageRequest(long categoryId, long itemCategoryId, int orderId, int userLevel ,int page, int limit) throws Exception;

}
