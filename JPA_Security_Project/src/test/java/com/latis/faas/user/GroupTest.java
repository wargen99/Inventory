package com.latis.faas.user;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.faas.dtoex.Group;
import com.example.faas.dtoex.Person;
import com.example.faas.dtoex.Project;
import com.example.faas.dtoex.QGroup;
import com.example.faas.dtoex.QPerson;
import com.example.faas.repositoryex.GroupRepository;
import com.example.faas.repositoryex.PersonRepository;
import com.example.faas.repositoryex.ProjectRepository;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Predicate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/security-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/LogInInterceptor.xml" })
public class GroupTest {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private GroupRepository grepo;

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Test
	public void projectMakeEx() {

		Person person = new Person("test", "test@naver.com", "test");
		personRepository.save(person);

		for (int i = 0; i < 10; i++) {
			Project project = new Project("project" + i, "description" + i);
			Group group = new Group(person, project, "owner");
			project.getGroups().add(group);

			projectRepository.save(project);
		}

		QGroup qgroup = QGroup.group;
		
		QPerson qperson = QPerson.person;
		
		
		
		
		
		
//		Predicate predicate = qgroup.person.eq(person);
//		
//		Iterable<Group> groups = grepo.findAll(predicate);
//		Iterator<Group> gi = groups.iterator();
//		
//		while(gi.hasNext()){
//			System.out.println(gi.next().getProject().toString());
//		}

		//
		//
		// EntityManager em = entityManagerFactory.createEntityManager();
		// JPAQuery query = new JPAQuery(em);
		//
		// //QPerson qperson = QPerson.person;
		// QPerson qperson = QPerson.person;
		//
		// QProject qproject = QProject.project;
		// QGroup qgroup = QGroup.group;
		//
		// // Person test =
		// query.from(qperson).where(qperson.name.eq("test")).uniqueResult(qperson);
		// // List<Group> prjlist =
		// query.from(qgroup).where(qgroup.person.name.eq("test")).list(qgroup);
		// List<Group> projectList = query.from(qgroup).
		// innerJoin(qgroup.person, qperson).
		// where(qgroup.person.eq(person)).
		// list(qgroup);
		//
		// for(Group prj : projectList )
		// {
		// System.out.println(prj.getProject().getName());
		// }

	}

	@Test
	public void queryDslTest() {
		/*
		 * Person person = new Person("test", "testgun@naver.com", "test");
		 * personRepository.save(person);
		 */
	}

}
