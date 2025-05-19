package com.nhnacademy.daily.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Project {
    private String code;
    private LocalDate localDate;
    private ProjectType type;

    public Project(String code, LocalDate localDate, ProjectType type) {
        this.code = code;
        this.localDate = localDate;
        this.type = type;
    }
}
