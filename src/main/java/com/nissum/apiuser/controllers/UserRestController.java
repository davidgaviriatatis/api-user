package com.nissum.apiuser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissum.apiuser.dto.Converter;
import com.nissum.apiuser.dto.UserDTORequest;
import com.nissum.apiuser.dto.UserDTOResponse;
import com.nissum.apiuser.exceptions.BadRequestException;
import com.nissum.apiuser.exceptions.InternalServerErrorException;
import com.nissum.apiuser.models.User;
import com.nissum.apiuser.services.IUserService;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usersnissumapi")
public class UserRestController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private Converter converter;
	
	@PostMapping(value="/user", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?>create(@RequestBody UserDTORequest userDTO){
		if(userDTO.getEmail().isEmpty()) {
            throw new BadRequestException("El email es requerido");
        }
		
		System.out.println(userService.findByEmail(userDTO.getEmail()).isPresent());
		
		if(userService.findByEmail(userDTO.getEmail()).isPresent()) {
			System.out.println("Entro al email find");
			throw new InternalServerErrorException("El email ya se encuentra registrado");
		}
		
		User newUser = userService.save(userDTO);
		UserDTOResponse userResponse = converter.UserToDTO(newUser);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
	}

}
