package com.djunderworld.nongjik.service.storycomment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.djunderworld.nongjik.dto.StoryCommentDto;
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
		return storyCommentRepository.findAllByStoryIdAndPageRequests(storyId, pageRequest);
	}

	@Override
	public List<StoryCommentDto> getStoryCommentDtosByStoryIdAndPageRequests(long storyId, int page, int limit)
			throws Exception {
		PageRequest pageRequest = new PageRequest(page, limit);
		List<StoryComment> storyComments = storyCommentRepository.findAllByStoryIdAndPageRequests(storyId, pageRequest);

		List<StoryCommentDto> storyCommentDtos = new ArrayList<StoryCommentDto>();

		for (StoryComment storyComment : storyComments) {
			StoryCommentDto storyCommentDto = new StoryCommentDto();
			storyCommentDto.buildDto(storyComment);
			storyCommentDtos.add(storyCommentDto);
		}

		return storyCommentDtos;
	}

	@Override
	public StoryCommentDto getStoryCommentDtoByInsertingStoryComment(StoryComment storyComment) throws Exception {
		long depth = storyComment.getDepth();

		if (depth == 0) {
			long groupId = storyCommentRepository.findMaxGroupId() + 1;
			storyComment.setGroupId(groupId);

		} else {
			long groupId = storyComment.getGroupId();
			long position = storyCommentRepository.findMaxPositionByGroupId(groupId) + 1;
			storyComment.setPosition(position);

		}
		storyComment = storyCommentRepository.saveAndFlush(storyComment);
		
		StoryCommentDto storyCommentDto = new StoryCommentDto();
		storyCommentDto.buildDto(storyComment);
		return storyCommentDto;
	}

}
