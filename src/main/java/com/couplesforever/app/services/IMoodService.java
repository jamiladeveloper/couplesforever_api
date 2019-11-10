package com.couplesforever.app.services;

import com.couplesforever.app.model.MoodMeter;


public interface IMoodService {
	public MoodMeter getMoodById(Integer moodId);
	
	public MoodMeter addMood(String moodText);
	
	public void deleteMoodById(Integer moodId);
}
