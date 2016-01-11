package com.example.faas.repositoryex;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.faas.dtoex.Person;

import java.lang.String;
import java.util.List;

public interface PersonRepository extends
		PagingAndSortingRepository<Person, Integer>{

	List<Person> findByName(String name);

	List<Person> findByEmail(String email);

}
