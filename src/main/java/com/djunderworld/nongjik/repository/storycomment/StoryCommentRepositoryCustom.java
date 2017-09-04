package com.djunderworld.nongjik.repository.storycomment;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.djunderworld.nongjik.entity.StoryComment;

public interface StoryCommentRepositoryCustom {
	List<StoryComment> findAllByStoryIdAndPageRequests(long storyId, PageRequest pageRequest) throws Exception;

	long findMaxGroupId() throws Exception;

	long findMaxPositionByGroupId(long groupId) throws Exception;
}
