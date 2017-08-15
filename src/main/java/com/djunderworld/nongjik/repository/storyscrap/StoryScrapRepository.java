package com.djunderworld.nongjik.repository.storyscrap;

import org.springframework.data.jpa.repository.JpaRepository;

import com.djunderworld.nongjik.entity.StoryScrap;

public interface StoryScrapRepository extends JpaRepository<StoryScrap,Long>, StoryScrapRepositoryCustom{

	StoryScrap findOneByStoryIdAndUserId(long storyId, long userId) throws Exception;
}
