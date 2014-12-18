package org.bloodbank.mongo.service;

import org.blood.mongo.repo.BloodRequestRepository;
import org.blood.mongo.repo.UserProfileRepository;
import org.bloodbank.mongo.model.UserCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class DeleteService {
	
	@Autowired
	private BloodRequestRepository bloodRequestRepository;
	
	@Autowired
	private UserProfileRepository userProfileRepository;
	
	@Autowired
	private MongoOperations mongoOperations;
	
	public void deleteBloodRequests() {
		bloodRequestRepository.deleteAll();
	}
	
	public void deleteUserProfiles() {
		userProfileRepository.deleteAll();
	}
	
	public void deleteUserCredentials() {
		Query query = new Query(Criteria.where("role").ne("ADMIN"));
		mongoOperations.remove(query, UserCredential.class);
	}

}
