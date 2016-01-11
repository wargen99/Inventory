package com.example.faas.service;

import org.springframework.stereotype.Service;

import com.example.faas.dtoex.Person;

@Service
public interface UserService {
	public Person signIn(Person person);
	public Person logIn(String id, String password);
	public String logOut(String id);
	public Person getUserInfo(int idx);
	
}