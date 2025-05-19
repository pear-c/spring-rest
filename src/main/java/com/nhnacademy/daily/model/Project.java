package com.nhnacademy.daily.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.nhnacademy.daily.serializer.MyLocalDateSerializer;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Project {
    private String code;
    @JsonSerialize(using = MyLocalDateSerializer.class)
    private LocalDate localDate;
    @JsonSerialize(using = ToStringSerializer.class)
    private ProjectType type;

    public Project(String code, LocalDate localDate, ProjectType type) {
        this.code = code;
        this.localDate = localDate;
        this.type = type;
    }
}
