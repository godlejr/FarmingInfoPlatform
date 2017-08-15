package com.djunderworld.nongjik.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.djunderworld.nongjik.entity.User;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

	User findById(long id);

	User findByEmail(String email);
	
	User findByEmailAndPassword(String email, String password);
}
