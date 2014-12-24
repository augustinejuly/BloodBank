package org.bloodbank.mongo.service;

import java.util.Arrays;
import java.util.List;

import org.bloodbank.mongo.model.UserCredential;
import org.bloodbank.mongo.repo.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {

	@Autowired
	private UserCredentialRepository userCredentialRepository;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
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
