package com.genius.solar.freitech.config;

import org.springframework.core.convert.converter.Converter;
import org.thymeleaf.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateSpringConverter implements Converter<String, LocalDate> {
    private final DateTimeFormatter formatter;

    public LocalDateSpringConverter(String dateFormant) {
        this.formatter = DateTimeFormatter.ofPattern(dateFormant);
    }

    @Override
    public LocalDate convert(String s) {
        if (StringUtils.isEmpty(s)) {
            return null;
        }
        return LocalDate.parse(s, formatter);
    }
}
