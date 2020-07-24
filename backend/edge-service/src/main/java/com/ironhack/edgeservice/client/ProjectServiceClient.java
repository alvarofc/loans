package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.model.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "project-service")
public interface ProjectServiceClient {
    @GetMapping("/projects")
    public List<Project> findAll();

    @GetMapping("/project/{id}")
    public Project findById(@PathVariable(name = "id") Integer id) throws Exception;

    @GetMapping("/projects/{owner}")
    public List<Project> findByOwner(@PathVariable(name = "owner") Integer owner);

    @PutMapping("/project/{id}")
    public Project change(@PathVariable(name = "id") Integer id, @RequestBody Project project) throws Exception;

    @DeleteMapping("/project/{id}")
    public void delete(@PathVariable(name = "id") Integer id) throws Exception;

    @PostMapping("/project")
    public Project save(@RequestBody Project project);
}
