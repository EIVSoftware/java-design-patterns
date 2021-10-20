package com.eiv;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParameterContainerCfg {

    @Bean
    public ParameterContainer getParameterContainer() {
        return new ParameterContainerImpl()
                .addParameter("param-bool", Boolean.class, Boolean.TRUE)
                .addParameter("param-date", LocalDate.class, LocalDate.now())
                ;
    }
}
