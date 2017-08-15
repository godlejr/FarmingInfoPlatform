package com.djunderworld.nongjik.service.storycomment;

import java.util.List;

import com.djunderworld.nongjik.entity.StoryComment;

public interface StoryCommentService {

	List<StoryComment> getStoryCommentsByStoryIdAndPageRequests(long storyId, int page, int limit) throws Exception;

}
