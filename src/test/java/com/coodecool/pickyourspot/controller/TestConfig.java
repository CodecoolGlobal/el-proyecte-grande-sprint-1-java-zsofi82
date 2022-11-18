package com.coodecool.pickyourspot.controller;

import com.coodecool.pickyourspot.storage.TableDao;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class TestConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public TableDao getTableDao() {
        return new MockTableDao();
    }
}
