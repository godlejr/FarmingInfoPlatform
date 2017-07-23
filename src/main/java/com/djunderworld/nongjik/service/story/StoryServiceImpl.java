package com.djunderworld.nongjik.service.story;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.djunderworld.nongjik.dto.StoryDto;
import com.djunderworld.nongjik.entity.Story;
import com.djunderworld.nongjik.repository.story.StoryRepository;

@Service
@Transactional
public class StoryServiceImpl implements StoryService {

	@Autowired
	private StoryRepository storyRepository;

	@Override
	public List<Story> getStoriesWithPageRequest(long categoryId, long itemCategoryId, int orderId, int userLevel,
			int page, int limit) throws Exception {
		PageRequest pageRequest = new PageRequest(page, limit);
		List<Story> stories = storyRepository.findAllByPageRequest(pageRequest);

		return stories;
	}

	@Override
	public List<StoryDto> getStoryDtosWithPageRequest(long categoryId, long itemCategoryId, int orderId, int userLevel,
			int page, int limit) throws Exception {
		PageRequest pageRequest = new PageRequest(page, limit);
		List<Story> stories = storyRepository.findAllByPageRequest(pageRequest);

		List<StoryDto> storyDtos = new ArrayList<StoryDto>();

		for (Story story : stories) {
			StoryDto storyDto = new StoryDto();
			storyDto.buildDto(story);
			storyDtos.add(storyDto);
		}

		return storyDtos;
	}

}
