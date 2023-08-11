package com.nissum.apiuser.dto;

import java.io.Serializable;
import java.util.List;

import com.nissum.apiuser.annotations.PasswordFormat;
import com.nissum.apiuser.models.Phone;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class UserDTORequest implements Serializable{

	@NonNull
	private String name;
	
	@NonNull
	@Email
	private String email;
	
	@NonNull
	@NotBlank(message = "La contraseña no puede estar en blanco")
	private String password;
	
	private List<Phone>phones;
	
	
	
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



	public List<Phone> getPhones() {
		return phones;
	}



	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}



	private static final long serialVersionUID = 1L;

}
