package com.djunderworld.nongjik.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.djunderworld.nongjik.entity.Story;
import com.djunderworld.nongjik.entity.StoryComment;
import com.djunderworld.nongjik.entity.User;

public class StoryCommentDto extends BaseDto {
	private Story story;
	private User user;

	private long groupId;
	private long depth;
	private long position;
	private String content;
	private String customCreatedAt;

	private long groupIdCount;

	public StoryCommentDto() {
		super();
	}

	public StoryCommentDto(long id, String createdAt, String updatedAt) {
		super(id, createdAt, updatedAt);
	}

	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public void setCustomCreatedAt(String customCreatedAt) {
		this.customCreatedAt = customCreatedAt;
	}

	public String getCustomCreatedAt() {
		return customCreatedAt;
	}

	public long getGroupIdCount() {
		return groupIdCount;
	}

	public void setGroupIdCount(long groupIdCount) {
		this.groupIdCount = groupIdCount;
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

	public void buildDto(StoryComment storyComment) {
		setId(storyComment.getId());

		String storyCreatedAt = storyComment.getCreatedAt();
		if (storyCreatedAt != null) {
			setUpdatedAt(storyComment.getUpdatedAt());
			this.customCreatedAt = calculateDate(storyCreatedAt);
		}

		this.story = storyComment.getStory();
		this.user = storyComment.getUser();
		this.content = storyComment.getContent();

		this.groupId = storyComment.getGroupId();
		this.depth = storyComment.getDepth();
		this.position = storyComment.getPosition();

		this.groupIdCount = storyComment.getGroupIdCount();
	}

	public String calculateDate(String dateTime) {
		String message = null;

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;

		try {
			date = simpleDateFormat.parse(dateTime);
			long currentTime = System.currentTimeMillis();
			long registeredTime = date.getTime();
			long differentOfTime = (currentTime - registeredTime) / 1000;

			if (differentOfTime < 60) {
				message = differentOfTime + "초전";
			} else if ((differentOfTime /= 60) < 60) {
				message = differentOfTime + "분전";
			} else if ((differentOfTime /= 60) < 24) {
				message = (differentOfTime) + "시간전";
			} else if ((differentOfTime /= 24) < 7) {
				message = (differentOfTime) + "일전";
			} else {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 M월 d일");
				message = dateFormat.format(date);
			}
		} catch (ParseException e) {
			message = "알수없음";
		}
		return message;
	}
}
