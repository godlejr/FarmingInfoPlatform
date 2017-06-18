package com.djunderworld.nongjik.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.djunderworld.nongjik.domain.File;

@Entity
@Table(name = "files")
public class FileEntity extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "story_id")
	private StoryEntity storyEntity;

	private int type;
	private String name;
	private String ext;
	private int size;

	
	
	public FileEntity() {
		super();
	}

	public StoryEntity getStoryEntity() {
		return storyEntity;
	}

	public void setStoryEntity(StoryEntity storyEntity) {
		this.storyEntity = storyEntity;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
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
	
	public File buildDomainForBackRef() {
		File file = new File();

		file.setId(getId());
		file.setType(type);
		file.setName(name);
		file.setExt(ext);
		file.setSize(size);

		file.setCreatedAt(getCreatedAt());
		file.setUpdatedAt(getUpdatedAt());

		return file;
	}

	

	public File buildDomain() {
		File file = new File();

		file.setId(getId());
		file.setStory(storyEntity.buildDomain());
		file.setType(type);
		file.setName(name);
		file.setExt(ext);
		file.setSize(size);

		file.setCreatedAt(getCreatedAt());
		file.setUpdatedAt(getUpdatedAt());

		return file;
	}
	
	public void buildEntityForBackRef(File file) {
		setId(file.getId());

		type = file.getType();
		name = file.getName();
		ext = file.getExt();
		size = file.getSize();

		setCreatedAt(file.getCreatedAt());
		setUpdatedAt(file.getUpdatedAt());
	}
	

	public void buildEntity(File file) {
		setId(file.getId());

		StoryEntity storyEntity = new StoryEntity();
		storyEntity.buildEntity(file.getStory());

		type = file.getType();
		name = file.getName();
		ext = file.getExt();
		size = file.getSize();

		setCreatedAt(file.getCreatedAt());
		setUpdatedAt(file.getUpdatedAt());
	}
}
