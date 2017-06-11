package com.djunderworld.nongjik.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.djunderworld.nongjik.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>, CustomUserRepository {

	UserEntity findById(long id) throws Exception;

	UserEntity findByEmail(String email);
	
	UserEntity findByEmailAndPassword(String email, String password);
}
