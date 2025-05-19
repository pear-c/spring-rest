package com.nhnacademy.daily.model;

public enum Locale {
    KO, EN, JP;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
