package com.tourism.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.management.model.TourismManagementRequest;
import com.tourism.management.model.TourismManagementResponse;
import com.tourism.management.service.TourismManagementService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/tourism/")
@Slf4j
public class TourismManagementController  extends BaseResource{
	
	@Autowired
	TourismManagementService tourismManagementService;
	
	@PostMapping("branch")
	public ResponseEntity<TourismManagementResponse> addBranch(
			@Validated @RequestBody TourismManagementRequest tourismManagementRequest) {
		log.info("addBranch - start");

		TourismManagementResponse tourismManagementResponse = tourismManagementService.addPlaces(tourismManagementRequest);

		return resolveResponse(tourismManagementResponse, HttpStatus.OK);
	}


}
