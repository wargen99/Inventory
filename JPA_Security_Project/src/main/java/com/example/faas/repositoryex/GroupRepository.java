package com.example.faas.repositoryex;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.faas.dtoex.Group;
import com.example.faas.dtoex.Person;
import com.example.faas.dtoex.Project;

import java.util.List;

public interface GroupRepository extends
		PagingAndSortingRepository<Group, Integer>{

	@Query("select g" + " from project_groups g" + " join g.person p"
			+ " where p = :person)")
	List<Group> joinByPerson(@Param("person") Person person);

	List<Group> findByPerson(Person person);

	List<Group> findByProject(Project project);

}
