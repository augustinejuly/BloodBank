package org.bloodbank.mongo.dao;

import org.bloodbank.mongo.model.CommonUserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

@Repository
public class UserProfileDao {

	@Autowired
	private MongoOperations mongoOperations;
	
	public void saveUserProfile(CommonUserProfile commonUserProfile) {
			mongoOperations.insert(commonUserProfile);
	}
}
