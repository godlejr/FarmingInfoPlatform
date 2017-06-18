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

import com.djunderworld.nongjik.domain.File;
import com.djunderworld.nongjik.domain.Story;

@Entity
@Table(name = "stories")
public class StoryEntity extends BaseEntity implements Serializable{

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity userEntity;

	@ManyToOne
	@JoinColumn(name = "item_category_id")
	private ItemCategoryEntity itemCategoryEntity;

	private String title;
	private String content;
	private int hits;
	
	

	public StoryEntity() {
		super();
	}

	
	
	@OneToMany(mappedBy = "storyEntity", fetch = FetchType.EAGER)
	private List<FileEntity> fileEntities = new ArrayList<FileEntity>();

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public ItemCategoryEntity getItemCategoryEntity() {
		return itemCategoryEntity;
	}

	public void setItemCategoryEntity(ItemCategoryEntity itemCategoryEntity) {
		this.itemCategoryEntity = itemCategoryEntity;
	}

	public List<FileEntity> getFileEntities() {
		return fileEntities;
	}

	public void setFileEntities(List<FileEntity> fileEntities) {
		this.fileEntities = fileEntities;
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

	public Story buildDomain() {
		Story story = new Story();

		story.setId(getId());
		story.setUser(userEntity.buildDomain());
		story.setItemCategory(itemCategoryEntity.buildDomain());
		story.setTitle(title);
		story.setContent(content);
		story.setHits(hits);

		List<File> files = new ArrayList<File>();

		for (FileEntity entity : fileEntities) {
			File file = entity.buildDomainForBackRef();
			files.add(file);
		}
		story.setFiles(files);

		story.setCreatedAt(getCreatedAt());
		story.setUpdatedAt(getUpdatedAt());

		return story;
	}

	public void buildEntity(Story story) {
		setId(story.getId());

		UserEntity user = new UserEntity();
		user.buildEntity(story.getUser());

		userEntity = user;

		ItemCategoryEntity itemCategory = new ItemCategoryEntity();
		itemCategory.buildEntity(story.getItemCategory());

		List<FileEntity> fileEntities = new ArrayList<FileEntity>();

		List<File> files = new ArrayList<File>();
		
		for (File file : files) {
			FileEntity fileEntity = new FileEntity();
			fileEntity.buildEntityForBackRef(file);
			fileEntities.add(fileEntity);
		}
		
		this.fileEntities = fileEntities;
		this.title = story.getTitle();
		this.content = story.getContent();
		this.hits = story.getHits();
		setCreatedAt(story.getCreatedAt());
		setUpdatedAt(story.getUpdatedAt());
	}
}
