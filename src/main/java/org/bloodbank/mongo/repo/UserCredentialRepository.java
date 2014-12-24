package org.bloodbank.mongo.repo;

import org.bloodbank.mongo.model.UserCredential;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialRepository extends MongoRepository<UserCredential, String>{
	
	public UserCredential findByUsername(String username);

}
