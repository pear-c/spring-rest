package com.nhnacademy.daily.converter;

import com.nhnacademy.daily.model.Locale;
import com.nhnacademy.daily.model.Member;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CsvHttpMessageConverter extends AbstractHttpMessageConverter<List<Member>> {

    public CsvHttpMessageConverter() {
        super(new MediaType("text", "csv"));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return List.class.isAssignableFrom(clazz);
    }

    @Override
    protected List<Member> readInternal(Class<? extends List<Member>> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        List<Member> members = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new InputStreamReader(inputMessage.getBody(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                String id = fields[0].trim();
                String name = fields[1].trim();
                Integer age = Integer.valueOf(fields[2].trim());
                String clazzValue = fields[3].trim();
                Locale locale = Locale.valueOf(fields[4].trim().toUpperCase());

                Member member = new Member(id, name, age, clazzValue, locale);
                members.add(member);
            }
        }

        return members;
    }

    @Override
    protected boolean canRead(MediaType mediaType) {
        return true;
    }


    @Override
    protected void writeInternal(List<Member> members, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

        outputMessage.getHeaders().setContentType(MediaType.valueOf("text/csv; charset=UTF-8"));

        try(Writer writer = new OutputStreamWriter(outputMessage.getBody())) {
            Field[] fields = members.get(0).getClass().getDeclaredFields();
            for(int i=0; i<fields.length; i++) {
                writer.write(fields[i].getName());
                if(i < fields.length - 1) {
                    writer.write(',');
                }
            }
            writer.write(System.lineSeparator());
            for(Member member : members) {
                writer.write(member.toString() + System.lineSeparator());
            }
        }
    }
}