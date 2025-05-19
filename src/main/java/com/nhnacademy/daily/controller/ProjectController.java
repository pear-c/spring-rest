package com.nhnacademy.daily.controller;

import com.nhnacademy.daily.model.Project;
import com.nhnacademy.daily.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/projects/{code}")
    public ResponseEntity<Project> getProject(@PathVariable String code) {
        Project project = projectService.getProject(code);
        return ResponseEntity.ok(project);
    }

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getAllProjects(Pageable pageable) {
        List<Project> projects = projectService.getProjectList();
        return ResponseEntity.ok(projects);
    }
}
