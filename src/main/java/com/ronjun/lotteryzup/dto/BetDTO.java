package com.ronjun.lotteryzup.dto;

import java.io.Serializable;

import com.ronjun.lotteryzup.entities.Bet;

public class BetDTO implements Serializable {
	private static final long serialVersionUID = -7368404448334630579L;
	
	private Long id;
	private int[] luckNumbers;
	private UserDTO user;

	public BetDTO() {
	}

	public BetDTO(Long id, int[] luckNumbers, UserDTO user) {
		this.id = id;
		this.luckNumbers = luckNumbers;
		this.user = user;
	}

	public BetDTO(Bet entity) {
		id = entity.getId();
		luckNumbers = entity.getLuckNumbers();
		user = new UserDTO(entity.getUser());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int[] getLuckNumbers() {
		return luckNumbers;
	}

	public void setLuckNumbers(int[] luckNumbers) {
		this.luckNumbers = luckNumbers;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

}
