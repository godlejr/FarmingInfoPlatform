package com.djunderworld.nongjik.repository.story;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.djunderworld.nongjik.entity.Story;

public interface CustomStoryRepository {

	List<Story> findAllByPageRequest(PageRequest pageRequest);

}
