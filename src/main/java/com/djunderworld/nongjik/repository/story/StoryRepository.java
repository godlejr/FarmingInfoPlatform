package com.djunderworld.nongjik.repository.story;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.djunderworld.nongjik.entity.Story;

public interface StoryRepository extends JpaRepository<Story, Long>, CustomStoryRepository{
	
	Page<Story> findAll(Pageable pageable);

}
