package com.djunderworld.nongjik.repository.user;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import com.djunderworld.nongjik.entity.UserEntity;

public class UserRepositoryImpl extends QueryDslRepositorySupport implements CustomUserRepository {

	public UserRepositoryImpl() {
		super(UserEntity.class);
	}

}
