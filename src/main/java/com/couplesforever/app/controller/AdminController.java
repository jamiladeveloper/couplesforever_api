package com.couplesforever.app.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.couplesforever.app.model.MoodMeter;
import com.couplesforever.app.services.IMoodService;

@RestController
public class AdminController {

	private Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	ApplicationContext ctx;
	
	IMoodService moodService;

	@PostMapping("/admin/mood/add")
	public MoodMeter addMood(@Valid @RequestBody String moodText) {
		logger.debug("API call = /admin/mood/add");
		moodService = (IMoodService) ctx.getBean("moodService");
		return moodService.addMood(moodText);
	}

	@PutMapping("/admin/mood/remove/{moodId}")
	public boolean removeMood(@PathVariable Integer moodId) {
		logger.debug("API call = /admin/mood/remove" + moodId);
		moodService = (IMoodService) ctx.getBean("moodService");
		moodService.deleteMoodById(moodId);
		logger.debug("Mood deleted successfully");
		return true;
	}

}
