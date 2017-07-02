package com.djunderworld.nongjik.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "story_comments")
public class StoryComment extends Base {

	@ManyToOne
	@JoinColumn(name = "story_id")
	private Story story;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	private long groupId;
	private long depth;
	private long position;
	private String content;
	private int deleted;

	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		if (this.story != null) {
			this.story.getStoryComments().remove(this);
		}

		this.story = story;
		this.story.getStoryComments().add(this);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		if (this.user != null) {
			this.user.getStoryComments().remove(this);
		}

		this.user = user;
		this.user.getStoryComments().add(this);
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public long getDepth() {
		return depth;
	}

	public void setDepth(long depth) {
		this.depth = depth;
	}

	public long getPosition() {
		return position;
	}

	public void setPosition(long position) {
		this.position = position;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	@Override
	public long getId() {
		return super.getId();
	}

	@Override
	public void setId(long id) {
		super.setId(id);
	}

	@Override
	public String getCreatedAt() {
		return super.getCreatedAt();
	}

	@Override
	public void setCreatedAt(String createdAt) {
		super.setCreatedAt(createdAt);
	}

	@Override
	public String getUpdatedAt() {
		return super.getUpdatedAt();
	}

	@Override
	public void setUpdatedAt(String updatedAt) {
		super.setUpdatedAt(updatedAt);
	}

}
