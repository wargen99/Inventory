package com.example.faas.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.faas.dto.Project;

public interface ProjectRepository extends PagingAndSortingRepository<Project, Integer>{

}
