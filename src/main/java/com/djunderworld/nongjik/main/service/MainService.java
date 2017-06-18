package com.djunderworld.nongjik.main.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.djunderworld.nongjik.domain.Category;
import com.djunderworld.nongjik.domain.Story;
import com.djunderworld.nongjik.domain.User;

public interface MainService {
	List<Category> selectCategories() throws Exception;

	void insertUser(User user) throws Exception;

	String selectLogin(User user, Model model, HttpSession session) throws Exception;

	List<Story> selectStoriesWithPageRequest(int firstPageNo, int limit);

}
