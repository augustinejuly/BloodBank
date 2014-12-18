package org.bloodbank.mongo.service;

import java.util.Arrays;
import java.util.List;

import org.blood.mongo.repo.UserCredentialRepository;
import org.bloodbank.mongo.model.UserCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {

	//private static final Map<String,Login> userMap = new HashMap<String, Login>();

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserCredentialRepository userCredentialRepository;
	//private UserCredentialDao userCredentialDao;

	/*@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("After Properties Invoked >>>>>>>>>>>>");
		Login adminUser = new Login();
		adminUser.setUsername("admin");
		adminUser.setPassword(bCryptPasswordEncoder.encode("admin"));
		adminUser.setRole("ROLE_ADMIN");

		Login user = new Login();
		user.setUsername("user");
		user.setPassword(bCryptPasswordEncoder.encode("user"));
		user.setRole("ROLE_USER");

		userMap.put("admin", adminUser);
		userMap.put("user", user);
	}*/

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		//Login user = userMap.get(username);
		UserCredential user = userCredentialRepository.findByUsername(username);
		
		if(user != null) {
			System.out.println("User Name : " + user.getUsername());
		}
		if( user == null )
			throw new UsernameNotFoundException( "User Name unknown" );

		List<SimpleGrantedAuthority> authorities = Arrays.asList( new SimpleGrantedAuthority( user.getRole() ) );

		return new User( user.getUsername(), user.getPassword(), authorities );
	}

}
