package org.bloodbank.mongo.dao;

import org.blood.mongo.repo.UserCredentialRepository;
import org.bloodbank.mongo.model.UserCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

@Repository
public class UserCredentailDao {
	
	@Autowired
	private MongoOperations mongoOperations;
	
	@Autowired
	private UserCredentialRepository userCredentialRepository;
	
	
	public void saveUserCredential(UserCredential userCredential) {
		mongoOperations.insert(userCredential);
	}
	
	public void removeUserCredential(UserCredential userCredential) {
		userCredentialRepository.delete(userCredential);
	}
	
}
