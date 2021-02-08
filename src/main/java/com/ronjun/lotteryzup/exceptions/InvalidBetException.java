package com.ronjun.lotteryzup.exceptions;

public class InvalidBetException extends RuntimeException {
	private static final long serialVersionUID = -7239378382478671588L;

	public InvalidBetException(String msg) {
		super(msg);
	}
}
