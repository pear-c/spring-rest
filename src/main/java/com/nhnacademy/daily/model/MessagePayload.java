package com.nhnacademy.daily.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MessagePayload {
    private String botName;
    private String text;
}
