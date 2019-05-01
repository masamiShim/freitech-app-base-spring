package com.genius.solar.freitech.config;

import org.springframework.core.convert.converter.Converter;
import org.thymeleaf.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeSpringConverter implements Converter<String, LocalDateTime> {
    private final DateTimeFormatter formatter;

    public LocalDateTimeSpringConverter(String dateFormant) {
        this.formatter = DateTimeFormatter.ofPattern(dateFormant);
    }

    @Override
    public LocalDateTime convert(String s) {
        if (StringUtils.isEmpty(s)) {
            return null;
        }
        return LocalDateTime.parse(s, formatter);
    }
}
