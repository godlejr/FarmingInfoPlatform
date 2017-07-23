package com.djunderworld.nongjik.dto;

import com.djunderworld.nongjik.entity.ItemCategory;
import com.djunderworld.nongjik.entity.Story;
import com.djunderworld.nongjik.entity.User;

public class StoryDto extends BaseDto {
	private User user;
	private ItemCategory itemCategory;

	private String title;
	private String content;
	private int hits;

	private int storyLikeCount;
	private int storyScrapCount;
	private int storyCommentCount;

	private String fileAvatar;

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

	public int getStoryLikeCount() {
		return storyLikeCount;
	}

	public void setStoryLikeCount(int storyLikeCount) {
		this.storyLikeCount = storyLikeCount;
	}

	public int getStoryScrapCount() {
		return storyScrapCount;
	}

	public void setStoryScrapCount(int storyScrapCount) {
		this.storyScrapCount = storyScrapCount;
	}

	public int getStoryCommentCount() {
		return storyCommentCount;
	}

	public void setStoryCommentCount(int storyCommentCount) {
		this.storyCommentCount = storyCommentCount;
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

	public void buildDto(Story story) {
		setId(story.getId());
		setCreatedAt(story.getCreatedAt());
		setUpdatedAt(story.getUpdatedAt());

		this.user = story.getUser();
		this.itemCategory = story.getItemCategory();
		this.title = story.getTitle();
		this.content = story.getContent();
		this.hits = story.getHits();

		this.setFileAvatar(story.getFiles().get(0).getName() + '.' + story.getFiles().get(0).getExt());

		this.storyLikeCount = story.getStoryLikes().size();
		this.storyCommentCount = story.getStoryComments().size();
		this.storyScrapCount = story.getStoryScraps().size();
	}

	public String getFileAvatar() {
		return fileAvatar;
	}

	public void setFileAvatar(String fileAvatar) {
		this.fileAvatar = fileAvatar;
	}
}
