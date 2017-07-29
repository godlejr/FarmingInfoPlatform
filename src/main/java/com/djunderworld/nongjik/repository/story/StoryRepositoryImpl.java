package com.djunderworld.nongjik.repository.story;

import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import com.djunderworld.nongjik.entity.QStory;
import com.djunderworld.nongjik.entity.Story;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.SearchResults;
import com.mysema.query.types.OrderSpecifier;

public class StoryRepositoryImpl extends QueryDslRepositorySupport implements CustomStoryRepository {

	public StoryRepositoryImpl() {
		super(Story.class);
	}

	@Override
	public List<Story> findAllByPageRequest(long categoryId, long itemCategoryId, int orderId, int userLevel,
			String search, PageRequest pageRequest) {
		int size = pageRequest.getPageSize();
		int offset = pageRequest.getOffset();

		QStory story = QStory.story;
		@SuppressWarnings("rawtypes")
		OrderSpecifier orderSpecifier = story.updatedAt.desc();

		BooleanBuilder booleanBuilder = new BooleanBuilder();

		if (categoryId > 0) {
			booleanBuilder.and(story.itemCategory.category.id.eq(categoryId));
		}

		if (itemCategoryId > 0) {
			booleanBuilder.and(story.itemCategory.id.eq(itemCategoryId));
		}

		if (userLevel > 0) {
			booleanBuilder.and(story.user.level.eq(userLevel));
		}

		if (search != null) {
			booleanBuilder.and((story.title.like("%" + search + "%")).or(story.content.like("%" + search + "%")));
		}

		if (orderId == 1) {
			orderSpecifier = story.storyLikes.size().desc();
		}

		if (orderId == 2) {
			orderSpecifier = story.hits.desc();
		}

		SearchResults<Story> searchResults = from(story).where(booleanBuilder).orderBy(orderSpecifier).offset(offset)
				.limit(size).listResults(story);

		List<Story> stories = searchResults.getTotal() > offset ? searchResults.getResults()
				: Collections.<Story>emptyList();
		return stories;
	}

}
