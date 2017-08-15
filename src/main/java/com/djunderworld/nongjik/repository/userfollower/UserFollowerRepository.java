package com.djunderworld.nongjik.repository.userfollower;

import org.springframework.data.jpa.repository.JpaRepository;

import com.djunderworld.nongjik.entity.UserFollower;

public interface UserFollowerRepository extends JpaRepository<UserFollower,Long> ,UserFollowerRepositoryCustom{

	UserFollower findOneByUserIdAndFollowerId(long userId, long followerId) throws Exception;


}
