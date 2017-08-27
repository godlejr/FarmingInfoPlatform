package com.djunderworld.nongjik.service.user;

import com.djunderworld.nongjik.entity.User;

public interface UserService {

	User getUserByEmailAndPassword(String email, String password) throws Exception;

	void saveUser(User user) throws Exception;

	User getUserByEmail(String email) throws NullPointerException;

	void saveOrDeleteUserFollowerByIdAndUserIdAndStoryUserId(long id, long userId, long storyUserId) throws Exception;

}
