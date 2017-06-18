package com.djunderworld.nongjik.model;

import java.util.ArrayList;
import java.util.List;

import com.djunderworld.nongjik.domain.File;
import com.djunderworld.nongjik.domain.Story;
import com.djunderworld.nongjik.entity.FileEntity;
import com.djunderworld.nongjik.entity.ItemCategoryEntity;
import com.djunderworld.nongjik.entity.UserEntity;

public class StoryModel extends BaseModel {

	private UserModel userModel;

	private ItemCategoryModel itemCategoryModel;

	private String title;
	private String content;
	private int hits;

	private List<FileModel> fileModels = new ArrayList<FileModel>();

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public ItemCategoryModel getItemCategoryModel() {
		return itemCategoryModel;
	}

	public void setItemCategoryModel(ItemCategoryModel itemCategoryModel) {
		this.itemCategoryModel = itemCategoryModel;
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

	public List<FileModel> getFileModels() {
		return fileModels;
	}

	public void setFileModels(List<FileModel> fileModels) {
		this.fileModels = fileModels;
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
	
	
	public Story buildDomain() {
		Story story = new Story();

		story.setId(getId());
		story.setUser(userModel.buildDomain());
		story.setItemCategory(itemCategoryModel.buildDomain());
		story.setTitle(title);
		story.setContent(content);
		story.setHits(hits);

		List<File> files = new ArrayList<File>();

		for (FileModel entity : fileModels) {
			File file = entity.buildDomainForBackRef();
			files.add(file);
		}
		story.setFiles(files);

		story.setCreatedAt(getCreatedAt());
		story.setUpdatedAt(getUpdatedAt());

		return story;
	}

	public void buildModel(Story story) {
		setId(story.getId());

		UserModel user = new UserModel();
		user.buildModel(story.getUser());

		userModel = user;

		ItemCategoryModel itemCategory = new ItemCategoryModel();
		itemCategory.buildModel(story.getItemCategory());

		List<FileModel> fileModels = new ArrayList<FileModel>();

		List<File> files = new ArrayList<File>();
		
		for (File file : files) {
			FileModel fileModel = new FileModel();
			fileModel.buildModelForBackRef(file);
			fileModels.add(fileModel);
		}
		
		this.fileModels = fileModels;
		this.title = story.getTitle();
		this.content = story.getContent();
		this.hits = story.getHits();
		setCreatedAt(story.getCreatedAt());
		setUpdatedAt(story.getUpdatedAt());
	}
	
}
