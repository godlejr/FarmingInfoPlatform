package com.djunderworld.nongjik.service.storycomment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.djunderworld.nongjik.entity.StoryComment;
import com.djunderworld.nongjik.repository.storycomment.StoryCommentRepository;

@Service
public class StoryCommentServiceImpl implements StoryCommentService {
	@Autowired
	private StoryCommentRepository storyCommentRepository;

	@Override
	public List<StoryComment> getStoryCommentsByStoryIdAndPageRequests(long storyId, int page, int limit)
			throws Exception {
		PageRequest pageRequest = new PageRequest(page, limit);
		return storyCommentRepository.findAllByStoryIdAndPageRequests(storyId,pageRequest);
	}
}
