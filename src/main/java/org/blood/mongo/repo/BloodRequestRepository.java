package org.blood.mongo.repo;

import java.util.List;

import org.bloodbank.mongo.model.BloodGroup;
import org.bloodbank.mongo.model.BloodRequest;
import org.bloodbank.mongo.model.BloodRequestType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodRequestRepository extends MongoRepository<BloodRequest, Long> {
	
	/*@Query(value="{'bloodGroup' : ?0 , 'bloodRequestType' : ?1}", fields="{_id : 0}")
	public Long countByBloodGroupAndByBloodRequestType(String bloodGroup,String bloodRequestType);*/
	
	public List<BloodRequest> findByBloodGroupAndBloodRequestType(BloodGroup bloodGroup, BloodRequestType bloodRequestType);

}
