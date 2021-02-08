package com.ronjun.lotteryzup.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ronjun.lotteryzup.entities.Bet;
import com.ronjun.lotteryzup.entities.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = -3386764460743475195L;

	private Long id;
	private String email;
	private List<BetDTO> bets = new ArrayList<>();

	public UserDTO() {
	}

	public UserDTO(Long id, String email, List<BetDTO> bets) {
		this.id = id;
		this.email = email;
		this.bets = bets;
	}
	
	public UserDTO(User entity) {
		id = entity.getId();
		email = entity.getEmail();
	}

	public UserDTO(User entity, List<Bet> bets) {
		id = entity.getId();
		email = entity.getEmail();
		bets.forEach(x -> this.bets.add(new BetDTO(x)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<BetDTO> getBets() {
		return bets;
	}

}
