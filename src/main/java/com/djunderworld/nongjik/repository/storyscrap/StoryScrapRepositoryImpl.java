package com.djunderworld.nongjik.repository.storyscrap;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import com.djunderworld.nongjik.entity.QStoryScrap;
import com.djunderworld.nongjik.entity.StoryScrap;
import com.mysema.query.types.Predicate;

public class StoryScrapRepositoryImpl extends QueryDslRepositorySupport implements StoryScrapRepositoryCustom {

	public StoryScrapRepositoryImpl() {
		super(StoryScrap.class);
	}

	@Override
	public Boolean isExistByStoryIdAndUserId(long storyId, long userId) {
		QStoryScrap storyScrap = QStoryScrap.storyScrap;
		Predicate predicate = storyScrap.story.id.eq(storyId).and(storyScrap.user.id.eq(userId));
		Boolean isScraped = from(storyScrap).where(predicate).exists();
		return isScraped;
	}

}
