package com.djunderworld.nongjik.repository.behavior;

import org.springframework.data.jpa.repository.JpaRepository;

import com.djunderworld.nongjik.entity.Behavior;

public interface BehaviorRepository extends JpaRepository<Behavior, Long>{

	Behavior findById(long id) throws Exception;

}
