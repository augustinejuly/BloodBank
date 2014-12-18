package org.bloodbank.mongo.service;

import org.bloodbank.form.beans.Login;
import org.bloodbank.form.beans.MemberForm;
import org.bloodbank.form.beans.ProviderForm;
import org.bloodbank.mongo.dao.UserCredentailDao;
import org.bloodbank.mongo.dao.UserProfileDao;
import org.bloodbank.mongo.model.CommonUserProfile;
import org.bloodbank.mongo.model.MemberProfile;
import org.bloodbank.mongo.model.ProviderProfile;
import org.bloodbank.mongo.model.UserCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService{
	
	public static final String USER = "USER";
	
	public static final String ADMIN_USER = "ADMIN";

	@Autowired
	private UserProfileDao userProfileDao;
	
	@Autowired
	private UserCredentailDao userCredentailDao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public void saveMemberDetails(MemberForm memberForm) {

		/*UserCredential userCredential = null;
		try {*/
			UserCredential	userCredential = new UserCredential(memberForm.getUsername(),
					bCryptPasswordEncoder.encode(memberForm.getPassword()),
					(memberForm.getRole()==null ? USER : memberForm.getRole()));
			MemberProfile memberProfile = memberForm.getMemberProfile();
			memberProfile.setUsername(memberForm.getUsername());
			
			/*mongoOperations.save(userCredential);
			mongoOperations.insert(memberProfile);*/
			doItInAtomicStyle(memberProfile,userCredential,MemberProfile.class);
		/*} catch (Exception e) {
			// rollback if error occurs while saving member
			if (userCredential != null) {
				mongoOperations.remove(userCredential);
			}
			throw new RuntimeException("error while saving member details", e);
		}*/

	}

	public void saveProviderDetails(ProviderForm providerForm) {

		UserCredential	userCredential = new UserCredential(providerForm.getUsername(),
				bCryptPasswordEncoder.encode(providerForm.getPassword()),
				(providerForm.getRole()==null ? USER : providerForm.getRole()));
		ProviderProfile providerProfile = providerForm.getProviderProfile();
		providerProfile.setUsername(providerForm.getUsername());

		doItInAtomicStyle(providerProfile,userCredential,ProviderProfile.class);

	}

	

	public void doItInAtomicStyle(CommonUserProfile commonUserProfile,
			UserCredential userCredential, Class<? extends CommonUserProfile> entity) {
		try {
			System.out.println("Atomic style is called >>>>>>>>>>>");
			userCredentailDao.saveUserCredential(userCredential);
			userProfileDao.saveUserProfile(commonUserProfile);
			/*mongoOperations.save(userCredential);
			mongoOperations.insert(commonUserProfile);*/
		} catch (Exception e) {
			// rollback if error occurs while saving provider/  member
			if (userCredential != null) {
				userCredentailDao.removeUserCredential(userCredential);
				//mongoOperations.remove(userCredential);
			}
			throw new RuntimeException("error while saving " + entity + " details", e);
		}
		
	}

	public void saveUser(Login loginUser) {
		UserCredential	userCredential = new UserCredential(loginUser.getUsername(),
				bCryptPasswordEncoder.encode(loginUser.getPassword()),
				(loginUser.getRole()==null ? USER : loginUser.getRole()));
		userCredentailDao.saveUserCredential(userCredential);
	}
	
}
