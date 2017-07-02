package com.djunderworld.nongjik.repository.story;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.djunderworld.nongjik.entity.Story;

public interface StoryRepository extends JpaRepository<Story, Long>{
	
	Page<Story> findAll(Pageable pageable);

}
