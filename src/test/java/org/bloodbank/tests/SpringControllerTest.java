package org.bloodbank.tests;

import static org.junit.Assert.assertTrue;

import org.bloodbank.web.BloodController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ExtendedModelMap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:/spring/spring-mvc-config.xml","classpath:/spring/mongo-config.xml","classpath:/spring/spring-security-context.xml"})
@ActiveProfiles("dev")
public class SpringControllerTest {
	
	@Autowired
	private BloodController bloodController;
	
	@Test
	public void testBloodController() throws Exception {
		String bloodHome = bloodController.bloodHome(new ExtendedModelMap());
		assertTrue("bloodhome".equals(bloodHome));
	}
	
	@Test
	public void testshowRegisteredUsers() throws Exception {
		String showRegisteredUsers = bloodController.showRegisteredUsers(new ExtendedModelMap());
		assertTrue("showRegisteredUsers".equals(showRegisteredUsers));
	}

}
