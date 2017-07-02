package com.djunderworld.nongjik.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "stories")
public class Story extends Base implements Serializable {

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "item_category_id")
	private ItemCategory itemCategory;

	private String title;
	private String content;
	private int hits;

	@OneToMany(mappedBy = "story", fetch = FetchType.LAZY)
	private List<StoryLike> storyLikes = new ArrayList<StoryLike>();

	@OneToMany(mappedBy = "story", fetch = FetchType.LAZY)
	private List<StoryScrap> storyScraps = new ArrayList<StoryScrap>();

	@OneToMany(mappedBy = "story", fetch = FetchType.LAZY)
	private List<StoryComment> storyComments = new ArrayList<StoryComment>();

	@OneToMany(mappedBy = "story", fetch = FetchType.LAZY)
	private List<File> files = new ArrayList<File>();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ItemCategory getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(ItemCategory itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public List<StoryLike> getStoryLikes() {
		return storyLikes;
	}

	public void setStoryLikes(List<StoryLike> storyLikes) {
		this.storyLikes = storyLikes;
	}

	public List<StoryScrap> getStoryScraps() {
		return storyScraps;
	}

	public void setStoryScraps(List<StoryScrap> storyScraps) {
		this.storyScraps = storyScraps;
	}

	public List<StoryComment> getStoryComments() {
		return storyComments;
	}

	public void setStoryComments(List<StoryComment> storyComments) {
		this.storyComments = storyComments;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
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