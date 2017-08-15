package com.djunderworld.nongjik.repository.storylike;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import com.djunderworld.nongjik.entity.QStoryLike;
import com.djunderworld.nongjik.entity.StoryLike;
import com.mysema.query.types.Predicate;

public class StoryLikeRepositoryImpl extends QueryDslRepositorySupport implements StoryLikeRepositoryCustom {

	public StoryLikeRepositoryImpl() {
		super(StoryLike.class);
	}

	@Override
	public Boolean isExistByStoryIdAndUserId(long storyId, long userId) {

		QStoryLike storyLike = QStoryLike.storyLike;
		Predicate predicate = storyLike.story.id.eq(storyId).and(storyLike.user.id.eq(userId));
		Boolean isLiked = from(storyLike).where(predicate).exists();
		return isLiked;
	}

}
