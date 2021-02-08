package com.ronjun.lotteryzup.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ronjun.lotteryzup.dto.BetDTO;
import com.ronjun.lotteryzup.entities.Bet;
import com.ronjun.lotteryzup.entities.User;
import com.ronjun.lotteryzup.exceptions.InvalidBetException;
import com.ronjun.lotteryzup.repositories.BetRepository;
import com.ronjun.lotteryzup.repositories.UserRepository;

@Service
public class BetService {

	@Autowired
	private BetRepository repository;

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public BetDTO insertNewBet(String email) {

		Bet bet = new Bet();
		bet.setUser(userRepository.findByEmail(email));
		if (bet.getUser() == null) {
			User user = new User();
			user.setEmail(email);
			bet.setUser(userRepository.save(user));
		}
		bet.setLuckNumbers(generateBet());
		if (repository.findUserBet(bet.getLuckNumbers(), bet.getUser().getId()) == null) {
			repository.save(bet);
		} else {
			throw new InvalidBetException("Você já fez esta aposta!");
		}
		return new BetDTO(bet);
	}
	
	public int[] generateBet() {
		return new Random().ints(1, 61).distinct().limit(6).sorted().toArray();
	}
}
