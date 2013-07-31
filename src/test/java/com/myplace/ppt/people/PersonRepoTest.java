package com.myplace.ppt.people;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration({ "classpath:/META-INF/spring/mongo-persistence.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class PersonRepoTest {

	@Autowired  
	private PersonRepository personRepo;

	@Test
	public void testSave() { 
		assertNotNull(personRepo);

		Person person = personRepo.save(new Person());

		assertNotNull(person.getId()); 
	}

}
