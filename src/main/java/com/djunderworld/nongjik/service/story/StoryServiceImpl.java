package com.djunderworld.nongjik.service.story;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.djunderworld.nongjik.entity.Story;
import com.djunderworld.nongjik.repository.story.StoryRepository;

@Service
@Transactional
public class StoryServiceImpl implements StoryService{

	@Autowired
	private StoryRepository storyRepository;
	
	@Override
	public List<Story> getStoriesWithPageRequest(int firstPageNo, int limit) throws Exception {
		PageRequest pageRequest = new PageRequest(firstPageNo, limit, new Sort(Direction.DESC,"updatedAt"));
		Page<Story> result = storyRepository.findAll(pageRequest);
		
		return result.getContent();
	}

}
