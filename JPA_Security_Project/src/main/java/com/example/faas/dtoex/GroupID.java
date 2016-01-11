package com.example.faas.dtoex;

import java.io.Serializable;

public class GroupID implements Serializable{
	
	private int person;
	private int project;

	
	public GroupID() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int getPerson() {
		return person;
	}

	public void setPerson(int person) {
		this.person = person;
	}

	public int getProject() {
		return project;
	}

	public void setProject(int project) {
		this.project = project;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	
}
