package com.nissum.apiuser.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nissum.apiuser.annotations.EmailFormat;
import com.nissum.apiuser.annotations.PasswordFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "users")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NonNull
	private String name;
	
	@NonNull
	@Email(message = "Formato de email no valido")
	@Size(min =  5)
	@EmailFormat
	private String email;
	
	@NonNull
	@JsonIgnore
	@PasswordFormat
	private String password;
	
	@NonNull
	private String token;
	
	@NonNull
	private LocalDateTime created = LocalDateTime.now();
	
	@NonNull
	private LocalDateTime modified = LocalDateTime.now();
	
	@NonNull
	@Column(name = "last_login", nullable = false)
	private LocalDateTime lastLogin = LocalDateTime.now();
	
	@NonNull
	@Column(name = "active", nullable = false)
	private boolean isActive;
	
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name="idPhone")
	private List<Phone>phones;
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getToken() {
		return token;
	}



	public void setToken(String token) {
		this.token = token;
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



	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	public List<Phone> getPhones() {
		return phones;
	}



	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}



	private static final long serialVersionUID = 1L;

}
