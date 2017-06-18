package com.djunderworld.nongjik.model;

import com.djunderworld.nongjik.domain.File;
import com.djunderworld.nongjik.entity.StoryEntity;

public class FileModel extends BaseModel{

	private StoryModel storyModel;
	private int type;
	private String name;
	private String ext;
	private int size;
	public StoryModel getStoryModel() {
		return storyModel;
	}
	public void setStoryModel(StoryModel storyModel) {
		this.storyModel = storyModel;
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
	public String getUpdatedAt() {
		return super.getUpdatedAt();
	}
	@Override
	public void setUpdatedAt(String updatedAt) {
		super.setUpdatedAt(updatedAt);
	}
	@Override
	public String getCreatedAt() {
		return super.getCreatedAt();
	}
	@Override
	public void setCreatedAt(String createdAt) {
		super.setCreatedAt(createdAt);
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
		file.setStory(storyModel.buildDomain());
		file.setType(type);
		file.setName(name);
		file.setExt(ext);
		file.setSize(size);

		file.setCreatedAt(getCreatedAt());
		file.setUpdatedAt(getUpdatedAt());

		return file;
	}
	
	public void buildModelForBackRef(File file) {
		setId(file.getId());

		type = file.getType();
		name = file.getName();
		ext = file.getExt();
		size = file.getSize();

		setCreatedAt(file.getCreatedAt());
		setUpdatedAt(file.getUpdatedAt());
	}
	

	public void buildModel(File file) {
		setId(file.getId());

		StoryModel storyModel = new StoryModel();
		storyModel.buildModel(file.getStory());

		type = file.getType();
		name = file.getName();
		ext = file.getExt();
		size = file.getSize();

		setCreatedAt(file.getCreatedAt());
		setUpdatedAt(file.getUpdatedAt());
	}
	
	
}
