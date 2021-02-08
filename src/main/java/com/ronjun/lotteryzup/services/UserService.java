package com.ronjun.lotteryzup.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ronjun.lotteryzup.dto.UserDTO;
import com.ronjun.lotteryzup.entities.User;
import com.ronjun.lotteryzup.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public UserDTO findByEmail(String email) {
		User user = repository.findByEmail(email);
		return new UserDTO(user, user.getBets());
	}
}
