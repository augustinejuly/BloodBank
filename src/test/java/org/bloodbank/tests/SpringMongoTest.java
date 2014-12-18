package org.bloodbank.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:/spring/mongo-config.xml","classpath:/spring/spring-security-context.xml"})
@ActiveProfiles("dev")
public class SpringMongoTest {
	
	@Autowired
	private MongoOperations mongoOperations;
	
	@Test
	public void testMongo() throws Exception {
		assertNotNull(mongoOperations);
	}

}
