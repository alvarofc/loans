package com.ironhack.projectservice.service;

import com.ironhack.projectservice.model.Project;
import com.ironhack.projectservice.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    public List<Project> findAll() {
       return projectRepository.findAll();
    }

    public List<Project> findByOwner(Integer owner) {
        return projectRepository.findByOwner(owner);
    }

    public Project findById(Integer id) throws Exception {
        return projectRepository.findById(id).orElseThrow(() -> new Exception("There is no Project with that id."));
    }

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public Project change(Integer id, Project project) throws Exception {
        Project old = findById(id);
        project.setId(old.getId());
        return save(project);
    }
    public void delete(Integer id) throws Exception {
        Project project = findById(id);
        projectRepository.delete(project);
    }
}
