package com.djunderworld.nongjik.repository.storylike;

import org.springframework.data.jpa.repository.JpaRepository;

import com.djunderworld.nongjik.entity.StoryLike;

public interface StoryLikeRepository extends JpaRepository<StoryLike,Long>, StoryLikeRepositoryCustom{

	StoryLike findOneByStoryIdAndUserId(long storyId, long userId) throws Exception;
}
