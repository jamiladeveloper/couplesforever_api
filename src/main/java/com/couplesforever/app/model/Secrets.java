package com.couplesforever.app.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "secrets")
public class Secrets {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long secretid;
	
	@Column(columnDefinition = "secrettext")
	private String secrettext;
	
	@Column(columnDefinition = "isreadby")
	private String isreadby;
	
	@Column(columnDefinition = "secrettimestamp")
	private Timestamp secrettimestamp;
	
	@Column(columnDefinition = "submittedby")
	private Long submittedby;
	
	@Column(columnDefinition = "submittedto")
	private Long submittedto;

	public Long getSecretid() {
		return secretid;
	}

	public void setSecretid(Long secretid) {
		this.secretid = secretid;
	}

	public String getSecrettext() {
		return secrettext;
	}

	public void setSecrettext(String secrettext) {
		this.secrettext = secrettext;
	}

	public String getIsreadby() {
		return isreadby;
	}

	public void setIsreadby(String isreadby) {
		this.isreadby = isreadby;
	}

	public Timestamp getSecrettimestamp() {
		return secrettimestamp;
	}

	public void setSecrettimestamp(Timestamp secrettimestamp) {
		this.secrettimestamp = secrettimestamp;
	}

	public Long getSubmittedby() {
		return submittedby;
	}

	public void setSubmittedby(Long submittedby) {
		this.submittedby = submittedby;
	}

	public Long getSubmittedto() {
		return submittedto;
	}

	public void setSubmittedto(Long submittedto) {
		this.submittedto = submittedto;
	}
	
	
}
