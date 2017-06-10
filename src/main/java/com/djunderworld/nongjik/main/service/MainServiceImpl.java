package com.djunderworld.nongjik.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.djunderworld.nongjik.common.flag.UserLevelFlag;
import com.djunderworld.nongjik.domain.Category;
import com.djunderworld.nongjik.domain.User;
import com.djunderworld.nongjik.entity.CategoryEntity;
import com.djunderworld.nongjik.entity.ProfessionalEntity;
import com.djunderworld.nongjik.entity.UserEntity;
import com.djunderworld.nongjik.repository.category.CategoryRepository;
import com.djunderworld.nongjik.repository.professional.ProfessionalRepository;
import com.djunderworld.nongjik.repository.user.UserRepository;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProfessionalRepository professionalRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> selectCategories() throws Exception {
		List<Category> categories = new ArrayList<Category>();
		List<CategoryEntity> categoryEntities = categoryRepository.findAll();

		for (CategoryEntity entity : categoryEntities) {
			Category category = entity.buildDomain();
			categories.add(category);
		}

		return categories;
	}

	@Override
	public void insertUser(User user) throws Exception {
		int level = user.getLevel();

		UserEntity userEntity = new UserEntity();
		userEntity.buildEntity(user);

		UserEntity userPersist = userRepository.saveAndFlush(userEntity);
		
		if (level == UserLevelFlag.COMPANY) {
			ProfessionalEntity professionalEntity = new ProfessionalEntity();
			professionalEntity.setBusinessNo(user.getBusinessNo());
			professionalEntity.setUserEntity(userPersist);

			professionalRepository.saveAndFlush(professionalEntity);
		}

	}

}
