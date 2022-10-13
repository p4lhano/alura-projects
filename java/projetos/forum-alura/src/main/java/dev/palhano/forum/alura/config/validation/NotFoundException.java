package dev.palhano.forum.alura.config.validation;

import org.springframework.dao.EmptyResultDataAccessException;

public class NotFoundException extends EmptyResultDataAccessException {

	public NotFoundException() {
		super(1);
	}
	
	public NotFoundException(String message) {
		super(message,1);
	}
	
}
