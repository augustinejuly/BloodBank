package org.bloodbank.tests;

import java.security.SecureRandom;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptTest {
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Before
	public void setUp() {
		int strength = 5;
		SecureRandom sr = new SecureRandom();
		bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, sr);
	}
	
	@Test
	public void testBcryptPasswordEncryption() {
		String pwd = "hello123";
		String encode = bCryptPasswordEncoder.encode(pwd);
		String encode2 = bCryptPasswordEncoder.encode(pwd);
		assertTrue(bCryptPasswordEncoder.matches(pwd, encode));
		assertTrue(bCryptPasswordEncoder.matches(pwd, encode2));
	}

}
