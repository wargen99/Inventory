package com.example.faas.dao;

import org.springframework.stereotype.Component;

import com.example.faas.dtoex.Person;

@Component
public interface UserDao {
	public Person signIn(Person person);
	public Person logIn(String id, String password);
	public String logOut(String id);
	public Person getUserInfo(int idx);
}
