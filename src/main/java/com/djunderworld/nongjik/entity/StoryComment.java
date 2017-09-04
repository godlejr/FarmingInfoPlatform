package com.djunderworld.nongjik.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;
import org.springframework.beans.factory.annotation.Autowired;

import com.djunderworld.nongjik.repository.storycomment.StoryCommentRepository;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "story_comments")
public class StoryComment extends Base {

	@ManyToOne
	@JoinColumn(name = "story_id")
	@JsonManagedReference
	private Story story;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonManagedReference
	private User user;

	private long groupId;
	private long depth;
	private long position;
	private String content;

	@Formula("(select count(sc.group_id) from story_comments sc where sc.group_id = group_id)")
	private long groupIdCount;

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

	public String getCustomCreatedAt() {
		return calculateDate(this.getCreatedAt());
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
