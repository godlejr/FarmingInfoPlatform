package com.djunderworld.nongjik.service.story;

import java.util.List;

import com.djunderworld.nongjik.dto.StoryDto;
import com.djunderworld.nongjik.entity.Story;

public interface StoryService {

	List<Story> getStoriesByPageRequests(long categoryId, long itemCategoryId, int orderId, int userLevel,
			String search, int page, int limit) throws Exception;

	List<StoryDto> getStoryDtosByPageRequests(long categoryId, long itemCategoryId, int orderId, int userLevel,
			String search, int page, int limit) throws Exception;

	Story getStoryById(long id) throws Exception;
}
