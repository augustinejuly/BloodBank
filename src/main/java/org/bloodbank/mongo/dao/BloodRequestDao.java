package org.bloodbank.mongo.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.blood.mongo.repo.BloodRequestRepository;
import org.bloodbank.mongo.model.BloodGroup;
import org.bloodbank.mongo.model.BloodRequest;
import org.bloodbank.mongo.model.BloodRequestType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class BloodRequestDao{
	
	public static final String BLOOD_REQUEST_COLLECTION_NAME = "bloodRequest";
	
	@Autowired
	private MongoOperations mongoOperations;
	
	@Autowired
	private BloodRequestRepository bloodRequestRepository;

	public void save(BloodRequest bloodRequest) {
		System.out.println(">>>>>>>> insert blood request ");
		mongoOperations.insert(bloodRequest);
	}

	public void update(BloodRequest bloodRequest) {
		bloodRequestRepository.save(bloodRequest);
	}

	public void delete(BloodRequest bloodRequest) {
		bloodRequestRepository.delete(bloodRequest);
	}

	public BloodRequest read(Serializable serializable) {
		return bloodRequestRepository.findOne((Long)serializable);
	}
	
	public Map<String, Long> getBloodGroupStatusMap(){
		Map<String, Long> bloodStatusMap = new  HashMap<String, Long>();
		
		for (BloodGroup bloodGroup : BloodGroup.values()) {
			long donateCount, demandCount = 0;
			
			donateCount = mongoOperations.count(new Query(Criteria.where("bloodGroup").is(bloodGroup)
					.andOperator(Criteria.where("bloodRequestType").is(BloodRequestType.DONATE.name()))), BloodRequest.class);
			
			bloodStatusMap.put(bloodGroup.name()+BloodRequestType.DONATE.name(), donateCount);
			
			demandCount = mongoOperations.count(new Query(Criteria.where("bloodGroup").is(bloodGroup)
					.andOperator(Criteria.where("bloodRequestType").is(BloodRequestType.DEMAND.name()))), BloodRequest.class);
			
			bloodStatusMap.put(bloodGroup.name()+BloodRequestType.DEMAND.name(), demandCount);
		}
		return bloodStatusMap;
	}
	
	public List<BloodRequest> getBloodRequest(BloodGroup bloodGroup, BloodRequestType bloodRequestType){
	
		return bloodRequestRepository.findByBloodGroupAndBloodRequestType(bloodGroup, bloodRequestType);
	}
	
}
