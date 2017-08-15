package com.djunderworld.nongjik.repository.user;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import com.djunderworld.nongjik.entity.User;

public class UserRepositoryImpl extends QueryDslRepositorySupport implements UserRepositoryCustom {

	public UserRepositoryImpl() {
		super(User.class);
	}
	
}
