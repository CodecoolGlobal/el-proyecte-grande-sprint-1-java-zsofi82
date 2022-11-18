package com.coodecool.pickyourspot.config;

import com.coodecool.pickyourspot.Initializer;
import com.coodecool.pickyourspot.model.AppUser;
import com.coodecool.pickyourspot.storage.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfiguration {
    private UserDao userDao;

    @Autowired
    public DevConfiguration(UserDao userDao) {
        this.userDao = userDao;
    }

    @Bean
    public Initializer getInitializer() {
        return () -> {
            userDao.addUser(new AppUser("Bob", "bob@company.com", "$ax$abcabca43234"));
        };
    }
}
