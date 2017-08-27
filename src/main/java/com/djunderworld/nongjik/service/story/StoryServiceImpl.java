package com.djunderworld.nongjik.service.story;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.djunderworld.nongjik.common.flag.NotificationFlag;
import com.djunderworld.nongjik.dto.StoryDto;
import com.djunderworld.nongjik.entity.Behavior;
import com.djunderworld.nongjik.entity.Notification;
import com.djunderworld.nongjik.entity.Story;
import com.djunderworld.nongjik.entity.StoryLike;
import com.djunderworld.nongjik.entity.StoryScrap;
import com.djunderworld.nongjik.entity.User;
import com.djunderworld.nongjik.entity.UserNotification;
import com.djunderworld.nongjik.repository.behavior.BehaviorRepository;
import com.djunderworld.nongjik.repository.notification.NotificationRepository;
import com.djunderworld.nongjik.repository.story.StoryRepository;
import com.djunderworld.nongjik.repository.storylike.StoryLikeRepository;
import com.djunderworld.nongjik.repository.storyscrap.StoryScrapRepository;
import com.djunderworld.nongjik.repository.userfollower.UserFollowerRepository;
import com.djunderworld.nongjik.repository.usernotification.UserNotificationRepository;

@Service
@Transactional
public class StoryServiceImpl implements StoryService {

	@Autowired
	private StoryRepository storyRepository;

	@Autowired
	private StoryLikeRepository storyLikeRepository;

	@Autowired
	private StoryScrapRepository storyScrapRepository;

	@Autowired
	private UserFollowerRepository userFollowerRepository;

	@Autowired
	private UserNotificationRepository userNotificationRepository;

	@Autowired
	private NotificationRepository notificationRepository;

	@Autowired
	private BehaviorRepository behaviorRepository;

	@Override
	public List<Story> getStoriesByPageRequests(long categoryId, long itemCategoryId, int orderId, int userLevel,
			String search, int page, int limit) throws Exception {
		PageRequest pageRequest = new PageRequest(page, limit);
		List<Story> stories = storyRepository.findAllByPageRequest(categoryId, itemCategoryId, orderId, userLevel,
				search, pageRequest);

		return stories;
	}

	@Override
	public List<StoryDto> getStoryDtosByPageRequests(long categoryId, long itemCategoryId, int orderId, int userLevel,
			String search, int page, int limit) throws Exception {
		PageRequest pageRequest = new PageRequest(page, limit);
		List<Story> stories = storyRepository.findAllByPageRequest(categoryId, itemCategoryId, orderId, userLevel,
				search, pageRequest);
		List<StoryDto> storyDtos = new ArrayList<StoryDto>();

		for (Story story : stories) {
			StoryDto storyDto = new StoryDto();
			storyDto.buildDto(story);
			storyDtos.add(storyDto);
		}

		return storyDtos;
	}

	@Override
	public Story getStoryById(long id) throws Exception {
		return storyRepository.findOne(id);
	}

	@Override
	public Boolean isLikedByIdAndUserId(long id, long userId) throws Exception {
		return storyLikeRepository.isExistByStoryIdAndUserId(id, userId);
	}

	@Override
	public Boolean isScrapedByIdAndUserId(long id, long userId) throws Exception {
		return storyScrapRepository.isExistByStoryIdAndUserId(id, userId);

	}

	@Override
	public Boolean isFollowedByStoryUserIdAndUserId(long storyUserId, long userId) throws Exception {
		return userFollowerRepository.isExistByUserIdAndFollowerId(storyUserId, userId);
	}

	@Override
	public int getLikeCountSavedOrDeletedByIdAndUserIdAndStoryUserId(long id, long userId, long storyUserId)
			throws Exception {
		int count = 0;
		StoryLike storyLike = storyLikeRepository.findOneByStoryIdAndUserId(id, userId);

		if (storyLike != null) {
			long storyLikeId = storyLike.getId();
			storyLikeRepository.delete(storyLikeId);

			count--;
		} else {
			storyLike = new StoryLike();
			Story story = new Story();
			User user = new User();

			story.setId(id);
			user.setId(userId);
			storyLike.setStory(story);
			storyLike.setUser(user);

			storyLikeRepository.save(storyLike);
			count++;

			Notification notification = new Notification();
			notification.setUser(user);
			notification.setReceiverCategoryId(NotificationFlag.TO_WRITER);
			notification.setReceiverId(storyUserId);
			notification.setContent(NotificationFlag.CONTENT_OBJECT_OF_WRITING_COMMENT_OR_LIKE_SCRAP);
			notification.setNavigationCategoryId(NotificationFlag.NAVIGATE_TO_THE_PAGE_OF_STORY);
			notification.setNavigationId(id);
			Behavior behavior = behaviorRepository.findById(NotificationFlag.LIKE_THE_STORY);
			notification.setBehavior(behavior);

			notificationRepository.saveAndFlush(notification);

			UserNotification userNotification = new UserNotification();
			User storyUser = new User();
			storyUser.setId(storyUserId);
			userNotification.setUser(storyUser);
			userNotification.setNotification(notification);

			userNotificationRepository.save(userNotification);
		}

		return count;
	}

	@Override
	public void saveOrDeleteStoryScrapByIdAndUserIdAndStoryUserId(long id, long userId, long storyUserId)
			throws Exception {
		StoryScrap storyScrap = storyScrapRepository.findOneByStoryIdAndUserId(id, userId);

		if (storyScrap != null) {
			long storyScrapId = storyScrap.getId();
			storyScrapRepository.delete(storyScrapId);

		} else {
			storyScrap = new StoryScrap();
			Story story = new Story();
			User user = new User();

			story.setId(id);
			user.setId(userId);
			storyScrap.setStory(story);
			storyScrap.setUser(user);

			storyScrapRepository.save(storyScrap);

			Notification notification = new Notification();
			notification.setUser(user);
			notification.setReceiverCategoryId(NotificationFlag.TO_WRITER);
			notification.setReceiverId(storyUserId);
			notification.setContent(NotificationFlag.CONTENT_OBJECT_OF_WRITING_COMMENT_OR_LIKE_SCRAP);
			notification.setNavigationCategoryId(NotificationFlag.NAVIGATE_TO_THE_PAGE_OF_STORY);
			notification.setNavigationId(id);
			Behavior behavior = behaviorRepository.findById(NotificationFlag.SCRAP_THE_STORY);
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
