package com.djunderworld.nongjik.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.djunderworld.nongjik.common.flag.NotificationFlag;
import com.djunderworld.nongjik.common.flag.UserLevelFlag;
import com.djunderworld.nongjik.entity.Behavior;
import com.djunderworld.nongjik.entity.Notification;
import com.djunderworld.nongjik.entity.Professional;
import com.djunderworld.nongjik.entity.User;
import com.djunderworld.nongjik.entity.UserFollower;
import com.djunderworld.nongjik.entity.UserNotification;
import com.djunderworld.nongjik.repository.behavior.BehaviorRepository;
import com.djunderworld.nongjik.repository.notification.NotificationRepository;
import com.djunderworld.nongjik.repository.professional.ProfessionalRepository;
import com.djunderworld.nongjik.repository.user.UserRepository;
import com.djunderworld.nongjik.repository.userfollower.UserFollowerRepository;
import com.djunderworld.nongjik.repository.usernotification.UserNotificationRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProfessionalRepository professionalRepository;

	@Autowired
	private UserFollowerRepository userFollowerRepository;

	@Autowired
	private UserNotificationRepository userNotificationRepository;

	@Autowired
	private NotificationRepository notificationRepository;

	@Autowired
	private BehaviorRepository behaviorRepository;

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

	@Override
	public void saveOrDeleteUserFollowerByIdAndUserIdAndStoryUserId(long id, long userId, long storyUserId)
			throws Exception {
		UserFollower userFollower = userFollowerRepository.findOneByUserIdAndFollowerId(id, userId);

		if (userFollower != null) {
			long userFollowerId = userFollower.getId();
			userFollowerRepository.delete(userFollowerId);

		} else {
			userFollower = new UserFollower();
			User user = new User();
			User follower = new User();

			user.setId(id);
			follower.setId(userId);
			userFollower.setUser(user);
			userFollower.setFollower(follower);

			userFollowerRepository.save(userFollower);

			Notification notification = new Notification();
			notification.setUser(follower);
			notification.setReceiverCategoryId(NotificationFlag.TO_WRITER);
			notification.setReceiverId(storyUserId);
			notification.setContent(NotificationFlag.CONTENT_OBJECT_OF_FOLLOWING_MERCHANT);
			notification.setNavigationCategoryId(NotificationFlag.NAVIGATE_TO_THE_PAGE_OF_USER);
			notification.setNavigationId(storyUserId);
			Behavior behavior = behaviorRepository.findById(NotificationFlag.FOLLOWING_THE_USER);
			notification.setBehavior(behavior);

			notificationRepository.saveAndFlush(notification);

			UserNotification userNotification = new UserNotification();
			User storyUser = new User();
			storyUser.setId(storyUserId);
			userNotification.setUser(storyUser);
			userNotification.setNotification(notification);

			userNotificationRepository.save(userNotification);
		}
	}

}
