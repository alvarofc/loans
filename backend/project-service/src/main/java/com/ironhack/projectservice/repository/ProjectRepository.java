package com.ironhack.projectservice.repository;

import com.ironhack.projectservice.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    public List<Project> findByOwner(Integer owner);
}
