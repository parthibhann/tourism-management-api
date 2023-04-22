package com.tourism.management.service;

import com.tourism.management.model.BranchDetail;

public interface TourismManagementService {
	
	public String addPlaces(BranchDetail branchDetail);
	
	public String updateTariff(int branchId); 

}
