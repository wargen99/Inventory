package com.latis.faas.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.JpaQueryCreator;
import org.springframework.data.jpa.repository.query.JpaQueryMethod;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/security-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/LogInInterceptor.xml" })
public class QdslTest {
	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private GroupRepository groupRepository;
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Test
	public void test() {
		
		
		Person person = new Person("test", "test@naver.com", "test");
		personRepository.save(person);

		for (int i = 0; i < 10; i++) {
			Project project = new Project("project" + i, "description" + i);
			Group group = new Group(person, project, "owner");
			project.getGroups().add(group);

			projectRepository.save(project);
		}
		
		EntityManager em = entityManagerFactory.createEntityManager();

		QGroup qgroup = QGroup.group;

		QPerson qperson = QPerson.person;
		
		JPAQuery jpaQuery = new JPAQuery(em);
		
		List<Group> glist =	jpaQuery.
				from(qgroup).
				innerJoin(qgroup.person, qperson).
				where(qgroup.person.eq(person)).
				limit(10).
				offset(0).
				list(qgroup);
		
		

	}
}
