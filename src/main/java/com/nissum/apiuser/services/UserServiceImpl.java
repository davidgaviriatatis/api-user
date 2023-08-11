package com.nissum.apiuser.services;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissum.apiuser.dto.Converter;
import com.nissum.apiuser.dto.UserDTORequest;
import com.nissum.apiuser.models.User;
import com.nissum.apiuser.repositories.IUserRepository;
import com.nissum.apiuser.utils.JwtUtil;

@Service
@Transactional
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private Converter converter;

	@Override
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User save(UserDTORequest userDTO) {
		User newUser = converter.UserDTORequestTOUser(userDTO);
		//LocalDateTime date = LocalDateTime.now();
		String nameUser = newUser.getName();
		
		/*newUser.setCreated(date);
		newUser.setModified(date);
		newUser.setLastLogin(date);*/
		newUser.setActive(true);
		
		newUser.setToken(JwtUtil.generateToken(nameUser));
		
		userRepository.save(newUser);
		
		return newUser;
	}

}
