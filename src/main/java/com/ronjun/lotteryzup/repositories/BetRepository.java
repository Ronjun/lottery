package com.ronjun.lotteryzup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ronjun.lotteryzup.entities.Bet;

@Repository
public interface BetRepository extends JpaRepository<Bet, Long>{

	@Query("SELECT obj FROM Bet obj WHERE "
			+ "(obj.luckNumbers = :luckNumbers) AND"
			+ "(obj.user.id = :id)")
	Bet findUserBet(int[] luckNumbers, Long id);
}
