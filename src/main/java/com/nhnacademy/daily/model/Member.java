package com.nhnacademy.daily.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private String id;
    private String name;
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer age;
    @JsonProperty("class")
    private String clazz;
    @JsonSerialize(using = ToStringSerializer.class)
    private Locale locale;

    public Member(String id, String name, Integer age, String clazz, Locale locale) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.clazz = clazz;
        this.locale = locale;
    }
}
