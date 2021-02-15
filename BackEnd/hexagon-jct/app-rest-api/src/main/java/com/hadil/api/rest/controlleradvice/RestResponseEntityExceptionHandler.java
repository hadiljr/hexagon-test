package com.hadil.api.rest.controlleradvice;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(value = { NoSuchElementException.class,EmptyResultDataAccessException.class })
	public void handleNotFound(Exception ex, HttpServletResponse response) throws IOException {

		response.sendError(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}

	@ExceptionHandler(value = { IllegalArgumentException.class, DataIntegrityViolationException.class,EntityNotFoundException.class })
	public void handleBadRequest(Exception ex, HttpServletResponse response) throws IOException {
		
		response.sendError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
	}
}
