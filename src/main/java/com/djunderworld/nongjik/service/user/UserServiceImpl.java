package com.djunderworld.nongjik.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.djunderworld.nongjik.common.flag.UserLevelFlag;
import com.djunderworld.nongjik.entity.Professional;
import com.djunderworld.nongjik.entity.User;
import com.djunderworld.nongjik.repository.professional.ProfessionalRepository;
import com.djunderworld.nongjik.repository.user.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProfessionalRepository professionalRepository;

	@Override
	public User getUserByEmailAndPassword(String email, String password) throws Exception {
		return userRepository.findByEmailAndPassword(email, password);
	}

	@Override
	public void saveUser(User user) throws Exception {
		int level = user.getLevel();

		User userPersist = userRepository.saveAndFlush(user);

		if (level == UserLevelFlag.COMPANY) {
			Professional professional = new Professional();
			professional.setBusinessNo(user.getBusinessNo());
			professional.setUser(userPersist);

			professionalRepository.saveAndFlush(professional);
		}
	}

	@Override
	public User getUserByEmail(String email) throws NullPointerException {
		return userRepository.findByEmail(email);

	}

}
