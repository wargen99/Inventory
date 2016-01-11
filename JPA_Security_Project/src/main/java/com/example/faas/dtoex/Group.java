package com.example.faas.dtoex;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.faas.dtoex.Person;
import com.example.faas.dtoex.Project;

@Entity(name="project_groups")
//@IdClass(GroupID.class)
public class Group implements Serializable {

	private int idx;
	private String role;

	private Person person;
	private Project project;
	
	public Group() {
		// TODO Auto-generated constructor stub
	}
	
	public Group(Person person, Project project, String role) {
		this.person = person;
		this.project = project;
		this.role = role;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	@Column(name = "role")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@ManyToOne
	@JoinColumn(name="person_id")
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@ManyToOne
	@JoinColumn(name="project_id")
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
}
