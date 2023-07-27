package com.tourism.management.service;

import com.tourism.management.model.BranchDetail;
import com.tourism.management.model.TourismManagementResponse;

public interface TourismManagementService {
	
	public TourismManagementResponse addPlaces(BranchDetail branchDetail);
	
	public TourismManagementResponse updateTariff(BranchDetail branchDetail); 

}
