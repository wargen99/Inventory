package com.example.faas.dao;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.faas.dtoex.Person;
import com.example.faas.repositoryex.PersonRepository;


public class UserDaoImpl implements UserDao {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public Person signIn(Person person) {
		// TODO Auto-generated method stub
		
		
		try {
			personRepository.save(person);
			
			List<Person> personList = personRepository.findByName(person.getName());
			if (personList.size() > 0) {
				Person savedPerson = personRepository.findByName(person.getName()).get(0);
				return savedPerson;
			}
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			// TODO: handle exception
			logger.error("unique key : email duplicated");
			return null;
		}

		return null;
	}

	@Override
	public Person logIn(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String logOut(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person getUserInfo(int idx) {
		// TODO Auto-generated method stub

		// return personRepository.findByIdx(idx).get(0);
		return null;
	}

}
