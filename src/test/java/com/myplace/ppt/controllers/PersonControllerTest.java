package com.myplace.ppt.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.myplace.ppt.people.Address;
import com.myplace.ppt.people.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration()
@ContextHierarchy({
		@ContextConfiguration("classpath:META-INF/spring/mongo-persistence.xml"),
		@ContextConfiguration("classpath:WEB-INF/spring/appservlet/servlet-context.xml") })
@ActiveProfiles("test")
public class PersonControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockmvc;

	@Before
	public void setup() {
		mockmvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void testSave() throws Exception {
		String person = createPerson();
		mockmvc.perform(
				post("/person/save").contentType(MediaType.APPLICATION_JSON)
						.content(person))
				.andExpect(jsonPath("$.lastName").exists()).andDo(print());

	}

	private String createPerson() throws JsonGenerationException,
			JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Person person = new Person();
		person.setFirstName("435436456");
		person.setEmail("xyz@yahoo.com");
		// person.setLastName("Puthalapattu");
		person.setPassword("iiiii");
		person.setPrimaryPhone("1234556789");
		person.setPresentAddress(new Address());
		ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();
		return objectWriter.writeValueAsString(person);
	}
}
