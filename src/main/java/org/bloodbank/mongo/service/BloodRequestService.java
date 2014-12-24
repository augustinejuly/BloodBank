package org.bloodbank.mongo.service;

import static org.bloodbank.mongo.dao.BloodRequestDao.BLOOD_REQUEST_COLLECTION_NAME;

import java.util.Date;

import org.bloodbank.mongo.dao.BloodRequestDao;
import org.bloodbank.mongo.model.BloodRequest;
import org.bloodbank.mongo.model.CommonUserProfile;
import org.bloodbank.mongo.repo.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloodRequestService {
	
	@Autowired
	private BloodRequestDao bloodRequestDao;
	
	@Autowired
	private UserProfileRepository userProfileRepository;
	
	@Autowired
	private CounterService counterService;
	
	public void saveBloodRequest(BloodRequest bloodRequest, String username) {
		CommonUserProfile userProfile = userProfileRepository.findByUsername(username);
		System.out.println("User type is " + userProfile.getUserType().name());
		
		bloodRequest.setBloodRequestId(counterService.getNextSequence(BLOOD_REQUEST_COLLECTION_NAME));
		bloodRequest.setRequestPostedBy(userProfile);
		bloodRequest.setPostedTime(new Date());
		bloodRequestDao.save(bloodRequest);
	}

}
