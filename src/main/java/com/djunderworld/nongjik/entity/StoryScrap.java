package com.djunderworld.nongjik.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "story_scraps")
public class StoryScrap extends Base {

	@ManyToOne
	@JoinColumn(name = "story_id")
	private Story story;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		if (this.story != null) {
			this.story.getStoryScraps().remove(this);
		}

		this.story = story;
		this.story.getStoryScraps().add(this);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		if (this.user != null) {
			this.user.getStoryScraps().remove(this);
		}

		this.user = user;
		this.user.getStoryScraps().add(this);
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
