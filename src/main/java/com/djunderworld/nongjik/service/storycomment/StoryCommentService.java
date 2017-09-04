package com.djunderworld.nongjik.service.storycomment;

import java.util.List;

import com.djunderworld.nongjik.dto.StoryCommentDto;
import com.djunderworld.nongjik.entity.StoryComment;

public interface StoryCommentService {

	List<StoryComment> getStoryCommentsByStoryIdAndPageRequests(long storyId, int page, int limit) throws Exception;

	List<StoryCommentDto> getStoryCommentDtosByStoryIdAndPageRequests(long storyId, int page, int limit)
			throws Exception;

	StoryCommentDto getStoryCommentDtoByInsertingStoryComment(StoryComment storyComment) throws Exception;

}
