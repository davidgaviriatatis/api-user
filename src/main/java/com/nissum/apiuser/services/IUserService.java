package com.nissum.apiuser.services;

import java.util.List;
import java.util.Optional;

import com.nissum.apiuser.dto.UserDTORequest;
import com.nissum.apiuser.models.User;

public interface IUserService {
	
	public List<User> findAll();
	
	public Optional<User> findById(Long id);
	
	public Optional<User> findByEmail(String email);
	
	public User save(UserDTORequest userDTO);

}
