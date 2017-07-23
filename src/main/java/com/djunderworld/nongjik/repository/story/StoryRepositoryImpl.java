package com.djunderworld.nongjik.repository.story;

import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import com.djunderworld.nongjik.entity.QStory;
import com.djunderworld.nongjik.entity.Story;
import com.mysema.query.SearchResults;

public class StoryRepositoryImpl extends QueryDslRepositorySupport implements CustomStoryRepository {

	public StoryRepositoryImpl() {
		super(Story.class);
	}

	@Override
	public List<Story> findAllByPageRequest(PageRequest pageRequest) {
		int size = pageRequest.getPageSize();
		int offset = pageRequest.getOffset();
		
		
		QStory story = QStory.story;
		SearchResults<Story> searchResults = from(story).orderBy(story.updatedAt.desc()).offset(offset).limit(size).
				listResults(story);
		
		List<Story> stories = searchResults.getTotal() > offset  ? searchResults.getResults() : Collections.<Story> emptyList();
		return stories;
	}

}
