package com.tourism.management.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.tourism.management.mapper.TourismManagementMapper;
import com.tourism.management.model.BranchDetail;
import com.tourism.management.model.TourismManagementRequest;
import com.tourism.management.model.TourismManagementResponse;
import com.tourism.management.repository.TourismManagementRepository;
import com.tourism.management.repository.TourismManagementServiceClient;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TourismManagementServiceImpl implements TourismManagementService {

	@Autowired
	TourismManagementMapper tourismManagementMapper;
	
	@Autowired
	TourismManagementRepository tourismManagementRepo;
	
	@Autowired
	TourismManagementServiceClient tourismManagementServiceClient;
	
	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate;
	
	@Value("${kafka.topic.admin}")
	private String kafkaTopicAdmin;

	@Value("${kafka.topic.update}")
	private String kafkaTopicUpdate;
	
	@Override
	public TourismManagementResponse addPlaces(BranchDetail branchDetail) {
	
		log.debug(" Entering addPlaces ");
		TourismManagementRequest tourismManagementRequest = new TourismManagementRequest();
		tourismManagementRequest.setBranchDetail(branchDetail);
		TourismManagementResponse tourismManagementResponse = tourismManagementServiceClient.addNewPlace(tourismManagementRequest);
		
		if(isSuccessResponse(Optional.of(tourismManagementResponse))) {
			kafkaTemplate.send(kafkaTopicAdmin, tourismManagementResponse.getBranchDetail());
		}
		
		return tourismManagementResponse;
	}

	private boolean isSuccessResponse(Optional<TourismManagementResponse> tourismManagementResponseO) {
		
		Optional<String> statusO = tourismManagementResponseO
				.map(TourismManagementResponse::getStatus);

		return statusO.filter(status -> "SUCCESS".equals(status)).isPresent();
	}

	@Override
	public TourismManagementResponse updateTariff(BranchDetail branchDetail) {
		
		log.debug(" Entering updateTariff ");
		TourismManagementRequest tourismManagementRequest = new TourismManagementRequest();
		tourismManagementRequest.setBranchDetail(branchDetail);
		TourismManagementResponse tourismManagementResponse = tourismManagementServiceClient.manageTariff(tourismManagementRequest);
		
		if(isSuccessResponse(Optional.of(tourismManagementResponse))) {
			kafkaTemplate.send(kafkaTopicUpdate, tourismManagementResponse.getBranchDetail());
		}
		
		return tourismManagementResponse;
	}

}
