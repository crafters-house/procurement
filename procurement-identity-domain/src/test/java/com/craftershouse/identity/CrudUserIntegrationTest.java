package com.craftershouse.identity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.craftershouse.context.ApplicationContextProvider;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:application-context-test-db.xml")
public class CrudUserIntegrationTest {
	
	@Autowired
	private ApplicationContextProvider provider;
	
	@Test
	public void givenValidUserThenCanBeCreatedIntoRepository() {
		
		User user = new User(); 
		user.setLogin("ercarval");  
		user.setEmail("ercarval@gmail.com");
		user.setFullName("ercarval@gmail.com");
		user.setFirstName("ercarval@gmail.com");
		user.setLastName("ercarval@gmail.com");

		user.save();
		System.out.println("");
		
	
	}
	

}
