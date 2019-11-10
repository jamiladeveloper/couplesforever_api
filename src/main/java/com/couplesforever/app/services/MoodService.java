package com.couplesforever.app.services;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.couplesforever.app.model.MoodMeter;
import com.couplesforever.app.repository.MoodRepository;

@Configuration
public class MoodService implements IMoodService{

	@Autowired
	MoodRepository moodRepository;
	
	@Override
	public MoodMeter getMoodById(Integer moodId) {
		return moodRepository.findById(moodId).get();
	}

	@Override
	public MoodMeter addMood(String moodText) {
		MoodMeter mood = new MoodMeter();
		mood.setMoodText(moodText);
		mood.setMoodTimestamp(new Timestamp(System.currentTimeMillis()));
		return moodRepository.save(mood);
	}

	@Override
	public void deleteMoodById(Integer moodId) {
		moodRepository.deleteById(moodId);
	}

}
