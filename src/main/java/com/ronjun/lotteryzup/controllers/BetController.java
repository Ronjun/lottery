package com.ronjun.lotteryzup.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ronjun.lotteryzup.dto.BetDTO;
import com.ronjun.lotteryzup.services.BetService;

@RestController
@RequestMapping(value ="/bets")
public class BetController {

	@Autowired
	private BetService service;
	
	@PostMapping
	public ResponseEntity<BetDTO> insertNewBet(@RequestBody String email) {
		BetDTO dto = service.insertNewBet(email);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
}
