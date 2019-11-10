package com.couplesforever.app.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.couplesforever.app.constants.Constants;
import com.couplesforever.app.exception.AccessDeniedException;
import com.couplesforever.app.model.MoodMeter;
import com.couplesforever.app.model.User;
import com.couplesforever.app.repository.UserRepository;
import com.couplesforever.app.services.IMoodService;

@RestController
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	ApplicationContext ctx;

	@Autowired
	private UserRepository userRepository;

	IMoodService moodService;

	@PostMapping("/user/get")
	public User getUser(@Valid @RequestBody User user) {
		logger.info("API call = /user/get");
		logger.debug("Requestbody User : " + user);
		User dbUser = userRepository.findByUserId(user.getUserId());
		if (dbUser.getPassword().equals(user.getPassword())) {
			return dbUser;
		} else {
			throw new AccessDeniedException(Constants.EXCEPTION_ACCESS_DENIED);
		}

	}

	@PostMapping("/user/create")
	public User createUser(@Valid @RequestBody User user) {
		logger.info("API call = /user/create");
		logger.debug("Requestbody User : " + user);
		return userRepository.save(user);
	}

	@PostMapping("/user/mood/update/{moodId}")
	public boolean updateMood(@Valid @RequestBody User user, @PathVariable Integer moodId) {
		logger.info("API call = /user/mood/update/" + moodId);
		User dbUser = validateUser(user);
		if (validateMood(moodId)) {
			dbUser.setMood(moodId);
			userRepository.save(dbUser);
			logger.debug("Mood update successfully");
			return true;
		} else {
			logger.debug("Invalid User or Mood Id");
			throw new AccessDeniedException(Constants.EXCEPTION_ACCESS_DENIED);
		}
	}

	@PostMapping("/user/follow/{userId}")
	public User follow(@Valid @RequestBody User user, @PathVariable String userId) {
		logger.info("API call = /user/follow/" + userId);

		User dbUser = validateUser(user);
		if (dbUser != null) {

			User followUser = userRepository.findByUserId(userId);
			if (followUser != null) {
				dbUser.setLink(userId);
				userRepository.save(dbUser);

			}
			return followUser;
		} else {
			throw new AccessDeniedException(Constants.EXCEPTION_ACCESS_DENIED);
		}

	}

	@PostMapping("/user/unfollow")
	public User unfollow(@Valid @RequestBody User user) {
		logger.info("API call = /user/unfollow");

		User dbUser = validateUser(user);
		if (dbUser != null) {
			dbUser.setLink("");
			userRepository.save(dbUser);
			logger.debug("unfollow successful.");
			
			return dbUser;
		} else {
			throw new AccessDeniedException(Constants.EXCEPTION_ACCESS_DENIED);
		}
	}

	private User validateUser(@Valid User user) {
		User dbUser = userRepository.findByUserId(user.getUserId());
		if (dbUser.getPassword().equals(user.getPassword())) {
			return dbUser;
		}
		return null;
	}

	private boolean validateMood(Integer moodId) {
		moodService = (IMoodService) ctx.getBean("moodService");
		MoodMeter mood = moodService.getMoodById(moodId);
		if (mood != null) {
			return true;
		}
		return false;
	}

}
