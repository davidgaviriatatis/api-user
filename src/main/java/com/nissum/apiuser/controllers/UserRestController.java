package com.nissum.apiuser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.nissum.apiuser.dto.Converter;
import com.nissum.apiuser.dto.UserDTORequest;
import com.nissum.apiuser.dto.UserDTOResponse;
import com.nissum.apiuser.exceptions.BadRequestException;
import com.nissum.apiuser.exceptions.InternalServerErrorException;
import com.nissum.apiuser.exceptions.ResourceNotFoundException;
import com.nissum.apiuser.models.User;
import com.nissum.apiuser.services.IUserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
		
		if(userService.findByEmail(userDTO.getEmail()).isPresent()) {
			throw new InternalServerErrorException("El email ya se encuentra registrado");
		}
		
		User newUser = userService.save(userDTO);
		UserDTOResponse userResponse = converter.UserToDTO(newUser);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
	}
	
	@GetMapping(value="/allusers",  produces= "application/json")
	public ResponseEntity<?> getAll() {
		List<User> users = userService.findAll();
		
		if (users.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);
		}
		else {
			List<UserDTOResponse> userDTO = users
					.stream().map(us -> converter.UserToDTO(us))
					.collect(Collectors.toList());
			
			return ResponseEntity.status(HttpStatus.OK).body(userDTO);
		}
	}
	
	@GetMapping(value="/user/{id}", produces = "application/json")
	public ResponseEntity<?> getUser(@PathVariable Long id) {
		Optional<User> optional = userService.findById(id);
		
		if (!optional.isPresent()) {
			throw new ResourceNotFoundException("El usuario no existe en la base de datos.");
		}
		
		return ResponseEntity.ok(optional.get());
	}

}
