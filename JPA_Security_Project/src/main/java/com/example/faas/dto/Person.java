package com.example.faas.dto;


import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name="person")
public class Person {

	private int idx;

	private String name;
	private String email;
	private String password;
	
	
	private List<Project> projects;
	
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(String name, String email, String password) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Person(String name, String email, String password, List<Project> projects) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.email = email;
		this.password = password;
		this.projects = projects;
	}

	
	@Id
	@GeneratedValue
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
		
	@ManyToMany(mappedBy = "person")	
	public List<Project> getProjects() {
		return projects;
	}
	
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name=" + name + ", password=" + password + ", email=" + email;
	}
}
