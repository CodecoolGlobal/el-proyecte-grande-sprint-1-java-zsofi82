package com.coodecool.pickyourspot.model;

import java.util.UUID;

public class User {
    private UUID id;
    private String username;
    private String email;
    private String hashedPassword;

    public User(UUID id, String username, String email, String hashedPassword) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.hashedPassword = hashedPassword;
    }

    public User(String username, String email, String hashedPassword) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.email = email;
        this.hashedPassword = hashedPassword;
    }

    public String getUsername() {
        return username;
    }
}
