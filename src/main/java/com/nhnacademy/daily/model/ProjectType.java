package com.nhnacademy.daily.model;

public enum ProjectType {
    PUBLIC, PRIVATE;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
