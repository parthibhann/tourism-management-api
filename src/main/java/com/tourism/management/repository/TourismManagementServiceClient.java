package com.tourism.management.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tourism.management.model.TourismManagementRequest;
import com.tourism.management.model.TourismManagementResponse;



@FeignClient(value = "${feign.client.tourism.management.service}", url = "${feign.client.url.tourism.management.service}")
public interface TourismManagementServiceClient {
	
	@RequestMapping(method = RequestMethod.POST, value = "/manage/places")
	public TourismManagementResponse addNewPlace(TourismManagementRequest tourismManagementRequest);
	
	@RequestMapping(method = RequestMethod.POST, value = "/manage/tariff")
	public TourismManagementResponse manageTariff(TourismManagementRequest tourismManagementRequest);

}
