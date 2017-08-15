package com.djunderworld.nongjik.repository.userfollower;

public interface UserFollowerRepositoryCustom {
	Boolean isExistByUserIdAndFollowerId(long storyUserId, long userId);

}
