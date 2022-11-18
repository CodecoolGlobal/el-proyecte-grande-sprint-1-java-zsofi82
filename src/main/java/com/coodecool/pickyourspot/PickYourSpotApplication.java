package com.coodecool.pickyourspot;

import com.coodecool.pickyourspot.storage.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PickYourSpotApplication implements CommandLineRunner {
    private Initializer initializer;

    @Autowired
    public PickYourSpotApplication(Initializer initializer) {
        this.initializer = initializer;
    }

    public static void main(String[] args) {
        SpringApplication.run(PickYourSpotApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        initializer.initialize();
    }

}
