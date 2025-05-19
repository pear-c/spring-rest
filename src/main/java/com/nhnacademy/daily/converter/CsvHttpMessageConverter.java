package com.nhnacademy.daily.converter;

import com.nhnacademy.daily.model.Member;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.List;

public class CsvHttpMessageConverter extends AbstractHttpMessageConverter<List<Member>> {

    public CsvHttpMessageConverter() {
        super(new MediaType("text", "csv"));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return Member.class.isAssignableFrom(clazz);
    }

    @Override
    protected List<Member> readInternal(Class<? extends List<Member>> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    protected void writeInternal(List<Member> members, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        Field[] fields = member.getClass().getDeclaredFields();

        outputMessage.getHeaders().setContentType(MediaType.valueOf("text/csv; charset=UTF-8"));
        try(Writer writer = new OutputStreamWriter(outputMessage.getBody())) {
            for(Field field : fields) {
                writer.write(field.getName() + ",");
            }
            writer.write(System.lineSeparator());
            writer.write(member.toString());
        }
        return;
    }

    @Override
    protected boolean canRead(MediaType mediaType) {
        return false;
    }
}
