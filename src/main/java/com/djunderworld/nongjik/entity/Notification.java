package com.djunderworld.nongjik.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "notifications")
public class Notification extends Base {

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonManagedReference
	private User user;

	@ManyToOne
	@JoinColumn(name = "behavior_id")
	@JsonManagedReference
	private Behavior behavior;

	private long receiverId;
	private long receiverCategoryId;
	private String content;
	private long navigationId;
	private long navigationCategoryId;
	private int checked;

	@OneToMany(mappedBy = "notification", fetch = FetchType.LAZY)
	@JsonBackReference
	private List<UserNotification> userNotifications = new ArrayList<UserNotification>();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Behavior getBehavior() {
		return behavior;
	}

	public void setBehavior(Behavior behavior) {
		this.behavior = behavior;
	}

	public long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(long receiverId) {
		this.receiverId = receiverId;
	}

	public long getReceiverCategoryId() {
		return receiverCategoryId;
	}

	public void setReceiverCategoryId(long receiverCategoryId) {
		this.receiverCategoryId = receiverCategoryId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getNavigationId() {
		return navigationId;
	}

	public void setNavigationId(long navigationId) {
		this.navigationId = navigationId;
	}

	public long getNavigationCategoryId() {
		return navigationCategoryId;
	}

	public void setNavigationCategoryId(long navigationCategoryId) {
		this.navigationCategoryId = navigationCategoryId;
	}

	public int getChecked() {
		return checked;
	}

	public void setChecked(int checked) {
		this.checked = checked;
	}

	public List<UserNotification> getUserNotifications() {
		return userNotifications;
	}

	public void setUserNotifications(List<UserNotification> userNotifications) {
		this.userNotifications = userNotifications;
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
