package com.djunderworld.nongjik.repository.userfollower;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import com.djunderworld.nongjik.entity.QUserFollower;
import com.djunderworld.nongjik.entity.UserFollower;
import com.mysema.query.types.Predicate;

public class UserFollowerRepositoryImpl extends QueryDslRepositorySupport implements UserFollowerRepositoryCustom{

	public UserFollowerRepositoryImpl() {
		super(UserFollower.class);
	}

	@Override
	public Boolean isExistByUserIdAndFollowerId(long storyUserId, long userId) {
		QUserFollower userFollower = QUserFollower.userFollower;

		Predicate predicate = userFollower.user.id.eq(storyUserId).and(userFollower.follower.id.eq(userId));
		Boolean isFollowed = from(userFollower).where(predicate).exists();
		return isFollowed;
	}

}
