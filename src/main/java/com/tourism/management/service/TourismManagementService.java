package com.tourism.management.service;

import com.tourism.management.model.BranchDetail;
import com.tourism.management.model.TourismManagementRequest;
import com.tourism.management.model.TourismManagementResponse;

public interface TourismManagementService {
	
	public TourismManagementResponse addPlaces(TourismManagementRequest tourismManagementRequest);
	
	public TourismManagementResponse updateTariff(BranchDetail branchDetail); 

}
