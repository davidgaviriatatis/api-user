package com.nissum.apiuser.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.nissum.apiuser.models.User;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Component
@Data
@RequiredArgsConstructor
public class Converter {
	
	private final ModelMapper modelMapper = new ModelMapper();
	
	public UserDTOResponse UserToDTO(User user) {
		return modelMapper.map(user, UserDTOResponse.class);
	}
	
	public User UserDTORequestTOUser(UserDTORequest userDTORequest) {
		return modelMapper.map(userDTORequest, User.class);
	}

}
