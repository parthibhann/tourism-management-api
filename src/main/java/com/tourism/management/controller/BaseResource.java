package com.tourism.management.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

abstract class BaseResource {
	
	protected <T> ResponseEntity<T> resolveResponse(T response, HttpStatus status) {
		return new ResponseEntity<T>(response, status);
	} 

}
