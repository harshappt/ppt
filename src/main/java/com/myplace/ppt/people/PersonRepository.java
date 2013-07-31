package com.myplace.ppt.people;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepository extends
		PagingAndSortingRepository<Person, String> {

}
