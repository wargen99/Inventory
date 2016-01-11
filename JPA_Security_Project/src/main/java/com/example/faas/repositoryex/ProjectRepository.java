package com.example.faas.repositoryex;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.faas.dtoex.Project;

public interface ProjectRepository extends PagingAndSortingRepository<Project, Integer>{

	List<Project> findByIdx(int idx);
}
