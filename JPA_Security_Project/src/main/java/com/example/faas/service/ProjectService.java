package com.example.faas.service;

import java.util.List;

import com.example.faas.dtoex.Person;
import com.example.faas.dtoex.Project;

public interface ProjectService {
	public List<Project> getProjectList(Person person);
	public Project getProjectInfo(int pid);
	public Project createProject(Project project, Person person);
	public List<Person> getCurrentProjectReviewerList(Project project);
	public Project addProjectReviewer(Person person);
	
}
