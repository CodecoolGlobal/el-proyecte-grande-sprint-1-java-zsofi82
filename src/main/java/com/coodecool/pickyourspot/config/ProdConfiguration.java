package com.coodecool.pickyourspot.config;

import com.coodecool.pickyourspot.Initializer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProdConfiguration {

    @Bean
    public Initializer getInitializer() {
        return () -> {
        };
    }
}
