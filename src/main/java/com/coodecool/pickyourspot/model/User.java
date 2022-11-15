package com.coodecool.pickyourspot.model;

import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", hashedPassword='" + hashedPassword + '\'' +
                '}';
    }

    public UUID getId() {
        return id;
    }
}
