package com.djunderworld.nongjik.service.story;

import java.util.List;

import com.djunderworld.nongjik.entity.Story;


public interface StoryService {
	List<Story> getStoriesWithPageRequest(int firstPageNo, int limit) throws Exception;
}
