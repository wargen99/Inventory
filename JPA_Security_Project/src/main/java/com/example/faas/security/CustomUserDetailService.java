package com.example.faas.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.faas.dtoex.Person;
import com.example.faas.repositoryex.PersonRepository;


public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private PersonRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		ArrayList<Person> person = (ArrayList<Person>) repo.findByEmail(email);
		
		if(person.size() == 0){
			throw new UsernameNotFoundException(email);
		}
		
		return new CustomUserDetail(person.get(0));
	}
	
	
	
	

}
