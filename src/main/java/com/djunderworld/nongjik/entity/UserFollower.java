package com.djunderworld.nongjik.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user_followers")
public class UserFollower extends Base{
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonManagedReference
	private User user;

	@ManyToOne
	@JoinColumn(name = "follower_id")
	@JsonManagedReference
	private User follower;

	public void setUser(User user) {
		if (this.user != null) {
			this.user.getUserFollowers().remove(this);
		}

		this.user = user;
		this.user.getUserFollowers().add(this);
	}

	public User getFollower() {
		return follower;
	}

	public void setFollower(User follower) {
		if (this.follower != null) {
			this.follower.getFollowerUsers().remove(this);
		}

		this.follower = follower;
		this.follower.getFollowerUsers().add(this);
	}

	public User getUser() {
		return user;
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

