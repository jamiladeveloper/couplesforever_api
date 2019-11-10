package com.couplesforever.app.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "moodmeter")
public class MoodMeter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "moodid")
	private Integer moodid;
	
	@Column(columnDefinition = "moodtext")
	private String moodtext;
	
	@Column(columnDefinition = "moodtimestamp")
	private Timestamp moodtimestamp;

	public Integer getMoodid() {
		return moodid;
	}

	public void setMoodid(Integer moodid) {
		this.moodid = moodid;
	}

	public String getMoodText() {
		return moodtext;
	}

	public void setMoodText(String moodText) {
		this.moodtext = moodText;
	}

	public Timestamp getMoodTimestamp() {
		return moodtimestamp;
	}

	public void setMoodTimestamp(Timestamp moodTimestamp) {
		this.moodtimestamp = moodTimestamp;
	}
	
	
}
