package com.genius.solar.freitech;

import com.genius.solar.freitech.config.LocalDateSpringConverter;
import com.genius.solar.freitech.config.LocalDateTimeSpringConverter;
import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@PropertySource(value = {"classpath:application.yml"})
public class FreitechApplication implements ApplicationContextAware, WebMvcConfigurer {

    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(FreitechApplication.class, args);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new LocalDateSpringConverter("yyyy-MM-dd"));
        registry.addConverter(new LocalDateTimeSpringConverter("yyyy-MM-dd'T'HH:mm:ss.SSS"));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

}
