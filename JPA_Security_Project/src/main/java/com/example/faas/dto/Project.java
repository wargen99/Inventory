package com.example.faas.dto;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name="project")
public class Project {
	
	private int idx;
	
	
	private String name;
	private String description;
	
	
	private List<Person> person;
	
	
	

	public Project() {
		// TODO Auto-generated constructor stub
	}
	
	public Project(String name, String description){
		this.name = name;
		this.description = description;
		
	}
	
	public Project(String name, String description, List<Person> person){
		this.name = name;
		this.description = description;
		this.person = person;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	/*
	@ManyToMany(mappedBy = "projects")
	*/
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "project_group", 
	joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "idx"),
	inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "idx"))
	public List<Person> getPerson() {
		return person;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name=" + name + ", desc=" + description;
	}
	
}
