package com.tourism.management.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tourism.management.entity.Branch;

public interface TourismManagementRepository extends MongoRepository<Branch, Integer> {

}
