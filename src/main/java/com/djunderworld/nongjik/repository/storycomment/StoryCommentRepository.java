package com.djunderworld.nongjik.repository.storycomment;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.djunderworld.nongjik.entity.StoryComment;

public interface StoryCommentRepository extends JpaRepository<StoryComment, Long>, StoryCommentRepositoryCustom{


}
