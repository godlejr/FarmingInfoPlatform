package com.djunderworld.nongjik.repository.story;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.djunderworld.nongjik.entity.StoryEntity;

public interface StoryRepository extends JpaRepository<StoryEntity, Long>{
	
	Page<StoryEntity> findAll(Pageable pageable);

}
