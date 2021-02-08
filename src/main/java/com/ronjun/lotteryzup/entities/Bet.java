package com.ronjun.lotteryzup.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_bet")
public class Bet implements Serializable {
	private static final long serialVersionUID = -5408161065869675670L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int[] luckNumbers;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Bet() {
	}

	public Bet(Long id, int[] luckNumbers, User user) {
		this.id = id;
		this.luckNumbers = luckNumbers;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bet other = (Bet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
