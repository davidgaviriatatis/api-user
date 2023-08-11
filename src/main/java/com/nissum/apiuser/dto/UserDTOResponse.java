package com.nissum.apiuser.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserDTOResponse implements Serializable{

	private Long id;
	private LocalDateTime created;
	private LocalDateTime modified;
	private LocalDateTime lastLogin;
	private String token;
	private boolean isActive;
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public LocalDateTime getCreated() {
		return created;
	}



	public void setCreated(LocalDateTime created) {
		this.created = created;
	}



	public LocalDateTime getModified() {
		return modified;
	}



	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}



	public LocalDateTime getLastLogin() {
		return lastLogin;
	}



	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}



	public String getToken() {
		return token;
	}



	public void setToken(String token) {
		this.token = token;
	}



	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	private static final long serialVersionUID = 1L;

}
