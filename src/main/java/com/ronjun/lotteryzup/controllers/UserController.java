package com.ronjun.lotteryzup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ronjun.lotteryzup.dto.UserDTO;
import com.ronjun.lotteryzup.services.UserService;

@RestController
@RequestMapping(value = "users")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<UserDTO> findByEmail(@RequestParam(value = "email") String email){
		UserDTO user = service.findByEmail(email);
		return ResponseEntity.ok(user);
	}
}
 