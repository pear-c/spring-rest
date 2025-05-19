package com.nhnacademy.daily.service;

import com.nhnacademy.daily.model.Project;
import com.nhnacademy.daily.model.ProjectType;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjectService {
    private Map<String, Project> projectMap;

    public ProjectService() {
        this.projectMap = new HashMap<>();
        Project project = new Project("black&white", LocalDate.now(), ProjectType.PUBLIC);
        this.projectMap.put("black&white", project);
    }

    public List<Project> getProjectList() {
        return new ArrayList<>(projectMap.values());
    }
}
