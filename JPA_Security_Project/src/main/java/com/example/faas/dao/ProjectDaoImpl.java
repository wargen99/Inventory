package com.example.faas.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.faas.dtoex.Group;
import com.example.faas.dtoex.Person;
import com.example.faas.dtoex.Project;
import com.example.faas.repositoryex.GroupRepository;
import com.example.faas.repositoryex.ProjectRepository;
import com.latis.faas.dtoex.QGroup;
import com.latis.faas.dtoex.QPerson;
import com.mysema.query.jpa.impl.JPAQuery;

public class ProjectDaoImpl implements ProjectDao {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private GroupRepository groupRepository;

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public List<Project> getProjectList(Person person) {

		//JPQL 방식
		List<Group> groups = groupRepository.joinByPerson(person);

		if (groups.size() > 0) {
			List<Project> projects = new ArrayList<Project>();

			for (Group group : groups) {
				projects.add(group.getProject());
			}

			return projects;

		}
		// QueryDSL 방식
		EntityManager em = entityManagerFactory.createEntityManager();
		QGroup qgroup = QGroup.group;
		QPerson qperson = QPerson.person;
		JPAQuery jpaQuery = new JPAQuery(em);

		List<Group> glist = jpaQuery.from(qgroup)
				.innerJoin(qgroup.person, qperson)
				.where(qgroup.person.eq(person)).list(qgroup);
		if (glist.size() > 0) {
			List<Project> projects = new ArrayList<Project>();

			for (Group group : groups) {
				projects.add(group.getProject());
			}
			return projects;

		}
		return null;
	}

	@Override
	public Project getProjectInfo(int pid) {
		// TODO Auto-generated method stub
		List<Project> projectList = projectRepository.findByIdx(pid);

		if (projectList.size() > 0) {
			return projectList.get(0);
		}

		return null;
	}

	@Override
	public Project createProject(Project project, Person person) {
		// TODO Auto-generated method stub

		Group group = new Group(person, project, "owner");
		project.getGroups().add(group);

		return projectRepository.save(project);
	}

	@Override
	public List<Person> getCurrentProjectReviewerList(Project project) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Project addProjectReviewer(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

}
