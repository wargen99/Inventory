package com.example.faas.dao;

import java.util.List;

import com.example.faas.dtoex.Person;
import com.example.faas.dtoex.Project;

public interface ProjectDao {
	public List<Project> getProjectList(Person person);
	public Project getProjectInfo(int pid);
	public Project createProject(Project project, Person person);
	public List<Person> getCurrentProjectReviewerList(Project project);
	public Project addProjectReviewer(Person person);
}
