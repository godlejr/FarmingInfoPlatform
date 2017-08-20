package com.djunderworld.nongjik.repository.storycomment;

import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import com.djunderworld.nongjik.entity.QStoryComment;
import com.djunderworld.nongjik.entity.StoryComment;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.SearchResults;

public class StoryCommentRepositoryImpl  extends QueryDslRepositorySupport implements StoryCommentRepositoryCustom{

	public StoryCommentRepositoryImpl() {
		super(StoryComment.class);
	}

	@Override
	public List<StoryComment> findAllByStoryIdAndPageRequests(long storyId, PageRequest pageRequest) throws Exception {

		int size = pageRequest.getPageSize();
		int offset = pageRequest.getOffset();

		QStoryComment storyComment = QStoryComment.storyComment;

		BooleanBuilder booleanBuilder = new BooleanBuilder();
		booleanBuilder.and(storyComment.story.id.eq(storyId));
		
		SearchResults<StoryComment> searchResults = from(storyComment).where(booleanBuilder).orderBy(storyComment.groupId.desc(),storyComment.depth.asc()).offset(offset)
				.limit(size).listResults(storyComment);

		List<StoryComment> storyComments = searchResults.getTotal() > offset ? searchResults.getResults()
				: Collections.<StoryComment>emptyList();
		
		return storyComments;
	}

}
