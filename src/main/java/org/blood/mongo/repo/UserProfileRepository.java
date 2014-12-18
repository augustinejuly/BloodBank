package org.blood.mongo.repo;

import java.util.List;

import org.bloodbank.mongo.model.CommonUserProfile;
import org.bloodbank.mongo.model.MemberProfile;
import org.bloodbank.mongo.model.ProviderProfile;
import org.bloodbank.mongo.model.UserType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends MongoRepository<CommonUserProfile,String>{
	
	public CommonUserProfile findByUsername(String name);
	
	@Query("{ 'userType' : ?0 }")
	public List<MemberProfile> findAllMemberProfiles(UserType userType, Pageable pageable);
	
	@Query("{ 'userType' : ?0 }")
	public List<ProviderProfile> findAllProviderProfiles(UserType userType, Pageable pageable);

}
