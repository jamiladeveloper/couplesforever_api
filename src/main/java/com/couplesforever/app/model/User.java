package com.couplesforever.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "\"user\"")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Column(columnDefinition = "userid")
	private String userid;
	
	@NotNull
	@Column(columnDefinition = "name")
	private String name;
	
	@Column(columnDefinition = "link")
	private String link;
	
	@NotNull
	@Column(columnDefinition = "password")
	private String password;
	
	@Column(columnDefinition = "mood")
	private Integer mood;
	
	@NotNull
	@Column(columnDefinition = "points")
	private Integer points;

	public String getUserId() {
		return userid;
	}

	public void setUserId(String userId) {
		this.userid = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getMood() {
		return mood;
	}

	public void setMood(Integer mood) {
		this.mood = mood;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		return "\nUser ID: " + this.userid + 
				"\nName: " + this.name + 
				"\nPassword: " + this.password + 
				"\nLink: " + this.link +
				"\nMood: " + this.mood +
				"\nPoints: " + this.points;
	}
	
}
