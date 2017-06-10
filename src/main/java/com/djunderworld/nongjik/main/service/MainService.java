package com.djunderworld.nongjik.main.service;

import java.util.List;

import com.djunderworld.nongjik.domain.Category;
import com.djunderworld.nongjik.domain.User;

public interface MainService {
	List<Category> selectCategories() throws Exception;

	void insertUser(User user) throws Exception;
}
