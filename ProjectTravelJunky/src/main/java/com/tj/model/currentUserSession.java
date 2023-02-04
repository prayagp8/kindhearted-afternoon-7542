package com.tj.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class currentUserSession {

	@Id
	@Column(unique = true)
	private Integer userId;
	
	private String uuid;
	
	private LocalDateTime localDateTime;
	
	
	public currentUserSession() {
		
	}

	public currentUserSession(Integer userId, String uuid, LocalDateTime localDateTime) {
		super();
		this.userId = userId;
		this.uuid = uuid;
		this.localDateTime = localDateTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	@Override
	public String toString() {
		return "currentUserSession [userId=" + userId + ", uuid=" + uuid + ", localDateTime=" + localDateTime + "]";
	}
	
	
	
	
	
}
