package com.myplace.ppt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myplace.ppt.people.Person;
import com.myplace.ppt.people.PersonRepository;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonRepository personRepo;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody
	Person save(@Validated @RequestBody Person person) {

		Person savedPerson = personRepo.save(person);

		return savedPerson;
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	Iterable<Person> findAllPeople() {
		return personRepo.findAll();
	}

	// @RequestMapping(method = RequestMethod.GET)
	// public Person findByEmailAndPassword(@Re){
	//
	// }

}
